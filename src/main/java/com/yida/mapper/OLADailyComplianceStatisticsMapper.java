package com.yida.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yida.entity.DailyComplianceStatistics;
import com.yida.entity.DailyComplianceStatisticsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OLADailyComplianceStatisticsMapper extends BaseMapper<DailyComplianceStatistics> {
    long countByExample(DailyComplianceStatisticsExample example);

    int deleteByExample(DailyComplianceStatisticsExample example);

    int insertSelective(DailyComplianceStatistics record);

    List<DailyComplianceStatistics> selectByExample(DailyComplianceStatisticsExample example);

    int updateByExampleSelective(@Param("record") DailyComplianceStatistics record, @Param("example") DailyComplianceStatisticsExample example);

    int updateByExample(@Param("record") DailyComplianceStatistics record, @Param("example") DailyComplianceStatisticsExample example);
}