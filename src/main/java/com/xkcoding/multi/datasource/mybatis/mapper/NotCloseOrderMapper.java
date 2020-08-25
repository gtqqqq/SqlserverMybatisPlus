package com.xkcoding.multi.datasource.mybatis.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * 尚未关闭工单部分的查询语句
 * @author fanchenxi
 */
public interface NotCloseOrderMapper {

    /**
     * 查询 Incident 当天尚未关闭工单数
     * @return
     */
    @Select("select count(*) from Incident where state not in ('closed','Resolved','Complete') \n" +
            "and DateDiff(dd,Opened,getdate())=0")
    Integer getIncidentNum();

    /**
     * 查询 Request 当天尚未关闭工单数
     * @return
     */
    @Select("select count(*) from Request where state not in ('closed','Resolved','Complete') \n" +
            "and DateDiff(dd,Opened,getdate())=0")
    Integer getRequestNum();

    /**
     * 查询 CDC_Request 当天尚未关闭工单数
     * @return
     */
    @Select("select count(*) from CDC_Request where state not in ('closed','Resolved','Complete') \n" +
            "and DateDiff(dd,Opened,getdate())=0")
    Integer getCDCRequestNum();

    /**
     * 查询 CDC_Incident 当天尚未关闭工单数
     * @return
     */
    @Select("select count(*) from CDC_Incident where  [Incident state]   not in ('closed','Resolved','Complete') \n" +
            "and DateDiff(dd,Opened,getdate())=0")
    Integer getCDCIncidentNum();


    /**
     * 查询 Incident 当天滞留的工单数量
     * @return
     */
    @Select("select count(*) from Incident where (state like '%Transferred%' or state like '%pending%')\n" +
            "and DateDiff(dd,Opened,getdate())=0")
     Integer getStopIncidentNum();

    /**
     * 查询 Request 当天滞留的工单数量
     */
    @Select("select count(*) from Request where (state like '%Transferred%' or state like '%pending%')\n" +
            "and DateDiff(dd,Opened,getdate())=0")
    Integer getStopRequestNum();

    /**
     *查询 CDC_Request 当天滞留的工单数量
     * @return
     */
    @Select("select count(*) from CDC_Request where (state like '%Transferred%' or state like '%pending%')\n" +
            "and DateDiff(dd,Opened,getdate())=0")
    Integer getStopCDCRequestNum();

    /**
     * 查询 CDC_Incident 当天滞留的工单数量
     * @return
     */
    @Select("select count(*) from CDC_Incident where ([Incident state] like '%Transferred%' or [Incident state] like '%pending%')\n" +
            "and DateDiff(dd,Opened,getdate())=0")
    Integer getStopCDCIncident();


    /**
     * 查询 Incident当天进行中的工单
     * @return
     */
    @Select("select count(*) from Incident where (state like '%In progress%' or state like '%work in progress%')\n" +
            "and DateDiff(dd,Opened,getdate())=0")
    Integer getOnGoingIncident();

    /**
     *查询 Request 当天进行中的工单
     * @return
     */
    @Select("select count(*) from Request where (state like '%In progress%' or state like '%work in progress%')\n" +
            "and DateDiff(dd,Opened,getdate())=0")
    Integer getOnGoingRequest();

    /**
     * 查询 CDC_Request 当天进行中的工单
     * @return
     */
    @Select("select count(*) from CDC_Request where (state like '%In progress%' or state like '%work in progress%')\n" +
            "and DateDiff(dd,Opened,getdate())=0")
    Integer getOnGoingCDCRequest();

    /**
     * 查询 CDC_Request 当天进行中的工单
     * @return
     */
    @Select("select count(*) from CDC_Incident where ([Incident state] like '%In progress%' or [Incident state] like '%work in progress%')\n" +
            "and DateDiff(dd,Opened,getdate())=0")
    Integer getOnGoingCDCIncident();
}
