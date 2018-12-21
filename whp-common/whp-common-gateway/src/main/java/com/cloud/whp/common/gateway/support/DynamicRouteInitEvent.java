
package com.cloud.whp.common.gateway.support;

import org.springframework.context.ApplicationEvent;

/**
 * @author whp
 * @date 2018年12月19日
 * <p>
 * 路由初始化事件
 */
public class DynamicRouteInitEvent extends ApplicationEvent {
	public DynamicRouteInitEvent(Object source) {
		super(source);
	}
}
