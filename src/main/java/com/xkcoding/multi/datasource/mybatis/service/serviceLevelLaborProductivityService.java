package com.xkcoding.multi.datasource.mybatis.service;

import com.xkcoding.multi.datasource.mybatis.model.serviceLevelLaborProductivity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: smf
 * @time: 7/12/2020 6:47 PM
 * @description: 作业生产量管控- L1关单量 服务层
 */
public interface serviceLevelLaborProductivityService {
    /**
     * 录入作业生产量管控-L1关单量
     *
     * @param serviceLevelLaborProductivityList
     * @return
     */
    public Boolean insertServiceLevelLaborProductivity(List<serviceLevelLaborProductivity> serviceLevelLaborProductivityList);

    /**
     * 清表
     */
    public void deleteServiceLevelLaborProductivity();

    //TODO  1、FTE  指人数（有人事异动时候手动变更）BY组

    /**
     * FTE-指人数  TODO 不确定
     *
     * @return
     */
    public Integer selectServiceLevelLaborProductByPerson();


}
