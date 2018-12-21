
package com.cloud.whp.admin.controller;

import cn.hutool.json.JSONArray;
import com.cloud.whp.admin.service.SysRouteConfService;
import com.cloud.whp.common.core.util.R;
import com.cloud.whp.common.log.annotation.SysLog;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 路由
 *
 * @author whp
 * @date 2018-11-06 10:17:18
 */
@RestController
@AllArgsConstructor
@RequestMapping("/route")
@Api(value = "route",description = "动态路由管理模块")
public class SysRouteConfController {
	private final SysRouteConfService sysRouteConfService;


	/**
	 * 获取当前定义的路由信息
	 *
	 * @return
	 */
	@GetMapping
	public R listRoutes() {
		return new R<>(sysRouteConfService.list());
	}

	/**
	 * 修改路由
	 *
	 * @param routes 路由定义
	 * @return
	 */
	@SysLog("修改路由")
	@PutMapping
	public R updateRoutes(@RequestBody JSONArray routes) {
		return new R(sysRouteConfService.updateRoutes(routes));
	}

}
