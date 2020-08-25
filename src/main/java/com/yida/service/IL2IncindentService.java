package com.yida.service;

import com.yida.entity.L2Incindent;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author guantianqi
 * @since 2020-07-06
 */
public interface IL2IncindentService extends IService<L2Incindent> {

    public Integer  selectL2Totalticket();


    public Integer  selectL2WorkingTickets();


    public Integer  selectL2WaitingTickets();


    public Integer  selectL2PendingTickets();


    public Integer  selectL2ClosedTickets();
}
