
package com.cloud.whp.manager.compensate.service;

import com.cloud.whp.manager.compensate.model.TransactionCompensateMsg;
import com.cloud.whp.manager.compensate.model.TxModel;
import com.lorne.core.framework.exception.ServiceException;
import com.cloud.whp.manager.model.ModelName;
import com.cloud.whp.manager.netty.model.TxGroup;

import java.util.List;

/**
 * @author whp
 * @since 2018-12-20
 */
public interface CompensateService {

	boolean saveCompensateMsg(TransactionCompensateMsg transactionCompensateMsg);

	List<ModelName> loadModelList();

	List<String> loadCompensateTimes(String model);

	List<TxModel> loadCompensateByModelAndTime(String path);

	void autoCompensate(String compensateKey, TransactionCompensateMsg transactionCompensateMsg);

	boolean executeCompensate(String key) throws ServiceException;

	void reloadCompensate(TxGroup txGroup);

	boolean hasCompensate();

	boolean delCompensate(String path);

	TxGroup getCompensateByGroupId(String groupId);
}
