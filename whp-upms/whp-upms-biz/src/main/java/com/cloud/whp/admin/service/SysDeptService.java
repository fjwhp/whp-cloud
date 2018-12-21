
package com.cloud.whp.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.whp.admin.api.dto.DeptTree;
import com.cloud.whp.admin.api.entity.SysDept;

import java.util.List;

/**
 * <p>
 * 部门管理 服务类
 * </p>
 *
 * @author whp
 * @since 2018-12-19
 */
public interface SysDeptService extends IService<SysDept> {

	/**
	 * 查询部门树菜单
	 *
	 * @return 树
	 */
	List<DeptTree> selectTree();

	/**
	 * 查询用户部门树
	 *
	 * @return
	 */
	List<DeptTree> getUserTree();

	/**
	 * 添加信息部门
	 *
	 * @param sysDept
	 * @return
	 */
	Boolean saveDept(SysDept sysDept);

	/**
	 * 删除部门
	 *
	 * @param id 部门 ID
	 * @return 成功、失败
	 */
	Boolean removeDeptById(Integer id);

	/**
	 * 更新部门
	 *
	 * @param sysDept 部门信息
	 * @return 成功、失败
	 */
	Boolean updateDeptById(SysDept sysDept);

}
