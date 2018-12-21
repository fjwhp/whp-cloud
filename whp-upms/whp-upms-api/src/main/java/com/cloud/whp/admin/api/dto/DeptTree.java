
package com.cloud.whp.admin.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author whp
 * @date 2018年12月20日
 * 部门树
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DeptTree extends TreeNode {
	private String name;
}
