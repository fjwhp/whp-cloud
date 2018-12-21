
package com.cloud.whp.manager.listener.service.impl;

import com.cloud.whp.manager.config.ConfigReader;
import com.cloud.whp.manager.framework.utils.Constants;
import com.cloud.whp.manager.netty.service.NettyServerService;
import com.cloud.whp.manager.listener.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author whp
 * @since 2018-12-20
 */
@Service
public class InitServiceImpl implements InitService {

	@Autowired
	private NettyServerService nettyServerService;

	@Autowired
	private ConfigReader configReader;


	@Override
	public void start() {
		/**加载本地服务信息**/

		Constants.socketPort = configReader.getSocketPort();
		Constants.maxConnection = configReader.getSocketMaxConnection();
		nettyServerService.start();
	}

	@Override
	public void close() {
		nettyServerService.close();
	}
}
