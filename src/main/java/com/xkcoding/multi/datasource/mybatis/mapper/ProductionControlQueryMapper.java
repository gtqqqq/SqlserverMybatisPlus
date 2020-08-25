package com.xkcoding.multi.datasource.mybatis.mapper;

import com.xkcoding.multi.datasource.mybatis.model.ProductionControl;
import com.xkcoding.multi.datasource.mybatis.model.ProductionControlExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ProductionControlQueryMapper {


    /**
     * 查询作业生产量管控(每日)
     * @return
     */
    @Select(" select \n" +
            "ta.[Assignment group],\n" +
            "SUBSTRING(CONVERT(VARCHAR(100),ta.Opened,20),1,13) as 'opened',\n" +
            "(select count(*) from L2Incindent where [Assignment group]=ta.[Assignment group] \n" +
            "and SUBSTRING(CONVERT(VARCHAR(100),ta.Opened,20),1,13)=SUBSTRING(CONVERT(VARCHAR(100),Opened,20),1,13))as total_num,\n" +
            "(select count(*) from L2Incindent where [Assignment group]=ta.[Assignment group] \n" +
            "and SUBSTRING(CONVERT(VARCHAR(100),ta.Opened,20),1,13)=SUBSTRING(CONVERT(VARCHAR(100),Opened,20),1,13)\n" +
            "and ([Incident state] like '%In progress%' or [Incident state] like '%Pending%'))as respond_num,\n" +
            "(select count(*) from L2Incindent where [Assignment group]=ta.[Assignment group] \n" +
            "and SUBSTRING(CONVERT(VARCHAR(100),ta.Opened,20),1,13)=SUBSTRING(CONVERT(VARCHAR(100),Opened,20),1,13)\n" +
            "and ([Incident state] like '%Resolved%' or [Incident state] like '%closed%'))as close_num,\n" +
            "1 as mark\n" +
            "from L2Incindent as ta \n" +
            "GROUP BY ta.[Assignment group],SUBSTRING(CONVERT(VARCHAR(100),ta.Opened,20),1,13)\n" +
            "union\n" +
            "select \n" +
            "ta.[Assignment group],\n" +
            "SUBSTRING(CONVERT(VARCHAR(100),ta.Opened,20),1,13) as 'opened',\n" +
            "(select count(*) from L2Request where [Assignment group]=ta.[Assignment group] \n" +
            "and SUBSTRING(CONVERT(VARCHAR(100),ta.Opened,20),1,13)=SUBSTRING(CONVERT(VARCHAR(100),Opened,20),1,13))as total_num,\n" +
            "(select count(*) from L2Request where [Assignment group]=ta.[Assignment group] \n" +
            "and SUBSTRING(CONVERT(VARCHAR(100),ta.Opened,20),1,13)=SUBSTRING(CONVERT(VARCHAR(100),Opened,20),1,13)\n" +
            "and (state like '%Work in progress%' or state like '%Hold%'))as respond_num,\n" +
            "(select count(*) from L2Request where [Assignment group]=ta.[Assignment group] \n" +
            "and SUBSTRING(CONVERT(VARCHAR(100),ta.Opened,20),1,13)=SUBSTRING(CONVERT(VARCHAR(100),Opened,20),1,13)\n" +
            "and state like '%Complete%')as close_num,\n" +
            "2 as mark \n" +
            "from L2Request as ta \n" +
            "GROUP BY ta.[Assignment group],SUBSTRING(CONVERT(VARCHAR(100),ta.Opened,20),1,13)\n ")
    List<Map<String,Object>> getProductionControlByToDay();


    /**
     * 询作业生产量管控(每日)汇总
     * @return
     */
    @Select("select  'Incoming' as 'name',sum(total_num)as total_num,null as 'Delivered',null as 'Target Hitted' from (\n" +
            "\tselect p.[Assignment group],sum(total_num)as total_num from (\n" +
            "\tselect \n" +
            "\tDISTINCT ta.[Assignment group],\n" +
            "\t(select count(*) from L2Incindent where [Assignment group]=ta.[Assignment group])as total_num\n" +
            "\tfrom L2Incindent as ta  where DateDiff(dd,Opened,getdate())=0 \n" +
            "\tunion \n" +
            "\tselect \n" +
            "\tDISTINCT ta.[Assignment group],\n" +
            "\t(select count(*) from L2Request where [Assignment group]=ta.[Assignment group])as total_num\n" +
            "\tfrom L2Request as ta  where DateDiff(dd,Opened,getdate())=0 \n" +
            "\t)as p\n" +
            "\tgroup by p.[Assignment group]\n" +
            "\t) p_total\n" +
            "union \n" +
            "(\n" +
            "\tselect 'Responded' as 'name',sum(respond_num)as total_num,null as 'Delivered',null as 'Target Hitted' from (\n" +
            "\tselect p.[Assignment group],sum(respond_num)as respond_num from (\n" +
            "\tselect \n" +
            "\tDISTINCT ta.[Assignment group],\n" +
            "\t(select count(*) from L2Incindent where [Assignment group]=ta.[Assignment group] and ([Incident state] like '%In progress%' or [Incident state] like '%Pending%'))as respond_num\n" +
            "\tfrom L2Incindent as ta  where DateDiff(dd,Opened,getdate())=0 \n" +
            "\tunion \n" +
            "\tselect \n" +
            "\tDISTINCT ta.[Assignment group],\n" +
            "\t(select count(*) from L2Request where [Assignment group]=ta.[Assignment group] and (state like '%Work in progress%' or state like '%Hold%'))as respond_num\n" +
            "\tfrom L2Request as ta  where DateDiff(dd,Opened,getdate())=0 \n" +
            "\t)as p\n" +
            "\tgroup by p.[Assignment group]\n" +
            "\t) respond_total\n" +
            ")\n" +
            "union\n" +
            "(\n" +
            "\tselect 'Closed' as 'name',sum(close_num)as total_num,null as 'Delivered',null as 'Target Hitted' from (\n" +
            "\t\tselect p.[Assignment group],sum(close_num)as close_num from (\n" +
            "\t\t\tselect \n" +
            "\t\t\tDISTINCT ta.[Assignment group],\n" +
            "\t\t\t(select count(*) from L2Incindent where [Assignment group]=ta.[Assignment group] and ([Incident state] like '%Resolved%' or [Incident state] like '%closed%')) as close_num\n" +
            "\t\t\tfrom L2Incindent as ta  where DateDiff(dd,Opened,getdate())=0 \n" +
            "\t\t\tunion \n" +
            "\t\t\tselect \n" +
            "\t\t\tDISTINCT ta.[Assignment group],\n" +
            "\t\t\t(select count(*) from L2Request where [Assignment group]=ta.[Assignment group] and state like '%Complete%')as close_num\n" +
            "\t\t\tfrom L2Request as ta  where DateDiff(dd,Opened,getdate())=0 \n" +
            "\t\t\t)as p\n" +
            "\t\t\tgroup by p.[Assignment group]\n" +
            "\t) close_total\n" +
            ")order by total_num desc")
    List<Map<String,Object>> getProductionControlTotalByToDay();

    /**
     * 查询作业生产量管控(每日) 昨天23点59分之前的数据
     * @return
     */
    @Select("select p.mark,p.[Assignment group],sum(total_num)as total_num,sum(respond_num)as respond_num,sum(close_num)as close_num from (\n" +
            "            select \n" +
            "            DISTINCT ta.[Assignment group],\n" +
            "            (select count(*) from L2Incindent where [Assignment group]=ta.[Assignment group])as total_num,\n" +
            "            (select count(*) from L2Incindent where [Assignment group]=ta.[Assignment group] and ([Incident state] like '%In progress%' or [Incident state] like '%Pending%'))as respond_num,\n" +
            "            (select count(*) from L2Incindent where [Assignment group]=ta.[Assignment group] and ([Incident state] like '%Resolved%' or [Incident state] like '%closed%'))as close_num,\n" +
            "\t\t\t\t\t\t1 as mark\n" +
            "            from L2Incindent as ta  where DateDiff(dd,Opened,getdate())=1 AND CONVERT ( CHAR ( 8 ), Opened, 108 ) >= '00:00:00' AND CONVERT ( CHAR ( 8 ), Opened, 108 ) <= '23:59:59'  \n" +
            "            union \n" +
            "            select \n" +
            "            DISTINCT ta.[Assignment group],\n" +
            "            (select count(*) from L2Request where [Assignment group]=ta.[Assignment group])as total_num,\n" +
            "            (select count(*) from L2Request where [Assignment group]=ta.[Assignment group] and (state like '%Work in progress%' or state like '%Work in Hold%'))as respond_num,\n" +
            "            (select count(*) from L2Request where [Assignment group]=ta.[Assignment group] and state like '%Complete%')as close_num,\n" +
            "\t\t\t\t\t\t2 as mark\n" +
            "            from L2Request as ta  where DateDiff(dd,Opened,getdate())=1 AND CONVERT ( CHAR ( 8 ), Opened, 108 ) >= '00:00:00' AND CONVERT ( CHAR ( 8 ), Opened, 108 ) <= '23:59:59'  \n" +
            "            )as p\n" +
            "            group by p.[Assignment group],p.mark")
    List<Map<String, Object>> getYestToDayProductionControlByToDay();
}