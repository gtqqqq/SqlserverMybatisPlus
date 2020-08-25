package com.yida.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.yida.entity.L2Incindent;
import com.yida.mapper.L2IncindentMapper;
import com.yida.service.IL2IncindentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author guantianqi
 * @since 2020-07-06
 */
@Slf4j
@DS("slave")
@Service
public class L2IncindentServiceImpl extends ServiceImpl<L2IncindentMapper, L2Incindent> implements IL2IncindentService {

    @Override
    public Integer selectL2Totalticket() {
        return baseMapper.selectL2Totalticket();
    }

    @Override
    public Integer selectL2WorkingTickets() {
        return baseMapper.selectL2WorkingTickets();
    }

    @Override
    public Integer selectL2WaitingTickets() {
        return baseMapper.selectL2WaitingTickets();
    }

    @Override
    public Integer selectL2PendingTickets() {
        return baseMapper.selectL2PendingTickets();
    }

    @Override
    public Integer selectL2ClosedTickets() {
        return baseMapper.selectL2ClosedTickets();
    }
}
