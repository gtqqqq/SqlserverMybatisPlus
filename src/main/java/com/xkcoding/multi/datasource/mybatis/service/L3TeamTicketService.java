package com.xkcoding.multi.datasource.mybatis.service;

import com.xkcoding.multi.datasource.mybatis.model.L3TeamTicket3;
import com.xkcoding.multi.datasource.mybatis.model.NotCloseModel;
import com.xkcoding.multi.datasource.mybatis.model.TodayTotalModel;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author fnchenxi
 */
public interface L3TeamTicketService {

    /**
     * 查询L3总票数量
     * @return
     */

    Integer getTotalTickets();

    /**
     * 查询L3working票数量
     * @return
     */

    Integer getWorkIngTickets();


    /**
     * 查询L3待售票数
     * @return
     */

    Integer getPendingTickets();

    /**
     * 查询L3关闭票数量
     * @return
     */

    Integer getClosedTickets();

    /**
     *  查询L3等待票数量
     * @return
     */
    Integer getWaitingTickets();

    /**
     * 组合以上汇总的数据为一个对象并返回数据
     * @return
     */
    L3TeamTicket3 getModelData();

    int insertSelective(L3TeamTicket3 modelData);

    int deleteDataByToDay();
}
