
package com.cloud.whp.act.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author whp
 * @date 2018-12-20
 */
@Data
public class StartTaskForm {
	@NotEmpty
	public String procDefKey;
	public String entityId;
	@NotEmpty
	public String title;
	public String comment;
}
