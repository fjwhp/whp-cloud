
package com.cloud.whp.admin.api.feign;

import com.cloud.whp.admin.api.feign.factory.RemoteLogServiceFallbackFactory;
import com.cloud.whp.admin.api.entity.SysLog;
import com.cloud.whp.common.core.constant.SecurityConstants;
import com.cloud.whp.common.core.constant.ServiceNameConstant;
import com.cloud.whp.common.core.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author whp
 * @since 2018年12月20日
 */
@FeignClient(value = ServiceNameConstant.UMPS_SERVICE, fallbackFactory = RemoteLogServiceFallbackFactory.class)
public interface RemoteLogService {
	/**
	 * 保存日志
	 *
	 * @param sysLog 日志实体
	 * @param from   是否内部调用
	 * @return succes、false
	 */
	@PostMapping("/log/save")
	R<Boolean> saveLog(@RequestBody SysLog sysLog, @RequestHeader(SecurityConstants.FROM) String from);
}
