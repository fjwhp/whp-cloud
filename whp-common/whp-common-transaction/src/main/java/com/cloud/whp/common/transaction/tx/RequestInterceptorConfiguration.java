

package com.cloud.whp.common.transaction.tx;

import com.cloud.whp.common.transaction.tx.springcloud.feign.TransactionRestTemplateInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LCN on 2018/1/18
 *
 * @author LCN
 * @since 4.1.0
 */
@Configuration
public class RequestInterceptorConfiguration {

	@Bean
	public RequestInterceptor requestInterceptor() {
		return new TransactionRestTemplateInterceptor();
	}
}
