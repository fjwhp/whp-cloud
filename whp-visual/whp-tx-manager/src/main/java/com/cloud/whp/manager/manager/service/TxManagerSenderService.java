
package com.cloud.whp.manager.manager.service;

import com.cloud.whp.manager.netty.model.TxGroup;

/**
 * @author whp
 * @since 2018-12-20
 */
public interface TxManagerSenderService {

	int confirm(TxGroup group);

	String sendMsg(String model, String msg, int delay);

	String sendCompensateMsg(String model, String groupId, String data, int startState);
}
