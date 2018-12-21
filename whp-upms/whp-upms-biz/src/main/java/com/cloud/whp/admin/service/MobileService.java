
package com.cloud.whp.admin.service;

import com.cloud.whp.common.core.util.R;

/**
 * @author whp
 * @since 2018-12-19
 */
public interface MobileService {
	/**
	 * 发送手机验证码
	 *
	 * @param mobile mobile
	 * @return code
	 */
	R<Boolean> sendSmsCode(String mobile);
}
