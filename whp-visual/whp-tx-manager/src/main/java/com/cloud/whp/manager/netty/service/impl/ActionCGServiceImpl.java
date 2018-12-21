
package com.cloud.whp.manager.netty.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cloud.whp.manager.netty.model.TxGroup;
import com.cloud.whp.manager.manager.service.TxManagerService;
import com.cloud.whp.manager.netty.service.IActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 创建事务组
 * @author whp
 * @since 2018-12-20
 */
@Service(value = "cg")
public class ActionCGServiceImpl implements IActionService {


	@Autowired
	private TxManagerService txManagerService;

	@Override
	public String execute(String channelAddress, String key, JSONObject params) {
		String res = "";
		String groupId = params.getString("g");
		TxGroup txGroup = txManagerService.createTransactionGroup(groupId);
		if (txGroup != null) {
			txGroup.setNowTime(System.currentTimeMillis());
			res = txGroup.toJsonString(false);
		} else {
			res = "";
		}
		return res;
	}
}
