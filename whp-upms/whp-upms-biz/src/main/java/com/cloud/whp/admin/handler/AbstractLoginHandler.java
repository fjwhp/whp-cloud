
package com.cloud.whp.admin.handler;

import com.cloud.whp.admin.api.dto.UserInfo;

/**
 * @author whp
 * @date 2018/11/18
 */
public abstract class AbstractLoginHandler implements LoginHandler {

	/**
	 * 处理方法
	 *
	 * @param loginStr 登录参数
	 * @return
	 */
	@Override
	public UserInfo handle(String loginStr) {
		String identify = identify(loginStr);
		return info(identify);
	}
}
