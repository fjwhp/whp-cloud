
package com.cloud.whp.manager.model;

/**
 * 模块信息
 * @author whp
 * @since 2018-12-20
 */
public class ModelInfo {

	private String model;

	private String ipAddress;

	private String channelName;

	private String uniqueKey;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getUniqueKey() {
		return uniqueKey;
	}

	public void setUniqueKey(String uniqueKey) {
		this.uniqueKey = uniqueKey;
	}
}
