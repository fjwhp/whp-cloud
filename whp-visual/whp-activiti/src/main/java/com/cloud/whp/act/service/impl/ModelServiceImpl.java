
package com.cloud.whp.act.service.impl;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.whp.act.service.ModelService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.cloud.whp.common.core.constant.PaginationConstant;
import com.cloud.whp.common.core.constant.SecurityConstants;
import com.cloud.whp.common.core.util.TenantContextHolder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ModelQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * @author: whp.
 * @createTime: 2017/11/26.
 */
@Slf4j
@Service
@AllArgsConstructor
public class ModelServiceImpl implements ModelService {
	private static final String BPMN20_XML = ".bpmn20.xml";
	private final RepositoryService repositoryService;
	private final ObjectMapper objectMapper;

	/**
	 * 创建流程
	 *
	 * @param name
	 * @param key
	 * @param desc
	 * @param category
	 * @return
	 */
	@Override
	public Model create(String name, String key, String desc, String category) {
		try {
			ObjectNode editorNode = objectMapper.createObjectNode();
			editorNode.put("id", "canvas");
			editorNode.put("resourceId", "canvas");
			ObjectNode properties = objectMapper.createObjectNode();
			properties.put("process_author", SecurityConstants.WHP_LICENSE);
			editorNode.set("properties", properties);
			ObjectNode stencilset = objectMapper.createObjectNode();
			stencilset.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
			editorNode.set("stencilset", stencilset);

			Model model = repositoryService.newModel();
			model.setKey(key);
			model.setName(name);
			model.setCategory(category);
			model.setVersion(Integer.parseInt(
				String.valueOf(repositoryService.createModelQuery()
					.modelKey(model.getKey()).count() + 1)));

			ObjectNode modelObjectNode = objectMapper.createObjectNode();
			modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, name);
			modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, model.getVersion());
			modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, desc);
			model.setMetaInfo(modelObjectNode.toString());
			model.setTenantId(String.valueOf(TenantContextHolder.getTenantId()));

			repositoryService.saveModel(model);
			repositoryService.addModelEditorSource(model.getId(), editorNode.toString().getBytes("utf-8"));
			return model;
		} catch (UnsupportedEncodingException e) {
			log.error("UnsupportedEncodingException", e);
		}
		return null;
	}

	/**
	 * 分页获取流程
	 *
	 * @param params
	 * @return
	 */
	@Override
	public IPage<Model> getModelPage(Map<String, Object> params) {
		ModelQuery modelQuery = repositoryService.createModelQuery()
			.modelTenantId(String.valueOf(TenantContextHolder.getTenantId()))
			.latestVersion().orderByLastUpdateTime().desc();
		String category = (String) params.get("category");
		if (StrUtil.isNotBlank(category)) {
			modelQuery.modelCategory(category);
		}

		int page = MapUtil.getInt(params, PaginationConstant.CURRENT);
		int limit = MapUtil.getInt(params, PaginationConstant.SIZE);

		IPage result = new Page(page, limit);
		result.setTotal(modelQuery.count());
		result.setRecords(modelQuery.listPage((page - 1) * limit, limit));
		return result;
	}

	/**
	 * 删除流程
	 *
	 * @param id
	 * @return
	 */
	@Override
	public Boolean removeModelById(String id) {
		repositoryService.deleteModel(id);
		return Boolean.TRUE;
	}

	/**
	 * 部署流程
	 *
	 * @param id
	 * @return
	 */
	@Override
	public Boolean deploy(String id) {
		try {
			// 获取模型
			Model model = repositoryService.getModel(id);
			ObjectNode objectNode = (ObjectNode) new ObjectMapper().readTree(repositoryService.getModelEditorSource(model.getId()));
			BpmnModel bpmnModel = new BpmnJsonConverter().convertToBpmnModel(objectNode);

			String processName = model.getName();
			if (!StrUtil.endWithIgnoreCase(processName, BPMN20_XML)) {
				processName += BPMN20_XML;
			}
			// 部署流程
			Deployment deployment = repositoryService
				.createDeployment().name(model.getName())
				.addBpmnModel(processName, bpmnModel)
				.tenantId(String.valueOf(TenantContextHolder.getTenantId()))
				.deploy();

			// 设置流程分类
			List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery()
				.deploymentId(deployment.getId())
				.list();

			list.stream().forEach(processDefinition ->
				repositoryService.setProcessDefinitionCategory(processDefinition.getId(), model.getCategory()));
		} catch (Exception e) {
			log.error("部署失败，异常", e);
		}
		return Boolean.TRUE;
	}
}
