package com.xkcoding.multi.datasource.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xkcoding.multi.datasource.mybatis.model.EmailResponseRate;
import com.xkcoding.multi.datasource.mybatis.model.slaCompliance;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author smf
 * @Description: 邮件响应率以及snow接单率持久层
 * @date 2020/8/14
 */
public interface EmailResponseRateMapper extends BaseMapper<EmailResponseRate> {


    /**
     * 录入邮件响应率 以及snow接单率
     *
     * @return
     */
    @Insert({
            "<script>",
            "insert into email_response_rate_Test(time, Mail_Resp_Rate_Molecule_Hour,Mail_Resp_Rate_Molecule_Number,Mail_Resp_Rate_Denominator_Hour,Mail_Resp_Rate_Denominator_Number,Snow_order_rate_Molecule_Hour,Snow_order_rate_Molecule_Number,Snow_order_rate_Denominator_Hour,Snow_order_rate_Denominator_Number,EndTime) values ",
            "<foreach collection='emailResponseRateList' item='item' index='index' separator=','>",
            "( #{item.time}, #{item.MailRespRateMoleculeHour},#{item.MailRespRateMoleculeNumber},#{item.MailRespRateDenominatorHour},#{item.MailRespRateDenominatorNumber},#{item.SnowOrderRateMoleculeHour},#{item.SnowOrderRateMoleculeNumber},#{item.SnowOrderRateDenominatorHour},#{item.SnowOrderRateDenominatorNumber},#{item.EndTime})",
            "</foreach>",
            "</script>"
    })
    Boolean insertEmailResponseRateByList(@Param("emailResponseRateList") List<EmailResponseRate> emailResponseRateList);

    /**
     * 清表
     */
    @Delete({
            "delete from email_response_rate_Test"
    })
    void deleteEmailResponseRate();

    /**
     * 查询 邮件响应率
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
                    "concat (ROUND(t2.Number1/t4.Number2*100,2),'%')as jtRate\n" +
                    "from (\n" +
                    "select\n" +
                    "CAST (count(*) as FLOAT) as Number1,\n" +
                    "-- SUBSTRING(CONVERT(varchar(100), t1.呼叫开始时间, 20) ,12,2) as opendateTime\\\\\\\\n\\\\\\\" +\\\\n\\\" +\\n\" +\n" +
                    "DATEPART(hh, t1.呼叫开始时间) as opendateTime\n" +
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
                    "-- SUBSTRING(CONVERT(varchar(100), 呼叫开始时间, 20) ,12,2) as opendate\\\\n\\\" +\\n\" +\n" +
                    "DATEPART(hh, t3.呼叫开始时间) as opendate\n" +
                    "from Call t3\n" +
                    "where DATEDIFF(day, t3.[呼叫开始时间],FORMAT (getdate(), 'yyyy-MM-dd HH:00:00')) =0\n" +
                    "and Convert(Time,CONVERT(nvarchar(8),t3.通话时间,114),114)> '00:00:00'\n" +
                    "and t3.联系服务队列名称 in ('CSQ_Chinese_Support','CSQ_Train_Support','CSQ_Concur_Support','CSQ_iCustomer_Support','CSQ_ESM_Support','CSQ_Password_Support','CSQ_Travel_Support','CSQ_English_Support','CSQ_eXuehui','CSQ_Taiwan_Support')\n" +
                    "-- and 联系处置=2\\\\n\\\" +\\n\" +\n" +
                    "GROUP BY DATEPART(hh, t3.呼叫开始时间)\n" +
                    ") t4 \n" +
                    "on t2.opendateTime =t4.opendate"
    })
    List<Map<String, Object>> selectEmailResponseRate();


}
