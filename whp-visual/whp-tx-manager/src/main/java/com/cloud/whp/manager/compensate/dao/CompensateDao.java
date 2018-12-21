
package com.cloud.whp.manager.compensate.dao;

import com.cloud.whp.manager.compensate.model.TransactionCompensateMsg;

import java.util.List;

/**
 * @author whp
 * @since 2018-12-20
 */
public interface CompensateDao {

	String saveCompensateMsg(TransactionCompensateMsg transactionCompensateMsg);

	List<String> loadCompensateKeys();

	List<String> loadCompensateTimes(String model);

	List<String> loadCompensateByModelAndTime(String path);

	String getCompensate(String key);

	String getCompensateByGroupId(String groupId);

	void deleteCompensateByPath(String path);

	void deleteCompensateByKey(String key);

	boolean hasCompensate();
}
