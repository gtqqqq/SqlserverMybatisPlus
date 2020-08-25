package com.xkcoding.multi.datasource.mybatis.service;

import com.xkcoding.multi.datasource.mybatis.model.FteOrderL1;
import com.xkcoding.multi.datasource.mybatis.model.FteOrderL2;
import com.xkcoding.multi.datasource.mybatis.model.FteOrderL3;

import java.util.List;

/**
 * FTE服务层
 *
 * @author fanchenxi
 */
public interface FteService {

    /**
     * 获取L2Fte等相关数据
     *
     * @return
     */
    List<FteOrderL2> getL2FteOrderList();

    /**
     * 获取L3Fte等相关数据
     *
     * @return
     */
    List<FteOrderL3> getL3FteOrderList();

    int insertL2ModelData(List<FteOrderL2> l2FteOrderList);

    int insertL3ModelData(List<FteOrderL3> l3FteOrderList);


    /**
     * 查询 FTE ,分组AVG ,以及Responded Tickets
     *
     * @return
     */
    public List<FteOrderL1> getL1FteOrderList();

    /**
     * 录入 fte_order_l1
     *
     * @return
     */
    public Boolean insertL1ModelData(List<FteOrderL1> fteOrderL1s);

    /**
     * 清表fte_order_l1
     *
     * @return
     */
    int deleteFteOrderL1();

    int deleteL2DataByToDay();

    int deleteL3DataByToDay();

    int deleteL1DataByToDay();
}
