
package com.cloud.whp.manager.api.service;

import com.cloud.whp.manager.compensate.model.TxModel;
import com.lorne.core.framework.exception.ServiceException;
import com.cloud.whp.manager.model.ModelName;
import com.cloud.whp.manager.model.TxState;

import java.util.List;
import java.util.Map;

/**
 * @author whp
 * @since 2018-12-20
 */
public interface ApiAdminService {

	TxState getState();

	/**
	 * k/v 获取 值封装成map
	 *
	 * @return
	 */
	List<Map<String, Object>> getMapState();

	String loadNotifyJson();

	List<ModelName> modelList();


	List<String> modelTimes(String model);

	List<TxModel> modelInfos(String path);

	boolean compensate(String path) throws ServiceException;

	boolean hasCompensate();

	boolean delCompensate(String path);
}
