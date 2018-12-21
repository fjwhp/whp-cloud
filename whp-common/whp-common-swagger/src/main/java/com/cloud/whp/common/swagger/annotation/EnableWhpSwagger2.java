

package com.cloud.whp.common.swagger.annotation;

import com.cloud.whp.common.swagger.config.SwaggerAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author whp
 * @date 2018/7/21
 * 开启whp-cloud swagger
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({SwaggerAutoConfiguration.class})
public @interface EnableWhpSwagger2 {
}
