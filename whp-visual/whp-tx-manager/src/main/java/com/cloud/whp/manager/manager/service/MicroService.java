
package com.cloud.whp.manager.manager.service;

import com.cloud.whp.manager.model.TxServer;
import com.cloud.whp.manager.model.TxState;

/**
 * @author whp
 * @since 2018-12-20
 */
public interface MicroService {

	String TMKEY = "tx-manager";

	TxServer getServer();

	TxState getState();
}
