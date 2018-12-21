
package com.cloud.whp.act;

import com.cloud.whp.common.security.annotation.EnableWhpFeignClients;
import com.cloud.whp.common.security.annotation.EnablePigxResourceServer;
import com.cloud.whp.common.swagger.annotation.EnableWhpSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author whp
 * @date 2018-12-20
 * 工作流管理模块
 */
@EnableWhpSwagger2
@EnableWhpFeignClients
@EnablePigxResourceServer
@SpringCloudApplication
public class ActivitiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivitiApplication.class, args);
	}

}
