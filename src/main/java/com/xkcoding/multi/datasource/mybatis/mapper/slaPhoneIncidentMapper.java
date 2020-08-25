package com.xkcoding.multi.datasource.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xkcoding.multi.datasource.mybatis.model.slaCompliance;
import com.xkcoding.multi.datasource.mybatis.model.slaCompliancePhoneIncidentSqlServer;
import com.xkcoding.multi.datasource.mybatis.model.slaPhoneIncident;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author: smf
 * @time: 7/10/2020
 * @description: 第一通电话解决率 以及一线解决率 持久层
 */
public interface slaPhoneIncidentMapper extends BaseMapper<slaPhoneIncident> {

    /***
     * 录入 SD-L1 ：SLA 达标情况  FCR - Phone Incident and L1 - FLR%
     */
    @Insert({
            "<script>",
            "insert into sla_phone_incident(time, openTimeOne,NumberOne,OpenTimeTwo,NumberTwo,FcrPhoneIncident,OpenDateTimeFirstLineOne,NumberFirstLineOne,OpenDateTimeFirstLineTwo,NumberFirstLineTwo,CallAbandonFirstLineRate,ReopenIncident,EndTime) values ",
            "<foreach collection='slaPhoneIncidentList' item='item' index='index' separator=','>",
            "( #{item.time}, #{item.openTimeOne},#{item.NumberOne},#{item.OpenTimeTwo},#{item.NumberTwo},#{item.FcrPhoneIncident},#{item.OpenDateTimeFirstLineOne},#{item.NumberFirstLineOne},#{item.OpenDateTimeFirstLineTwo},#{item.NumberFirstLineTwo},#{item.CallAbandonFirstLineRate},#{item.ReopenIncident},#{item.EndTime})",
            "</foreach>",
            "</script>"
    })
    public Boolean insertSlaPhoneIncidentList(@Param("slaPhoneIncidentList") List<slaPhoneIncident> slaPhoneIncidentList);

    /**
     * 清表
     */
    @Delete({
            "<script>",
            "delete from sla_phone_incident",
            "</script>"
    })
    public void deleteSlaPhoneIncident();


    /**
     * 查询 第一通电话解决率
     *
     * @return
     */

    /*@Select({
            "-- FCR - Phone Incident  第一通电话解决率\n" +
                    "select \n" +
                    "abc.openTime1 as openTime1,\n" +
                    "abc.Number1 as Number1,\n" +
                    "qwe.openTime2 as openTime2,\n" +
                    "qwe.Number2 as Number2,\n" +
                    "concat(ROUND(abc.Number1/qwe.Number2*100, 2),'%') as jjRate\n" +
                    "from (\n" +
                    "select  \n" +
                    " DATEPART(hh, t1.Opened) as openTime1,\n" +
                    "CAST(COUNT(*) as FLOAT) as Number1\n" +
                    "from Incident t1 \n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='08:30:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='12:00:00'\n" +
                    "and t1.[Contact type] in ('Phone')\n" +
                    "--  and t1.[Parent Incident] is null  \\n\" +\n" +
                    "and t1.State not in ('Cancelled') \n" +
                    "and t1.[Opened by] not in ('BPPM Application')\n" +
                    "and t1.[First Contact Resolution] ='0'\n" +
                    "and t1.[Assignment Group] in (select * from L1_AssignmentGroup )\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    "UNION ALL\n" +
                    "select  \n" +
                    " DATEPART(hh, t1.Opened) as ot1,\n" +
                    "CAST(COUNT(*) as FLOAT) as n1\n" +
                    "from Incident t1 \n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='13:00:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='22:00:00'\n" +
                    "and t1.[Contact type] in ('Phone')\n" +
                    "--  and t1.[Parent Incident] is null  \\n\" +\n" +
                    "and t1.State not in ('Cancelled') \n" +
                    "and t1.[Opened by] not in ('BPPM Application')\n" +
                    "and t1.[First Contact Resolution] ='0'\n" +
                    "and t1.[Assignment Group] in (select * from L1_AssignmentGroup )\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    "\n" +
                    ") abc\n" +
                    "LEFT JOIN \n" +
                    "(\n" +
                    "-- FCR - Phone Incident  第一通电话解决率， 分母\\\\n\\\" +\\n\" +\n" +
                    "select\n" +
                    "DATEPART(hh, t2.Opened) as openTime2,\n" +
                    "CAST(COUNT(*) as FLOAT) as Number2\n" +
                    "from Incident t2\n" +
                    "where DATEDIFF(day, t2.Opened, GETDATE())=0\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t2.Opened,114),114)>='08:30:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t2.Opened,114),114)<='12:00:00'\n" +
                    "and t2.[Contact type] in ('Phone') \n" +
                    "-- and t2.[Parent Incident] is null\\n\" +\n" +
                    "and t2.State not in ('Cancelled')\n" +
                    "and t2.[Opened by] not in ('BPPM Application')\n" +
                    "and t2.[First Contact Resolution] ='1'\n" +
                    "and t2.[Assignment Group] in (select * from L1_AssignmentGroup )\n" +
                    "GROUP BY DATEPART(hh, t2.Opened)\n" +
                    "UNION ALL\n" +
                    "select\n" +
                    "DATEPART(hh, t2.Opened) as ot2,\n" +
                    "CAST(COUNT(*) as FLOAT) as n2\n" +
                    "from Incident t2\n" +
                    "where DATEDIFF(day, t2.Opened, GETDATE())=0\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t2.Opened,114),114)>='13:00:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t2.Opened,114),114)<='22:00:00'\n" +
                    "and t2.[Contact type] in ('Phone') \n" +
                    "-- and t2.[Parent Incident] is null\\n\" +\n" +
                    "and t2.State not in ('Cancelled')\n" +
                    "and t2.[Opened by] not in ('BPPM Application')\n" +
                    "and t2.[First Contact Resolution] ='1'\n" +
                    "and t2.[Assignment Group] in (select * from L1_AssignmentGroup )\n" +
                    "GROUP BY DATEPART(hh, t2.Opened)\n" +
                    ") qwe\n" +
                    " on abc.openTime1 = qwe.openTime2"
    })*/
    @Select({
            "-- FCR - Phone Incident  第一通电话解决率， 分子\\\\n\\\" +\\n\" +\n" +
                    "select \n" +
                    "abc.openTime1 as openTime1,\n" +
                    "abc.Number1 as Number1,\n" +
                    "qwe.openTime2 as openTime2,\n" +
                    "qwe.Number2 as Number2,\n" +
                    "concat(ROUND(abc.Number1/qwe.Number2*100, 2),'%') as jjRate\n" +
                    "from (\n" +
                    "select  \n" +
                    " DATEPART(hh, t1.Opened) as openTime1,\n" +
                    "CAST(COUNT(*) as FLOAT) as Number1\n" +
                    "from Incident t1 \n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    "and t1.[Contact type] in ('Phone')\n" +
                    "-- and t1.[Parent Incident] is null  \n" +
                    "-- and t1.[Parent Incident] !=''\n" +
                    "and t1.State not in ('Cancelled') \n" +
                    "and t1.[Opened by] not in ('BPPM Application')\n" +
                    "and t1.[First Contact Resolution] ='0'\n" +
                    "and t1.[Assignment Group] in (select * from L1_AssignmentGroup )\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    ") abc\n" +
                    "LEFT JOIN \n" +
                    "(\n" +
                    "-- FCR - Phone Incident  第一通电话解决率， 分母\\\\n\\\" +\\n\" +\n" +
                    "select\n" +
                    "DATEPART(hh, t2.Opened) as openTime2,\n" +
                    "CAST(COUNT(*) as FLOAT) as Number2\n" +
                    "from Incident t2\n" +
                    "where DATEDIFF(day, t2.Opened, GETDATE())=0\n" +
                    "and t2.[Contact type] in ('Phone') \n" +
                    "--  and t2.[Parent Incident] is null  \n" +
                    "--  and t2.[Parent Incident] !=''\n" +
                    "and t2.State not in ('Cancelled')\n" +
                    "and t2.[Opened by] not in ('BPPM Application')\n" +
                    "and t2.[First Contact Resolution] ='1'\n" +
                    "and t2.[Assignment Group] in (select * from L1_AssignmentGroup )\n" +
                    "GROUP BY DATEPART(hh, t2.Opened)\n" +
                    ") qwe\n" +
                    " on abc.openTime1 = qwe.openTime2"
    })
    public List<slaCompliancePhoneIncidentSqlServer> selectSlaCompliancePhoneIncident();


    /**
     * 查询 一线解决率
     *
     * @return
     */
   /* @Select({
            "-- L1 - FLR%  一线解决率\\\\\\\\n\\\\\\\" +\\\\n\\\" +\\n\" +\n" +
                    "select \n" +
                    "aa.OpenedTime as openTime1,   -- OpenedTimeFz\\\\n\\\" +\\n\" +\n" +
                    "aa.totalfz as Number1,--NumFz\\\\\\\\n\\\\\\\" +\\\\n\\\" +\\n\" +\n" +
                    "bb.OpenedTime1 as openTime2,     -- OpenedTimeFm\\\\n\\\" +\\n\" +\n" +
                    "bb.totalfm as Number2,     --NumFu\\\\\\\\n\\\\\\\" +\\\\n\\\" +\\n\" +\n" +
                    "concat (ROUND(aa.totalfz/bb.totalfm*100,2),'%') as jjRate   --   OneLineTotalRate\\\\n\\\" +\\n\" +\n" +
                    "from (\n" +
                    "select  \n" +
                    "total.OpenedTime as OpenedTime,\n" +
                    "SUM(total.num) as totalfz\n" +
                    "from (\n" +
                    "-- -- L1 - FLR%  一线解决率 分子 by Incident_Test\\n\" +\n" +
                    "select \n" +
                    " DATEPART(hh, t1.Opened) as OpenedTime,\n" +
                    "CAST(COUNT(*) as float)  as num\n" +
                    "from Incident t1\n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE()) =0\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='08:30:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='12:00:00'\n" +
                    "and t1.State ='Closed'\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    "UNION ALL\n" +
                    "select \n" +
                    " DATEPART(hh, t1.Opened) as OpenedTime,\n" +
                    "CAST(COUNT(*) as float)  as num\n" +
                    "from Incident t1\n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE()) =0\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='13:00:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='22:00:00'\n" +
                    "and t1.State ='Closed'\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    "UNION All\n" +
                    "-- -- L1 - FLR%  一线解决率 分子 by Request_Tes\\\\\\n\" +\n" +
                    "select \n" +
                    "DATEPART(hh, t1.Opened) as OpenedTime2,\n" +
                    "CAST(COUNT(*) as float) as num\n" +
                    "from Request t1 \n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE()) =0 \n" +
                    " and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='08:30:00'\n" +
                    " and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='12:00:00'\n" +
                    "and t1.State='Closed'\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    " and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    "UNION ALL\n" +
                    "select \n" +
                    "DATEPART(hh, t1.Opened) as OpenedTime2,\n" +
                    "CAST(COUNT(*) as float) as num\n" +
                    "from Request t1 \n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE()) =0 \n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='13:00:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='22:00:00'\n" +
                    "and t1.State='Closed'\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    " and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    "UNION ALL\n" +
                    "-- L1 - FLR%  一线解决率 分子 by NewCall_Test\\\\n\\\" +\\n\" +\n" +
                    "select  \n" +
                    "DATEPART(hh, t1.Opened) as OpenedTime3,\n" +
                    "CAST(COUNT(*) as float) as num\n" +
                    "from NewCall t1\n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE()) =0 \n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='08:30:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='12:00:00'\n" +
                    "and t1.[Call type] = 'Enquiry (FCR Only)'--//TODO Enquiry (FCR Only)\\n\" +\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    "UNION ALL\n" +
                    "select  \n" +
                    "DATEPART(hh, t1.Opened) as OpenedTime3,\n" +
                    "CAST(COUNT(*) as float) as num\n" +
                    "from NewCall t1\n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE()) =0 \n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='13:00:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='22:00:00'\n" +
                    "and t1.[Call type] = 'Enquiry (FCR Only)'--//TODO Enquiry (FCR Only)\\n\" +\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    "\n" +
                    ") total\n" +
                    "GROUP BY total.OpenedTime\n" +
                    ") aa\n" +
                    "LEFT JOIN \n" +
                    "(\n" +
                    "select \n" +
                    " qwe.OpenedTime1 as OpenedTime1,\n" +
                    " SUM(qwe.num) as totalfm\n" +
                    "from (\n" +
                    "-- L1 - FLR%  一线解决率 分母  by Incident_Test\\n\" +\n" +
                    "select  \n" +
                    " DATEPART(hh, t1.Opened) as OpenedTime1,\n" +
                    "CAST(COUNT(*) as float) as num\n" +
                    "from Incident t1\n" +
                    "where  DATEDIFF(day, t1.Opened, GETDATE()) =0\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='08:30:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='12:00:00'\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "-- and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\\n\" +\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    "UNION All\n" +
                    "select  \n" +
                    " DATEPART(hh, t1.Opened) as OpenedTime1,\n" +
                    "CAST(COUNT(*) as float) as num\n" +
                    "from Incident t1\n" +
                    "where  DATEDIFF(day, t1.Opened, GETDATE()) =0\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='13:00:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='22:00:00'\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "-- and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\\n\" +\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    "UNION ALL\n" +
                    "-- -- L1 - FLR%  一线解决率 分母 by Request_Test\\\\n\\\" +\\n\" +\n" +
                    "select \n" +
                    "DATEPART(hh, t1.Opened) as OpenedTime3,\n" +
                    "CAST(COUNT(*) as float) as num\n" +
                    "from Request t1\n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE()) =0\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='08:30:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='12:00:00'\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "-- and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\\n\" +\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    "UNION ALL\n" +
                    "select \n" +
                    "DATEPART(hh, t1.Opened) as OpenedTime3,\n" +
                    "CAST(COUNT(*) as float) as num\n" +
                    "from Request t1\n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE()) =0\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='13:00:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='22:00:00'\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "-- and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\\n\" +\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    "\n" +
                    "UNION ALL\n" +
                    "-- L1 - FLR%  一线解决率 分母 by NewCall_Test\\n\" +\n" +
                    "select \n" +
                    "DATEPART(hh, t1.Opened) as OpenedTime3,\n" +
                    "CAST(COUNT(*) as float) as num\n" +
                    "from NewCall t1\n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE()) =0 \n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='08:30:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='12:00:00'\n" +
                    "and t1.[Call type] = 'Enquiry (FCR Only)' -- //TODO Enquiry (FCR Only)\\n\" +\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "-- and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\\n\" +\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    "UNION ALL\n" +
                    "select \n" +
                    "DATEPART(hh, t1.Opened) as OpenedTime3,\n" +
                    "CAST(COUNT(*) as float) as num\n" +
                    "from NewCall t1\n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE()) =0 \n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='13:00:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='22:00:00'\n" +
                    "and t1.[Call type] = 'Enquiry (FCR Only)' -- //TODO Enquiry (FCR Only)\\n\" +\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "-- and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\\n\" +\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    "\n" +
                    ")as  qwe \n" +
                    "GROUP BY qwe.OpenedTime1\n" +
                    ") bb\n" +
                    "on aa.OpenedTime = bb.OpenedTime1\n" +
                    "\n" +
                    "GROUP BY aa.OpenedTime ,aa.totalfz,bb.OpenedTime1,bb.totalfm\n"
    })*/
    @Select({
            "-- L1 - FLR%  一线解决率\\\\\\\\n\\\\\\\" +\\\\n\\\" +\\n\" +\n" +
                    "select \n" +
                    "aa.OpenedTime as openTime1,   -- OpenedTimeFz\\\\n\\\" +\\n\" +\n" +
                    "aa.totalfz as Number1,--NumFz\\\\\\\\n\\\\\\\" +\\\\n\\\" +\\n\" +\n" +
                    "bb.OpenedTime1 as openTime2,     -- OpenedTimeFm\\\\n\\\" +\\n\" +\n" +
                    "bb.totalfm as Number2,     --NumFu\\\\\\\\n\\\\\\\" +\\\\n\\\" +\\n\" +\n" +
                    "concat (ROUND(aa.totalfz/bb.totalfm*100,2),'%') as jjRate   --   OneLineTotalRate\\\\n\\\" +\\n\" +\n" +
                    "from (\n" +
                    "select  \n" +
                    "total.OpenedTime as OpenedTime,\n" +
                    "SUM(total.num) as totalfz\n" +
                    "from (\n" +
                    "-- -- L1 - FLR%  一线解决率 分子 by Incident_Test\\n\" +\n" +
                    "select \n" +
                    " DATEPART(hh, t1.Opened) as OpenedTime,\n" +
                    "CAST(COUNT(*) as float)  as num\n" +
                    "from Incident t1\n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE()) =0\n" +
                    "and t1.State ='Closed'\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    "UNION All\n" +
                    "-- -- L1 - FLR%  一线解决率 分子 by Request_Tes\\\\\\n\" +\n" +
                    "select \n" +
                    "DATEPART(hh, t1.Opened) as OpenedTime2,\n" +
                    "CAST(COUNT(*) as float) as num\n" +
                    "from Request t1 \n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE()) =0 \n" +
                    "and t1.State='Closed'\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    "UNION ALL\n" +
                    "-- L1 - FLR%  一线解决率 分子 by NewCall_Test\\\\n\\\" +\\n\" +\n" +
                    "select  \n" +
                    "DATEPART(hh, t1.Opened) as OpenedTime3,\n" +
                    "CAST(COUNT(*) as float) as num\n" +
                    "from NewCall t1\n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE()) =0 \n" +
                    "and t1.[Call type] = 'Enquiry (FCR Only)'--//TODO Enquiry (FCR Only)\\n\" +\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    ") total\n" +
                    "GROUP BY total.OpenedTime\n" +
                    ") aa\n" +
                    "LEFT JOIN \n" +
                    "(\n" +
                    "select \n" +
                    "qwe.OpenedTime1 as OpenedTime1,\n" +
                    "SUM(qwe.num) as totalfm\n" +
                    "from (\n" +
                    "-- L1 - FLR%  一线解决率 分母  by Incident_Test\\n\" +\n" +
                    "select  \n" +
                    " DATEPART(hh, t1.Opened) as OpenedTime1,\n" +
                    "CAST(COUNT(*) as float) as num\n" +
                    "from Incident t1\n" +
                    "where  DATEDIFF(day, t1.Opened, GETDATE()) =0\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "-- and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\\n\" +\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    "UNION All\n" +
                    "-- -- L1 - FLR%  一线解决率 分母 by Request_Test\\\\n\\\" +\\n\" +\n" +
                    "select \n" +
                    "DATEPART(hh, t1.Opened) as OpenedTime3,\n" +
                    "CAST(COUNT(*) as float) as num\n" +
                    "from Request t1\n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE()) =0\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "-- and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\\n\" +\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    "UNION ALL\n" +
                    "-- L1 - FLR%  一线解决率 分母 by NewCall_Test\\n\" +\n" +
                    "select \n" +
                    "DATEPART(hh, t1.Opened) as OpenedTime3,\n" +
                    "CAST(COUNT(*) as float) as num\n" +
                    "from NewCall t1\n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE()) =0 \n" +
                    "and t1.[Call type] = 'Enquiry (FCR Only)' -- //TODO Enquiry (FCR Only)\\n\" +\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "-- and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\\n\" +\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    ") qwe \n" +
                    "GROUP BY qwe.OpenedTime1\n" +
                    ") bb\n" +
                    "on aa.OpenedTime = bb.OpenedTime1\n" +
                    "\n" +
                    "GROUP BY aa.OpenedTime ,aa.totalfz,bb.OpenedTime1,bb.totalfm"
    })
    public List<slaCompliancePhoneIncidentSqlServer> selectSlaComplianceFirstLineSolutionRate();


    /**
     * 查询 SLA 达标率 -电话服务事件解决率（FCR）(第一通电话解决率)
     *
     * @return
     */
   /* @Select({
            "\n" +
                    "-- FCR - Phone Incident  第一通电话解决率， 分子\n" +
                    "select \n" +
                    " abc.openTime1 as openTime1,\n" +
                    " abc.Number1 as Number1,\n" +
                    " qwe.openTime2 as openTime2,\n" +
                    " qwe.Number2 as Number2,\n" +
                    "-- concat(ROUND(SUM( abc.Number1)  / SUM(qwe.Number2) *100, 2),'%') as jjRate\n" +
                    "concat(Round(abc.Number1/qwe.Number2*100,2),'%') as jjRate\n" +
                    "from (\n" +
                    "select  \n" +
                    " DATEPART(hh, t1.Opened) as openTime1,\n" +
                    "CAST(COUNT(*) as FLOAT) as Number1\n" +
                    "from Incident t1 \n" +
                    "where DATEDIFF(day, t1.Opened, FORMAT (getdate(), 'yyyy-MM-dd HH:00:00'))=0\n" +
                    "and t1.[Contact type] in ('Phone')\n" +
                    "and (t1.[Parent Incident] is null   or t1.[Parent Incident] ='')\n" +
                    "and t1.State not in ('Cancelled') \n" +
                    "and t1.[Opened by] not in ('BPPM Application')\n" +
                    "and t1.[First Contact Resolution] ='0'\n" +
                    "-- and t1.[Owned By] in (select * from L1_AssignmentGroup )\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    ") abc\n" +
                    "LEFT JOIN \n" +
                    "(\n" +
                    "-- FCR - Phone Incident  第一通电话解决率， 分母\n" +
                    "select\n" +
                    "DATEPART(hh, t2.Opened) as openTime2,\n" +
                    "CAST(COUNT(*) as FLOAT) as Number2\n" +
                    "from Incident t2\n" +
                    "where DATEDIFF(day, t2.Opened, FORMAT (getdate(), 'yyyy-MM-dd HH:00:00'))=0\n" +
                    "and t2.[Contact type] in ('Phone') \n" +
                    "and (t2.[Parent Incident] is null  or t2.[Parent Incident] ='')\n" +
                    "and t2.State not in ('Cancelled')\n" +
                    "and t2.[Opened by] not in ('BPPM Application')\n" +
                    "and t2.[First Contact Resolution] ='1'\n" +
                    "-- and t2.[Owned By] in (select * from L1_AssignmentGroup )\n" +
                    "GROUP BY DATEPART(hh, t2.Opened)\n" +
                    ") qwe\n" +
                    " on abc.openTime1 = qwe.openTime2"
    })*/
    //查询历史全部数据
    @Select({
            "-- FCR - Phone Incident  第一通电话解决率， 分子\n" +
                    "select \n" +
                    "abc.openTime1 as openTime1,\n" +
                    "abc.Number1 as Number1,\n" +
                    "qwe.openTime2 as openTime2,\n" +
                    "qwe.Number2 as Number2,\n" +
                    "concat(ROUND(abc.Number1/qwe.Number2*100, 2),'%') as jjRate\n" +
                    "from (\n" +
                    "select  \n" +
                    "SUBSTRING(CONVERT(VARCHAR(100),t1.Opened,20),1,13) as openTime1,\n" +
                    "CAST(COUNT(*) as FLOAT) as Number1\n" +
                    "from Incident t1 \n" +
                    "-- where DATEDIFF(day, t1.Opened, FORMAT (getdate(), 'yyyy-MM-dd HH:00:00'))=1\n" +
                    "where t1.[Contact type] in ('Phone')\n" +
                    "and (t1.[Parent Incident] is null  or t1.[Parent Incident] ='') \n" +
                    "and t1.State not in ('Cancelled') \n" +
                    "and t1.[Opened by] not in ('BPPM Application')\n" +
                    "and t1.[First Contact Resolution] ='0'\n" +
                    "--  and t1.[Owned By] in (select * from L1_AssignmentGroup )\n" +
                    "GROUP BY SUBSTRING(CONVERT(VARCHAR(100),t1.Opened,20),1,13)\n" +
                    ") abc\n" +
                    "left JOIN \n" +
                    "(\n" +
                    "-- FCR - Phone Incident  第一通电话解决率， 分母\n" +
                    "select\n" +
                    "SUBSTRING(CONVERT(VARCHAR(100),t2.Opened,20),1,13) as openTime2,\n" +
                    "CAST(COUNT(*) as FLOAT) as Number2\n" +
                    "from Incident t2\n" +
                    "-- where DATEDIFF(day, t2.Opened, FORMAT (getdate(), 'yyyy-MM-dd HH:00:00'))=1\n" +
                    "where t2.[Contact type] in ('Phone') \n" +
                    "and (t2.[Parent Incident] is null  or t2.[Parent Incident] ='') \n" +
                    "and t2.State not in ('Cancelled')\n" +
                    "and t2.[Opened by] not in ('BPPM Application')\n" +
                    "and t2.[First Contact Resolution] ='1'\n" +
                    "-- and t2.[Owned By] in (select * from L1_AssignmentGroup )\n" +
                    "GROUP BY SUBSTRING(CONVERT(VARCHAR(100),t2.Opened,20),1,13)\n" +
                    ") qwe\n" +
                    " on abc.openTime1 = qwe.openTime2"
    })
    public List<Map<String, Object>> selectSlaCompliancePhoneIncident2();


    /**
     * 查询 SLA 达标率 -电话服务事件解决率（FCR）,昨天23点至零点时间段(第一通电话解决率)
     *
     * @return
     */
    @Select({
            "\n" +
                    "-- FCR - Phone Incident  第一通电话解决率， 分子\n" +
                    "select \n" +
                    " abc.openTime1 as openTime1,\n" +
                    " abc.Number1 as Number1,\n" +
                    " qwe.openTime2 as openTime2,\n" +
                    " qwe.Number2 as Number2,\n" +
                    "-- concat(ROUND(SUM( abc.Number1)  / SUM(qwe.Number2) *100, 2),'%') as jjRate\n" +
                    "concat(Round(abc.Number1/qwe.Number2*100,2),'%') as jjRate\n" +
                    "from (\n" +
                    "select  \n" +
                    " DATEPART(hh, t1.Opened) as openTime1,\n" +
                    "CAST(COUNT(*) as FLOAT) as Number1\n" +
                    "from Incident t1 \n" +
                    "where DATEDIFF(day, t1.Opened, FORMAT (getdate(), 'yyyy-MM-dd HH:00:00'))=1\n" +
                    "and CONVERT (TIME, CONVERT (VARCHAR (20), t1.[Opened], 114 ), 114 ) >= '23:00:00'\n" +
                    "AND CONVERT (TIME, CONVERT (VARCHAR (20), t1.[Opened], 114 ), 114 ) <= '23:59:59'\n" +
                    "and t1.[Contact type] in ('Phone')\n" +
                    "and (t1.[Parent Incident] is null   or t1.[Parent Incident] ='')\n" +
                    "and t1.State not in ('Cancelled') \n" +
                    "and t1.[Opened by] not in ('BPPM Application')\n" +
                    "and t1.[First Contact Resolution] ='0'\n" +
                    "-- and t1.[Owned By] in (select * from L1_AssignmentGroup )\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    ") abc\n" +
                    "LEFT JOIN \n" +
                    "(\n" +
                    "-- FCR - Phone Incident  第一通电话解决率， 分母\n" +
                    "select\n" +
                    "DATEPART(hh, t2.Opened) as openTime2,\n" +
                    "CAST(COUNT(*) as FLOAT) as Number2\n" +
                    "from Incident t2\n" +
                    "where DATEDIFF(day, t2.Opened, FORMAT (getdate(), 'yyyy-MM-dd HH:00:00'))=1\n" +
                    "and CONVERT (TIME, CONVERT (VARCHAR (20), t2.[Opened], 114 ), 114 ) >= '23:00:00'\n" +
                    "AND CONVERT (TIME, CONVERT (VARCHAR (20), t2.[Opened], 114 ), 114 ) <= '23:59:59'\n" +
                    "and t2.[Contact type] in ('Phone') \n" +
                    "and (t2.[Parent Incident] is null  or t2.[Parent Incident] ='')\n" +
                    "and t2.State not in ('Cancelled')\n" +
                    "and t2.[Opened by] not in ('BPPM Application')\n" +
                    "and t2.[First Contact Resolution] ='1'\n" +
                    "-- and t2.[Owned By] in (select * from L1_AssignmentGroup )\n" +
                    "GROUP BY DATEPART(hh, t2.Opened)\n" +
                    ") qwe\n" +
                    " on abc.openTime1 = qwe.openTime2"
    })
    public List<Map<String, Object>> selectSlaCompliancePhoneIncident2BYTime();


    /**
     * 删除当天时间段23:00到零点之间数据
     */
    @Select({
            "delete from sla_phone_incident where   DATE_FORMAT(time,'%y/%m/%d')  = DATE_FORMAT(SYSDATE()-1,'%y/%m/%d') and openTimeOne=23"
    })
    public void deleteSlaPhoneIncidentByTime();


    /**
     * 查询 一线解决率-2
     *
     * @return
     */
   /* @Select({
            "-- L1 - FLR%  一线解决率\n" +
                    "select \n" +
                    "aa.OpenedTime as openTime1,   -- OpenedTimeFz\n" +
                    "aa.totalfz as Number1,--NumFz\n" +
                    "bb.OpenedTime1 as openTime2,     -- OpenedTimeFm\n" +
                    "bb.totalfm as Number2,     --NumFu\n" +
                    "concat (ROUND(aa.totalfz/bb.totalfm*100,2),'%') as jjRate   --   OneLineTotalRate\n" +
                    "from (\n" +
                    "select  \n" +
                    "total.OpenedTime as OpenedTime,\n" +
                    "SUM(total.num) as totalfz\n" +
                    "from (\n" +
                    "-- -- L1 - FLR%  一线解决率 分子 by Incident_Test\n" +
                    "select \n" +
                    "DATEPART(hh, t1.Opened) as OpenedTime,\n" +
                    "CAST(COUNT(*) as float)  as num\n" +
                    "from Incident t1\n" +
                    "where DATEDIFF(day, t1.Opened,  FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')) =0\n" +
                    "and t1.State ='Closed'\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    "UNION All\n" +
                    "-- -- L1 - FLR%  一线解决率 分子 by Request_Tes\n" +
                    "select \n" +
                    "DATEPART(hh, t1.Opened) as OpenedTime2,\n" +
                    "CAST(COUNT(*) as float) as num\n" +
                    "from Request t1\n" +
                    "where DATEDIFF(day, t1.Opened,  FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')) =0\n" +
                    "and t1.State='Closed'\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    "UNION ALL\n" +
                    "-- L1 - FLR%  一线解决率 分子 by NewCall_Test\n" +
                    "select  \n" +
                    "DATEPART(hh, t1.Opened) as OpenedTime3,\n" +
                    "CAST(COUNT(*) as float) as num\n" +
                    "from NewCall t1\n" +
                    "where DATEDIFF(day, t1.Opened,  FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')) =0\n" +
                    "and t1.[Call type] = 'Enquiry (FCR Only)'--//TODO Enquiry (FCR Only)\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "-- and t1.[Opened by] in ('chen,Louis')\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    ") total\n" +
                    "GROUP BY total.OpenedTime\n" +
                    ") aa\n" +
                    "LEFT JOIN \n" +
                    "(\n" +
                    "select \n" +
                    "qwe.OpenedTime1 as OpenedTime1,\n" +
                    "SUM(qwe.num) as totalfm\n" +
                    "from (\n" +
                    "-- L1 - FLR%  一线解决率 分母  by Incident_Test\n" +
                    "select  \n" +
                    " DATEPART(hh, t1.Opened) as OpenedTime1,\n" +
                    "CAST(COUNT(*) as float) as num\n" +
                    "from Incident t1\n" +
                    "where  DATEDIFF(day, t1.Opened,  FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')) =0\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "-- and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    "UNION All\n" +
                    "-- -- L1 - FLR%  一线解决率 分母 by Request_Test\n" +
                    "select\n" +
                    "DATEPART(hh, t1.Opened) as OpenedTime3,\n" +
                    "CAST(COUNT(*) as float) as num\n" +
                    "from Request t1\n" +
                    "where DATEDIFF(day, t1.Opened,  FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')) =0\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "-- and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    "UNION ALL\n" +
                    "-- L1 - FLR%  一线解决率 分母 by NewCall_Test\n" +
                    "select \n" +
                    "DATEPART(hh, t1.Opened) as OpenedTime3,\n" +
                    "CAST(COUNT(*) as float) as num\n" +
                    "from NewCall t1\n" +
                    "where DATEDIFF(day, t1.Opened,  FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')) =0\n" +
                    "and t1.[Call type] = 'Enquiry (FCR Only)' -- //TODO Enquiry (FCR Only)\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "-- and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "-- and t1.[Opened by] in ('chen,Louis')\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    ") qwe \n" +
                    "GROUP BY qwe.OpenedTime1\n" +
                    ") bb\n" +
                    "on aa.OpenedTime = bb.OpenedTime1"
    })*/
    //查询历史全部数据
    @Select({
            "-- L1 - FLR%  一线解决率\n" +
                    "select \n" +
                    "aa.OpenedTime as openTime1,   -- OpenedTimeFz\n" +
                    "aa.totalfz as Number1,--NumFz\n" +
                    "bb.OpenedTime1 as openTime2,     -- OpenedTimeFm\n" +
                    "bb.totalfm as Number2,     --NumFu\n" +
                    "concat (ROUND(aa.totalfz/bb.totalfm*100,2),'%') as jjRate   --   OneLineTotalRate\n" +
                    "from (\n" +
                    "select  \n" +
                    "total.OpenedTime as OpenedTime,\n" +
                    "SUM(total.num) as totalfz\n" +
                    "from (\n" +
                    "-- -- L1 - FLR%  一线解决率 分子 by Incident_Test\n" +
                    "select \n" +
                    "SUBSTRING(CONVERT(VARCHAR(100),t1.Opened,20),1,13)  as OpenedTime,\n" +
                    "CAST(COUNT(*) as float)  as num\n" +
                    "from Incident t1\n" +
                    "-- where DATEDIFF(day, t1.Opened,  FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')) =1\n" +
                    "where t1.State ='Closed'\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "GROUP BY SUBSTRING(CONVERT(VARCHAR(100),t1.Opened,20),1,13) \n" +
                    "UNION All\n" +
                    "-- -- L1 - FLR%  一线解决率 分子 by Request_Tes\n" +
                    "select \n" +
                    "SUBSTRING(CONVERT(VARCHAR(100),t1.Opened,20),1,13) as OpenedTime2,\n" +
                    "CAST(COUNT(*) as float) as num\n" +
                    "from Request t1\n" +
                    "-- where DATEDIFF(day, t1.Opened,  FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')) =1\n" +
                    "where t1.State='Closed'\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "GROUP BY SUBSTRING(CONVERT(VARCHAR(100),t1.Opened,20),1,13)\n" +
                    "UNION ALL\n" +
                    "-- L1 - FLR%  一线解决率 分子 by NewCall_Test\n" +
                    "select  \n" +
                    "SUBSTRING(CONVERT(VARCHAR(100),t1.Opened,20),1,13) as OpenedTime3,\n" +
                    "CAST(COUNT(*) as float) as num\n" +
                    "from NewCall t1\n" +
                    "-- where DATEDIFF(day, t1.Opened,  FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')) =1\n" +
                    "where t1.[Call type] = 'Enquiry (FCR Only)'--//TODO Enquiry (FCR Only)\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "-- and t1.[Opened by] in ('chen,Louis')\n" +
                    "GROUP BY SUBSTRING(CONVERT(VARCHAR(100),t1.Opened,20),1,13)\n" +
                    ") total\n" +
                    "GROUP BY total.OpenedTime\n" +
                    ") aa\n" +
                    "LEFT JOIN \n" +
                    "(\n" +
                    "select \n" +
                    "qwe.OpenedTime1 as OpenedTime1,\n" +
                    "SUM(qwe.num) as totalfm\n" +
                    "from (\n" +
                    "-- L1 - FLR%  一线解决率 分母  by Incident_Test\n" +
                    "select  \n" +
                    "SUBSTRING(CONVERT(VARCHAR(100),t1.Opened,20),1,13) as OpenedTime1,\n" +
                    "CAST(COUNT(*) as float) as num\n" +
                    "from Incident t1\n" +
                    "-- where  DATEDIFF(day, t1.Opened,  FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')) =1\n" +
                    "where t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "-- and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "GROUP BY SUBSTRING(CONVERT(VARCHAR(100),t1.Opened,20),1,13)\n" +
                    "UNION All\n" +
                    "-- -- L1 - FLR%  一线解决率 分母 by Request_Test\n" +
                    "select\n" +
                    "SUBSTRING(CONVERT(VARCHAR(100),t1.Opened,20),1,13) as OpenedTime3,\n" +
                    "CAST(COUNT(*) as float) as num\n" +
                    "from Request t1\n" +
                    "-- where DATEDIFF(day, t1.Opened,  FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')) =1\n" +
                    "where t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "-- and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "GROUP BY SUBSTRING(CONVERT(VARCHAR(100),t1.Opened,20),1,13)\n" +
                    "UNION ALL\n" +
                    "-- L1 - FLR%  一线解决率 分母 by NewCall_Test\n" +
                    "select \n" +
                    "SUBSTRING(CONVERT(VARCHAR(100),t1.Opened,20),1,13) as OpenedTime3,\n" +
                    "CAST(COUNT(*) as float) as num\n" +
                    "from NewCall t1\n" +
                    "-- where DATEDIFF(day, t1.Opened,  FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')) =1\n" +
                    "where t1.[Call type] = 'Enquiry (FCR Only)' -- //TODO Enquiry (FCR Only)\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "-- and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "-- and t1.[Opened by] in ('chen,Louis')\n" +
                    "GROUP BY SUBSTRING(CONVERT(VARCHAR(100),t1.Opened,20),1,13)\n" +
                    ") qwe \n" +
                    "GROUP BY qwe.OpenedTime1\n" +
                    ") bb\n" +
                    "on aa.OpenedTime = bb.OpenedTime1"
    })
    public List<Map<String, Object>> selectSlaComplianceFirstLineSolutionRate2();


    /**
     * 查询 SLA 达标率 -1线关单解决率（FLR）,昨天23点至零点时间段数据(一线解决率)
     *
     * @return
     */
    @Select({
            "-- L1 - FLR%  一线解决率\n" +
                    "select \n" +
                    "aa.OpenedTime as openTime1,   -- OpenedTimeFz\n" +
                    "aa.totalfz as Number1,--NumFz\n" +
                    "bb.OpenedTime1 as openTime2,     -- OpenedTimeFm\n" +
                    "bb.totalfm as Number2,     --NumFu\n" +
                    "concat (ROUND(aa.totalfz/bb.totalfm*100,2),'%') as jjRate   --   OneLineTotalRate\n" +
                    "from (\n" +
                    "select  \n" +
                    "total.OpenedTime as OpenedTime,\n" +
                    "SUM(total.num) as totalfz\n" +
                    "from (\n" +
                    "-- -- L1 - FLR%  一线解决率 分子 by Incident_Test\n" +
                    "select \n" +
                    "DATEPART(hh, t1.Opened) as OpenedTime,\n" +
                    "CAST(COUNT(*) as float)  as num\n" +
                    "from Incident t1\n" +
                    "where DATEDIFF(day, t1.Opened,  FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')) =1\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='23:00:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='23:59:59'\n" +
                    "and t1.State ='Closed'\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    "UNION All\n" +
                    "-- -- L1 - FLR%  一线解决率 分子 by Request_Tes\n" +
                    "select \n" +
                    "DATEPART(hh, t1.Opened) as OpenedTime2,\n" +
                    "CAST(COUNT(*) as float) as num\n" +
                    "from Request t1\n" +
                    "where DATEDIFF(day, t1.Opened,  FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')) =1\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='23:00:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='23:59:59'\n" +
                    "and t1.State='Closed'\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    "UNION ALL\n" +
                    "-- L1 - FLR%  一线解决率 分子 by NewCall_Test\n" +
                    "select  \n" +
                    "DATEPART(hh, t1.Opened) as OpenedTime3,\n" +
                    "CAST(COUNT(*) as float) as num\n" +
                    "from NewCall t1\n" +
                    "where DATEDIFF(day, t1.Opened,  FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')) =1\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='23:00:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='23:59:59'\n" +
                    "and t1.[Call type] = 'Enquiry (FCR Only)'--//TODO Enquiry (FCR Only)\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "-- and t1.[Opened by] in ('chen,Louis')\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    ") total\n" +
                    "GROUP BY total.OpenedTime\n" +
                    ") aa\n" +
                    "LEFT JOIN \n" +
                    "(\n" +
                    "select \n" +
                    "qwe.OpenedTime1 as OpenedTime1,\n" +
                    "SUM(qwe.num) as totalfm\n" +
                    "from (\n" +
                    "-- L1 - FLR%  一线解决率 分母  by Incident_Test\n" +
                    "select  \n" +
                    " DATEPART(hh, t1.Opened) as OpenedTime1,\n" +
                    "CAST(COUNT(*) as float) as num\n" +
                    "from Incident t1\n" +
                    "where  DATEDIFF(day, t1.Opened,  FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')) =1\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='23:00:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='23:59:59'\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "-- and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    "UNION All\n" +
                    "-- -- L1 - FLR%  一线解决率 分母 by Request_Test\n" +
                    "select\n" +
                    "DATEPART(hh, t1.Opened) as OpenedTime3,\n" +
                    "CAST(COUNT(*) as float) as num\n" +
                    "from Request t1\n" +
                    "where DATEDIFF(day, t1.Opened,  FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')) =1\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='23:00:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='23:59:59'\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "-- and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    "UNION ALL\n" +
                    "-- L1 - FLR%  一线解决率 分母 by NewCall_Test\n" +
                    "select \n" +
                    "DATEPART(hh, t1.Opened) as OpenedTime3,\n" +
                    "CAST(COUNT(*) as float) as num\n" +
                    "from NewCall t1\n" +
                    "where DATEDIFF(day, t1.Opened,  FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')) =1\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='23:00:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='23:59:59'\n" +
                    "and t1.[Call type] = 'Enquiry (FCR Only)' -- //TODO Enquiry (FCR Only)\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "-- and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "-- and t1.[Opened by] in ('chen,Louis')\n" +
                    "GROUP BY DATEPART(hh, t1.Opened)\n" +
                    ") qwe \n" +
                    "GROUP BY qwe.OpenedTime1\n" +
                    ") bb\n" +
                    "on aa.OpenedTime = bb.OpenedTime1"
    })
    public List<Map<String, Object>> selectSlaComplianceFirstLineSolutionRate2ByTime();


    /**
     * 删除当天时间段23:00到零点之间数据
     */
    @Select({
            "delete from sla_phone_incident where   DATE_FORMAT(time,'%y/%m/%d')  = DATE_FORMAT(SYSDATE()-1,'%y/%m/%d') and OpenDateTimeFirstLineOne=23"
    })
    public void deleteSlaPhoneIncidentFirstLineSolutionRateByTime();

}
