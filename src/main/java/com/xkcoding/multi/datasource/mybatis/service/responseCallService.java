package com.xkcoding.multi.datasource.mybatis.service;

import com.xkcoding.multi.datasource.mybatis.model.responseCall;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: smf
 * @description: L1累计电话接入 服务层
 */
public interface responseCallService {
    /***
     * 录入L1累计电话接入 以及累计响应 累计解决
     */
    public Boolean insertResponseCall(@Param("responseCallsList") List<responseCall> responseCallsList);

    /***
     * 清表
     */
    public void deleteResponseCall();

    /**
     * L1累计电话接入
     *
     * @return
     */
    public Integer selectResponseCall();

    /**
     * L1累计电话接入-累计响应
     *
     * @return
     */
    public Integer selectByResponseCall();

    /**
     * L1累计电话接入-累计解决
     *
     * @return
     */
    public Integer selectBySoleResponseCall();


}
