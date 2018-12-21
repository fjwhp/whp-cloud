
package com.cloud.whp.admin.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.whp.admin.api.entity.SysMenu;
import com.cloud.whp.admin.api.entity.SysRoleMenu;
import com.cloud.whp.admin.api.vo.MenuVO;
import com.cloud.whp.admin.mapper.SysMenuMapper;
import com.cloud.whp.admin.mapper.SysRoleMenuMapper;
import com.cloud.whp.admin.service.SysMenuService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author whp
 * @since 2018-12-19
 */
@Service
@AllArgsConstructor
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
	private final SysRoleMenuMapper sysRoleMenuMapper;

	@Override
	@Cacheable(value = "menu_details", key = "#roleId  + '_menu'")
	public List<MenuVO> findMenuByRoleId(Integer roleId) {
		return baseMapper.listMenusByRoleId(roleId);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	@CacheEvict(value = "menu_details", allEntries = true)
	public Boolean removeMenuById(Integer id) {
		// 查询父节点为当前节点的节点
		List<Integer> menuIdList = this.list(Wrappers.<SysMenu>query()
			.lambda().eq(SysMenu::getParentId, id))
			.stream().map(SysMenu::getMenuId)
			.collect(Collectors.toList());

		//删除关联ROLE_MENU 数据
		menuIdList.add(id);
		menuIdList.forEach(menu -> sysRoleMenuMapper
			.delete(Wrappers.<SysRoleMenu>query()
				.lambda().eq(SysRoleMenu::getMenuId, menu)));
		//删除当前菜单及其子菜单
		return this.removeByIds(menuIdList);
	}

	@Override
	@CacheEvict(value = "menu_details", allEntries = true)
	public Boolean updateMenuById(SysMenu sysMenu) {
		return this.updateById(sysMenu);
	}
}
