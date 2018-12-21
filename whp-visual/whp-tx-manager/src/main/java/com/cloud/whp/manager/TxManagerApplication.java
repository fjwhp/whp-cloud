package com.cloud.whp.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 采用了LCN分布式事务框架
 * @author whp
 * tx-manager ，进行了代码逻辑和代码规范重构
 */
@SpringCloudApplication
public class TxManagerApplication {


	public static void main(String[] args) {
		SpringApplication.run(TxManagerApplication.class, args);
	}

}
