
package com.cloud.whp.daemon.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.whp.common.core.util.R;
import com.cloud.whp.daemon.entity.ExecutionLog;
import com.cloud.whp.daemon.service.ExecutionLogService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * @author whp
 * @date 2018-08-03 22:15:56
 */
@RestController
@RequestMapping("/execution-log")
@AllArgsConstructor
public class ExecutionLogController {

	private final ExecutionLogService executionLogService;

	/**
	 * 任务日志处理简单分页查询
	 *
	 * @param page         分页对象
	 * @param executionLog 任务日志处理
	 * @return
	 */
	@GetMapping("/page")
	public R getExecutionLogPage(Page page, ExecutionLog executionLog) {
		return new R<>(executionLogService.page(page, Wrappers.query(executionLog)));
	}


	/**
	 * 通过id查询一条记录
	 *
	 * @param id
	 * @return R
	 */
	@GetMapping("/{id}")
	public R getById(@PathVariable("id") String id) {
		return new R<>(executionLogService.getById(id));
	}

	/**
	 * 保存
	 *
	 * @param executionLog
	 * @return R
	 */
	@PostMapping
	public R save(@RequestBody ExecutionLog executionLog) {
		return new R<>(executionLogService.save(executionLog));
	}

	/**
	 * 修改
	 *
	 * @param executionLog
	 * @return R
	 */
	@PutMapping
	public R update(@RequestBody ExecutionLog executionLog) {
		return new R<>(executionLogService.updateById(executionLog));
	}

	/**
	 * 删除
	 *
	 * @param id
	 * @return R
	 */
	@DeleteMapping("/{id}")
	public R removeById(@PathVariable String id) {
		return new R<>(executionLogService.removeById(id));
	}

}
