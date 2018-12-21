
package com.cloud.whp.manager.api.service.impl;

import com.cloud.whp.manager.api.service.ApiModelService;
import com.cloud.whp.manager.model.ModelInfo;
import com.cloud.whp.manager.manager.ModelInfoManager;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author whp
 * @since 2018-12-20
 */
@Service
public class ApiModelServiceImpl implements ApiModelService {


	@Override
	public List<ModelInfo> onlines() {
		return ModelInfoManager.getInstance().getOnlines();
	}


}
