package com.xkcoding.multi.datasource.mybatis.service;

import com.xkcoding.multi.datasource.mybatis.model.OrderUpL1;
import com.xkcoding.multi.datasource.mybatis.model.OrderUpL2;
import com.xkcoding.multi.datasource.mybatis.model.OrderUpL3;

import java.util.List;

/**
 * 升单量服务层
 * @author fanchenxi
 */
public interface OrderUpService {

    /**
     * 获取L1的升单量数据
     * @return
     */
    List<OrderUpL1> getL1ModelData();

    /**
     * 清表 order_up_l1
     *
     * @return
     */
    int deleteL1ModelData();

    /**
     * 添加L1的升单量数据
     * @return
     */
    int insertL1ModelData(List<OrderUpL1> orderUpL1List);

    /**
     * 获取L2的升单量数据
     * @return
     */
    List<OrderUpL2> getL2ModelData();

    /**
     * 添加L2的升单量数据
     * @return
     */
    int insertL2ModelData(List<OrderUpL2> l2);

    /**
     * 获取L3的升单量数据
     * @return
     */
    List<OrderUpL3> getL3ModelData();

    /**
     * 添加L3的升单量数据
     * @return
     */
    int insertL3ModelData(List<OrderUpL3> l3);

    int deleteL1DataByToDay();

    int deleteL2DataByToDay();

    int deleteL3DataByToDay();
}
