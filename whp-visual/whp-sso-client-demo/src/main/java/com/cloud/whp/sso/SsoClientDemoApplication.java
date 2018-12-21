

package com.cloud.whp.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author whp
 * @date 2018年11月15日17:06:26
 * <p>
 * 单点登录客户端
 * 1. 启动实例访问:http://localhost:4040/sso1/ 提示登录，然后获取到用户信息
 * 2. 再启动一个实例： http://localhost:4041/sso1/ 不需要登录即可获取当前用户信息
 */
@EnableOAuth2Sso
@SpringCloudApplication
public class SsoClientDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsoClientDemoApplication.class, args);
	}

}
