package com.xkcoding.multi.datasource.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xkcoding.multi.datasource.mybatis.model.businessVolume;
import com.xkcoding.multi.datasource.mybatis.model.responseCall;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @description: 数据层
 * @author: smf
 * @time: 7/6/2020
 */
public interface businessVolumeMapper extends BaseMapper<businessVolume> {

    /***
     * 录入 Business Volume
     */
    @Insert({
            "<script>",
            "insert into business_volume(time, EscalatedTickets,ClosedTickets,PendingTickets,WaitingTickets) values ",
            "<foreach collection='businessVolumeList' item='item' index='index' separator=','>",
            "( #{item.time}, #{item.EscalatedTickets},#{item.ClosedTickets},#{item.PendingTickets},#{item.WaitingTickets})",
            "</foreach>",
            "</script>"
    })
    public Boolean insertBusinessVolumeList(@Param("businessVolumeList") List<businessVolume> businessVolumeList);


    /***
     * 清business_volume表
     */
    @Delete({
            "<script>",
            "delete from business_volume",
            "</script>"
    })
    public void deleteBusinessVolume();


    /**
     * 查询公告板Business Volume Closed Tickets关闭的工单数ByIncident
     *
     * @return
     */
    @Select({
            "select \n" +
                    " COUNT(*) as num \n" +
                    " from Incident_Test t1 \n" +
                    " where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    " and t1.[Assignment Group] in (select *from L1_AssignmentGroup)\n" +
                    "and t1.[Business Service] is null  OR t1.[Business Service] =''"
    })
    public List<Integer> selectClosedTicketsByIncident();


    /**
     * 查询公告板Business Volume Closed Tickets关闭的工单数ByRequest
     *
     * @return
     */
    @Select({
            "select  \n" +
                    "COUNT(*) as num\n" +
                    "from Request_Test t1 \n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    "and t1.[Assignment Group] in (select *from L1_AssignmentGroup)\n" +
                    "and t1.[Business Service] is NULL\n" +
                    "or  t1.[Business Service] =''"
    })
    public List<Integer> selectClosedTicketsByRequest();


    /**
     * 查询公告板Business Volume Closed Tickets关闭的工单数ByNewCall
     *
     * @return
     */
    @Select({
            "select  \n" +
                    "COUNT(*) as num\n" +
                    "from NewCall_Test t1 \n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    "and t1.[Assignment Group] in (select *from L1_AssignmentGroup)\n" +
                    "and t1.[Business Service] is NULL\n" +
                    "or  t1.[Business Service] =''"
    })
    public List<Integer> selectClosedTicketsByNewCall();


    /**
     * 查询公告板Business Volume Pending Tickets L1未关闭的工单数ByIncident
     *
     * @return
     */
   /* @Select({
            "select \n" +
                    "COUNT(*) as Number\n" +
                    "from Incident t2 \n" +
                    "where t2.Opened >=CONVERT(VARCHAR(10),GETDATE(),120)+ ' 00:00:00' \n" +
                    "and t2.Opened < CONVERT(VARCHAR(10),GETDATE()+1,120) + ' 00:00:00' \n" +
                    "and t2.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "-- and t2.[Business Service] is null and t2.[Business Service] !=''\n" +
                    "and t2.State not in ('Closed','Resolved','Complete')"
    })*/
    @Select({
            "select \n" +
                    "COUNT(*) as num \n" +
                    "from Incident_Test t1 \t\n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    "and t1.[Assignment Group] in (select *from L1_AssignmentGroup)\n" +
                    "and t1.State not in ('Closed','Resolved','Complete')"
    })
    public List<Integer> selectPendingTicketsByIncident();


    /**
     * 查询公告板Business Volume Pending Tickets L1未关闭的工单数ByRequest
     *
     * @return
     */
   /* @Select({
            "select \n" +
                    "COUNT(*) as Number\n" +
                    "from Request t2 \n" +
                    "where t2.Opened >=CONVERT(VARCHAR(10),GETDATE(),120)+ ' 00:00:00' \n" +
                    "and t2.Opened < CONVERT(VARCHAR(10),GETDATE()+1,120) + ' 00:00:00' \n" +
                    "and t2.[Assignment Group] in (select * from L1_AssignmentGroup)\n" +
                    "-- and t2.[Business Service] is null and t2.[Business Service] !=''\n" +
                    "and t2.State not in ('Closed','Resolved','Complete')"
    })*/
    @Select({
            "select \n" +
                    "COUNT(*) as num \n" +
                    "from Request_Test t1 \t\n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE())=0\n" +
                    "and t1.[Assignment Group] in (select *from L1_AssignmentGroup)\n" +
                    "and t1.State not in ('Closed','Resolved','Complete')"
    })
    public List<Integer> selectPendingTicketsByRequest();


    /**
     * 查询公告板Business Volume Waiting TicketsBy:CDC_Incident
     *
     * @return
     */
    @Select({
            "select  \n" +
                    "COUNT(*) as num\n" +
                    "from CDC_Incident_Test t1 \n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE()) =0\n" +
                    "and t1.[Incident state] in ('transfer','assigned')"   //TODO t1.[Incident state] in ('Transferred','Pending - Assigned External')
    })
    public List<Integer> selectPendingTicketsByCDCIncident();


    /**
     * 查询公告板Business Volume Waiting TicketsBy:CDC_Request
     *
     * @return
     */
    /*@Select({
            "select \n" +
                    "COUNT(*) as number\n" +
                    "from CDC_Request t1 \n" +
                    "where t1.Opened >= CONVERT(VARCHAR(10),GETDATE(),120)+' 00:00:00'\n" +
                    "and t1.Opened < CONVERT(VARCHAR(10),GETDATE()+1,120)+' 00:00:00'"
    })*/
    //State状态
    //TODO 10240	Complete
    //17530	Closed
    //27	Hold
    //292	Work in Progress
    //80	Cancelled
    //26	Open
    @Select({
            "select  \n" +
                    "COUNT(*) as num\n" +
                    "from CDC_Request_Test t1 \n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE()) =0\n" +
                    "and t1.State in ('transfer','assigned')"
    })
    public List<Integer> selectPendingTicketsByCDCRequest();

}
