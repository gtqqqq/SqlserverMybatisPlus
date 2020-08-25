package com.xkcoding.multi.datasource.mybatis.mapper;

import com.xkcoding.multi.datasource.mybatis.model.DailyComplianceStatistics;
import com.xkcoding.multi.datasource.mybatis.model.DailyComplianceStatisticsL3;
import com.xkcoding.multi.datasource.mybatis.model.DailyComplianceStatisticsL3Example;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface DailyComplianceStatisticsL3Mapper {
    long countByExample(DailyComplianceStatisticsL3Example example);

    int deleteByExample(DailyComplianceStatisticsL3Example example);

    int insert(DailyComplianceStatisticsL3 record);

    int insertSelective(DailyComplianceStatisticsL3 record);

    List<DailyComplianceStatisticsL3> selectByExample(DailyComplianceStatisticsL3Example example);

    int updateByExampleSelective(@Param("record") DailyComplianceStatisticsL3 record, @Param("example") DailyComplianceStatisticsL3Example example);

    int updateByExample(@Param("record") DailyComplianceStatisticsL3 record, @Param("example") DailyComplianceStatisticsL3Example example);

    int deleteDataByToDay();

    /**
     * 根据日期查询L2的合格率数据
     * @param map
     * @return
     */
    List<DailyComplianceStatistics> selectToDayList(Map map);

    /**
     * 删除L3 SLA昨天的数据
     */
    int deleteYestToDayL3Sla();

    int deleteYestToDayL3SlaByReq();

    int deleteDataByToDayByReq();
}