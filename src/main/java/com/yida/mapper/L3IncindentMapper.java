package com.yida.mapper;

import com.yida.entity.L3Incindent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gtq
 * @since 2020-07-11
 */
public interface L3IncindentMapper extends BaseMapper<L3Incindent> {
    @Select("select \n" +
            "ta.[Assignment group],\n" +
            "SUBSTRING(CONVERT(VARCHAR(100),ta.Opened,20),1,13) as 'opened',\n" +
            "(select count(*) from L3Incindent where [Assignment group]=ta.[Assignment group] \n" +
            "and SUBSTRING(CONVERT(VARCHAR(100),ta.Opened,20),1,13)=SUBSTRING(CONVERT(VARCHAR(100),Opened,20),1,13))as total_num,\n" +
            "(select count(*) from L3Incindent where [Assignment group]=ta.[Assignment group] \n" +
            "and SUBSTRING(CONVERT(VARCHAR(100),ta.Opened,20),1,13)=SUBSTRING(CONVERT(VARCHAR(100),Opened,20),1,13)\n" +
            "and ([Incident state] like '%In progress%' or [Incident state] like '%Pending%'))as respond_num,\n" +
            "(select count(*) from L3Incindent where [Assignment group]=ta.[Assignment group] \n" +
            "and SUBSTRING(CONVERT(VARCHAR(100),ta.Opened,20),1,13)=SUBSTRING(CONVERT(VARCHAR(100),Opened,20),1,13)\n" +
            "and ([Incident state] like '%Resolved%' or [Incident state] like '%closed%'))as close_num,\n" +
            "1 as mark\n" +
            "from L3Incindent as ta \n" +
            "GROUP BY ta.[Assignment group],SUBSTRING(CONVERT(VARCHAR(100),ta.Opened,20),1,13)\n" +
            "union\n" +
            "select \n" +
            "ta.[Assignment group],\n" +
            "SUBSTRING(CONVERT(VARCHAR(100),ta.Opened,20),1,13) as 'opened',\n" +
            "(select count(*) from L3Request where [Assignment group]=ta.[Assignment group] \n" +
            "and SUBSTRING(CONVERT(VARCHAR(100),ta.Opened,20),1,13)=SUBSTRING(CONVERT(VARCHAR(100),Opened,20),1,13))as total_num,\n" +
            "(select count(*) from L3Request where [Assignment group]=ta.[Assignment group] \n" +
            "and SUBSTRING(CONVERT(VARCHAR(100),ta.Opened,20),1,13)=SUBSTRING(CONVERT(VARCHAR(100),Opened,20),1,13)\n" +
            "and (state like '%Work in progress%' or state like '%Hold%'))as respond_num,\n" +
            "(select count(*) from L3Request where [Assignment group]=ta.[Assignment group] \n" +
            "and SUBSTRING(CONVERT(VARCHAR(100),ta.Opened,20),1,13)=SUBSTRING(CONVERT(VARCHAR(100),Opened,20),1,13)\n" +
            "and state like '%Complete%')as close_num,\n" +
            "2 as mark \n" +
            "from L3Request as ta \n" +
            "GROUP BY ta.[Assignment group],SUBSTRING(CONVERT(VARCHAR(100),ta.Opened,20),1,13) ")
            public List<Map<String,Object>> selectTeamProductList();

    @Select("select sum(total_num) as total_num, sum(respond_num) as respond_num, sum(close_num) as close_num from " +
            "(select p.mark,p.[Assignment group],sum(total_num)as total_num,sum(respond_num)as respond_num,sum(close_num)as close_num from ( "+
            "select  " +
            "DISTINCT ta.[Assignment group], " +
            "(select count(*) from L3Incindent where [Assignment group]=ta.[Assignment group])as total_num, " +
            "(select count(*) from L3Incindent where [Assignment group]=ta.[Assignment group] and ([Incident state] like '%In progress%' or [Incident state] like '%Pending%'))as respond_num, " +
            "(select count(*) from L3Incindent where [Assignment group]=ta.[Assignment group] and ([Incident state] like '%Resolved%' or [Incident state] like '%closed%'))as close_num,'1' as mark " +
            "from L3Incindent as ta where DateDiff(dd,Opened,getdate())=0 and DATEPART(hh, getDate())>DATEPART(hh, Opened) " +
            "union  " +
            "select  " +
            "DISTINCT ta.[Assignment group], " +
            "(select count(*) from L3Request where [Assignment group]=ta.[Assignment group])as total_num, " +
            "(select count(*) from L3Request where [Assignment group]=ta.[Assignment group] and (state like '%Work in progress%' or state like '%Hold%'))as respond_num, " +
            "(select count(*) from L3Request where [Assignment group]=ta.[Assignment group] and state like '%Complete%')as close_num,'2' as mark " +
            "from L3Request as ta where DateDiff(dd,Opened,getdate())=0 and DATEPART(hh, getDate())>DATEPART(hh, Opened) " +
            ")as p " +
            "group by p.[Assignment group],p.mark ) as total")
    public Map<String, Integer> selectTeamProductTotalList();
}
