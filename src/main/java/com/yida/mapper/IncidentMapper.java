package com.yida.mapper;

import com.yida.entity.Incident;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author guantianqi
 * @since 2020-07-02
 */
public interface IncidentMapper extends BaseMapper<Incident> {

    @Select("SELECT COUNT(1) FROM dbo.Incident AS inc " +
            "WHERE " +
            "inc.[Business Service] IS NOT NULL AND inc.[Assignment Group] IN (SELECT L1_AssignmentGroup FROM  L1_AssignmentGroup)")
    public Integer selectL1IncidentList();

    @Select("SELECT COUNT(1) FROM dbo.L2Incindent AS inc " +
            "WHERE " +
            "DateDiff(dd,inc.[Resolved],getdate())=0   AND " +
            "inc.[Incident state] = #{state} ")
    public Integer selectL2IncResolvedList(@Param("state")String state);


    @Select("SELECT COUNT(1) FROM dbo.L3Incindent AS inc " +
            "WHERE " +
            "DateDiff(dd,inc.[Resolved],getdate())=0   AND " +
            "inc.[Incident state] = #{state} ")
    public Integer selectL3IncResolvedList(@Param("state")String state);



}
