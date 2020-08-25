package com.xkcoding.multi.datasource.mybatis.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 今日订单受理总数
 * @author fanchenxi
 */
public interface TodayOrderTotalMapper {

    /**
     * 查询 Incident 今日创建工单数
     * @return
     */
    @Select("select count(*) from Incident where [Business Service]!= '' and [Business Service] is not null \n" +
            "and DateDiff(dd,Opened,getdate())=0")
    Integer getTodayCreateOrderByIncident();

    /**
     * 查询 Request 今日创建工单数
     * @return
     */
    @Select("select count(*) from Request where [Business Service]!= '' and [Business Service] is not null \n" +
            "and DateDiff(dd,Opened,getdate())=0")
    Integer getTodayCreateOrderByRequest();

    /**
     * 查询 CDC_Incident 今日创建工单数
     * @return
     */
    @Select("select count(*) from CDC_Incident where [Business Service]!= '' and [Business Service] is not null \n" +
            "and DateDiff(dd,Opened,getdate())=0")
    Integer getTodayCreateOrderByCDCIncident();

    /**
     * 查询 CDC_Request 今日创建工单数
     * @return
     */
    @Select("select count(*) from CDC_Request where  DateDiff(dd,Opened,getdate())=0")
    Integer getTodayCreateOrderByCDCRequest();

    /**
     * 查询 NewCall 今日创建工单数
     * @return
     */
    @Select("select count(*) from NewCall where [Business Service]!= '' and [Business Service] is not null \n" +
            "and DateDiff(dd,Opened,getdate())=0")
    Integer getTodayCreateOrderByNewCall();


    /**
     * 查询 Incident 今日关闭的工单数
     * @return
     */
    @Select("select count(*) from Incident where \n" +
            "[Assignment group] in('AZ China Shanghai Service Desk','AZ ESM Level 1 Support','AZ Asiapac IT Service Desk','AZ Dalian Desk to Desk Support')\n" +
            "and state ='CLOSE'\n" +
            "and DateDiff(dd,Opened,getdate())=0")
    Integer getTodayCloseOrderByIncident();

    /**
     * 查询 Request 今日关闭的工单数
     * @return
     */
    @Select("select count(*) from Request where\n" +
            "[Assignment group] in('AZ China Shanghai Service Desk','AZ ESM Level 1 Support','AZ Asiapac IT Service Desk','AZ Dalian Desk to Desk Support')\n" +
            "and state ='CLOSE'\n" +
            "and DateDiff(dd,Opened,getdate())=0")
    Integer getTodayCloseOrderByRequest();

    /**
     * 查询 CDC_Incident 今日关闭的工单数
     * @return
     */
    @Select("select count(*) from CDC_Incident where\n" +
            "[Assignment group] in('AZ China Shanghai Service Desk','AZ ESM Level 1 Support','AZ Asiapac IT Service Desk','AZ Dalian Desk to Desk Support')\n" +
            "and [Incident state] ='CLOSE'\n" +
            "and DateDiff(dd,Opened,getdate())=0 ")
    Integer getTodayCloseOrderByCDCIncident();


    /**
     * 查询 CDC_Request 今日关闭的工单数
     * @return
     */
    @Select("select count(*) from CDC_Request where \n" +
            "[Assignment group] in('AZ China Shanghai Service Desk','AZ ESM Level 1 Support','AZ Asiapac IT Service Desk','AZ Dalian Desk to Desk Support')\n" +
            "and state ='CLOSE'\n" +
            "and DateDiff(dd,Opened,getdate())=0 ")
    Integer getTodayCloseOrderByCDCRequest();

    /**
     * 查询 NewCall 今日关闭的工单数
     * @return
     */
    @Select("select count(*) from NewCall where \n" +
            "[Assignment group] in('AZ China Shanghai Service Desk','AZ ESM Level 1 Support','AZ Asiapac IT Service Desk','AZ Dalian Desk to Desk Support')\n" +
            "and DateDiff(dd,Opened,getdate())=0")
    Integer getTodayCloseOrderByNewCall();

    /**
     * 查询 INC 今日解决的工单数
     * @return
     */
    @Select("select count(*) from Incident where \n" +
            "[Assignment group] in('AZ China Shanghai Service Desk','AZ ESM Level 1 Support','AZ Asiapac IT Service Desk','AZ Dalian Desk to Desk Support')\n" +
            "and DateDiff(dd,resolved,getdate())=0")
    Integer getTodayCompliOrderByIncident();

    /**
     * 查询 Request 今日解决的工单数
     * @return
     */
    @Select("select count(*) from Request where \n" +
            "[Assignment group] in('AZ China Shanghai Service Desk','AZ ESM Level 1 Support','AZ Asiapac IT Service Desk','AZ Dalian Desk to Desk Support')\n" +
            "and DateDiff(dd,CLOSED,getdate())=0")
    Integer getTodayCompliOrderByRequest();

    /**
     * 查询 New Call 今日解决的工单数
     * @return
     */
    @Select("select count(*) from NewCall where \n" +
            "[Assignment group] in('AZ China Shanghai Service Desk','AZ ESM Level 1 Support','AZ Asiapac IT Service Desk','AZ Dalian Desk to Desk Support')\n" +
            "and DateDiff(dd,Opened,getdate())=0")
    Integer getTodayCompliOrderByNewCall();

    /**
     * 查询 L2 INC 今日解决的工单数
     * @return
     */
    @Select("select \n" +
            "  yy.Number,\n" +
            "\tyy.Priority,\n" +
            "\tyy.opened,\n" +
            "\tyy.opened_new,\n" +
            "\tyy.Resolved,\n" +
            "\tyy.resolved_new,\n" +
            "\t(\n" +
            "\tyy.DiffDate- ( SELECT COUNT ( * ) AS dd FROM sheet2 WHERE Hoilday >= yy.opened_new AND Hoilday <= yy.Resolved_new ) * 24 \n" +
            "\t) AS Duration \n" +
            "from (\n" +
            "\tselect \n" +
            "\txx.Number,\n" +
            "\txx.Priority,\n" +
            "\txx.opened,\n" +
            "\txx.opened_new,\n" +
            "\txx.Resolved,\n" +
            "\txx.resolved_new,\n" +
            "\tDATEDIFF(hour,xx.opened_new,xx.resolved_new) AS DiffDate \n" +
            "\tfrom (\n" +
            "\tselect \n" +
            "\t Priority,\n" +
            "\t Number,\n" +
            "\t mainData.opened,\n" +
            "\t case when mainData.calcdata is null THEN mainData.opened else mainData.calcdata end as opened_new, \n" +
            "\t mainData.Resolved,\n" +
            "\t case when endDate.calcdata is null THEN mainData.Resolved else endDate.calcdata  end as resolved_new\n" +
            "\tfrom (\n" +
            "\t\tSELECT\n" +
            "\t\tmainDate.Priority,\n" +
            "\t\tmainDate.opened,\n" +
            "\t\tmainDate.Resolved,\n" +
            "\t\tmainDate.Number,\n" +
            "\t\tstartDate.calcdata \n" +
            "\tFROM\n" +
            "\t\tL2Incindent AS mainDate\n" +
            "\t\tLEFT JOIN sheet2 AS startDate ON (\n" +
            "\t\tDATEPART( yyyy, mainDate.opened ) = DATEPART( yyyy, startDate.hoilday )) \n" +
            "\t\tAND (\n" +
            "\t\tDATEPART( m, mainDate.opened ) = DATEPART( m, startDate.hoilday )) \n" +
            "\t\tAND (\n" +
            "\t\tDATEPART( d, mainDate.opened ) = DATEPART( d, startDate.hoilday ))) AS mainData\t\n" +
            "\t\tLEFT JOIN sheet2 AS endDate ON (\n" +
            "\t\tDATEPART( yyyy, mainData.Resolved ) = DATEPART( yyyy, endDate.hoilday )) \n" +
            "\t\tAND (\n" +
            "\t\tDATEPART( m, mainData.Resolved ) = DATEPART( m, endDate.hoilday )) \n" +
            "\t\tAND (\n" +
            "\t\tDATEPART( d, mainData.Resolved ) = DATEPART( d ,endDate.hoilday ))\n" +
            "\t\t)as xx\n" +
            ")as yy \n" +
            "where DateDiff(dd,Resolved,getdate())=0 ")
    List<Map<String,Object>> getTodayCompliOrderByL2Incident();

    /**
     * 查询 L3 INC 今日解决的工单数
     * @return
     */
    @Select("select \n" +
            "  yy.Number,\n" +
            "\tyy.Priority,\n" +
            "\tyy.opened,\n" +
            "\tyy.opened_new,\n" +
            "\tyy.Resolved,\n" +
            "\tyy.resolved_new,\n" +
            "\t(\n" +
            "\tyy.DiffDate- ( SELECT COUNT ( * ) AS dd FROM sheet2 WHERE Hoilday >= yy.opened_new AND Hoilday <= yy.Resolved_new ) * 24 \n" +
            "\t) AS Duration \n" +
            "from (\n" +
            "\tselect \n" +
            "\txx.Number,\n" +
            "\txx.Priority,\n" +
            "\txx.opened,\n" +
            "\txx.opened_new,\n" +
            "\txx.Resolved,\n" +
            "\txx.resolved_new,\n" +
            "\tDATEDIFF(hour,xx.opened_new,xx.resolved_new) AS DiffDate \n" +
            "\tfrom (\n" +
            "\tselect \n" +
            "\t Priority,\n" +
            "\t Number,\n" +
            "\t mainData.opened,\n" +
            "\t case when mainData.calcdata is null THEN mainData.opened else mainData.calcdata end as opened_new, \n" +
            "\t mainData.Resolved,\n" +
            "\t case when endDate.calcdata is null THEN mainData.Resolved else endDate.calcdata  end as resolved_new\n" +
            "\tfrom (\n" +
            "\t\tSELECT\n" +
            "\t\tmainDate.Priority,\n" +
            "\t\tmainDate.opened,\n" +
            "\t\tmainDate.Resolved,\n" +
            "\t\tmainDate.Number,\n" +
            "\t\tstartDate.calcdata \n" +
            "\tFROM\n" +
            "\t\tL3Incindent AS mainDate\n" +
            "\t\tLEFT JOIN sheet2 AS startDate ON (\n" +
            "\t\tDATEPART( yyyy, mainDate.opened ) = DATEPART( yyyy, startDate.hoilday )) \n" +
            "\t\tAND (\n" +
            "\t\tDATEPART( m, mainDate.opened ) = DATEPART( m, startDate.hoilday )) \n" +
            "\t\tAND (\n" +
            "\t\tDATEPART( d, mainDate.opened ) = DATEPART( d, startDate.hoilday ))) AS mainData\t\n" +
            "\t\tLEFT JOIN sheet2 AS endDate ON (\n" +
            "\t\tDATEPART( yyyy, mainData.Resolved ) = DATEPART( yyyy, endDate.hoilday )) \n" +
            "\t\tAND (\n" +
            "\t\tDATEPART( m, mainData.Resolved ) = DATEPART( m, endDate.hoilday )) \n" +
            "\t\tAND (\n" +
            "\t\tDATEPART( d, mainData.Resolved ) = DATEPART( d ,endDate.hoilday ))\n" +
            "\t\t)as xx\n" +
            ")as yy \n" +
            "where DateDiff(dd,Resolved,getdate())=0 ")
    List<Map<String,Object>> getTodayCompliOrderByL3Incident();

    /**
     * 获取今日服务热点(排名前5条数据)
     * @return
     */
    @Select("select TOP 5 [Business Service],total_count from (\n" +
            "select [Business Service],count([Business Service])as total_count from incident GROUP BY [Business Service] \n" +
            "union \n" +
            "select [Business Service],count([Business Service])as total_count from Request GROUP BY [Business Service]\n" +
            "\n" +
            ")as t order by t.total_count desc ")
    List<Map<String, Object>> getServerHot();
}
