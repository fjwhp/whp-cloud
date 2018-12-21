
package com.cloud.whp.daemon;

import com.cloud.whp.common.job.annotation.EnableWhpJob;
import com.cloud.whp.common.security.annotation.EnableWhpFeignClients;
import com.cloud.whp.common.security.annotation.EnablePigxResourceServer;
import com.cloud.whp.common.swagger.annotation.EnableWhpSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author whp
 * @date 2018-12-20
 * 分布式任务调度模块
 */
@EnableWhpJob
@EnableWhpSwagger2
@EnableWhpFeignClients
@SpringCloudApplication
@EnablePigxResourceServer
public class DaemonApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaemonApplication.class, args);
	}

}
