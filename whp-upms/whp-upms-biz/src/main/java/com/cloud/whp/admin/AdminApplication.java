

package com.cloud.whp.admin;


import com.cloud.whp.common.security.annotation.EnableWhpFeignClients;
import com.cloud.whp.common.security.annotation.EnablePigxResourceServer;
import com.cloud.whp.common.swagger.annotation.EnableWhpSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author whp
 * @since 2018-12-19
 * 用户统一管理系统
 */
@EnableWhpSwagger2
@SpringCloudApplication
@EnableWhpFeignClients
@EnablePigxResourceServer(details = true)
public class AdminApplication {
	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}

}
