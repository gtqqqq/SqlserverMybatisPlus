package com.xkcoding.multi.datasource.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xkcoding.multi.datasource.mybatis.model.lineChart;
import com.xkcoding.multi.datasource.mybatis.model.responseWorkOrder;
import com.xkcoding.multi.datasource.mybatis.model.slaCompliance;
import com.xkcoding.multi.datasource.mybatis.model.slaComplianceSqlServer;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author: smf
 * @time: 7/7/2020 9:01 PM
 * @description: SD-L1 ：SLA 达标情况 持久层
 */
public interface slaComplianceMapper extends BaseMapper<slaCompliance> {


    /***
     * 录入 SD-L1 ：SLA 达标情况
     */
    @Insert({
            "<script>",
            "insert into sla_compliance(time, OpenDateTimeOne,NumberOne,OpenDateTimeTwo,NumberTwo,CallAnswerRate,OpenDateTimeFallOne,NumberFallOne,OpenDateTimeFallTwo,NumberFallTwo,CallAbandonRate,WeChat,LiveChatServiceNow,Email,ServiceNowTickets,EndTime) values ",
            "<foreach collection='slaComplianceList' item='item' index='index' separator=','>",
            "( #{item.time}, #{item.OpenDateTimeOne},#{item.NumberOne},#{item.OpenDateTimeTwo},#{item.NumberTwo},#{item.CallAnswerRate},#{item.OpenDateTimeFallOne},#{item.NumberFallOne},#{item.OpenDateTimeFallTwo},#{item.NumberFallTwo},#{item.CallAbandonRate},#{item.WeChat},#{item.LiveChatServiceNow},#{item.Email},#{item.ServiceNowTickets},#{item.EndTime})",
            "</foreach>",
            "</script>"
    })
    public Boolean insertSlaComplianceList(@Param("slaComplianceList") List<slaCompliance> slaComplianceList);

    @Delete({
            "<script>",
            "delete from sla_compliance",
            "</script>"
    })
    public void deleteSlaCompliance();


    /**
     * 查询 SLA 达标情况-20秒内电话接通率
     *
     * @return
     */
    //TODO  以下注释掉为 当天 八点半到十点条件
    /*@Select({
            "-- SLA 达标情况-20秒内电话接通率\\\\n\\\" +\\n\" +\n" +
                    "select \n" +
                    "t2.opendateTime as opendateTime1,\n" +
                    "t2.Number1 as Number1,\n" +
                    "t4.opendate as opendateTime2,\n" +
                    "t4.Number2 as Number2,\n" +
                    "concat (ROUND(t2.Number1/t4.Number2*100,2),'%')as jtRate\n" +
                    "from (\n" +
                    "select  \n" +
                    "CAST (count(*) as FLOAT) as Number1,\n" +
                    "-- SUBSTRING(CONVERT(varchar(100), t1.呼叫开始时间, 20) ,12,2) as opendateTime\\n\" +\n" +
                    "DATEPART(hh, t1.呼叫开始时间) as opendateTime\n" +
                    "from Call t1\n" +
                    "where DATEDIFF(day, t1.[呼叫开始时间], GETDATE()) =0\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.[呼叫开始时间],114),114)>='08:30:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.[呼叫开始时间],114),114)<='12:00:00'\n" +
                    "and  convert(Time,CONVERT(nvarchar(8),t1.排队时间,114),114)<='00:00:20'\n" +
                    "and t1.联系服务队列名称 in ('CSQ_Chinese_Support','CSQ_Train_Support','CSQ_Concur_Support','CSQ_iCustomer_Support','CSQ_ESM_Support','CSQ_Password_Support','CSQ_Travel_Support','CSQ_English_Support','CSQ_eXuehui','CSQ_Taiwan_Support')\n" +
                    "and Convert(Time,CONVERT(nvarchar(8),t1.通话时间,114),114)> '00:00:00'\n" +
                    "GROUP BY DATEPART(hh, t1.呼叫开始时间)\n" +
                    "UNION ALL\n" +
                    "select  \n" +
                    "CAST (count(*) as FLOAT) as num1,\n" +
                    "DATEPART(hh, t1.呼叫开始时间) as opendateTime\n" +
                    "from Call t1\n" +
                    "where DATEDIFF(day, t1.[呼叫开始时间], GETDATE()) =0\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.[呼叫开始时间],114),114)>='13:00:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.[呼叫开始时间],114),114)<='22:00:00'\n" +
                    "and  convert(Time,CONVERT(nvarchar(8),t1.排队时间,114),114)<='00:00:20'\n" +
                    "and t1.联系服务队列名称 in ('CSQ_Chinese_Support','CSQ_Train_Support','CSQ_Concur_Support','CSQ_iCustomer_Support','CSQ_ESM_Support','CSQ_Password_Support','CSQ_Travel_Support','CSQ_English_Support','CSQ_eXuehui','CSQ_Taiwan_Support')\n" +
                    "and Convert(Time,CONVERT(nvarchar(8),t1.通话时间,114),114)> '00:00:00'\n" +
                    "GROUP BY DATEPART(hh, t1.呼叫开始时间)\n" +
                    ") t2\n" +
                    "LEFT JOIN\n" +
                    "(\n" +
                    "select \n" +
                    "CAST (count(*) as FLOAT) as Number2,\n" +
                    "-- SUBSTRING(CONVERT(varchar(100), 呼叫开始时间, 20) ,12,2) as opendate\n" +
                    "DATEPART(hh, t3.呼叫开始时间) as opendate\n" +
                    "from Call t3\n" +
                    "where DATEDIFF(day, t3.[呼叫开始时间], GETDATE()) =0\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t3.[呼叫开始时间],114),114)>='08:30:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t3.[呼叫开始时间],114),114)<='12:00:00'\n" +
                    "and Convert(Time,CONVERT(nvarchar(8),t3.通话时间,114),114)> '00:00:00'\n" +
                    "and t3.联系服务队列名称 in ('CSQ_Chinese_Support','CSQ_Train_Support','CSQ_Concur_Support','CSQ_iCustomer_Support','CSQ_ESM_Support','CSQ_Password_Support','CSQ_Travel_Support','CSQ_English_Support','CSQ_eXuehui','CSQ_Taiwan_Support')\n" +
                    "-- and 联系处置=2\n" +
                    "GROUP BY DATEPART(hh, t3.呼叫开始时间)\n" +
                    "UNION ALL\n" +
                    "select \n" +
                    "CAST (count(*) as FLOAT) as num2,\n" +
                    "-- SUBSTRING(CONVERT(varchar(100), 呼叫开始时间, 20) ,12,2) as opendate\n" +
                    "DATEPART(hh, t3.呼叫开始时间) as opendate\n" +
                    "from Call t3\n" +
                    "where DATEDIFF(day, t3.[呼叫开始时间], GETDATE()) =0\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t3.[呼叫开始时间],114),114)>='13:00:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t3.[呼叫开始时间],114),114)<='22:00:00'\n" +
                    "and Convert(Time,CONVERT(nvarchar(8),t3.通话时间,114),114)> '00:00:00'\n" +
                    "and t3.联系服务队列名称 in ('CSQ_Chinese_Support','CSQ_Train_Support','CSQ_Concur_Support','CSQ_iCustomer_Support','CSQ_ESM_Support','CSQ_Password_Support','CSQ_Travel_Support','CSQ_English_Support','CSQ_eXuehui','CSQ_Taiwan_Support')\n" +
                    "-- and 联系处置=2\n" +
                    "GROUP BY DATEPART(hh, t3.呼叫开始时间)\n" +
                    ") t4 \n" +
                    "on t2.opendateTime =t4.opendate\n"
    })*/
    //TODO 以下注释掉为 工作日和非工作日条件
   /* @Select({
            "-- 周一 至周五 工作日\n" +
                    "select \n" +
                    "fenzi.workTime,\n" +
                    "fenzi.workNumber,\n" +
                    "fenmu.workTime,\n" +
                    "fenmu.workNumber,\n" +
                    "fenzi.wokrday\n" +
                    "from(\n" +
                    "select \n" +
                    "a.opendateTime as workTime,\n" +
                    "count(Number1) as workNumber,\n" +
                    "'jie' as wokrday\n" +
                    "from\n" +
                    "(\n" +
                    "select \n" +
                    "CONVERT(varchar(11) ,t1.[呼叫开始时间], 120)as opendateTime,\n" +
                    "count(t1.[呼叫开始时间]) as Number1\n" +
                    "from Call t1 \n" +
                    "where 1=1\n" +
                    "and (CONVERT(TIME,CONVERT(VARCHAR(20),t1.[呼叫开始时间],114),114)>='08:30:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.[呼叫开始时间],114),114)<='12:00:00'\n" +
                    " and CONVERT(varchar(11) ,t1.[呼叫开始时间], 120) \n" +
                    "in (select CONVERT(varchar(11) ,Hoilday, 120)from sheet2))\n" +
                    "or (\n" +
                    "CONVERT(TIME,CONVERT(VARCHAR(20),t1.[呼叫开始时间],114),114)>='13:00:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.[呼叫开始时间],114),114)<='22:00:00'\n" +
                    "and CONVERT(varchar(11) ,t1.[呼叫开始时间], 120) \n" +
                    "in (select CONVERT(varchar(11) ,Hoilday, 120)from sheet2)\n" +
                    ")\n" +
                    "and Convert(Time,CONVERT(nvarchar(8),t1.排队时间,114),114)<= '00:00:20'\n" +
                    "and t1.联系服务队列名称 in ('CSQ_Chinese_Support','CSQ_Train_Support','CSQ_Concur_Support','CSQ_iCustomer_Support','CSQ_ESM_Support','CSQ_Password_Support','CSQ_Travel_Support','CSQ_English_Support','CSQ_eXuehui','CSQ_Taiwan_Support')\n" +
                    "and Convert(Time,CONVERT(nvarchar(8),t1.排队时间,114),114)> '00:00:00'\n" +
                    "GROUP BY t1.[呼叫开始时间]\n" +
                    ") a\n" +
                    " GROUP BY a.opendateTime\n" +
                    "UNION All\n" +
                    "-- 周一 至周五 工作日\n" +
                    "select \n" +
                    "a.opendateTime as workTime,\n" +
                    "count(Number1) as workNumber,\n" +
                    "'gongzuo' as wokrday\n" +
                    "from\n" +
                    "(\n" +
                    "select \n" +
                    "CONVERT(varchar(11) ,t1.[呼叫开始时间], 120)as opendateTime,\n" +
                    "count(t1.[呼叫开始时间]) as Number1\n" +
                    "from Call t1 \n" +
                    "where  1=1\n" +
                    "and (CONVERT(TIME,CONVERT(VARCHAR(20),t1.[呼叫开始时间],114),114)>='08:30:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.[呼叫开始时间],114),114)<='12:00:00'\n" +
                    " and CONVERT(varchar(11) ,t1.[呼叫开始时间], 120) \n" +
                    "not in (select CONVERT(varchar(11) ,Hoilday, 120)from sheet2))\n" +
                    "or (\n" +
                    "CONVERT(TIME,CONVERT(VARCHAR(20),t1.[呼叫开始时间],114),114)>='13:00:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.[呼叫开始时间],114),114)<='22:00:00'\n" +
                    "and CONVERT(varchar(11) ,t1.[呼叫开始时间], 120) \n" +
                    "not in (select CONVERT(varchar(11) ,Hoilday, 120)from sheet2)\n" +
                    ")\n" +
                    "and Convert(Time,CONVERT(nvarchar(8),t1.排队时间,114),114)<= '00:00:20'\n" +
                    "and t1.联系服务队列名称 in ('CSQ_Chinese_Support','CSQ_Train_Support','CSQ_Concur_Support','CSQ_iCustomer_Support','CSQ_ESM_Support','CSQ_Password_Support','CSQ_Travel_Support','CSQ_English_Support','CSQ_eXuehui','CSQ_Taiwan_Support')\n" +
                    "and Convert(Time,CONVERT(nvarchar(8),t1.排队时间,114),114)> '00:00:00'\n" +
                    "GROUP BY t1.[呼叫开始时间]\n" +
                    ") a\n" +
                    " GROUP BY a.opendateTime\n" +
                    ")fenzi\n" +
                    "LEFT JOIN(\n" +
                    "\n" +
                    "-- 周一 至周五 工作日\n" +
                    "select \n" +
                    "a.opendateTime as workTime,\n" +
                    "count(Number1) as workNumber\n" +
                    "from\n" +
                    "(\n" +
                    "select \n" +
                    "CONVERT(varchar(11) ,t1.[呼叫开始时间], 120)as opendateTime,\n" +
                    "count(t1.[呼叫开始时间]) as Number1\n" +
                    "from Call t1 \n" +
                    "where 1=1\n" +
                    "and (CONVERT(TIME,CONVERT(VARCHAR(20),t1.[呼叫开始时间],114),114)>='08:30:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.[呼叫开始时间],114),114)<='12:00:00'\n" +
                    " and CONVERT(varchar(11) ,t1.[呼叫开始时间], 120) \n" +
                    "in (select CONVERT(varchar(11) ,Hoilday, 120)from sheet2))\n" +
                    "or (\n" +
                    "CONVERT(TIME,CONVERT(VARCHAR(20),t1.[呼叫开始时间],114),114)>='13:00:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.[呼叫开始时间],114),114)<='22:00:00'\n" +
                    "and CONVERT(varchar(11) ,t1.[呼叫开始时间], 120) \n" +
                    "in (select CONVERT(varchar(11) ,Hoilday, 120)from sheet2)\n" +
                    ")\n" +
                    "and Convert(Time,CONVERT(nvarchar(8),t1.通话时间,114),114)> '00:00:00'\n" +
                    "and t1.联系服务队列名称 in ('CSQ_Chinese_Support','CSQ_Train_Support','CSQ_Concur_Support','CSQ_iCustomer_Support','CSQ_ESM_Support','CSQ_Password_Support','CSQ_Travel_Support','CSQ_English_Support','CSQ_eXuehui','CSQ_Taiwan_Support')\n" +
                    "and Convert(Time,CONVERT(nvarchar(8),t1.通话时间,114),114)> '00:00:00'\n" +
                    "GROUP BY t1.[呼叫开始时间]\n" +
                    ") a\n" +
                    " GROUP BY a.opendateTime\n" +
                    "UNION All\n" +
                    "-- 周一 至周五 工作日\n" +
                    "select \n" +
                    "a.opendateTime as workTime,\n" +
                    "count(Number1) as workNumber\n" +
                    "from\n" +
                    "(\n" +
                    "select \n" +
                    "CONVERT(varchar(11) ,t1.[呼叫开始时间], 120)as opendateTime,\n" +
                    "count(t1.[呼叫开始时间]) as Number1\n" +
                    "from Call t1 \n" +
                    "where  1=1\n" +
                    "and (CONVERT(TIME,CONVERT(VARCHAR(20),t1.[呼叫开始时间],114),114)>='08:30:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.[呼叫开始时间],114),114)<='12:00:00'\n" +
                    " and CONVERT(varchar(11) ,t1.[呼叫开始时间], 120) \n" +
                    "not in (select CONVERT(varchar(11) ,Hoilday, 120)from sheet2))\n" +
                    "or (\n" +
                    "CONVERT(TIME,CONVERT(VARCHAR(20),t1.[呼叫开始时间],114),114)>='13:00:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.[呼叫开始时间],114),114)<='22:00:00'\n" +
                    "and CONVERT(varchar(11) ,t1.[呼叫开始时间], 120) \n" +
                    "not in (select CONVERT(varchar(11) ,Hoilday, 120)from sheet2)\n" +
                    ")\n" +
                    "and Convert(Time,CONVERT(nvarchar(8),t1.通话时间,114),114)> '00:00:00'\n" +
                    "and t1.联系服务队列名称 in ('CSQ_Chinese_Support','CSQ_Train_Support','CSQ_Concur_Support','CSQ_iCustomer_Support','CSQ_ESM_Support','CSQ_Password_Support','CSQ_Travel_Support','CSQ_English_Support','CSQ_eXuehui','CSQ_Taiwan_Support')\n" +
                    "and Convert(Time,CONVERT(nvarchar(8),t1.通话时间,114),114)> '00:00:00'\n" +
                    "GROUP BY t1.[呼叫开始时间]\n" +
                    ") a\n" +
                    " GROUP BY a.opendateTime\n" +
                    ")fenmu\n" +
                    "on fenzi.workTime =fenmu.workTime\n"
    })*/
    @Select({
            "-- SLA 达标情况-20秒内电话接通率\\\\n\\\" +\\n\" +\n" +
                    "select \n" +
                    "t2.opendateTime as opendateTime1,\n" +
                    "t2.Number1 as Number1,\n" +
                    "t4.opendate as opendateTime2,\n" +
                    "t4.Number2 as Number2,\n" +
                    "concat (ROUND(t2.Number1/t4.Number2*100,2),'%')as jtRate\n" +
                    "from (\n" +
                    "select  \n" +
                    "CAST (count(*) as FLOAT) as Number1,\n" +
                    "-- SUBSTRING(CONVERT(varchar(100), t1.呼叫开始时间, 20) ,12,2) as opendateTime\\n\" +\n" +
                    "DATEPART(hh, t1.呼叫开始时间) as opendateTime\n" +
                    "\n" +
                    "from Call t1\n" +
                    "where DATEDIFF(day, t1.[呼叫开始时间], GETDATE()) =0\n" +
                    "and  convert(Time,CONVERT(nvarchar(8),t1.排队时间,114),114)<='00:00:20'\n" +
                    "and t1.联系服务队列名称 in ('CSQ_Chinese_Support','CSQ_Train_Support','CSQ_Concur_Support','CSQ_iCustomer_Support','CSQ_ESM_Support','CSQ_Password_Support','CSQ_Travel_Support','CSQ_English_Support','CSQ_eXuehui','CSQ_Taiwan_Support')\n" +
                    "and Convert(Time,CONVERT(nvarchar(8),t1.通话时间,114),114)> '00:00:00'\n" +
                    "GROUP BY DATEPART(hh, t1.呼叫开始时间)\n" +
                    ") t2\n" +
                    "LEFT JOIN\n" +
                    "(\n" +
                    "select \n" +
                    "CAST (count(*) as FLOAT) as Number2,\n" +
                    "-- SUBSTRING(CONVERT(varchar(100), 呼叫开始时间, 20) ,12,2) as opendate\n" +
                    "DATEPART(hh, t3.呼叫开始时间) as opendate\n" +
                    "from Call t3\n" +
                    "where DATEDIFF(day, t3.[呼叫开始时间], GETDATE()) =0\n" +
                    "and Convert(Time,CONVERT(nvarchar(8),t3.通话时间,114),114)> '00:00:00'\n" +
                    "and t3.联系服务队列名称 in ('CSQ_Chinese_Support','CSQ_Train_Support','CSQ_Concur_Support','CSQ_iCustomer_Support','CSQ_ESM_Support','CSQ_Password_Support','CSQ_Travel_Support','CSQ_English_Support','CSQ_eXuehui','CSQ_Taiwan_Support')\n" +
                    "-- and 联系处置=2\n" +
                    "GROUP BY DATEPART(hh, t3.呼叫开始时间)\n" +
                    ") t4 \n" +
                    "on t2.opendateTime =t4.opendate\n"
    })
    public List<slaComplianceSqlServer> selectCallAnswerRate();


    /**
     * 查询 SLA 达标情况-超20秒掉call率
     *
     * @return
     */

    /*@Select({
            "-- SLA 达标情况-超20秒掉call率\n" +
                    "select \n" +
                    "abc.opendateTime as opendateTime1,\n" +
                    "abc.num as Number1,\n" +
                    "qwe.opendateTime2 as opendateTime2,\n" +
                    "qwe.num2 as Number2,\n" +
                    "concat (ROUND(abc.num/qwe.num2*100,2),'%')as jtRate\n" +
                    "from (\n" +
                    "select \n" +
                    "CAST(COUNT (*) as FLOAT) as num ,\n" +
                    "-- SUBSTRING(CONVERT(varchar(100), t1.呼叫开始时间, 20) ,12,2) as opendateTime\\n\" +\n" +
                    "DATEPART(hh, t1.呼叫开始时间) as opendateTime\n" +
                    "from Call t1 \n" +
                    "where DATEDIFF(day, t1.[呼叫开始时间], GETDATE()) =0\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(8),t1.[排队时间],114),114)>= ' 00:00:20'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(8),t1.[通话时间],114),114)=' 00:00:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.[呼叫开始时间],114),114)>='08:30:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.[呼叫开始时间],114),114)<='12:00:00'\n" +
                    "and t1.联系服务队列名称 in ('CSQ_Chinese_Support','CSQ_Train_Support','CSQ_Concur_Support','CSQ_iCustomer_Support','CSQ_ESM_Support','CSQ_Password_Support','CSQ_Travel_Support','CSQ_English_Support','CSQ_eXuehui','CSQ_Taiwan_Support')\n" +
                    "GROUP BY DATEPART(hh, t1.呼叫开始时间)\n" +
                    "UNION ALL\n" +
                    "select \n" +
                    "CAST(COUNT (*) as FLOAT) as num1 ,\n" +
                    "-- SUBSTRING(CONVERT(varchar(100), t1.呼叫开始时间, 20) ,12,2) as opendateTime\\n\" +\n" +
                    "DATEPART(hh, t1.呼叫开始时间) as opendateTime\n" +
                    "from Call t1 \n" +
                    "where DATEDIFF(day, t1.[呼叫开始时间], GETDATE()) =0\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(8),t1.[排队时间],114),114)>= ' 00:00:20'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(8),t1.[通话时间],114),114)=' 00:00:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.[呼叫开始时间],114),114)>='13:00:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t1.[呼叫开始时间],114),114)<='22:00:00'\n" +
                    "and t1.联系服务队列名称 in ('CSQ_Chinese_Support','CSQ_Train_Support','CSQ_Concur_Support','CSQ_iCustomer_Support','CSQ_ESM_Support','CSQ_Password_Support','CSQ_Travel_Support','CSQ_English_Support','CSQ_eXuehui','CSQ_Taiwan_Support')\n" +
                    "GROUP BY DATEPART(hh, t1.呼叫开始时间)\n" +
                    ") abc\n" +
                    "LEFT JOIN \n" +
                    "(\n" +
                    "select  \n" +
                    "CAST(COUNT (*) as FLOAT) as num2,\n" +
                    "DATEPART(hh, t2.[呼叫开始时间]) as opendateTime2\n" +
                    "from Call t2 \n" +
                    "where DATEDIFF(day, t2.[呼叫开始时间], GETDATE()) =0\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t2.[呼叫开始时间],114),114)>='08:30:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t2.[呼叫开始时间],114),114)<='12:00:00'\n" +
                    "and t2.联系服务队列名称 in ('CSQ_Chinese_Support','CSQ_Train_Support','CSQ_Concur_Support','CSQ_iCustomer_Support','CSQ_ESM_Support','CSQ_Password_Support','CSQ_Travel_Support','CSQ_English_Support','CSQ_eXuehui','CSQ_Taiwan_Support')\n" +
                    "GROUP BY DATEPART(hh, t2.[呼叫开始时间])\n" +
                    "UNION ALL\n" +
                    "select  \n" +
                    "CAST(COUNT (*) as FLOAT) as num3,\n" +
                    "DATEPART(hh, t2.[呼叫开始时间]) as opendateTime2\n" +
                    "from Call t2 \n" +
                    "where DATEDIFF(day, t2.[呼叫开始时间], GETDATE()) =0\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t2.[呼叫开始时间],114),114)>='13:00:00'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(20),t2.[呼叫开始时间],114),114)<='22:00:00'\n" +
                    "and t2.联系服务队列名称 in ('CSQ_Chinese_Support','CSQ_Train_Support','CSQ_Concur_Support','CSQ_iCustomer_Support','CSQ_ESM_Support','CSQ_Password_Support','CSQ_Travel_Support','CSQ_English_Support','CSQ_eXuehui','CSQ_Taiwan_Support')\n" +
                    "GROUP BY DATEPART(hh, t2.[呼叫开始时间])\n" +
                    ") qwe\n" +
                    "on abc.opendateTime = qwe.opendateTime2"
    })*/
    @Select({
            "-- SLA 达标情况-超20秒掉call率\n" +
                    "select \n" +
                    "abc.opendateTime as opendateTime1,\n" +
                    "abc.num as Number1,\n" +
                    "qwe.opendateTime2 as opendateTime2,\n" +
                    "qwe.num2 as Number2,\n" +
                    "concat (ROUND(abc.num/qwe.num2*100,2),'%')as jtRate\n" +
                    "from (\n" +
                    "select \n" +
                    "CAST(COUNT (*) as FLOAT) as num ,\n" +
                    "-- SUBSTRING(CONVERT(varchar(100), t1.呼叫开始时间, 20) ,12,2) as opendateTime\\n\" +\n" +
                    "DATEPART(hh, t1.呼叫开始时间) as opendateTime\n" +
                    "from Call t1 \n" +
                    "where DATEDIFF(day, t1.[呼叫开始时间], GETDATE()) =0\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(8),t1.[排队时间],114),114)>= '00:00:20'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(8),t1.[通话时间],114),114)='00:00:00'\n" +
                    "-- and CONVERT ( TIME, CONVERT ( VARCHAR ( 20 ), t1.[呼叫开始时间], 114 ), 114 ) >= '08:30:00'   \n" +
                    "-- AND CONVERT ( TIME, CONVERT ( VARCHAR ( 20 ), t1.[呼叫开始时间], 114 ), 114 ) <= '12:00:00' \n" +
                    "and t1.联系服务队列名称 in ('CSQ_Chinese_Support','CSQ_Train_Support','CSQ_Concur_Support','CSQ_iCustomer_Support','CSQ_ESM_Support','CSQ_Password_Support','CSQ_Travel_Support','CSQ_English_Support','CSQ_eXuehui','CSQ_Taiwan_Support')\n" +
                    "GROUP BY DATEPART(hh, t1.呼叫开始时间)\n" +
                    "-- OR(\n" +
                    "-- CONVERT ( TIME, CONVERT ( VARCHAR ( 20 ), t1.[呼叫开始时间], 114 ), 114 ) >= '13:00:00' \n" +
                    "-- AND CONVERT ( TIME, CONVERT ( VARCHAR ( 20 ), t1.[呼叫开始时间], 114 ), 114 ) <= '22:00:00'\n" +
                    "-- )\n" +
                    "-- \n" +
                    ") abc\n" +
                    "LEFT JOIN \n" +
                    "(\n" +
                    "select  \n" +
                    "CAST(COUNT (*) as FLOAT) as num2,\n" +
                    "DATEPART(hh, t2.[呼叫开始时间]) as opendateTime2\n" +
                    "from Call t2 \n" +
                    "where DATEDIFF(day, t2.[呼叫开始时间], GETDATE()) =0\n" +
                    "and t2.联系服务队列名称 in ('CSQ_Chinese_Support','CSQ_Train_Support','CSQ_Concur_Support','CSQ_iCustomer_Support','CSQ_ESM_Support','CSQ_Password_Support','CSQ_Travel_Support','CSQ_English_Support','CSQ_eXuehui','CSQ_Taiwan_Support')\n" +
                    "GROUP BY DATEPART(hh, t2.[呼叫开始时间])\n" +
                    ") qwe\n" +
                    "on abc.opendateTime = qwe.opendateTime2\n"
    })
    public List<slaComplianceSqlServer> selectCallAnswerRateFallRate();

    /**
     * 查询 SLA 达标率 - L1-电话接听率(（Call Answer Rate (20s)）)
     *
     * @return
     */
    /*@Select({
            "-- SLA 达标情况-20秒内电话接通率\\\\\\\\n\\\\\\\" +\\\\n\\\" +\\n\" +\n" +
                    "select \n" +
                    "t2.opendateTime as opendateTime1,\n" +
                    "t2.Number1 as Number1,\n" +
                    "t4.opendate as opendateTime2,\n" +
                    "t4.Number2 as Number2,\n" +
                    "concat (ROUND(t2.Number1/t4.Number2*100,2),'%')as jtRate\n" +
                    "from (\n" +
                    "select  \n" +
                    "CAST (count(*) as FLOAT) as Number1,\n" +
                    "-- SUBSTRING(CONVERT(varchar(100), t1.呼叫开始时间, 20) ,12,2) as opendateTime\\\\n\\\" +\\n\" +\n" +
                    "DATEPART(hh, t1.呼叫开始时间) as opendateTime\n" +
                    "\n" +
                    "from Call t1\n" +
                    "where DATEDIFF(day, t1.[呼叫开始时间],FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')) =0\n" +
                    "and  convert(Time,CONVERT(nvarchar(8),t1.排队时间,114),114)<='00:00:20'\n" +
                    "and t1.联系服务队列名称 in ('CSQ_Chinese_Support','CSQ_Train_Support','CSQ_Concur_Support','CSQ_iCustomer_Support','CSQ_ESM_Support','CSQ_Password_Support','CSQ_Travel_Support','CSQ_English_Support','CSQ_eXuehui','CSQ_Taiwan_Support')\n" +
                    "and Convert(Time,CONVERT(nvarchar(8),t1.通话时间,114),114)> '00:00:00'\n" +
                    "GROUP BY DATEPART(hh, t1.呼叫开始时间)\n" +
                    ") t2\n" +
                    "LEFT JOIN\n" +
                    "(\n" +
                    "select \n" +
                    "CAST (count(*) as FLOAT) as Number2,\n" +
                    "-- SUBSTRING(CONVERT(varchar(100), 呼叫开始时间, 20) ,12,2) as opendate\\n\" +\n" +
                    "DATEPART(hh, t3.呼叫开始时间) as opendate\n" +
                    "from Call t3\n" +
                    "where DATEDIFF(day, t3.[呼叫开始时间],FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')) =0\n" +
                    "and Convert(Time,CONVERT(nvarchar(8),t3.通话时间,114),114)> '00:00:00'\n" +
                    "and t3.联系服务队列名称 in ('CSQ_Chinese_Support','CSQ_Train_Support','CSQ_Concur_Support','CSQ_iCustomer_Support','CSQ_ESM_Support','CSQ_Password_Support','CSQ_Travel_Support','CSQ_English_Support','CSQ_eXuehui','CSQ_Taiwan_Support')\n" +
                    "-- and 联系处置=2\\n\" +\n" +
                    "GROUP BY DATEPART(hh, t3.呼叫开始时间)\n" +
                    ") t4 \n" +
                    "on t2.opendateTime =t4.opendate"
    })*/
    //查询全部日期
    @Select({
            "-- SLA 达标情况-20秒内电话接通率\n" +
                    "select \n" +
                    "t2.opendateTime as opendateTime1,\n" +
                    "t2.Number1 as Number1,\n" +
                    "t4.opendate as opendateTime2,\n" +
                    "t4.Number2 as Number2,\n" +
                    "concat (ROUND(t2.Number1/t4.Number2*100,2),'%')as jtRate\n" +
                    "from (\n" +
                    "select\n" +
                    "CAST (count(*) as FLOAT) as Number1,\n" +
                    "-- SUBSTRING(CONVERT(varchar(100), t1.呼叫开始时间, 20) ,12,2) as opendateTime\\\\\\\\n\\\\\\\" +\\\\n\\\" +\\n\" +\n" +
                    "SUBSTRING(CONVERT(VARCHAR(100),t1.呼叫开始时间,20),1,13)  as opendateTime\n" +
                    "-- CONVERT(VARCHAR(14),GETDATE(),120) +'05:00' as endTime\n" +
                    "from Call t1\n" +
                    "-- where DATEDIFF(day, t1.[呼叫开始时间],FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')) =0\n" +
                    "where  convert(Time,CONVERT(nvarchar(8),t1.排队时间,114),114)<='00:00:20'\n" +
                    "and t1.联系服务队列名称 in ('CSQ_Chinese_Support','CSQ_Train_Support','CSQ_Concur_Support','CSQ_iCustomer_Support','CSQ_ESM_Support','CSQ_Password_Support','CSQ_Travel_Support','CSQ_English_Support','CSQ_eXuehui','CSQ_Taiwan_Support')\n" +
                    "and Convert(Time,CONVERT(nvarchar(8),t1.通话时间,114),114)> '00:00:00'\n" +
                    "GROUP BY SUBSTRING(CONVERT(VARCHAR(100),t1.呼叫开始时间,20),1,13)\n" +
                    ") t2\n" +
                    "LEFT JOIN\n" +
                    "(\n" +
                    "select \n" +
                    "CAST (count(*) as FLOAT) as Number2,\n" +
                    "-- SUBSTRING(CONVERT(varchar(100), 呼叫开始时间, 20) ,12,2) as opendate\\\\n\\\" +\\n\" +\n" +
                    "SUBSTRING(CONVERT(VARCHAR(100),t3.呼叫开始时间,20),1,13) as opendate\n" +
                    "from Call t3\n" +
                    "-- where DATEDIFF(day, t3.[呼叫开始时间],FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')) =0\n" +
                    "where Convert(Time,CONVERT(nvarchar(8),t3.通话时间,114),114)> '00:00:00'\n" +
                    "and t3.联系服务队列名称 in ('CSQ_Chinese_Support','CSQ_Train_Support','CSQ_Concur_Support','CSQ_iCustomer_Support','CSQ_ESM_Support','CSQ_Password_Support','CSQ_Travel_Support','CSQ_English_Support','CSQ_eXuehui','CSQ_Taiwan_Support')\n" +
                    "-- and 联系处置=2\\\\n\\\" +\\n\" +\n" +
                    "GROUP BY SUBSTRING(CONVERT(VARCHAR(100),t3.呼叫开始时间,20),1,13)\n" +
                    ") t4 \n" +
                    "on t2.opendateTime =t4.opendate"
    })
    public List<Map<String, Object>> selectCallAnswerRate2();


    /**
     * 查询昨天十一点数据
     *
     * @return
     */
    @Select({
            "--  取昨天十一点到零点条件\\n\" +\n" +
                    "-- SLA 达标情况-20秒内电话接通率\\\\\\\\\\\\\\\\n\\\\\\\\\\\\\\\" +\\\\\\\\n\\\\\\\" +\\\\n\\\" +\\n\" +\n" +
                    "select \n" +
                    "t2.opendateTime as opendateTime1,\n" +
                    "t2.Number1 as Number1,\n" +
                    "t4.opendate as opendateTime2,\n" +
                    "t4.Number2 as Number2,\n" +
                    "concat (ROUND(t2.Number1/t4.Number2*100,2),'%')as jtRate\n" +
                    "from (\n" +
                    "select  \n" +
                    "CAST (count(*) as FLOAT) as Number1,\n" +
                    "-- SUBSTRING(CONVERT(varchar(100), t1.呼叫开始时间, 20) ,12,2) as opendateTime\\\\\\\\n\\\\\\\" +\\\\n\\\" +\\n\" +\n" +
                    "DATEPART(hh, t1.呼叫开始时间) as opendateTime\n" +
                    "from Call t1\n" +
                    "where DATEDIFF(day, t1.[呼叫开始时间], FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')) =1\n" +
                    "and CONVERT ( CHAR ( 8 ),t1.[呼叫开始时间], 108 ) >= '23:00:00'\n" +
                    "AND CONVERT ( CHAR ( 8 ), t1.[呼叫开始时间], 108 ) <= '23:59:59'\n" +
                    "and  convert(Time,CONVERT(nvarchar(8),t1.排队时间,114),114)<='00:00:20'\n" +
                    "and t1.联系服务队列名称 in ('CSQ_Chinese_Support','CSQ_Train_Support','CSQ_Concur_Support','CSQ_iCustomer_Support','CSQ_ESM_Support','CSQ_Password_Support','CSQ_Travel_Support','CSQ_English_Support','CSQ_eXuehui','CSQ_Taiwan_Support')\n" +
                    "and Convert(Time,CONVERT(nvarchar(8),t1.通话时间,114),114)> '00:00:00'\n" +
                    "GROUP BY DATEPART(hh, t1.呼叫开始时间)\n" +
                    ") t2\n" +
                    "LEFT JOIN\n" +
                    "(\n" +
                    "select \n" +
                    "CAST (count(*) as FLOAT) as Number2,\n" +
                    "-- SUBSTRING(CONVERT(varchar(100), 呼叫开始时间, 20) ,12,2) as opendate\\\\n\\\" +\\n\" +\n" +
                    "DATEPART(hh, t3.呼叫开始时间) as opendate\n" +
                    "from Call t3\n" +
                    "where DATEDIFF(day, t3.[呼叫开始时间], FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')) =1\n" +
                    "-- where FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')\\n\" +\n" +
                    "and Convert(Time,CONVERT(nvarchar(8),t3.通话时间,114),114)> '00:00:00'\n" +
                    "and CONVERT ( CHAR ( 8 ),t3.[呼叫开始时间], 108 ) >= '23:00:00' \n" +
                    "AND CONVERT ( CHAR ( 8 ), t3.[呼叫开始时间], 108 ) <= '23:59:59' \n" +
                    "and t3.联系服务队列名称 in ('CSQ_Chinese_Support','CSQ_Train_Support','CSQ_Concur_Support','CSQ_iCustomer_Support','CSQ_ESM_Support','CSQ_Password_Support','CSQ_Travel_Support','CSQ_English_Support','CSQ_eXuehui','CSQ_Taiwan_Support')\n" +
                    "-- and 联系处置=2\n" +
                    "GROUP BY DATEPART(hh, t3.呼叫开始时间)\n" +
                    ") t4 \n" +
                    "on t2.opendateTime =t4.opendate"
    })
    public List<Map<String, Object>> selectYesterdayByTime();


    /**
     * 删除当天时间段23:00到零点之间数据
     */
    @Select({
            "delete from sla_compliance where   DATE_FORMAT(time,'%y/%m/%d')  = DATE_FORMAT(SYSDATE()-1,'%y/%m/%d') and OpenDateTimeOne=23"
    })
    public void deleteByTime();


    /**
     * 查询 SLA 达标率 -电话放弃率(Call Abandon Rate (20s))
     *
     * @return
     */
   /* @Select({
            "\n" +
                    "-- SLA 达标情况-超20秒掉call率\\n\" +\n" +
                    "select \n" +
                    "abc.opendateTime as opendateTime1,\n" +
                    "abc.num as Number1,\n" +
                    "qwe.opendateTime2 as opendateTime2,\n" +
                    "qwe.num2 as Number2,\n" +
                    "concat (ROUND(abc.num/qwe.num2*100,2),'%')as jtRate\n" +
                    "from (\n" +
                    "select \n" +
                    "CAST(COUNT (*) as FLOAT) as num ,\n" +
                    "-- SUBSTRING(CONVERT(varchar(100), t1.呼叫开始时间, 20) ,12,2) as opendateTime\\\\n\\\" +\\n\" +\n" +
                    "DATEPART(hh, t1.呼叫开始时间) as opendateTime\n" +
                    "from Call t1 \n" +
                    "where DATEDIFF(day, t1.[呼叫开始时间], FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')) =0\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(8),t1.[排队时间],114),114)>= '00:00:20'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(8),t1.[通话时间],114),114)='00:00:00'\n" +
                    "-- and CONVERT ( TIME, CONVERT ( VARCHAR ( 20 ), t1.[呼叫开始时间], 114 ), 114 ) >= '08:30:00'   \\n\" +\n" +
                    "-- AND CONVERT ( TIME, CONVERT ( VARCHAR ( 20 ), t1.[呼叫开始时间], 114 ), 114 ) <= '12:00:00' \\n\" +\n" +
                    "and t1.联系服务队列名称 in ('CSQ_Chinese_Support','CSQ_Train_Support','CSQ_Concur_Support','CSQ_iCustomer_Support','CSQ_ESM_Support','CSQ_Password_Support','CSQ_Travel_Support','CSQ_English_Support','CSQ_eXuehui','CSQ_Taiwan_Support')\n" +
                    "GROUP BY DATEPART(hh, t1.呼叫开始时间)\n" +
                    "-- OR(\n" +
                    "-- CONVERT ( TIME, CONVERT ( VARCHAR ( 20 ), t1.[呼叫开始时间], 114 ), 114 ) >= '13:00:00' \\n\" +\n" +
                    "-- AND CONVERT ( TIME, CONVERT ( VARCHAR ( 20 ), t1.[呼叫开始时间], 114 ), 114 ) <= '22:00:00'\\n\" +\n" +
                    "-- )\\n\" +\n" +
                    "-- \\n\" +\n" +
                    ") abc\n" +
                    "LEFT JOIN \n" +
                    "(\n" +
                    "select  \n" +
                    "CAST(COUNT (*) as FLOAT) as num2,\n" +
                    "DATEPART(hh, t2.[呼叫开始时间]) as opendateTime2\n" +
                    "from Call t2 \n" +
                    "where DATEDIFF(day, t2.[呼叫开始时间], FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')) =0\n" +
                    "and t2.联系服务队列名称 in ('CSQ_Chinese_Support','CSQ_Train_Support','CSQ_Concur_Support','CSQ_iCustomer_Support','CSQ_ESM_Support','CSQ_Password_Support','CSQ_Travel_Support','CSQ_English_Support','CSQ_eXuehui','CSQ_Taiwan_Support')\n" +
                    "GROUP BY DATEPART(hh, t2.[呼叫开始时间])\n" +
                    ") qwe\n" +
                    "on abc.opendateTime = qwe.opendateTime2\n"
    })*/
    // 查询历史数据
    @Select({
            "\n" +
                    "-- SLA 达标情况-超20秒掉call率\n" +
                    "select\n" +
                    "abc.opendateTime as opendateTime1,\n" +
                    "abc.num as Number1,\n" +
                    "qwe.opendateTime2 as opendateTime2,\n" +
                    "qwe.num2 as Number2,\n" +
                    "concat (ROUND(abc.num/qwe.num2*100,2),'%')as jtRate\n" +
                    "from (\n" +
                    "select \n" +
                    "CAST(COUNT (*) as FLOAT) as num ,\n" +
                    "-- SUBSTRING(CONVERT(varchar(100), t1.呼叫开始时间, 20) ,12,2) as opendateTime\\\\\\\\n\\\\\\\" +\\\\n\\\" +\\n\" +\n" +
                    "SUBSTRING(CONVERT(VARCHAR(100),t1.呼叫开始时间,20),1,13) as opendateTime\n" +
                    "from Call t1 \n" +
                    "-- where DATEDIFF(day, t1.[呼叫开始时间], FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')) =0\n" +
                    "where CONVERT(TIME,CONVERT(VARCHAR(8),t1.[排队时间],114),114)>= '00:00:20'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(8),t1.[通话时间],114),114)='00:00:00'\n" +
                    "-- and CONVERT ( TIME, CONVERT ( VARCHAR ( 20 ), t1.[呼叫开始时间], 114 ), 114 ) >= '08:30:00'   \\\\n\\\" +\\n\" +\n" +
                    "-- AND CONVERT ( TIME, CONVERT ( VARCHAR ( 20 ), t1.[呼叫开始时间], 114 ), 114 ) <= '12:00:00' \\\\n\\\" +\\n\" +\n" +
                    "and t1.联系服务队列名称 in ('CSQ_Chinese_Support','CSQ_Train_Support','CSQ_Concur_Support','CSQ_iCustomer_Support','CSQ_ESM_Support','CSQ_Password_Support','CSQ_Travel_Support','CSQ_English_Support','CSQ_eXuehui','CSQ_Taiwan_Support')\n" +
                    "GROUP BY SUBSTRING(CONVERT(VARCHAR(100),t1.呼叫开始时间,20),1,13)\n" +
                    "-- OR(\\n\" +\n" +
                    "-- CONVERT ( TIME, CONVERT ( VARCHAR ( 20 ), t1.[呼叫开始时间], 114 ), 114 ) >= '13:00:00' \\\\n\\\" +\\n\" +\n" +
                    "-- AND CONVERT ( TIME, CONVERT ( VARCHAR ( 20 ), t1.[呼叫开始时间], 114 ), 114 ) <= '22:00:00'\\\\n\\\" +\\n\" +\n" +
                    "-- )\\\\n\\\" +\\n\" +\n" +
                    "-- \\\\n\\\" +\\n\" +\n" +
                    ") abc\n" +
                    "LEFT JOIN\n" +
                    "(\n" +
                    "select  \n" +
                    "CAST(COUNT (*) as FLOAT) as num2,\n" +
                    "SUBSTRING(CONVERT(VARCHAR(100),t2.呼叫开始时间,20),1,13) as opendateTime2\n" +
                    "from Call t2 \n" +
                    "-- where DATEDIFF(day, t2.[呼叫开始时间], FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')) =0\n" +
                    "where t2.联系服务队列名称 in ('CSQ_Chinese_Support','CSQ_Train_Support','CSQ_Concur_Support','CSQ_iCustomer_Support','CSQ_ESM_Support','CSQ_Password_Support','CSQ_Travel_Support','CSQ_English_Support','CSQ_eXuehui','CSQ_Taiwan_Support')\n" +
                    "GROUP BY SUBSTRING(CONVERT(VARCHAR(100),t2.呼叫开始时间,20),1,13)\n" +
                    ") qwe\n" +
                    "on abc.opendateTime = qwe.opendateTime2"
    })
    public List<Map<String, Object>> selectCallAnswerRateFallRate2();

    /**
     * 查询 SLA 达标情况-超20秒掉call率-昨天23:00至零点
     *
     * @return
     */
    @Select({
            "-- SLA 达标情况-超20秒掉call率 \n" +
                    "-- 昨天23点至零点\\n\" +\n" +
                    "select \n" +
                    "abc.opendateTime as opendateTime1,\n" +
                    "abc.num as Number1,\n" +
                    "qwe.opendateTime2 as opendateTime2,\n" +
                    "qwe.num2 as Number2,\n" +
                    "concat (ROUND(abc.num/qwe.num2*100,2),'%')as jtRate\n" +
                    "from (\n" +
                    "select \n" +
                    "CAST(COUNT (*) as FLOAT) as num ,\n" +
                    "-- SUBSTRING(CONVERT(varchar(100), t1.呼叫开始时间, 20) ,12,2) as opendateTime\\\\n\\\" +\\n\" +\n" +
                    "DATEPART(hh, t1.呼叫开始时间) as opendateTime\n" +
                    "from Call t1 \n" +
                    "where DATEDIFF(day, t1.[呼叫开始时间], FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')) =1\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(8),t1.[排队时间],114),114)>= '00:00:20'\n" +
                    "and CONVERT(TIME,CONVERT(VARCHAR(8),t1.[通话时间],114),114)='00:00:00'\n" +
                    "and CONVERT ( TIME, CONVERT ( VARCHAR ( 20 ), t1.[呼叫开始时间], 114 ), 114 ) >= '23:00:00'   \n" +
                    "AND CONVERT ( TIME, CONVERT ( VARCHAR ( 20 ), t1.[呼叫开始时间], 114 ), 114 ) <= '23:59:59' \n" +
                    "and t1.联系服务队列名称 in ('CSQ_Chinese_Support','CSQ_Train_Support','CSQ_Concur_Support','CSQ_iCustomer_Support','CSQ_ESM_Support','CSQ_Password_Support','CSQ_Travel_Support','CSQ_English_Support','CSQ_eXuehui','CSQ_Taiwan_Support')\n" +
                    "GROUP BY DATEPART(hh, t1.呼叫开始时间)\n" +
                    "-- OR(\n" +
                    "-- CONVERT ( TIME, CONVERT ( VARCHAR ( 20 ), t1.[呼叫开始时间], 114 ), 114 ) >= '13:00:00' \\n\" +\n" +
                    "-- AND CONVERT ( TIME, CONVERT ( VARCHAR ( 20 ), t1.[呼叫开始时间], 114 ), 114 ) <= '22:00:00'\\n\" +\n" +
                    "-- )\\n\" +\n" +
                    "-- \\n\" +\n" +
                    ") abc\n" +
                    "LEFT JOIN \n" +
                    "(\n" +
                    "select  \n" +
                    "CAST(COUNT (*) as FLOAT) as num2,\n" +
                    "DATEPART(hh, t2.[呼叫开始时间]) as opendateTime2\n" +
                    "from Call t2 \n" +
                    "where DATEDIFF(day, t2.[呼叫开始时间], FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')) =1\n" +
                    "and t2.联系服务队列名称 in ('CSQ_Chinese_Support','CSQ_Train_Support','CSQ_Concur_Support','CSQ_iCustomer_Support','CSQ_ESM_Support','CSQ_Password_Support','CSQ_Travel_Support','CSQ_English_Support','CSQ_eXuehui','CSQ_Taiwan_Support')\n" +
                    " and CONVERT ( TIME, CONVERT ( VARCHAR ( 20 ), t2.[呼叫开始时间], 114 ), 114 ) >= '23:00:00'   \n" +
                    " AND CONVERT ( TIME, CONVERT ( VARCHAR ( 20 ), t2.[呼叫开始时间], 114 ), 114 ) <= '23:59:59'\n" +
                    "GROUP BY DATEPART(hh, t2.[呼叫开始时间])\n" +
                    ") qwe\n" +
                    "on abc.opendateTime = qwe.opendateTime2"
    })
    public List<Map<String, Object>> selectCallAnswerRateFallRate2ByTime();


    /**
     * 删除当天时间段23:00到零点之间数据
     */
    @Select({
            "delete from sla_compliance where   DATE_FORMAT(time,'%y/%m/%d')  = DATE_FORMAT(SYSDATE()-1,'%y/%m/%d') and OpenDateTimeFallOne=23"
    })
    public void deleteFallRate2ByTime();


}
