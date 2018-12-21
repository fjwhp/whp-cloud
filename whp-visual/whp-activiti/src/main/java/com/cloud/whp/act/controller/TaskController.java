
package com.cloud.whp.act.controller;

import cn.hutool.core.io.IoUtil;
import com.cloud.whp.act.dto.LeaveBillDto;
import com.cloud.whp.act.service.ActTaskService;
import com.cloud.whp.common.core.util.R;
import com.cloud.whp.common.security.util.SecurityUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.Map;

/**
 * @author whp
 * @date 2018/9/28
 */
@RestController
@AllArgsConstructor
@RequestMapping("/task")
public class TaskController {
	private final ActTaskService actTaskService;

	@GetMapping("/todo")
	public R todo(@RequestParam Map<String, Object> params) {
		return new R<>(actTaskService.getTaskByName(params, SecurityUtils.getUsername()));
	}

	@GetMapping("/{id}")
	public R getTaskById(@PathVariable String id) {
		return new R(actTaskService.getTaskById(id));
	}

	@PostMapping
	public R submitTask(@RequestBody LeaveBillDto leaveBillDto) {
		return new R(actTaskService.submitTask(leaveBillDto));
	}

	@GetMapping("/view/{id}")
	public ResponseEntity viewCurrentImage(@PathVariable String id) {
		InputStream imageStream = actTaskService.viewByTaskId(id);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		return new ResponseEntity(IoUtil.readBytes(imageStream), headers, HttpStatus.CREATED);
	}

	@GetMapping("/comment/{id}")
	public R commitList(@PathVariable String id) {
		return new R(actTaskService.getCommentByTaskId(id));
	}


}
