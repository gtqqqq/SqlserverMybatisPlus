package com.xkcoding.multi.datasource.mybatis.service;

import com.xkcoding.multi.datasource.mybatis.model.responseCall;
import com.xkcoding.multi.datasource.mybatis.model.responseWorkOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: smf
 * @time: 7/7/2020 11:14 AM
 * @description: L1累计工单派出 服务层
 */
public interface responseWorkOrderService {


    /***
     * 录入L1累计电话接入 累计响应 以及累计解决
     */
    public Boolean insertResponseWorkOrder(List<responseWorkOrder> orderList);

    /**
     * 清表
     */
    public void deleteWorkOrder();

    /**
     * 查询L1累计工单派出-累计响应ByIncident
     *
     * @return
     */
    public Integer selectResponseOrderByIncident();

    /**
     * 查询L1累计工单派出-累计响应ByRequest
     *
     * @return
     */
    public Integer selectResponseOrderByRequest();

    /**
     * 查询L1累计工单派出-累计响应ByNewCall
     *
     * @return
     */
    public Integer selectResponseOrderByNewCall();


    /**
     * 查询L1累计工单派出-累计解决ByIncident
     *
     * @return
     */
    public Integer selectResponseOrderSolveByIncident();

    /**
     * 查询L1累计工单派出-累计解决ByRequest
     *
     * @return
     */
    public Integer selectResponseOrderSolveByRequest();


    /**
     * 查询L1累计工单派出-累计解决ByNewCall
     *
     * @return
     */
    public Integer selectResponseOrderSolveByNewCall();


}
