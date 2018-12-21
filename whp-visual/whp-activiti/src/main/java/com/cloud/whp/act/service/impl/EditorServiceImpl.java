
package com.cloud.whp.act.service.impl;

import cn.hutool.core.util.CharsetUtil;
import com.cloud.whp.act.service.EditorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.cloud.whp.common.core.util.TenantContextHolder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.ActivitiException;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Model;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import static org.activiti.editor.constants.ModelDataJsonConstants.*;

/**
 * @author whp
 * @date 2018/9/25
 */
@Slf4j
@Service
@AllArgsConstructor
public class EditorServiceImpl implements EditorService {
	private final RepositoryService repositoryService;
	private final ObjectMapper objectMapper;

	/**
	 * 获取设计器页面的json
	 *
	 * @return
	 */
	@Override
	public Object getStencilset() {
		InputStream stencilsetStream = this.getClass().getClassLoader().getResourceAsStream("stencilset.json");
		try {
			return IOUtils.toString(stencilsetStream, CharsetUtil.UTF_8);
		} catch (Exception e) {
			log.error("Error while loading stencil set", e);
			throw new ActivitiException("Error while loading stencil set", e);
		}
	}

	/**
	 * 根据modelId获取model
	 *
	 * @param modelId
	 * @return
	 */
	@Override
	public Object getEditorJson(String modelId) {
		ObjectNode modelNode;
		Model model = repositoryService.getModel(modelId);
		if (model != null) {
			try {
				if (StringUtils.isNotEmpty(model.getMetaInfo())) {
					modelNode = (ObjectNode) objectMapper.readTree(model.getMetaInfo());
				} else {
					modelNode = objectMapper.createObjectNode();
					modelNode.put(MODEL_NAME, model.getName());
				}
				byte[] source = repositoryService.getModelEditorSource(model.getId());
				modelNode.put(MODEL_ID, model.getId());
				ObjectNode editorJsonNode = (ObjectNode) objectMapper.readTree(new String(source, CharsetUtil.UTF_8));
				modelNode.set("model", editorJsonNode);
				return modelNode;
			} catch (Exception e) {
				log.error("Error creating model JSON", e);
				throw new ActivitiException("Error creating model JSON", e);
			}
		}
		return null;
	}

	/**
	 * 保存model信息
	 *
	 * @param modelId
	 * @param name
	 * @param description
	 * @param jsonXml
	 * @param svgXml
	 */
	@Override
	public void saveModel(String modelId, String name, String description, String jsonXml, String svgXml) {
		try {
			Model model = repositoryService.getModel(modelId);
			ObjectNode modelJson = (ObjectNode) objectMapper.readTree(model.getMetaInfo());
			modelJson.put(MODEL_NAME, name);
			modelJson.put(MODEL_DESCRIPTION, description);
			model.setMetaInfo(modelJson.toString());
			model.setName(name);
			model.setTenantId(String.valueOf(TenantContextHolder.getTenantId()));

			repositoryService.saveModel(model);
			repositoryService.addModelEditorSource(model.getId(), jsonXml.getBytes(CharsetUtil.UTF_8));
			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			final byte[] result = outStream.toByteArray();
			repositoryService.addModelEditorSourceExtra(model.getId(), result);
			outStream.close();
		} catch (Exception e) {
			log.error("Error saving model", e);
			throw new ActivitiException("Error saving model", e);
		}
	}
}
