package com.xkcoding.multi.datasource.mybatis.service;


import com.xkcoding.multi.datasource.mybatis.model.QualityCheckL1;
import com.xkcoding.multi.datasource.mybatis.model.QualityCheckL2;
import com.xkcoding.multi.datasource.mybatis.model.QualityCheckL3;

import java.util.List;

/**
 * 质量检测服务层
 * @author fanchenxi
 */
public interface QualityCheckService {


    /**
     * 获取质量检测L1的数据
     * @return
     */
    List<QualityCheckL1> getL1ModelData();

    /**
     * 添加数据到L1质量检测
     * @return
     */
    int insertL1ModelData(List<QualityCheckL1> l1);

    /**
     * 获取质量检测L2的数据
     * @return
     */
    QualityCheckL2 getL2ModelData();

    /**
     * 添加数据到L2质量检测
     * @return
     */
    int insertL2ModelData(QualityCheckL2 l2);

    /**
     * 获取质量检测L3的数据
     * @return
     */
    QualityCheckL3 getL3ModelData();

    /**
     * 添加数据到L3质量检测
     * @return
     */
    int insertL3ModelData(QualityCheckL3 l3);

    int deleteDataByToDay();
}
