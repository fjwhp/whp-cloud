
package com.cloud.whp.manager.manager.service;

import com.cloud.whp.manager.model.LoadBalanceInfo;

/**
 * @author whp
 * @since 2018-12-20
 */
public interface LoadBalanceService {

	boolean put(LoadBalanceInfo loadBalanceInfo);

	LoadBalanceInfo get(String groupId, String key);

	boolean remove(String groupId);

	String getLoadBalanceGroupName(String groupId);

}
