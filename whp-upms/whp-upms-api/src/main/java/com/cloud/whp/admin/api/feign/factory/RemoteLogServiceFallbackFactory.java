
package com.cloud.whp.admin.api.feign.factory;

import com.cloud.whp.admin.api.feign.fallback.RemoteLogServiceFallbackImpl;
import com.cloud.whp.admin.api.feign.RemoteLogService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author whp
 * @since 2018年12月20日
 */
@Component
public class RemoteLogServiceFallbackFactory implements FallbackFactory<RemoteLogService> {

	@Override
	public RemoteLogService create(Throwable throwable) {
		RemoteLogServiceFallbackImpl remoteLogServiceFallback = new RemoteLogServiceFallbackImpl();
		remoteLogServiceFallback.setCause(throwable);
		return remoteLogServiceFallback;
	}
}
