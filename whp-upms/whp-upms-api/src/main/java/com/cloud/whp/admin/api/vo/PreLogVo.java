
package com.cloud.whp.admin.api.vo;

import lombok.Data;

/**
 * @author whp
 * @since 2018年12月20日
 * 前端日志vo
 */
@Data
public class PreLogVo {
	private String url;
	private String time;
	private String user;
	private String type;
	private String message;
	private String stack;
	private String info;
}
