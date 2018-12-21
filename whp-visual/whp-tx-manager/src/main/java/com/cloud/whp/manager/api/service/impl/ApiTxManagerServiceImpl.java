
package com.cloud.whp.manager.api.service.impl;


import com.cloud.whp.manager.api.service.ApiTxManagerService;
import com.cloud.whp.manager.compensate.model.TransactionCompensateMsg;
import com.cloud.whp.manager.compensate.service.CompensateService;
import com.cloud.whp.manager.config.ConfigReader;
import com.cloud.whp.manager.manager.service.MicroService;
import com.cloud.whp.manager.manager.service.TxManagerSenderService;
import com.cloud.whp.manager.manager.service.TxManagerService;
import com.cloud.whp.manager.model.TxServer;
import com.cloud.whp.manager.model.TxState;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author whp
 * @since 2018-12-20
 */
@Service
@AllArgsConstructor
public class ApiTxManagerServiceImpl implements ApiTxManagerService {

	private final TxManagerService managerService;

	private final MicroService eurekaService;

	private final CompensateService compensateService;

	private final TxManagerSenderService txManagerSenderService;

	private final ConfigReader configReader;


	@Override
	public TxServer getServer() {
		return eurekaService.getServer();
	}


	@Override
	public int cleanNotifyTransaction(String groupId, String taskId) {
		return managerService.cleanNotifyTransaction(groupId, taskId);
	}


	@Override
	public boolean sendCompensateMsg(long currentTime, String groupId, String model, String address, String uniqueKey, String className, String methodStr, String data, int time, int startError) {
		TransactionCompensateMsg transactionCompensateMsg = new TransactionCompensateMsg(currentTime, groupId, model, address, uniqueKey, className, methodStr, data, time, 0, startError);
		return compensateService.saveCompensateMsg(transactionCompensateMsg);
	}

	@Override
	public String sendMsg(String model, String msg) {
		return txManagerSenderService.sendMsg(model, msg, configReader.getTransactionNettyDelayTime());
	}


	@Override
	public TxState getState() {
		return eurekaService.getState();
	}
}
