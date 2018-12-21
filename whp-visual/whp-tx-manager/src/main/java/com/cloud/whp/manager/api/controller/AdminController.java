
package com.cloud.whp.manager.api.controller;

import com.cloud.whp.manager.api.service.ApiAdminService;
import com.cloud.whp.manager.api.service.ApiModelService;
import com.cloud.whp.manager.compensate.model.TxModel;
import com.cloud.whp.manager.model.ModelInfo;
import com.lorne.core.framework.exception.ServiceException;
import com.cloud.whp.manager.model.ModelName;
import com.cloud.whp.manager.model.TxState;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author whp
 * @since 2018-12-20
 */
@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
	private final ApiAdminService apiAdminService;
	private final ApiModelService apiModelService;


	@RequestMapping(value = "/onlines", method = RequestMethod.GET)
	public List<ModelInfo> onlines() {
		return apiModelService.onlines();
	}


	@RequestMapping(value = "/avueOnlines", method = RequestMethod.GET)
	public List<ModelInfo> avueOnlines() {
		return apiModelService.onlines();
	}


	@RequestMapping(value = "/setting", method = RequestMethod.GET)
	public TxState setting() {
		return apiAdminService.getState();
	}

	@RequestMapping(value = "/avueSetting", method = RequestMethod.GET)
	public List<Map<String, Object>> avueSetting() {
		return apiAdminService.getMapState();
	}

	@RequestMapping(value = "/json", method = RequestMethod.GET)
	public String json() {
		return apiAdminService.loadNotifyJson();
	}

	@RequestMapping(value = "/modelList", method = RequestMethod.GET)
	public List<ModelName> modelList() {
		return apiAdminService.modelList();
	}

	@RequestMapping(value = "/modelTimes", method = RequestMethod.GET)
	public List<String> modelTimes(@RequestParam("model") String model) {
		return apiAdminService.modelTimes(model);
	}


	@RequestMapping(value = "/modelInfos", method = RequestMethod.GET)
	public List<TxModel> modelInfos(@RequestParam("path") String path) {
		return apiAdminService.modelInfos(path);
	}

	@RequestMapping(value = "/compensate", method = RequestMethod.GET)
	public boolean compensate(@RequestParam("path") String path) throws ServiceException {
		return apiAdminService.compensate(path);
	}

	@RequestMapping(value = "/delCompensate", method = RequestMethod.GET)
	public boolean delCompensate(@RequestParam("path") String path) throws ServiceException {
		return apiAdminService.delCompensate(path);
	}

	@RequestMapping(value = "/hasCompensate", method = RequestMethod.GET)
	public boolean hasCompensate() throws ServiceException {
		return apiAdminService.hasCompensate();
	}
}
