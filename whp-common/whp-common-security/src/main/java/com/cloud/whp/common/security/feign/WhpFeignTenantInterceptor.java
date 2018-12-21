
package com.cloud.whp.common.security.feign;

import com.cloud.whp.common.core.constant.CommonConstant;
import com.cloud.whp.common.core.util.TenantContextHolder;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

/**
 * @author whp
 * @date 2018/9/14
 */
@Slf4j
public class WhpFeignTenantInterceptor implements RequestInterceptor {
	@Override
	public void apply(RequestTemplate requestTemplate) {
		if (TenantContextHolder.getTenantId() == null) {
			log.error("TTL 中的 租户ID为空，feign拦截器 >> 增强失败");
			return;
		}
		requestTemplate.header(CommonConstant.TENANT_ID, TenantContextHolder.getTenantId().toString());
	}
}
