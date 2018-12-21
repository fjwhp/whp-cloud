
package com.cloud.whp.admin.api.vo;

import com.cloud.whp.admin.api.entity.SysLog;
import lombok.Data;

import java.io.Serializable;

/**
 * @author whp
 * @since 2018年12月20日
 */
@Data
public class LogVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private SysLog sysLog;
	private String username;
}
