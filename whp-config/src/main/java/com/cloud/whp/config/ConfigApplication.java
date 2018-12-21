package com.cloud.whp.config;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author whp
 * @date 22018年12月19日15:42:23
 * 配置中心
 */
@EnableConfigServer
@SpringCloudApplication
public class ConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigApplication.class, args);
	}
}
