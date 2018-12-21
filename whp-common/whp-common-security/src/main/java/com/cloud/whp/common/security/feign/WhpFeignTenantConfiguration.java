
package com.cloud.whp.common.security.feign;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author whp
 * @date 2018/9/14
 * feign 租户信息拦截
 */
@Configuration
public class WhpFeignTenantConfiguration {
	@Bean
	public RequestInterceptor pigxFeignTenantInterceptor() {
		return new WhpFeignTenantInterceptor();
	}
}
