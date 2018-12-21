
package com.cloud.whp.common.gateway.configuration;

import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.config.PropertiesRouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author whp
 * @date 2018年12月19日
 * <p>
 * 动态路由配置类
 */
@Configuration
@ComponentScan("com.cloud.whp.common.gateway")
public class DynamicRouteAutoConfiguration {
	/**
	 * 配置文件设置为空
	 * redis 加载为准
	 * @author whp
	 * @return
	 */
	@Bean
	public PropertiesRouteDefinitionLocator propertiesRouteDefinitionLocator() {
		return new PropertiesRouteDefinitionLocator(new GatewayProperties());
	}
}
