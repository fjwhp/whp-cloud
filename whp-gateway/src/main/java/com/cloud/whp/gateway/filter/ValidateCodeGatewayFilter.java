package com.cloud.whp.gateway.filter;

import cn.hutool.core.util.StrUtil;
import com.cloud.whp.gateway.config.FilterIgnorePropertiesConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.cloud.whp.common.core.constant.CommonConstant;
import com.cloud.whp.common.core.constant.SecurityConstants;
import com.cloud.whp.common.core.exception.ValidateCodeException;
import com.cloud.whp.common.core.util.R;
import com.cloud.whp.common.core.util.WebUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @author whp
 * @date 2018年12月19日15:04:05
 * 验证码处理
 */
@Slf4j
@Component
@AllArgsConstructor
public class ValidateCodeGatewayFilter extends AbstractGatewayFilterFactory {
	private final ObjectMapper objectMapper;
	private final RedisTemplate redisTemplate;
	private final FilterIgnorePropertiesConfig filterIgnorePropertiesConfig;

	@Override
	public GatewayFilter apply(Object config) {
		return (exchange, chain) -> {
			ServerHttpRequest request = exchange.getRequest();

			// 不是登录请求，直接向下执行
			if (!StrUtil.containsAnyIgnoreCase(request.getURI().getPath()
				, SecurityConstants.OAUTH_TOKEN_URL, SecurityConstants.SMS_TOKEN_URL)) {
				return chain.filter(exchange);
			}

			// 终端设置不校验， 直接向下执行(1. 从请求参数中获取 2.从header取)
			String clientId = request.getQueryParams().getFirst("client_id");
			if (StrUtil.isNotBlank(clientId)
				&& filterIgnorePropertiesConfig.getClients().contains(clientId)) {
				return chain.filter(exchange);
			}

			try {
				String[] clientInfos = WebUtils.getClientId(request);
				if (filterIgnorePropertiesConfig.getClients().contains(clientInfos[0])) {
					return chain.filter(exchange);
				}

				//校验验证码
				checkCode(request);
			} catch (Exception e) {
				ServerHttpResponse response = exchange.getResponse();
				response.setStatusCode(HttpStatus.PRECONDITION_REQUIRED);
				try {
					return response.writeWith(Mono.just(response.bufferFactory()
						.wrap(objectMapper.writeValueAsBytes(new R<>(e)))));
				} catch (JsonProcessingException e1) {
					log.error("对象输出异常", e1);
				}
			}

			return chain.filter(exchange);
		};
	}

	/**
	 * 检查code
	 * @author whp
	 * @param request
	 * @throws ValidateCodeException 校验异常
	 */
	private void checkCode(ServerHttpRequest request) throws ValidateCodeException {
		String code = request.getQueryParams().getFirst("code");

		if (StrUtil.isBlank(code)) {
			throw new ValidateCodeException();
		}

		String randomStr = request.getQueryParams().getFirst("randomStr");
		if (StrUtil.isBlank(randomStr)) {
			randomStr = request.getQueryParams().getFirst("mobile");
		}

		String key = CommonConstant.DEFAULT_CODE_KEY + randomStr;
		if (!redisTemplate.hasKey(key)) {
			throw new ValidateCodeException();
		}

		Object codeObj = redisTemplate.opsForValue().get(key);

		if (codeObj == null) {
			throw new ValidateCodeException();
		}

		String saveCode = codeObj.toString();
		if (StrUtil.isBlank(saveCode)) {
			redisTemplate.delete(key);
			throw new ValidateCodeException();
		}

		if (!StrUtil.equals(saveCode, code)) {
			redisTemplate.delete(key);
			throw new ValidateCodeException();
		}

		redisTemplate.delete(key);
	}
}
