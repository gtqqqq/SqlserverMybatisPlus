package com.xkcoding.multi.datasource.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xkcoding.multi.datasource.mybatis.model.SlaComplianceBySpecificDate;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author smf
 * @Description: 20秒内 电话接通率，以及超20秒电话放弃率持久层
 * @date 2020/8/199:59
 */
public interface SlaComplianceBySpecificDateMapper extends BaseMapper<SlaComplianceBySpecificDate> {


    /**
     * 录入 SlaComplianceBySpecificDate
     *
     * @param specificDateList
     * @return
     */
    @Insert({
            "<script>",
            "insert into sla_compliance_by_specific_date(time, twentySecondsWithinMoleculeDate,twentySecondsWithinMoleculeNum,twentySecondsWithinDenominatorDate,twentySecondsWithinDenominatorNum,twentySecondsWithinRate,twentySecondsLaterMoleculeDate,twentySecondsLaterMoleculeNum,twentySecondsLaterDenominatorDate,twentySecondsLaterDenominatorNum,twentySecondsLaterRate,EndTime) values ",
            "<foreach collection='specificDateList' item='item' index='index' separator=','>",
            "( #{item.time}, #{item.twentySecondsWithinMoleculeDate},#{item.twentySecondsWithinMoleculeNum},#{item.twentySecondsWithinDenominatorDate},#{item.twentySecondsWithinDenominatorNum},#{item.twentySecondsWithinRate},#{item.twentySecondsLaterMoleculeDate},#{item.twentySecondsLaterMoleculeNum},#{item.twentySecondsLaterDenominatorDate},#{item.twentySecondsLaterDenominatorNum},#{item.twentySecondsLaterRate},#{item.EndTime})",
            "</foreach>",
            "</script>"
    })
    Boolean insertSlaComplianceBySpecificDate(@Param("specificDateList") List<SlaComplianceBySpecificDate> specificDateList);

    /**
     * 清表
     */
    @Delete({
            "<script>",
            "delete from sla_compliance_by_specific_date",
            "</script>"
    })
    void deleteSlaComplianceBySpecificDate();

    /**
     * 查询20s 电话接通率by年月日小时
     *
     * @return
     */
    @Select({
            "-- SLA 达标情况-20秒内电话接通率\n" +
                    "select \n" +
                    "t2.opendateTime as opendateTime1,\n" +
                    "t2.Number1 as Number1,\n" +
                    "t4.opendate as opendateTime2,\n" +
                    "t4.Number2 as Number2,\n" +
                    "concat (ROUND(CAST(t2.Number1 as FLOAT )/CAST( t4.Number2 as FLOAT)*100,2 ),'%')as jtRate\n" +
                    "from (\n" +
                    "select\n" +
                    "SUBSTRING(CONVERT(VARCHAR(100),t1.呼叫开始时间,20),1,13) as opendateTime,\n" +
                    "count(*)  as Number1\n" +
                    "-- SUBSTRING(CONVERT(varchar(100), t1.呼叫开始时间, 20) ,12,2) as opendateTime\n" +
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
                    "SUBSTRING(CONVERT(VARCHAR(100),t3.呼叫开始时间,20),1,13) as opendate,\n" +
                    "count(*) as Number2\n" +
                    "-- SUBSTRING(CONVERT(varchar(100), 呼叫开始时间, 20) ,12,2) as opendate\\\\n\\\" +\\n\" +\n" +
                    "from Call t3\n" +
                    "-- where DATEDIFF(day, t3.[呼叫开始时间],FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')) =0\n" +
                    "where Convert(Time,CONVERT(nvarchar(8),t3.通话时间,114),114)> '00:00:00'\n" +
                    "and t3.联系服务队列名称 in ('CSQ_Chinese_Support','CSQ_Train_Support','CSQ_Concur_Support','CSQ_iCustomer_Support','CSQ_ESM_Support','CSQ_Password_Support','CSQ_Travel_Support','CSQ_English_Support','CSQ_eXuehui','CSQ_Taiwan_Support')\n" +
                    "-- and 联系处置=2\\\\n\\\" +\\n\" +\n" +
                    "GROUP BY SUBSTRING(CONVERT(VARCHAR(100),t3.呼叫开始时间,20),1,13)\n" +
                    ") t4 \n" +
                    "on t2.opendateTime =t4.opendate"
    })
    List<Map<String, Object>> selectSlaComplianceBySpecificDate();


}
