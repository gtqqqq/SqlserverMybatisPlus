package com.xkcoding.multi.datasource.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xkcoding.multi.datasource.mybatis.model.Call;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

public interface CallMapper extends BaseMapper<Call> {


    /***
     *查询 L1累计电话接入
     * 表中暂时没有当前时间 ，暂时取昨天
     */
    @Select("select \n" +
            "COUNT(*) as num\n" +
            "from Call c \n" +
            "where c.[呼叫开始时间] >= CONVERT(VARCHAR(10),GETDATE()-2,120)+ ' 00:00:00'\n" +
            "and c.[呼叫开始时间] <CONVERT(VARCHAR(10),GETDATE()+1,120)+ ' 00:00:00'")
    public List<Object> selectPhoneAll();


    /**
     * 查询 L1累计电话接入累计响应
     * 表中暂时没有当前时间 ，暂时取昨天
     */
    // @Select("select COUNT(*) from Call t1 where t1.[联系处置] =#{code} ")
    @Select("select \n" +
            "COUNT(*) as starTtime \n" +
            "from Call t1 \n" +
            "where t1.[呼叫开始时间]> = convert(varchar(10), getdate()-2, 120)+' 00:00:00'\n" +
            "and t1.[呼叫开始时间] < convert(varchar(10), getdate()+1, 120)+' 00:00:00'\n" +
            "and t1.[联系处置] =2 ")
    public List<HashMap> selectCallByCode(@Param("code") String code);


    /**
     * 查询 L1累计电话接入累计解决
     *
     * @param code
     * @return
     */
   /* select
    COUNT(t1.呼叫开始时间) as solveNum
    from Call t1
    where t1.呼叫开始时间>DATEADD(hh," & t & ",'" & ActiveSheet.Range("Y1") & "')
    and 呼叫开始时间<=DATEADD(hh," & t + 1 & ",'" & ActiveSheet.Range("Y1") & "')
    and t1.[联系处置] = 1
    and Convert(Time,CONVERT(nvarchar(8),排队时间,114),114)<='00:00:20'*/
    @Select("select \n" +
            "COUNT(*) as starTtime\n" +
            "from Call t1 \n" +
            "where t1.[呼叫开始时间]> = convert(varchar(10), getdate()-2, 120)+' 00:00:00'\n" +
            "and t1.[呼叫开始时间] < convert(varchar(10), getdate()+1, 120)+' 00:00:00'\n" +
            "and t1.[联系处置] =2 and convert(Time,CONVERT(nvarchar(8),排队时间,114),114)<='00:00:20'")
    public List<Object> selectCallSolveByCode(String code);

    /***
     *查询 L1累计工单派出
     * 需求暂时 没有，暂写预留接口
     */
    @Select("select \n" +
            "COUNT(*) as Number\n" +
            "from Incident t1 \n" +
            "LEFT JOIN (select * from Request ) t2 on t1.Number =t2.Number\n" +
            "LEFT JOIN (select * from NewCall) t3 on t1.Number = t3.Number\n" +
            "where t1.Opened >=CONVERT(VARCHAR(10),GETDATE(),120)+ ' 00:00:00' \n" +
            "and t1.Opened < CONVERT(VARCHAR(10),GETDATE()+1,120) + ' 00:00:00' \n" +
            "and t1.[Business Service] is not null \n" +
            "and t1.[Assignment Group] not in ('AZ China Shanghai Service Desk','AZ ESM Level 1 Support','AZ Asiapac IT Service Desk','AZ Dalian Desk to Desk Support')")
    public List<Object> selectWorkOrder();


    /***
     *查询 L1累计累计响应
     */
    @Select("select \n" +
            "COUNT(*) as Number\n" +
            "--  t1.[Business Service] as [Business Service],\n" +
            "--  t1.Opened as star\n" +
            "from Incident t1 \n" +
            "LEFT JOIN (select * from Request) t2 on t1.Number = t2.Number\n" +
            "LEFT JOIN (select * from NewCall) t3 on t3.Number =t1.Number\n" +
            "where t1.[Business Service] is  not  null\n" +
            "and t1.Opened >=CONVERT(VARCHAR(10),GETDATE(),120)+' 00:00:00'\n" +
            "and t1.Opened <CONVERT(VARCHAR(10),GETDATE()+1,120)+' 00:00:00'\n" +
            "-- GROUP BY t1.[Business Service],t1.Opened \n" +
            "-- ORDER BY t1.Opened desc\n")
    public List<Object> selectWorkOrderResp();

    /***
     *查询 L1累计解决
     */
    @Select("select \n" +
            "COUNT(*) as Number\n" +
            "from Incident t1 \n" +
            "LEFT JOIN (select * from Request ) t2 on t1.Number =t2.Number\n" +
            "LEFT JOIN (select * from NewCall) t3 on t1.Number = t3.Number\n" +
            "where t1.Opened >=CONVERT(VARCHAR(10),GETDATE(),120)+ ' 00:00:00' \n" +
            "and t1.Opened < CONVERT(VARCHAR(10),GETDATE()+1,120) + ' 00:00:00' \n" +
            "and t1.[Business Service] is not null \n" +
            "and t1.[Assignment Group] in ('AZ China Shanghai Service Desk','AZ ESM Level 1 Support','AZ Asiapac IT Service Desk','AZ Dalian Desk to Desk Support')")
    public List<Object> selectWorkOrderSolveSum();

}
