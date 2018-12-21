
package com.cloud.whp.codegen;

import com.cloud.whp.common.security.annotation.EnablePigxResourceServer;
import com.cloud.whp.common.security.annotation.EnableWhpFeignClients;
import com.cloud.whp.common.swagger.annotation.EnableWhpSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author whp
 * @date 2018-12-20
 * 代码生成模块
 */
@EnableWhpSwagger2
@SpringCloudApplication
@EnableWhpFeignClients
@EnablePigxResourceServer
public class CodeGenApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeGenApplication.class, args);
	}
}
