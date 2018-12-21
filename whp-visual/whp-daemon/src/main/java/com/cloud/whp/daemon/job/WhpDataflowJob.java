
package com.cloud.whp.daemon.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;

import java.util.List;

/**
 * @author whp
 * @date 2018/2/8
 */
public class WhpDataflowJob implements DataflowJob<Integer> {

	@Override
	public List<Integer> fetchData(ShardingContext shardingContext) {
		return null;
	}

	@Override
	public void processData(ShardingContext shardingContext, List<Integer> list) {

	}
}
