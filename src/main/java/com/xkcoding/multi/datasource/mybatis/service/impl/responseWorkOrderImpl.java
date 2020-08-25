package com.xkcoding.multi.datasource.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xkcoding.multi.datasource.mybatis.mapper.responseCallMapper;
import com.xkcoding.multi.datasource.mybatis.mapper.responseWorkOrderMapper;
import com.xkcoding.multi.datasource.mybatis.model.responseCall;
import com.xkcoding.multi.datasource.mybatis.model.responseWorkOrder;
import com.xkcoding.multi.datasource.mybatis.service.responseWorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: smf
 * @time: 7/4/2020 5:24 PM
 * @description: L1累计工单派出 服务
 */
@Service
@DS("master")
public class responseWorkOrderImpl extends ServiceImpl<responseWorkOrderMapper, responseWorkOrder> implements responseWorkOrderService {

    @Autowired
    private responseWorkOrderMapper responseWorkOrderMapper;

    /**
     * 录入L1累计工单派出
     *
     * @param orderList
     * @return
     */
    @Override
    public Boolean insertResponseWorkOrder(List<responseWorkOrder> orderList) {
        return responseWorkOrderMapper.insertResponseWorkOrder(orderList);
    }

    /**
     * 清表
     */
    @Override
    public void deleteWorkOrder() {
        responseWorkOrderMapper.deleteResponseCall();
    }

    /**
     * 查询L1累计工单派出-累计响应ByIncident
     *
     * @return
     */
    @DS("slave")
    @Override
    public Integer selectResponseOrderByIncident() {
        return baseMapper.selectResponseOrderByIncident();
    }

    /**
     * 查询L1累计工单派出-累计响应ByRequest
     *
     * @return
     */
    @DS("slave")
    @Override
    public Integer selectResponseOrderByRequest() {
        return baseMapper.selectResponseOrderByRequest();
    }

    /**
     * 查询L1累计工单派出-累计响应ByNewCall
     *
     * @return
     */
    @DS("slave")
    @Override
    public Integer selectResponseOrderByNewCall() {
        return baseMapper.selectResponseOrderByNewCall();
    }

    /**
     * 查询L1累计工单派出-累计解决ByIncident
     *
     * @return
     */
    @DS("slave")
    @Override
    public Integer selectResponseOrderSolveByIncident() {
        return baseMapper.selectResponseOrderSolveByIncident();
    }

    /**
     * 查询L1累计工单派出-累计解决ByIncident
     *
     * @return
     */
    @DS("slave")
    @Override
    public Integer selectResponseOrderSolveByRequest() {
        return baseMapper.selectResponseOrderSolveByRequest();
    }

    /**
     * 查询L1累计工单派出-累计解决ByNewCall
     *
     * @return
     */
    @DS("slave")
    @Override
    public Integer selectResponseOrderSolveByNewCall() {
        return baseMapper.selectResponseOrderSolveByNewCall();
    }

}
