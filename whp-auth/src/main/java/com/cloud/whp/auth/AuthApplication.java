
package com.cloud.whp.auth;


import com.cloud.whp.common.security.annotation.EnableWhpFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author whp
 * @date 2018年06月21日
 * 认证授权中心
 */
@SpringCloudApplication
@EnableWhpFeignClients
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}
}
