package com.xkcoding.multi.datasource.mybatis.service;

import com.xkcoding.multi.datasource.mybatis.model.NotCloseModel;

/**
 * 尚未关闭工单
 * @author fanchenxi
 */
public interface NotCloseOrderService {

    /**
     * 查询当天尚未关闭工单数
     * @return
     */
     Integer getNotCloseOrderNum();

    /**
     * 查询当天滞留的工单数量
     */
    Integer getStopOrderNum();

    /**
     *  查询当天进行中的工单数量
     * @return
     */
    Integer getOnGoingOrderNum();

    /**
     * 组合以上3条汇总的数据为一个对象并返回数据
     * @return
     */
    public NotCloseModel getNotCloseModelData();

    int insertSelective(NotCloseModel record);

    int deleteDataByToDay();


}
