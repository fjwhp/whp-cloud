
package com.cloud.whp.common.security.annotation;

import com.cloud.whp.common.security.component.WhpResourceServerAutoConfiguration;
import com.cloud.whp.common.security.component.WhpSecurityBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.lang.annotation.*;

/**
 * @author whp
 * @date 2018/11/10
 * <p>
 * 资源服务注解
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import({WhpResourceServerAutoConfiguration.class, WhpSecurityBeanDefinitionRegistrar.class})
public @interface EnablePigxResourceServer {

	/**
	 * false：上下文获取用户名
	 * true： 上下文获取全部用户信息
	 *
	 * @return
	 */
	boolean details() default false;
}
