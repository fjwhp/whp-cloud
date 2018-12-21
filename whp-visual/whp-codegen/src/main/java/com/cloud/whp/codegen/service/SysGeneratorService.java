
package com.cloud.whp.codegen.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.whp.codegen.entity.GenConfig;

import java.util.List;
import java.util.Map;

/**
 * @author whp
 * @date 2018/7/29
 */
public interface SysGeneratorService {
	/**
	 * 生成代码
	 *
	 * @param tableNames 表名称
	 * @return
	 */
	byte[] generatorCode(GenConfig tableNames);

	/**
	 * 分页查询表
	 * @param tableName 表名
	 * @return
	 */
	IPage<List<Map<String, Object>>> getPage(Page page, String tableName);
}
