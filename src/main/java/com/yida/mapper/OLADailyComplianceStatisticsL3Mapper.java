package com.yida.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yida.entity.OLADailyComplianceStatisticsL3;
import com.yida.entity.DailyComplianceStatisticsL3Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OLADailyComplianceStatisticsL3Mapper extends BaseMapper<OLADailyComplianceStatisticsL3> {
    long countByExample(DailyComplianceStatisticsL3Example example);

    int deleteByExample(DailyComplianceStatisticsL3Example example);

    int insertSelective(OLADailyComplianceStatisticsL3 record);

    List<OLADailyComplianceStatisticsL3> selectByExample(DailyComplianceStatisticsL3Example example);

    int updateByExampleSelective(@Param("record") OLADailyComplianceStatisticsL3 record, @Param("example") DailyComplianceStatisticsL3Example example);

    int updateByExample(@Param("record") OLADailyComplianceStatisticsL3 record, @Param("example") DailyComplianceStatisticsL3Example example);

}