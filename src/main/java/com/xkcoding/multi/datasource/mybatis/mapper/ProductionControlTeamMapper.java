package com.xkcoding.multi.datasource.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xkcoding.multi.datasource.mybatis.model.ProductionControlTeam;
import com.xkcoding.multi.datasource.mybatis.model.ProductionControlTeamGroup;
import com.xkcoding.multi.datasource.mybatis.model.businessVolume;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author: smf
 * @time: 7/12/2020 8:47 AM 作业生产量管控-SD-L1 Team  持久层
 * @description:
 */
public interface ProductionControlTeamMapper extends BaseMapper<ProductionControlTeam> {

    /***
     * 录入 Production_Control_Team
     */
    @Insert({
            "<script>",
            "insert into Production_Control_Team(time, Incoming,Responded,Closed,ChGroup,EsmGroup,AAGroup,EndTime) values ",
            "<foreach collection='productionControlTeamList' item='item' index='index' separator=','>",
            "( #{item.time}, #{item.Incoming},#{item.Responded},#{item.Closed},#{item.ChGroup},#{item.EsmGroup},#{item.AAGroup},#{item.EndTime})",
            "</foreach>",
            "</script>"
    })
    public Boolean insertProductionControlTeamList(@Param("productionControlTeamList") List<ProductionControlTeam> productionControlTeamList);


    /***
     * Production_Control_Team
     */
    @Delete({
            "<script>",
            "delete from production_control_team",
            "</script>"
    })
    public void deleteProductionControlTeam();


    /**
     * 作业生产量管控-SD-L1 Team-Incoming
     *
     * @return
     */
    /*@Select({
            "-- 单量 - L1-incoming\\n\" +\n" +
                    "select  \n" +
                    "SUM(abc.num) as totalNum\n" +
                    "from (\n" +
                    "select  \n" +
                    "COUNT (*) as num \n" +
                    "from Call t1 \n" +
                    "where DATEDIFF(day, t1.[呼叫开始时间], GETDATE()) =0 \n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(8),t1.[通话时间],114),114)> ' 00:00:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.[呼叫开始时间],114),114)>='08:30:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.[呼叫开始时间],114),114)<='12:00:00'\n" +
                    "UNION ALL\n" +
                    "select  \n" +
                    "COUNT (*) as num \n" +
                    "from Call t1 \n" +
                    "where DATEDIFF(day, t1.[呼叫开始时间], GETDATE()) =0 \n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(8),t1.[通话时间],114),114)> ' 00:00:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.[呼叫开始时间],114),114)>='13:00:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.[呼叫开始时间],114),114)<='22:00:00'\n" +
                    "\n" +
                    ") abc"
    })*/
    @Select({
            "select  \n" +
                    "COUNT (*) as num \n" +
                    "from Call t1 \n" +
                    "where DATEDIFF(day, t1.[呼叫开始时间], GETDATE()) =0 \n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(8),t1.[通话时间],114),114)> ' 00:00:00'"
    })
    public Integer selectProductionControlIncoming();


    /**
     * 作业生产量管控-SD-L1 Team-Responded
     *
     * @return
     */

   /* @Select({  //TODO 修改前
            "select  \n" +
                    "SUM(abc.num) as totalNum\n" +
                    "from (\n" +
                    "--单量 - L1-RESPONDED   Incident\\\\n\\\" +\\n\" +\n" +
                    "select \n" +
                    "COUNT(*) as num \n" +
                    "from  Incident t1\n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    "-- and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='08:30:00'\n" +
                    "-- and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='12:00:00'\n" +
                    "and  t1.[Owned By] in (select  * from L1_AssignmentGroup )\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "\n" +
                    "UNION All\n" +
                    "-- 单量 - L1-RESPONDED   Request\\\\n\\\" +\\n\" +\n" +
                    "select \n" +
                    "COUNT(*) as num \n" +
                    "from  Request t1\n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    "-- and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='08:30:00'\n" +
                    "-- and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='12:00:00'\n" +
                    "and  t1.[Assignment Group] in (select  * from L1_AssignmentGroup )\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "UNION All\n" +
                    "-- 单量 - L1-RESPONDED   NewCall\\\\n\\\" \n" +
                    "select  \n" +
                    "COUNT(*) as num \n" +
                    "from NewCall t1 \n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    "-- and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='08:30:00'\n" +
                    "-- and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='12:00:00'\n" +
                    "-- and t1.[Opened by]  in ('Chen, Shaodong (YIDATEC)')\\\\n\\\" +\\n\" +\n" +
                    "and t1.[Opened by] = 'chen,Louis'\n" +
                    "and t1.[Call type] not in ('Enquiry (FCR Only)','Incident')\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "\n" +
                    ") abc "
    })*/
    @Select({
            "--  Res 总数\n" +
                    "select  \n" +
                    "SUM(qwe.resNum) as resNum\n" +
                    "from (\n" +
                    "--   Incident\n" +
                    " select  \n" +
                    "COUNT(*) as resNum,\n" +
                    "'1' as resMark\n" +
                    "from Incident t1 \n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    "and t1.[Owned By] in (select  * from L1_AssignmentGroup) \n" +
                    "\n" +
                    "\n" +
                    "\tUNION ALL\n" +
                    "--  Request\n" +
                    " select  \n" +
                    "COUNT(*) as resNum,\n" +
                    "'2' as resMark\n" +
                    "from Request t1 \n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE()) =0\n" +
                    "and t1.[Assignment Group] in (select  * from L1_AssignmentGroup)\n" +
                    "\n" +
                    "\n" +
                    "UNION ALL\n" +
                    "--  NewCall\n" +
                    "select  \n" +
                    "COUNT(*) as resNum ,\n" +
                    "'3' as resMark\n" +
                    "from NewCall t1 \n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE()) =0\n" +
                    "and t1.[Call type] not in('Enquiry (FCR Only)')\n" +
                    "and t1.[Opened by] ='chen,Louis'\n" +
                    "\n" +
                    "\n" +
                    ") qwe\n" +
                    "\n"
    })
    public Integer selectProductionControlResponded();


    /**
     * 作业生产量管控-SD-L1 Team-Closed
     *
     * @return
     */

    /*@Select({
            "select  \n" +
                    "SUM(abc.num) as totalNum\n" +
                    "from (\n" +
                    "--单量 - L1-RESPONDED   Incident\\n\" +\n" +
                    "select \n" +
                    "COUNT(*) as num \n" +
                    "from  Incident t1 \n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='08:30:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='12:00:00'\n" +
                    "and  t1.[Assignment Group] in (select  * from L1_AssignmentGroup )\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "UNION ALL\n" +
                    "select \n" +
                    "COUNT(*) as num \n" +
                    "from  Incident t1 \n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='13:00:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='22:00:00'\n" +
                    "and  t1.[Assignment Group] in (select  * from L1_AssignmentGroup )\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "UNION All\n" +
                    "-- 单量 - L1-RESPONDED   Request\\n\" +\n" +
                    "select \n" +
                    "COUNT(*) as num \n" +
                    "from  Request t1 \n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='08:30:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='12:00:00'\n" +
                    "and  t1.[Assignment Group] in (select  * from L1_AssignmentGroup )\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "UNION ALL\n" +
                    "select \n" +
                    "COUNT(*) as num \n" +
                    "from  Request t1 \n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='13:00:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='22:00:00'\n" +
                    "and  t1.[Assignment Group] in (select  * from L1_AssignmentGroup )\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "\n" +
                    "\n" +
                    "UNION All\n" +
                    "-- 单量 - L1-RESPONDED   NewCall\\n\" +\n" +
                    "select  \n" +
                    "COUNT(*) as num \n" +
                    "from NewCall t1 \n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='08:30:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='12:00:00'\n" +
                    "-- and t1.[Opened by]  in ('Chen, Shaodong (YIDATEC)')\\n\" +\n" +
                    "and t1.[Opened by] = 'chen,Louis'\n" +
                    "and t1.[Call type] not in ('Enquiry (FCR Only)','Incident')\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "UNION ALL\n" +
                    "select  \n" +
                    "COUNT(*) as num \n" +
                    "from NewCall t1 \n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='13:00:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='22:00:00'\n" +
                    "-- and t1.[Opened by]  in ('Chen, Shaodong (YIDATEC)')\\n\" +\n" +
                    "and t1.[Opened by] = 'chen,Louis'\n" +
                    "and t1.[Call type] not in ('Enquiry (FCR Only)','Incident')\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    ") abc "
    })*/
    /*@Select({  //TODO 修改前
            "select  \n" +
                    "SUM(abc.num) as totalNum\n" +
                    "from (\n" +
                    "--单量 - L1-RESPONDED   Incident\\\\n\\\" +\\n\" +\n" +
                    "select \n" +
                    "COUNT(*) as num \n" +
                    "from  Incident t1 \n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    "-- and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='08:30:00'\n" +
                    "-- and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='12:00:00'\n" +
                    "and  t1.[Assignment Group] in (select  * from L1_AssignmentGroup )\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "\n" +
                    "UNION All\n" +
                    "-- 单量 - L1-RESPONDED   Request\\\\n\\\" +\\n\" +\n" +
                    "select \n" +
                    "COUNT(*) as num \n" +
                    "from  Request t1 \n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    "-- and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='08:30:00'\n" +
                    "-- and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='12:00:00'\n" +
                    "and  t1.[Assignment Group] in (select  * from L1_AssignmentGroup )\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "\n" +
                    "UNION All\n" +
                    "-- 单量 - L1-RESPONDED   NewCall\\\\n\\\" +\\n\" +\n" +
                    "select  \n" +
                    "COUNT(*) as num \n" +
                    "from NewCall t1 \n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    "-- and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='08:30:00'\n" +
                    "-- and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='12:00:00'\n" +
                    "-- and t1.[Opened by]  in ('Chen, Shaodong (YIDATEC)')\\\\n\\\" +\\n\" +\n" +
                    "and t1.[Opened by] = 'chen,Louis'\n" +
                    "and t1.[Call type] not in ('Enquiry (FCR Only)','Incident')\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "\n" +
                    ") abc "
    })*/
    @Select({
            "\n" +
                    "-- close 总数 \n" +
                    "select \n" +
                    "SUM(asd.closeNum) as closeNum\n" +
                    " from \n" +
                    "\n" +
                    "(\n" +
                    "\n" +
                    "----CLOSE\n" +
                    "--  单量 - L1-RESPONDED\n" +
                    "--  Incident\n" +
                    "select  \n" +
                    "COUNT(*) as closeNum,\n" +
                    "'1' as Mark\n" +
                    "from Incident t1 \n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    "and t1.[Assignment Group] in (select  * from L1_AssignmentGroup) \n" +
                    "\n" +
                    "\n" +
                    "UNION ALL\n" +
                    "-- Request\n" +
                    "select  \n" +
                    "COUNT(*) as closeNum,\n" +
                    "'2' as Mark\n" +
                    "from Request t1 \n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE()) =0\n" +
                    "and t1.[Assignment Group] in (select  * from L1_AssignmentGroup)\n" +
                    "\n" +
                    "UNION ALL\n" +
                    "--  NewCall\n" +
                    "select  \n" +
                    "COUNT(*) as closeNum ,\n" +
                    "'3' as Mark\n" +
                    "from NewCall t1 \n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE()) =0\n" +
                    "and t1.[Call type] not in('Enquiry (FCR Only)')\n" +
                    "and t1.[Opened by] ='chen,Louis' \n" +
                    "\n" +
                    ") asd \n" +
                    "--  on asd.closeGroupName = qwe.resGroupName\n" +
                    "-- and asd.Mark = qwe.resMark"
    })
    public Integer selectProductionControlClosed();


    //测试时间接口
    @Select({" <script>",
            " select  \n" +
                    "COUNT (*) as num \n" +
                    "-- t1.Opened\n" +
                    "from \n" +
                    "Incident t1 \n" +
                    "where \n" +
                    "1=1",
            " <if test=\"starDuration != null and starDuration != ''\">",
            "and CONVERT(VARCHAR(10),t1.Opened,108) &gt;=#{starDuration}",
            "and CONVERT(VARCHAR(10),t1.Opened,108) &gt;=#{endDuration}",
            "</if>",
            "<if test=\"year != null and year != ''\">",
            "and DATEDIFF(yy, t1.Opened, GETDATE()) = #{year}",
            "</if>",
            "<if test=\"month != null and month != ''\">",
            "and DATEDIFF(mm, t1.Opened, GETDATE()) = #{month}",
            "</if>",
            " </script>"})
    public Integer selectByDuration(@Param("starDuration") String starDuration, @Param("endDuration") String endDuration, @Param("year") String year, @Param("month") String month);


    /**
     * 作业生产量管控-SD-L1 Team-Incoming-2
     *
     * @return
     */
    @Select({
            "select \n" +
                    "DATEPART(hh,t1.[呼叫开始时间]) as startTime,\n" +
                    "COUNT (*) as num \n" +
                    "from Call t1 \n" +
                    "where DATEDIFF(day, t1.[呼叫开始时间], GETDATE()) =0 \n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(8),t1.[通话时间],114),114)> ' 00:00:00'\n" +
                    "and t1.[联系服务队列名称] is not null  and t1.[联系服务队列名称] !=''\n" +
                    "GROUP BY DATEPART(hh,t1.[呼叫开始时间])"
    })
 /*   @Select({
            "\n" +
                    "select \n" +
                    "DATEPART(hh,t1.[呼叫开始时间]) as startTime,\n" +
                    "COUNT (*) as num ,\n" +
                    "t1.[联系服务队列名称]\n" +
                    "from Call t1 \n" +
                    "where DATEDIFF(day, t1.[呼叫开始时间], GETDATE()) =0 \n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(8),t1.[通话时间],114),114)> ' 00:00:00'\n" +
                    "and t1.[联系服务队列名称] is not null  and t1.[联系服务队列名称] !=''\n" +
                    "GROUP BY DATEPART(hh,t1.[呼叫开始时间]),t1.[联系服务队列名称]"
    })*/
    public List<Map<String, Object>> selectProductionControlIncoming2();

    /**
     * 查询昨天23:点至零点incoming
     *
     * @return
     */
    @Select({
            "-- 查询昨天23点至零点\n" +
                    "select \n" +
                    "COUNT (*) as num \n" +
                    " --t1.[呼叫开始时间]\n" +
                    "from Call t1 \n" +
                    "where DATEDIFF(day, t1.[呼叫开始时间], GETDATE()) =1\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(8),t1.[通话时间],114),114)> ' 00:00:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(8),t1.[呼叫开始时间],114),114)>='23:00:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(8),t1.[呼叫开始时间],114),114)>='23:59:59'\n" +
                    "--GROUP BY t1.[呼叫开始时间]"
    })
    public List<Map<String, Object>> selectProductionControlIncomingByTime();


    /**
     * 删除当天23点至零点数据
     */
    @Select({
            "delete from sla_compliance where   production_control_team(time,'%y/%m/%d')  = DATE_FORMAT(SYSDATE()-1,'%y/%m/%d') and Incoming=23"
    })
    public void deleteIncomingByTime();


    /**
     * 录入production_control_team_group
     *
     * @param productionControlTeamGroupList
     * @return
     */
    @Insert({
            "<script>",
            "insert into production_control_team_group(time, InComing,Responded,Closed,AssignmentGroup,MaRk,SourceType,EndTime) values ",
            "<foreach collection='productionControlTeamGroupList' item='item' index='index' separator=','>",
            "( #{item.time}, #{item.InComing},#{item.Responded},#{item.Closed},#{item.AssignmentGroup},#{item.MaRk},#{item.SourceType},#{item.EndTime})",
            "</foreach>",
            "</script>"
    })
    public Boolean insertProductionControlTeamGroup(@Param("productionControlTeamGroupList") List<ProductionControlTeamGroup> productionControlTeamGroupList);


    /***
     * production_control_team_group 清表
     */
    @Delete({
            "<script>",
            "delete from production_control_team_group",
            "</script>"
    })
    public void deleteProductionControlTeamGroup();


    /**
     * 分组统计RESPONDED
     */
   /* @Select({
            "--单量 - L1-RESPONDED   Incident\\\\\\\\n\\\\\\\" +\\\\n\\\" +\\n\" +\n" +
                    "select \n" +
                    "SUM(abc.num) as responded,\n" +
                    "abc.groupName as groupName,\n" +
                    "abc.mark \n" +
                    "from (\n" +
                    "select \n" +
                    "COUNT(*) as num ,\n" +
                    "t1.[Assignment Group] as groupName,\n" +
                    "'1' as mark\n" +
                    "from  Incident t1 \n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    "-- and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='08:30:00'\\n\" +\n" +
                    "-- and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='12:00:00'\\n\" +\n" +
                    "-- and  t1.[Assignment Group] in (select  * from L1_AssignmentGroup )\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "and t1.[Assignment Group] in ('AZ China Shanghai Service Desk','AZ ESM Level 1 Support','AZ Asiapac IT Service Desk')\n" +
                    "GROUP BY t1.[Assignment Group]\n" +
                    "\n" +
                    "UNION All\n" +
                    "-- 单量 - L1-RESPONDED   Request\\\\\\\\n\\\\\\\" +\\\\n\\\" +\\n\" +\n" +
                    "select \n" +
                    "COUNT(*) as num ,\n" +
                    "t1.[Assignment Group] as groupName,\n" +
                    "'2' as mark\n" +
                    "from  Request t1\n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    "-- and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='08:30:00'\\n\" +\n" +
                    "-- and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='12:00:00'\\n\" +\n" +
                    "-- and  t1.[Assignment Group] in (select  * from L1_AssignmentGroup )\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "and t1.[Assignment Group] in ('AZ China Shanghai Service Desk','AZ ESM Level 1 Support','AZ Asiapac IT Service Desk')\n" +
                    "GROUP BY t1.[Assignment Group]\n" +
                    "UNION All\n" +
                    "-- 单量 - L1-RESPONDED   NewCall\\\\\\\\n\\\\\\\" +\\\\n\\\" +\\n\" +\n" +
                    "select \n" +
                    "COUNT(*) as num ,\n" +
                    "t1.[Assignment Group] as groupName,\n" +
                    " 'NewCall' as mark\n" +
                    "from NewCall t1\n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    "-- and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='08:30:00'\\n\" +\n" +
                    "-- and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='12:00:00'\\n\" +\n" +
                    "-- and t1.[Opened by]  in ('Chen, Shaodong (YIDATEC)')\\\\\\\\n\\\\\\\" +\\\\n\\\" +\\n\" +\n" +
                    " and t1.[Opened by] = 'chen,Louis'\n" +
                    "and t1.[Call type] not in ('Enquiry (FCR Only)','Incident')\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "and t1.[Assignment Group] in ('AZ China Shanghai Service Desk','AZ ESM Level 1 Support','AZ Asiapac IT Service Desk')\n" +
                    "GROUP BY t1.[Assignment Group]\n" +
                    ") abc \n" +
                    "\n" +
                    "GROUP BY abc.groupName,abc.mark "
    })*/
   /* @Select({  TODO 修改前
            "  select \n" +
                    "  COUNT(*) as responded ,\n" +
                    "  t1.[Assignment Group] as groupName,\n" +
                    " \t'1' as mark\n" +
                    "  from Incident t1 \n" +
                    "  where DATEDIFF(day, t1.Opened, GETDATE()) =0\n" +
                    "  and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "  and t1.[Owned By] in (select  * from L1_AssignmentGroup)\n" +
                    "  and t1.[Assignment Group] in ('AZ China Shanghai Service Desk','AZ ESM Level 1 Support','AZ Asiapac IT Service Desk')\n" +
                    "  GROUP BY t1.[Assignment Group]\n" +
                    "  UNION All\n" +
                    " \n" +
                    "  select \n" +
                    "  COUNT(*) as num ,\n" +
                    "  t1.[Assignment Group] as groupName,\n" +
                    "  '2' as mark\n" +
                    "  from Request t1 \n" +
                    "  where DATEDIFF(day, t1.Opened, GETDATE()) =0\n" +
                    "  and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "  and t1.[Assignment Group] in (select  * from L1_AssignmentGroup)\n" +
                    "  and t1.[Assignment Group] in ('AZ China Shanghai Service Desk','AZ ESM Level 1 Support','AZ Asiapac IT Service Desk')\n" +
                    "  GROUP BY t1.[Assignment Group]\n" +
                    " UNION All\n" +
                    " \n" +
                    " select \n" +
                    " COUNT(*) as num ,\n" +
                    " t1.[Assignment Group] as groupName,\n" +
                    " '' as mark\n" +
                    " from NewCall t1 \n" +
                    " where  DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    " and t1.[Business Service] is not null and t1.[Business Service] !=''\n" +
                    " and t1.[Call type]  not in ('Enquiry (FCR Only)') \n" +
                    " -- and t1.[Opened by] in ('chen,Louis')\n" +
                    " and t1.[Assignment Group] in ('AZ China Shanghai Service Desk','AZ ESM Level 1 Support','AZ Asiapac IT Service Desk')\n" +
                    " GROUP BY t1.[Assignment Group]"
    })*/
    @Select({
            "select * from production_control_team_by_group"
    })
    public List<Map<String, Object>> selectProductionControlRespondedByGroup();

    /**
     * 分组统计Close
     */
    /*@Select({
            "--单量 - L1-RESPONDED   \n" +
                    "select \n" +
                    "SUM(abc.num) as closed,\n" +
                    "abc.groupName as groupName,\n" +
                    "abc.mark \n" +
                    "from (\n" +
                    "select \n" +
                    "COUNT(*) as num ,\n" +
                    "t1.[Assignment Group] as groupName,\n" +
                    "'1' as mark\n" +
                    "from  Incident t1 \n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    "-- and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='08:30:00'\\\\n\\\" +\\n\" +\n" +
                    "-- and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='12:00:00'\\\\n\\\" +\\n\" +\n" +
                    "-- and  t1.[Assignment Group] in (select  * from L1_AssignmentGroup )\\n\" +\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "and t1.[Assignment Group] in ('AZ China Shanghai Service Desk','AZ ESM Level 1 Support','AZ Asiapac IT Service Desk')\n" +
                    "GROUP BY t1.[Assignment Group]\n" +
                    "\n" +
                    "UNION All\n" +
                    "-- 单量 - L1-RESPONDED   Request\\\\\\\\\\\\\\\\n\\\\\\\\\\\\\\\" +\\\\\\\\n\\\\\\\" +\\\\n\\\" +\\n\" +\n" +
                    "select \n" +
                    "COUNT(*) as num ,\n" +
                    "t1.[Assignment Group] as groupName,\n" +
                    "'2' as mark\n" +
                    "from  Request t1\n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    "-- and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='08:30:00'\\\\n\\\" +\\n\" +\n" +
                    "-- and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='12:00:00'\\\\n\\\" +\\n\" +\n" +
                    "-- and  t1.[Assignment Group] in (select  * from L1_AssignmentGroup )\\n\" +\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "and t1.[Assignment Group] in ('AZ China Shanghai Service Desk','AZ ESM Level 1 Support','AZ Asiapac IT Service Desk')\n" +
                    "GROUP BY t1.[Assignment Group]\n" +
                    "UNION All\n" +
                    "-- 单量 - L1-RESPONDED   NewCall\\\\\\\\\\\\\\\\n\\\\\\\\\\\\\\\" +\\\\\\\\n\\\\\\\" +\\\\n\\\" +\\n\" +\n" +
                    "select \n" +
                    "COUNT(*) as num ,\n" +
                    "t1.[Assignment Group] as groupName,\n" +
                    " 'NewCall' as mark\n" +
                    "from NewCall t1\n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    "-- and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)>='08:30:00'\\\\n\\\" +\\n\" +\n" +
                    "-- and CONVERT(TIME,CONVERT(VARCHAR(20),t1.Opened,114),114)<='12:00:00'\\\\n\\\" +\\n\" +\n" +
                    "-- and t1.[Opened by]  in ('Chen, Shaodong (YIDATEC)')\\\\\\\\\\\\\\\\n\\\\\\\\\\\\\\\" +\\\\\\\\n\\\\\\\" +\\\\n\\\" +\\n\" +\n" +
                    " and t1.[Opened by] = 'chen,Louis'\n" +
                    "and t1.[Call type] not in ('Enquiry (FCR Only)','Incident')\n" +
                    "and t1.[Business Service] is not null  and t1.[Business Service] !=''\n" +
                    "and t1.[Assignment Group] in ('AZ China Shanghai Service Desk','AZ ESM Level 1 Support','AZ Asiapac IT Service Desk')\n" +
                    "GROUP BY t1.[Assignment Group]\n" +
                    ") abc \n" +
                    "\n" +
                    "GROUP BY abc.groupName,abc.mark"
    })*/
    @Select({
            "-- close \n" +
                    " select  \n" +
                    " COUNT(*) as closed,\n" +
                    " t1.[Assignment Group] as groupName,\n" +
                    "\t'1' as mark\n" +
                    " from Incident t1 \n" +
                    " where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    " and t1.[Business Service] is not null and t1.[Business Service] !=''\n" +
                    " -- and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    " and t1.[Assignment Group] in ('AZ China Shanghai Service Desk','AZ ESM Level 1 Support','AZ Asiapac IT Service Desk')\n" +
                    " GROUP BY t1.[Assignment Group] \n" +
                    " UNION All\n" +
                    " select  \n" +
                    " COUNT(*) as num,\n" +
                    " t1.[Assignment Group] as groupName,\n" +
                    " '2' as mark\n" +
                    " from Request t1 \n" +
                    " where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    " and t1.[Business Service] is not null and t1.[Business Service] !=''\n" +
                    " and t1.[Assignment Group] in ('AZ China Shanghai Service Desk','AZ ESM Level 1 Support','AZ Asiapac IT Service Desk')\n" +
                    " GROUP BY t1.[Assignment Group] \n" +
                    "UNION All\n" +
                    "\n" +
                    "select \n" +
                    "COUNT(*) as num ,\n" +
                    "t1.[Assignment Group] as groupName,\n" +
                    "'' as mark\n" +
                    "from NewCall t1 \n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    "and t1.[Call type]  not in ('Enquiry (FCR Only)') \n" +
                    "-- and t1.[Opened by] in ('chen,Louis')\n" +
                    " and t1.[Assignment Group] in ('AZ China Shanghai Service Desk','AZ ESM Level 1 Support','AZ Asiapac IT Service Desk') \n" +
                    "GROUP BY t1.[Assignment Group]"
    })
    public List<Map<String, Object>> selectProductionControlCloseByGroup();

    /**
     * 查询 incoming 全部历史数据
     *
     * @return
     */
    @Select({
            "select \n" +
                    "COUNT (*) as num ,\n" +
                    "SUBSTRING(CONVERT(VARCHAR(100),t1.[呼叫开始时间],20),1,13) as startTime,\n" +
                    "'2' as Mark\n" +
                    "from Call t1 \n" +
                    "-- where DATEDIFF(day, t1.[呼叫开始时间], GETDATE()) =0 \n" +
                    "where CONVERT(TIME,CONVERT(VARCHAR(8),t1.[通话时间],114),114)> ' 00:00:00'\n" +
                    "GROUP BY SUBSTRING(CONVERT(VARCHAR(100),t1.[呼叫开始时间],20),1,13)"
    })
    List<Map<String, Object>> selectIncomingByDate();


}
