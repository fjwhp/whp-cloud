
package com.cloud.whp.admin.api.feign.fallback;

import com.cloud.whp.admin.api.entity.SysLog;
import com.cloud.whp.admin.api.feign.RemoteLogService;
import com.cloud.whp.common.core.util.R;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author whp
 * @since 2018年12月20日
 */
@Slf4j
@Component
public class RemoteLogServiceFallbackImpl implements RemoteLogService {
	@Setter
	private Throwable cause;

	/**
	 * 保存日志
	 *
	 * @param sysLog
	 * @param from
	 * @return R
	 */
	@Override
	public R<Boolean> saveLog(SysLog sysLog, String from) {
		log.error("feign 插入日志失败", cause);
		return null;
	}
}
