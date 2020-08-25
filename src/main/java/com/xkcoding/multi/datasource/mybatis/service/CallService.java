package com.xkcoding.multi.datasource.mybatis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xkcoding.multi.datasource.mybatis.model.Call;

import java.util.HashMap;
import java.util.List;


/**
 * @author: smf
 * @description: call 服务
 */
public interface CallService extends IService<Call> {


    /***
     *查询 L1累计电话接入
     */
    public List<Object> selectPhoneAll();

    /**
     * 查询 L1累计电话接入累计响应
     *
     * @param code
     * @return
     */
    public List<HashMap> selectCallByCode(String code);

    /**
     * 查询 L1累计电话接入累计解决
     *
     * @param code
     * @return
     */
    public List<Object> selectCallSolveByCode(String code);

    /***
     *查询 L1累计工单派出
     */
    public List<Object> selectWorkOrder();

    /***
     *查询 L1累计工单累计响应
     */
    public List<Object> selectWorkOrderResp();

    /**
     * 查询 L1累计工单累计解决
     *
     * @return
     */
    public List<Object> selectWorkOrderSolveSum();

}
