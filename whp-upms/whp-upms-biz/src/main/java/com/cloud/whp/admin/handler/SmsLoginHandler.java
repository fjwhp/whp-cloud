

package com.cloud.whp.admin.handler;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cloud.whp.admin.api.dto.UserInfo;
import com.cloud.whp.admin.api.entity.SysUser;
import com.cloud.whp.admin.service.SysUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author whp
 * @date 2018/11/18
 */
@Slf4j
@Component("SMS")
@AllArgsConstructor
public class SmsLoginHandler extends AbstractLoginHandler {
	private final SysUserService sysUserService;

	/**
	 * 验证码登录传入为手机号
	 * 不用不处理
	 *
	 * @param mobile
	 * @return
	 */
	@Override
	public String identify(String mobile) {
		return mobile;
	}

	/**
	 * 通过mobile 获取用户信息
	 *
	 * @param identify
	 * @return
	 */
	@Override
	public UserInfo info(String identify) {
		SysUser sysUser = sysUserService
			.getOne(Wrappers.<SysUser>query()
				.lambda().eq(SysUser::getPhone, identify));

		if (sysUser == null) {
			log.info("手机号未注册:{}", identify);
			return null;
		}
		return sysUserService.findUserInfo(sysUser);
	}
}
