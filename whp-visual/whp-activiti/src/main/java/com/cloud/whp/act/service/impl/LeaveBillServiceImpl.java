
package com.cloud.whp.act.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.whp.act.entity.LeaveBill;
import com.cloud.whp.act.mapper.LeaveBillMapper;
import com.cloud.whp.act.service.LeaveBillService;
import org.springframework.stereotype.Service;

/**
 * @author whp
 * @date 2018-09-27
 */
@Service("leaveBillService")
public class LeaveBillServiceImpl extends ServiceImpl<LeaveBillMapper, LeaveBill> implements LeaveBillService {

}
