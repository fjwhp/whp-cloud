
package com.cloud.whp.daemon.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import lombok.extern.slf4j.Slf4j;

/**
 * @author whp
 * @date 2018/2/7
 * 测试Job
 */
@Slf4j
public class WhpSimpleJob2 implements SimpleJob {
	/**
	 * 业务执行逻辑
	 *
	 * @param shardingContext 分片信息
	 */
	@Override
	public void execute(ShardingContext shardingContext) {
		log.info("第二个执行了:{}", shardingContext);
	}
}
