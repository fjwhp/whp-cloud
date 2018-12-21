
package com.cloud.whp.admin.api.feign;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.whp.admin.api.feign.factory.RemoteTokenServiceFallbackFactory;
import com.cloud.whp.common.core.constant.SecurityConstants;
import com.cloud.whp.common.core.constant.ServiceNameConstant;
import com.cloud.whp.common.core.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author whp
 * @since 2018年12月20日
 */
@FeignClient(value = ServiceNameConstant.AUTH_SERVICE, fallbackFactory = RemoteTokenServiceFallbackFactory.class)
public interface RemoteTokenService {
	/**
	 * 分页查询token 信息
	 *
	 * @param params 分页参数
	 * @param from   内部调用标志
	 * @return page
	 */
	@PostMapping("/token/page")
	R<Page> getTokenPage(@RequestBody Map<String, Object> params, @RequestHeader(SecurityConstants.FROM) String from);

	/**
	 * 删除token
	 *
	 * @param token token
	 * @param from  调用标志
	 * @return
	 */
	@DeleteMapping("/token/{token}")
	R<Boolean> removeTokenById(@PathVariable("token") String token, @RequestHeader(SecurityConstants.FROM) String from);
}
