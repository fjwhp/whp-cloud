package com.cloud.whp.common.security.exception;

import com.cloud.whp.common.security.component.WhpAuth2ExceptionSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * @author whp
 * @date 2018年12月19日
 * 自定义OAuth2Exception
 */
@JsonSerialize(using = WhpAuth2ExceptionSerializer.class)
public class WhpAuth2Exception extends OAuth2Exception {

	public WhpAuth2Exception(String msg) {
		super(msg);
	}
}
