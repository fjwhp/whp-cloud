
package com.cloud.whp.act.listener;

import cn.hutool.core.collection.CollUtil;
import com.cloud.whp.admin.api.entity.SysUser;
import com.cloud.whp.admin.api.feign.RemoteUserService;
import com.cloud.whp.common.core.util.R;
import com.cloud.whp.common.core.util.SpringContextHolder;
import com.cloud.whp.common.security.util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author whp
 * @date 2018-12-20
 * 请假流程监听器
 */
@Slf4j
public class LeaveProcessTaskListener implements TaskListener {

	/**
	 * 查询提交人的上级
	 *
	 * @param delegateTask
	 */
	@Override
	public void notify(DelegateTask delegateTask) {
		RemoteUserService userService = SpringContextHolder.getBean(RemoteUserService.class);

		R<List<SysUser>> result = userService.ancestorUsers(SecurityUtils.getUsername());

		if (CollUtil.isEmpty(result.getData())) {
			log.warn("用户 {} 不存在上级,任务单由当前用户审批", SecurityUtils.getUsername());
			delegateTask.addCandidateUser(SecurityUtils.getUsername());
		} else {
			List<String> userList = result.getData().stream().map(SysUser::getUsername).collect(Collectors.toList());
			log.warn("当前任务 {}，由 {}处理", delegateTask.getId(), userList);
			delegateTask.addCandidateUsers(userList);
		}

	}
}
