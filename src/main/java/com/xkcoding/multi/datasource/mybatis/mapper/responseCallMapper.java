package com.xkcoding.multi.datasource.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xkcoding.multi.datasource.mybatis.model.User;
import com.xkcoding.multi.datasource.mybatis.model.responseCall;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: smf
 * @description: L1累计电话接入 服务 数据层
 */
public interface responseCallMapper extends BaseMapper<responseCall> {

    /**
     * 录入 L1累计电话接入
     *
     * @param responseCallsList
     * @return
     */
    @Insert({
            "<script>",
            "insert into response_call(time, callsum,respsum,solvesum) values ",
            "<foreach collection='responseCallsList' item='item' index='index' separator=','>",
            "( #{item.time}, #{item.callSum},#{item.respSum},#{item.solveSum})",
            "</foreach>",
            "</script>"
    })
    public Boolean insertResponseCall(@Param("responseCallsList") List<responseCall> responseCallsList);

    /***
     * 清call表
     */
    @Delete({
            "<script>",
            "delete from response_call",
            "</script>"
    })
    public void deleteResponseCall();


    /**
     * L1累计电话接入
     *
     * @return
     */
   /* @Select({
            "select \n" +
                    "COUNT(*) as num\n" +
                    "from Call c \n" +
                    "where c.[呼叫开始时间] >= CONVERT(VARCHAR(10),GETDATE()-1,120)+ ' 00:00:00'\n" +
                    "and c.[呼叫开始时间] <CONVERT(VARCHAR(10),GETDATE()+1,120)+ ' 00:00:00'"
    })*/
    @Select({
            "select \n" +
                    "COUNT(*) as NUmber\n" +
                    "from Call_Test  t1\n" +
                    "where DATEDIFF(day, t1.[呼叫开始时间], GETDATE())=0"
    })
    public Integer selectResponseCall();

    /**
     * L1累计电话接入-累计响应
     *
     * @return
     */
    /*@Select({
            "select \n" +
                    "COUNT(*) as starTtime \n" +
                    "from Call t1 \n" +
                    "where t1.[呼叫开始时间]> = convert(varchar(10), getdate()-1, 120)+' 00:00:00'\n" +
                    "and t1.[呼叫开始时间] < convert(varchar(10), getdate()+1, 120)+' 00:00:00'\n" +
                    "and t1.[联系处置] =2 "
    })*/
    @Select({
            "select \n" +
                    "COUNT(*) as NUmber\n" +
                    "from Call_Test  t1\n" +
                    "where DATEDIFF(day, t1.[呼叫开始时间], GETDATE())=0\n" +
                    "and t1.[联系处置] =2 \n"
    })
    public Integer selectByResponseCall();


    /**
     * L1累计电话接入-累计解决
     *
     * @return
     */
   /* @Select({
            "select \n" +
                    "COUNT(*) as starTtime\n" +
                    "from Call t1 \n" +
                    "where t1.[呼叫开始时间]> = convert(varchar(10), getdate()-1, 120)+' 00:00:00'\n" +
                    "and t1.[呼叫开始时间] < convert(varchar(10), getdate()+1, 120)+' 00:00:00'\n" +
                    "and t1.[联系处置] =2 and convert(Time,CONVERT(nvarchar(8),排队时间,114),114)<='00:00:20'"
    })*/
    @Select({
            "select \n" +
                    "COUNT(*) as NUmber\n" +
                    "from Call_Test  t1\n" +
                    "where DATEDIFF(day, t1.[呼叫开始时间], GETDATE())=0\n" +
                    "and convert(Time,CONVERT(nvarchar(8),排队时间,114),114)>='00:00:20'\n" +
                    "and t1.[联系处置] =1"
    })
    public Integer selectBySoleResponseCall();


}
