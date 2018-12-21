package com.cloud.whp.common.core.exception;

import lombok.NoArgsConstructor;

/**
 * @author whp
 * @date 2018年12月19日
 * 403 授权拒绝
 */
@NoArgsConstructor
public class WhpDeniedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public WhpDeniedException(String message) {
		super(message);
	}

	public WhpDeniedException(Throwable cause) {
		super(cause);
	}

	public WhpDeniedException(String message, Throwable cause) {
		super(message, cause);
	}

	public WhpDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
