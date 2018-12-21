
package com.cloud.whp.common.gateway.vo
	;

import lombok.Data;
import org.springframework.cloud.gateway.route.RouteDefinition;

import java.io.Serializable;

/**
 * @author whp
 * @date 2018年12月19日
 * <p>
 * 扩展此类支持序列化a
 * See RouteDefinition.class
 */
@Data
public class RouteDefinitionVo extends RouteDefinition implements Serializable {
	/**
	 * 路由名称
	 */
	private String routeName;
}
