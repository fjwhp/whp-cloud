
package com.cloud.whp.common.log.event;

import com.cloud.whp.admin.api.entity.SysLog;
import org.springframework.context.ApplicationEvent;

/**
 * @author whp
 * 系统日志事件
 */
public class SysLogEvent extends ApplicationEvent {

	public SysLogEvent(SysLog source) {
		super(source);
	}
}
