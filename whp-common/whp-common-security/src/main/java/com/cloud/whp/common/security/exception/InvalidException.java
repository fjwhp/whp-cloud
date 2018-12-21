
package com.cloud.whp.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.cloud.whp.common.security.component.WhpAuth2ExceptionSerializer;

/**
 * @author whp
 * @date 2018/7/8
 */
@JsonSerialize(using = WhpAuth2ExceptionSerializer.class)
public class InvalidException extends WhpAuth2Exception {

	public InvalidException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "invalid_exception";
	}

	@Override
	public int getHttpErrorCode() {
		return 426;
	}

}
