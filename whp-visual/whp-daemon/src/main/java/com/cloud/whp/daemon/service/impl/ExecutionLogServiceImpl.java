package com.cloud.whp.daemon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.whp.daemon.service.ExecutionLogService;
import com.cloud.whp.daemon.entity.ExecutionLog;
import com.cloud.whp.daemon.mapper.ExecutionLogMapper;
import org.springframework.stereotype.Service;

/**
 * 任务日志处理
 *
 * @author whp
 * @date 2018/11/22
 */
@Service("executionLogService")
public class ExecutionLogServiceImpl extends ServiceImpl<ExecutionLogMapper, ExecutionLog> implements ExecutionLogService {

}
