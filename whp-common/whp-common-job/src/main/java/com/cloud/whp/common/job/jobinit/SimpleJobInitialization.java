
package com.cloud.whp.common.job.jobinit;

import com.cloud.whp.common.job.properties.ElasticJobProperties;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.JobTypeConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;

import java.util.Map;


/**
 * @author whp
 * @date 2018/7/24
 * 简单任务初始
 */
public class SimpleJobInitialization extends AbstractJobInitialization {

	private Map<String, ElasticJobProperties.SimpleConfiguration> simpleConfigurationMap;

	public SimpleJobInitialization(final Map<String, ElasticJobProperties.SimpleConfiguration> simpleConfigurationMap) {
		this.simpleConfigurationMap = simpleConfigurationMap;
	}

	public void init() {
		for (String jobName : simpleConfigurationMap.keySet()) {
			ElasticJobProperties.SimpleConfiguration configuration = simpleConfigurationMap.get(jobName);
			initJob(jobName, configuration.getJobType(), configuration);
		}
	}

	@Override
	public JobTypeConfiguration getJobTypeConfiguration(String jobName, JobCoreConfiguration jobCoreConfiguration) {
		ElasticJobProperties.SimpleConfiguration configuration = simpleConfigurationMap.get(jobName);
		return new SimpleJobConfiguration(jobCoreConfiguration, configuration.getJobClass());
	}
}
