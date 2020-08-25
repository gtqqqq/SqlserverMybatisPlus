package com.xkcoding.multi.datasource.mybatis.service;

import com.xkcoding.multi.datasource.mybatis.model.HumanResourcesL1;
import com.xkcoding.multi.datasource.mybatis.model.HumanResourcesL2;
import com.xkcoding.multi.datasource.mybatis.model.HumanResourcesL3;


/**
 * 人力资源服务层
 */
public interface HumanResourcesService {

    /**
     * 获取L1人力资源数据
     * @return
     */
    HumanResourcesL1 getL1ModelData();

    /**
     * 添加L1人力资源数据
     * @return
     */
    int insertL1ModelData(HumanResourcesL1 l1);

    /**
     * 获取L2人力资源数据
     * @return
     */
    HumanResourcesL2 getL2ModelData();

    /**
     * 添加L2人力资源数据
     * @return
     */
    int insertL2ModelData(HumanResourcesL2 l2);

    /**
     * 获取L3人力资源数据
     * @return
     */
    HumanResourcesL3 getL3ModelData();

    /**
     * 添加L3人力资源数据
     * @return
     */
    int insertL3ModelData(HumanResourcesL3 l3);
}
