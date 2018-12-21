

package com.cloud.whp.gateway;


import com.cloud.whp.common.gateway.annotation.EnableWhpDynamicRoute;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author whp
 * @date 2018年12月19日
 * 网关应用
 */
@EnableWhpDynamicRoute
@SpringCloudApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}
