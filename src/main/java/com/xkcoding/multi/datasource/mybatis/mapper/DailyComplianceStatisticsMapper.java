package com.xkcoding.multi.datasource.mybatis.mapper;

import com.xkcoding.multi.datasource.mybatis.model.DailyComplianceStatistics;
import com.xkcoding.multi.datasource.mybatis.model.DailyComplianceStatisticsExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface DailyComplianceStatisticsMapper {
    long countByExample(DailyComplianceStatisticsExample example);

    int deleteByExample(DailyComplianceStatisticsExample example);

    int insert(DailyComplianceStatistics record);

    int insertSelective(DailyComplianceStatistics record);

    List<DailyComplianceStatistics> selectByExample(DailyComplianceStatisticsExample example);

    int updateByExampleSelective(@Param("record") DailyComplianceStatistics record, @Param("example") DailyComplianceStatisticsExample example);

    int updateByExample(@Param("record") DailyComplianceStatistics record, @Param("example") DailyComplianceStatisticsExample example);

    int deleteDataByToDay();

    /**
     * 根据日期查询L2的合格率数据
     * @param map
     * @return
     */
    List<DailyComplianceStatistics> selectToDayList(Map<String,Object> map);

    /**
     * 删除L2 SLA昨天的数据
     */
    int deleteYestToDayL2Sla();

    int deleteYestToDayL2Req();

    int deleteReqDataByToDay();
}