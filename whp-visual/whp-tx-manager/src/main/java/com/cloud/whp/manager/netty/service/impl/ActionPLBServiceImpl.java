
package com.cloud.whp.manager.netty.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cloud.whp.manager.manager.service.LoadBalanceService;
import com.cloud.whp.manager.model.LoadBalanceInfo;
import com.cloud.whp.manager.netty.service.IActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 添加负载模块信息
 * @author whp
 * @since 2018-12-20
 */
@Service(value = "plb")
public class ActionPLBServiceImpl implements IActionService {


	@Autowired
	private LoadBalanceService loadBalanceService;


	@Override
	public String execute(String channelAddress, String key, JSONObject params) {

		String groupId = params.getString("g");
		String k = params.getString("k");
		String data = params.getString("d");

		LoadBalanceInfo loadBalanceInfo = new LoadBalanceInfo();
		loadBalanceInfo.setData(data);
		loadBalanceInfo.setKey(k);
		loadBalanceInfo.setGroupId(groupId);
		boolean ok = loadBalanceService.put(loadBalanceInfo);

		return ok ? "1" : "0";
	}
}
