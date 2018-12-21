

package com.cloud.whp.common.transaction.tx.springcloud.interceptor;

import com.codingapi.tx.aop.service.AspectBeforeService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author LCN on 2017/6/7.
 * @author LCN
 * @author whp
 * @since 4.1.0
 */

@Component
public class TxManagerInterceptor {

	@Autowired
	private AspectBeforeService aspectBeforeService;

	public Object around(ProceedingJoinPoint point) throws Throwable {
		RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
		String groupId = request.getHeader("tx-group");
		return aspectBeforeService.around(groupId, point);
	}
}
