
package com.cloud.whp.manager.netty.service.impl;

import com.cloud.whp.manager.netty.service.IActionService;
import com.cloud.whp.manager.netty.service.NettyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author whp
 * @since 2018-12-20
 */
@Service
public class NettyServiceImpl implements NettyService {

	@Autowired
	private ApplicationContext spring;

	@Override
	public IActionService getActionService(String action) {
		return spring.getBean(action, IActionService.class);
	}
}
