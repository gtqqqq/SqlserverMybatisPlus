package com.yida.service;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yida.entity.DailyComplianceStatistics;

import java.util.List;

/**
 * 每日达标server
 * @author fanchenxi
 */
public interface OLADailyCompliService  extends IService<DailyComplianceStatistics> {

    /**
     * 组装好查询的数据，封装为一个实体对象
     * @return
     */
    List<DailyComplianceStatistics> getModelL2Data();

    /**
     * 组装好查询的数据，封装为一个实体对象
     * @return
     */
    List<DailyComplianceStatistics> getModelL3Data();

    List<DailyComplianceStatistics> getModelL2ListData();

    List<DailyComplianceStatistics> getModelL3ListData();

    int insertSelective(DailyComplianceStatistics record);

    List<DailyComplianceStatistics> list(QueryWrapper<DailyComplianceStatistics> queryWrapper);

    boolean remove(QueryWrapper<DailyComplianceStatistics> queryWrapper);

    boolean save(DailyComplianceStatistics DailyComplianceStatistics);
}
