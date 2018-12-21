
package com.cloud.whp.common.transaction.tx.springcloud.http;

import com.codingapi.tx.aop.bean.TxTransactionLocal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 *@author LCN on 2017/7/3.
 *
 * @author LCN
 * @since 4.1.0
 */
@Slf4j
public class TransactionHttpRequestInterceptor implements ClientHttpRequestInterceptor {
	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

		TxTransactionLocal txTransactionLocal = TxTransactionLocal.current();
		String groupId = txTransactionLocal == null ? null : txTransactionLocal.getGroupId();

		log.info("LCN-SpringCloud TxGroup info -> groupId:" + groupId);

		if (txTransactionLocal != null) {
			request.getHeaders().add("tx-group", groupId);
		}
		return execution.execute(request, body);
	}
}
