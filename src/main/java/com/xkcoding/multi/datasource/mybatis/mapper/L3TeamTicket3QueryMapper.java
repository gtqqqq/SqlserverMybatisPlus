package com.xkcoding.multi.datasource.mybatis.mapper;

import com.xkcoding.multi.datasource.mybatis.model.L3TeamTicket3;
import com.xkcoding.multi.datasource.mybatis.model.L3TeamTicket3Example;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 查询sqlServer的语句
 * @author fanchenxi
 */
public interface L3TeamTicket3QueryMapper {

    /**
     * 查询L3-L3 Incindent 总票数量
     * @return
     */
    @Select("select count(*) from L3Incindent where DateDiff(dd,Opened,getdate())=0 ")
    Integer getTotalTicketsByIncindent();

    /**
     * 查询L3-L3 Request 总票数量
     * @return
     */
    @Select("select count(*) from L3Request where DateDiff(dd,Opened,getdate())=0 ")
    Integer getgetTotalTicketsByRequest();

    /**
     * 查询L3 Incindent working票数量
     * @return
     */
    @Select("select count(*) from L3Incindent where DateDiff(dd,Opened,getdate())=0 and [Incident state] like '%In progress%' ")
    Integer getWorkIngTicketsByIncindent();


    /**
     * 查询L3 Request working票数量
     * @return
     */
    @Select("select count(*) from L3Request where DateDiff(dd,Opened,getdate())=0 and [state] like '%work in progress%'")
    Integer getWorkIngTicketsByRequest();
    /**
     * 查询L3 Incindent 待售票数
     * @return
     */
    @Select("select count(*) from L3Incindent where DateDiff(dd,Opened,getdate())=0 and [Incident state] like 'Pending%'")
    Integer getPendingTicketsByIncindent();

    /**
     * 查询L3 Request 待售票数
     * @return
     */
    @Select("select count(*) from L3Request where DateDiff(dd,Opened,getdate())=0 and [state] like '%Hold%'")
    Integer getPendingTicketsByRequest();

    /**
     * 查询L3 Incindent 关闭票数
     * @return
     */
    @Select("select count(*) from L3Incindent where DateDiff(dd,Opened,getdate())=0 and [Incident state] like '%Resolved%'")
    Integer getCloseTicketsByIncindent();

    /**
     * 查询L3 Request 关闭票数
     * @return
     */
    @Select("select count(*) from L3Request where DateDiff(dd,Opened,getdate())=0 and [state] like '%complete%'")
    Integer getCloseTicketsByRequest();

    /**
     * 查询L3 Incindent 等待票数
     * @return
     */
    @Select("select count(*) from L3Incindent where DateDiff(dd,Opened,getdate())=0 and [Incident state]  in ('transfer','assigned') ")
    Integer getWaitTicketsByIncindent();

    /**
     * 查询L3 Request 等待票数
     * @return
     */
    @Select("select count(*) from L3Request where DateDiff(dd,Opened,getdate())=0 and [state]  in ('transfer','assigned')")
    Integer getWaitTicketsByRequest();

}