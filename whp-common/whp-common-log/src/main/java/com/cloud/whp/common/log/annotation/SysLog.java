
package com.cloud.whp.common.log.annotation;

import java.lang.annotation.*;

/**
 * @author whp
 * @date 2018年12月19日
 * 操作日志注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

	/**
	 * 描述
	 *
	 * @return {String}
	 */
	String value();
}
