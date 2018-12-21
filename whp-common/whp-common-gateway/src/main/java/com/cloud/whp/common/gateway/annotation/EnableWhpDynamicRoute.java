package com.cloud.whp.common.gateway.annotation;

import com.cloud.whp.common.gateway.configuration.DynamicRouteAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author whp
 * @date 2018年12月19日
 * <p>
 * 开启whp 动态路由
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(DynamicRouteAutoConfiguration.class)
public @interface EnableWhpDynamicRoute {
}
