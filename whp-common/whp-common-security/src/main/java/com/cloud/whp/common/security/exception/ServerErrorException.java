
package com.cloud.whp.common.security.exception;

import com.cloud.whp.common.security.component.WhpAuth2ExceptionSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.http.HttpStatus;

/**
 * @author whp
 * @date 2018/7/8
 */
@JsonSerialize(using = WhpAuth2ExceptionSerializer.class)
public class ServerErrorException extends WhpAuth2Exception {

	public ServerErrorException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "server_error";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.INTERNAL_SERVER_ERROR.value();
	}

}
