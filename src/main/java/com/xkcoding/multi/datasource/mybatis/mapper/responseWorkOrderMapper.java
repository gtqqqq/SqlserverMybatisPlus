package com.xkcoding.multi.datasource.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xkcoding.multi.datasource.mybatis.model.responseCall;
import com.xkcoding.multi.datasource.mybatis.model.responseWorkOrder;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: smf
 * @time: 7/4/2020 5:24 PM
 * @description: L1累计工单派出 服务
 */
public interface responseWorkOrderMapper extends BaseMapper<responseWorkOrder> {

    /**
     * 录入 L1累计工单派出
     *
     * @param orderList
     * @return
     */
    @Insert({
            "<script>",
            "insert into response_work_order(time, workordersum,respsum,solvesum) values ",
            "<foreach collection='orderList' item='item' index='index' separator=','>",
            "( #{item.time}, #{item.workOrderSum},#{item.respSum},#{item.solveSum})",
            "</foreach>",
            "</script>"
    })
    public Boolean insertResponseWorkOrder(@Param("orderList") List<responseWorkOrder> orderList);

    /***
     * 清L1累计工单派出表
     */
    @Delete({
            "<script>",
            "delete from response_work_order",
            "</script>"
    })
    public void deleteResponseCall();

    /**
     * 查询L1累计工单派出-累计响应ByIncident
     *
     * @return
     */
    /*@Select({    //TODO  此条件按照需求文档图片
            "select \n" +
                    "COUNT(*) as Number\n" +
                    "from Incident_Test t1 \n" +
                    "where DATEDIFF(month, t1.Opened, GETDATE())=1\n" +
                    "and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "and t1.[Business Service] is not  null and t1.[Business Service] !='' "
    })*/
    @Select({
            "select \n" +
                    "COUNT(*) as Number\n" +
                    "from Incident_Test t1 \n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    "and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "and t1.[Business Service] is not  null and t1.[Business Service] !=''"
    })
    public Integer selectResponseOrderByIncident();


    /**
     * 查询L1累计工单派出-累计响应ByRequest
     *
     * @return
     */
    /*@Select({
            "SELECT \n" +
                    "COUNT(*) AS Number\n" +
                    "from Request t2\n" +
                    "where t2.Opened >= CONVERT(VARCHAR(10),GETDATE(),120) + ' 00:00:00'\n" +
                    "and t2.Opened < CONVERT(VARCHAR(10),GETDATE()+1,120) + ' 00:00:00'\n" +
                    "and t2.[Business Service] is not null and t2.[Business Service] !=''\n" +
                    "and t2.[Assignment Group] in (select * from L1_AssignmentGroup)"
    })*/
    /*@Select({   //TODO  此条件按照需求文档图片
            "select \n" +
                    "COUNT(*) as Number\n" +
                    "from Request_Test t1\n" +
                    "where DATEDIFF(week, t1.Opened, GETDATE())=1\n" +
                    "and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "and t1.[Business Service] is not  null and t1.[Business Service] !='' "
    })*/
    @Select({
            "select \n" +
                    "COUNT(*) as Number\n" +
                    "from Request_Test t1\n" +
                    "where DATEDIFF(DAY, t1.Opened, GETDATE())=0\n" +
                    "and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "and t1.[Business Service] is not  null and t1.[Business Service] !='' "
    })
    public Integer selectResponseOrderByRequest();

    /**
     * 查询L1累计工单派出-累计响应ByNewCall
     *
     * @return
     */
   /* @Select({   //TODO  此条件按照需求文档图片
            "select \n" +
                    "COUNT(*) as Number\n" +
                    "from NewCall_Test t1\n" +
                    "where DATEDIFF(week, t1.Opened, GETDATE()) =1\n" +
                    "-- and t1.[Call type] not in ('Hang Up','Status Call','Wrong Number')\n" +
                    "and t1.[Business Service] is not  null and t1.[Business Service] !='' "
    })*/
    @Select({
            "select \n" +
                    "COUNT(*) as Number\n" +
                    "from NewCall_Test t1\n" +
                    "where DATEDIFF(DAY, t1.Opened, GETDATE()) =0\n" +
                    "and t1.[Business Service] is not  null \n" +
                    "and t1.[Business Service] !=''\n" +
                    "and t1.[Assignment Group] in (select * from L1_AssignmentGroup)"
    })
    public Integer selectResponseOrderByNewCall();


    /**
     * 查询L1累计工单派出-累计解决ByIncident
     *
     * @return
     */
    /*@Select({   //TODO 此条件按照需求文档图片
            "select  \n" +
                    "COUNT(*) as Number\n" +
                    "from Incident_Test t1 \n" +
                    "where DATEDIFF(month, t1.Opened, GETDATE())=1\n" +
                    "and t1.[Assignment Group] in (select * from L1_AssignmentGroup )\n" +
                    "and t1.[Business Service] is not null \n" +
                    "and t1.[Business Service] !=''"
    })*/
    @Select({
            "select  \n" +
                    " COUNT(*) as Number\n" +
                    " from Incident_Test t1 \n" +
                    " where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    " and t1.[Assignment Group] in (select * from L1_AssignmentGroup )\n" +
                    " and t1.[Business Service] is not null \n" +
                    " and t1.[Business Service] !=''"
    })
    public Integer selectResponseOrderSolveByIncident();


    /**
     * 查询L1累计工单派出-累计解决ByRequest
     *
     * @return
     */
    /*@Select({  //TODO 此条件按照需求文档图片
            "select \n" +
                    "COUNT(*) as Number\n" +
                    "from Request_Test t1 \n" +
                    "where DATEDIFF(week, t1.Opened, GETDATE())=1\n" +
                    "and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "and t1.[Business Service] is not null \n" +
                    "and t1.[Business Service] !=''"
    })*/
    @Select({
            "select \n" +
                    "COUNT(*) as Number\n" +
                    "from Request_Test t1 \n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    "and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "and t1.[Business Service] is not null \n" +
                    "and t1.[Business Service] !=''"
    })
    public Integer selectResponseOrderSolveByRequest();


    /**
     * 查询L1累计工单派出-累计解决ByNewCall
     *
     * @return
     */
   /* @Select({
            "select \n" +
                    "COUNT(*) as Number\n" +
                    "from NewCall t1 \n" +
                    "where t1.Opened >=CONVERT(VARCHAR(10),GETDATE(),120)+ ' 00:00:00' \n" +
                    "and t1.Opened < CONVERT(VARCHAR(10),GETDATE()+1,120) + ' 00:00:00'\n" +
                    "and t1.[Business Service] is not null and t1.[Business Service] !=''\n" +
                    "and t1.[Assignment Group] in (select * from L1_AssignmentGroup)"
    })*/
   /* @Select({    //TODO 此条件按照需求文档图片
            "select \n" +
                    "COUNT(*) as Number\n" +
                    "from NewCall_Test t1 \n" +
                    "where DATEDIFF(week, t1.Opened, GETDATE())=1\n" +
                    "-- and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "and t1.[Business Service] is not null \n" +
                    "and t1.[Business Service] !=''"
    })*/
    @Select({
            "select \n" +
                    "COUNT(*) as Number\n" +
                    "from NewCall_Test t1\n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    "and t1.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "and t1.[Business Service] is not null \n" +
                    "and t1.[Business Service] !=''"
    })
    public Integer selectResponseOrderSolveByNewCall();


}
