package com.xkcoding.multi.datasource.mybatis.mapper;

import com.xkcoding.multi.datasource.mybatis.model.OrderComplianceAvg;
import com.xkcoding.multi.datasource.mybatis.model.OrderComplianceAvgExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface OrderComplianceAvgMapper {
    long countByExample(OrderComplianceAvgExample example);

    int deleteByExample(OrderComplianceAvgExample example);

    int insert(OrderComplianceAvg record);

    int insertSelective(OrderComplianceAvg record);

    List<OrderComplianceAvg> selectByExample(OrderComplianceAvgExample example);

    int updateByExampleSelective(@Param("record") OrderComplianceAvg record, @Param("example") OrderComplianceAvgExample example);

    int updateByExample(@Param("record") OrderComplianceAvg record, @Param("example") OrderComplianceAvgExample example);

    int deleteDataByToDay();
}