
package com.cloud.whp.manager.netty.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author whp
 * @since 2018-12-20
 */
public interface IActionService {


	String execute(String channelAddress, String key, JSONObject params);

}
