package com.xkcoding.multi.datasource.mybatis.service;


import com.xkcoding.multi.datasource.mybatis.model.DailyComplianceStatistics;
import com.xkcoding.multi.datasource.mybatis.model.ProductionControl;
import com.xkcoding.multi.datasource.mybatis.model.ProductionControlTotal;

import java.util.List;
import java.util.Map;

/**
 * @author fnchenxi
 */
public interface ProductionControlService {
    int deleteDataByToDay();

    int insertSelective(ProductionControl record);

    /**
     * 组合以上汇总的数据为一个对象并返回数据
     * @return
     */
    List<ProductionControl> getModelData();

    /**
     * 批量添加数据
     * @param proConmodelData
     * @return
     */
    int batchInsert(List<ProductionControl> proConmodelData);

    /**
     * 组合以上汇总的数据为一个对象并返回数据
     * @return
     */
    List<ProductionControlTotal> getModelTotalData();

    int deleteTotalDataByToDay();

    /**
     * 批量添加汇总的数据
     * @param proConmodelData
     * @return
     */
    int batchInsertTotalData(List<ProductionControlTotal> proConmodelData);

    /**
     * l2单量统计结果
     * @param param
     * @return
     */
    List<ProductionControlTotal> getl2OrderNumberList(DailyComplianceStatistics param);
}
