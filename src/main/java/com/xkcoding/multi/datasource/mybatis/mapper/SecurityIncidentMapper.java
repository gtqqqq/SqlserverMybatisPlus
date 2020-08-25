package com.xkcoding.multi.datasource.mybatis.mapper;

import com.xkcoding.multi.datasource.mybatis.model.SecurityIncident;
import com.xkcoding.multi.datasource.mybatis.model.SecurityIncidentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecurityIncidentMapper {
    long countByExample(SecurityIncidentExample example);

    int deleteByExample(SecurityIncidentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SecurityIncident record);

    int insertSelective(SecurityIncident record);

    List<SecurityIncident> selectByExample(SecurityIncidentExample example);

    SecurityIncident selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SecurityIncident record, @Param("example") SecurityIncidentExample example);

    int updateByExample(@Param("record") SecurityIncident record, @Param("example") SecurityIncidentExample example);

    int updateByPrimaryKeySelective(SecurityIncident record);

    int updateByPrimaryKey(SecurityIncident record);
}