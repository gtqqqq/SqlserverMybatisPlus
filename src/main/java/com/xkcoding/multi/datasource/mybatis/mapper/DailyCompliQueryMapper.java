package com.xkcoding.multi.datasource.mybatis.mapper;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author fnchenxi
 */
public interface DailyCompliQueryMapper {

    /**
     * 查询每日达标 SLA L2  (INC)
     * @return
     */
   @Select("SELECT\n" +
           "\tzz.Number,\n" +
           "\tzz.Priority,\n" +
           "\tzz.opened,\n" +
           "\tzz.opened_new,\n" +
           "\tzz.Resolved,\n" +
           "\tzz.[Assignment group],\n" +
           "\tzz.resolved_new,\n" +
           "\tday_num,\n" +
           "\tzz.Duration\n" +
           "\tFROM\n" +
           "\t\t(\n" +
           "\t\tselect gg.Number,\n" +
           "\t\t\tgg.Priority,\n" +
           "\t\t\tgg.opened,\n" +
           "\t\t\tgg.opened_new,\n" +
           "\t\t\tgg.Resolved,\n" +
           "\t\t\tgg.[Assignment group],\n" +
           "\t\t\tgg.resolved_new, \n" +
           "\t\t\tgg.Duration,\n" +
           "\t\t\tfloor( gg.Duration/ 24 ) AS day_num \n" +
           "\t\t\tfrom (\n" +
           "\t\tSELECT\n" +
           "\t\t\tyy.Number,\n" +
           "\t\t\tyy.Priority,\n" +
           "\t\t\tyy.opened,\n" +
           "\t\t\tyy.opened_new,\n" +
           "\t\t\tyy.Resolved,\n" +
           "\t\t\tyy.[Assignment group],\n" +
           "\t\t\tyy.resolved_new,\n" +
           "\t\t\t(\n" +
           "\t\t\t\tyy.DiffDate- ( SELECT COUNT ( * ) AS dd FROM sheet2 WHERE Hoilday >= yy.opened_new AND Hoilday <= yy.Resolved_new ) * 24 \n" +
           "\t\t\t) AS Duration\n" +
           "\t\tFROM\n" +
           "\t\t\t(\n" +
           "\t\t\tSELECT\n" +
           "\t\t\t\txx.Number,\n" +
           "\t\t\t\txx.Priority,\n" +
           "\t\t\t\txx.opened,\n" +
           "\t\t\t\txx.opened_new,\n" +
           "\t\t\t\txx.Resolved,\n" +
           "\t\t\t\txx.[Assignment group],\n" +
           "\t\t\t\txx.resolved_new,\n" +
           "\t\t\t\tDATEDIFF( HOUR, xx.opened_new, xx.resolved_new ) AS DiffDate \n" +
           "\t\t\tFROM\n" +
           "\t\t\t\t(\n" +
           "\t\t\t\tSELECT\n" +
           "\t\t\t\t\tPriority,\n" +
           "\t\t\t\t\tNumber,\n" +
           "\t\t\t\t\tmainData.opened,\n" +
           "\t\t\t\tCASE\n" +
           "\t\t\t\t\t\tWHEN mainData.calcdata IS NULL THEN\n" +
           "\t\t\t\t\t\tmainData.opened ELSE mainData.calcdata \n" +
           "\t\t\t\t\tEND AS opened_new,\n" +
           "\t\t\t\t\tmainData.Resolved,\n" +
           "\t\t\t\t\tmainData.[Assignment group],\n" +
           "\t\t\t\tCASE\n" +
           "\t\t\t\t\t\tWHEN endDate.calcdata IS NULL THEN\n" +
           "\t\t\t\t\t\tmainData.Resolved ELSE endDate.calcdata \n" +
           "\t\t\t\t\tEND AS resolved_new \n" +
           "\t\t\t\tFROM\n" +
           "\t\t\t\t\t(\n" +
           "\t\t\t\t\tSELECT\n" +
           "\t\t\t\t\t\tmainDate.Priority,\n" +
           "\t\t\t\t\t\tmainDate.opened,\n" +
           "\t\t\t\t\t\tmainDate.Resolved,\n" +
           "\t\t\t\t\t\tmainDate.Number,\n" +
           "\t\t\t\t\t\tstartDate.calcdata,\n" +
           "\t\t\t\t\t\tmainDate.[Assignment group] \n" +
           "\t\t\t\t\tFROM\n" +
           "\t\t\t\t\t\tL2Incindent AS mainDate\n" +
           "\t\t\t\t\t\tLEFT JOIN sheet2 AS startDate ON (\n" +
           "\t\t\t\t\t\tDATEPART( yyyy, mainDate.opened ) = DATEPART( yyyy, startDate.hoilday )) \n" +
           "\t\t\t\t\t\tAND (\n" +
           "\t\t\t\t\t\tDATEPART( m, mainDate.opened ) = DATEPART( m, startDate.hoilday )) \n" +
           "\t\t\t\t\t\tAND (\n" +
           "\t\t\t\t\t\tDATEPART( d, mainDate.opened ) = DATEPART( d, startDate.hoilday ))) AS mainData\n" +
           "\t\t\t\t\tLEFT JOIN sheet2 AS endDate ON (\n" +
           "\t\t\t\t\tDATEPART( yyyy, mainData.Resolved ) = DATEPART( yyyy, endDate.hoilday )) \n" +
           "\t\t\t\t\tAND (\n" +
           "\t\t\t\t\tDATEPART( m, mainData.Resolved ) = DATEPART( m, endDate.hoilday )) \n" +
           "\t\t\t\t\tAND (\n" +
           "\t\t\t\t\tDATEPART( d, mainData.Resolved ) = DATEPART( d, endDate.hoilday )) \n" +
           "\t\t\t\t) AS xx \n" +
           "\t\t\t) AS yy ) as gg\n" +
           "\t\t) AS zz \n" +
           "\t-- WHERE DateDiff(dd,Resolved,getdate())=0 and DATEPART(hh, getDate())>DATEPART(hh, Resolved) ")
    List<Map<String, Object>> getDailyCompliByL2Sla();

    /**
     * 查询每日达标 SLA L3 (INC)
     * @return
     */
    @Select(" SELECT\n" +
            "\tzz.Number,\n" +
            "\tzz.Priority,\n" +
            "\tzz.opened,\n" +
            "\tzz.opened_new,\n" +
            "\tzz.Resolved,\n" +
            "\tzz.[Assignment group],\n" +
            "\tzz.resolved_new,\n" +
            "\tday_num,\n" +
            "\tzz.Duration\n" +
            "\tFROM\n" +
            "\t\t(\n" +
            "\t\tselect gg.Number,\n" +
            "\t\t\tgg.Priority,\n" +
            "\t\t\tgg.opened,\n" +
            "\t\t\tgg.opened_new,\n" +
            "\t\t\tgg.Resolved,\n" +
            "\t\t\tgg.[Assignment group],\n" +
            "\t\t\tgg.resolved_new, \n" +
            "\t\t\tgg.Duration,\n" +
            "\t\t\tfloor( gg.Duration/ 24 ) AS day_num \n" +
            "\t\t\tfrom (\n" +
            "\t\tSELECT\n" +
            "\t\t\tyy.Number,\n" +
            "\t\t\tyy.Priority,\n" +
            "\t\t\tyy.opened,\n" +
            "\t\t\tyy.opened_new,\n" +
            "\t\t\tyy.Resolved,\n" +
            "\t\t\tyy.[Assignment group],\n" +
            "\t\t\tyy.resolved_new,\n" +
            "\t\t\t(\n" +
            "\t\t\t\tyy.DiffDate- ( SELECT COUNT ( * ) AS dd FROM sheet2 WHERE Hoilday >= yy.opened_new AND Hoilday <= yy.Resolved_new ) * 24 \n" +
            "\t\t\t) AS Duration\n" +
            "\t\tFROM\n" +
            "\t\t\t(\n" +
            "\t\t\tSELECT\n" +
            "\t\t\t\txx.Number,\n" +
            "\t\t\t\txx.Priority,\n" +
            "\t\t\t\txx.opened,\n" +
            "\t\t\t\txx.opened_new,\n" +
            "\t\t\t\txx.Resolved,\n" +
            "\t\t\t\txx.[Assignment group],\n" +
            "\t\t\t\txx.resolved_new,\n" +
            "\t\t\t\tDATEDIFF( HOUR, xx.opened_new, xx.resolved_new ) AS DiffDate \n" +
            "\t\t\tFROM\n" +
            "\t\t\t\t(\n" +
            "\t\t\t\tSELECT\n" +
            "\t\t\t\t\tPriority,\n" +
            "\t\t\t\t\tNumber,\n" +
            "\t\t\t\t\tmainData.opened,\n" +
            "\t\t\t\tCASE\n" +
            "\t\t\t\t\t\tWHEN mainData.calcdata IS NULL THEN\n" +
            "\t\t\t\t\t\tmainData.opened ELSE mainData.calcdata \n" +
            "\t\t\t\t\tEND AS opened_new,\n" +
            "\t\t\t\t\tmainData.Resolved,\n" +
            "\t\t\t\t\tmainData.[Assignment group],\n" +
            "\t\t\t\tCASE\n" +
            "\t\t\t\t\t\tWHEN endDate.calcdata IS NULL THEN\n" +
            "\t\t\t\t\t\tmainData.Resolved ELSE endDate.calcdata \n" +
            "\t\t\t\t\tEND AS resolved_new \n" +
            "\t\t\t\tFROM\n" +
            "\t\t\t\t\t(\n" +
            "\t\t\t\t\tSELECT\n" +
            "\t\t\t\t\t\tmainDate.Priority,\n" +
            "\t\t\t\t\t\tmainDate.opened,\n" +
            "\t\t\t\t\t\tmainDate.Resolved,\n" +
            "\t\t\t\t\t\tmainDate.Number,\n" +
            "\t\t\t\t\t\tstartDate.calcdata,\n" +
            "\t\t\t\t\t\tmainDate.[Assignment group] \n" +
            "\t\t\t\t\tFROM\n" +
            "\t\t\t\t\t\tL3Incindent AS mainDate\n" +
            "\t\t\t\t\t\tLEFT JOIN sheet2 AS startDate ON (\n" +
            "\t\t\t\t\t\tDATEPART( yyyy, mainDate.opened ) = DATEPART( yyyy, startDate.hoilday )) \n" +
            "\t\t\t\t\t\tAND (\n" +
            "\t\t\t\t\t\tDATEPART( m, mainDate.opened ) = DATEPART( m, startDate.hoilday )) \n" +
            "\t\t\t\t\t\tAND (\n" +
            "\t\t\t\t\t\tDATEPART( d, mainDate.opened ) = DATEPART( d, startDate.hoilday ))) AS mainData\n" +
            "\t\t\t\t\tLEFT JOIN sheet2 AS endDate ON (\n" +
            "\t\t\t\t\tDATEPART( yyyy, mainData.Resolved ) = DATEPART( yyyy, endDate.hoilday )) \n" +
            "\t\t\t\t\tAND (\n" +
            "\t\t\t\t\tDATEPART( m, mainData.Resolved ) = DATEPART( m, endDate.hoilday )) \n" +
            "\t\t\t\t\tAND (\n" +
            "\t\t\t\t\tDATEPART( d, mainData.Resolved ) = DATEPART( d, endDate.hoilday )) \n" +
            "\t\t\t\t) AS xx \n" +
            "\t\t\t) AS yy ) as gg\n" +
            "\t\t) AS zz \n" +
            "\t ")
    List<Map<String, Object>> getDailyCompliByL3Sla();

    /**
     * 获取昨天L2 0点到23点59分的SLA数据 (INC)
     * @return
     */
    @Select("SELECT\n" +
            "\tzz.Number,\n" +
            "\tzz.Priority,\n" +
            "\tzz.opened,\n" +
            "\tzz.opened_new,\n" +
            "\tzz.Resolved,\n" +
            "\tzz.[Assignment group],\n" +
            "\tzz.resolved_new,\n" +
            "\tday_num,\n" +
            "\tzz.Duration\n" +
            "\tFROM\n" +
            "\t\t(\n" +
            "\t\tselect gg.Number,\n" +
            "\t\t\tgg.Priority,\n" +
            "\t\t\tgg.opened,\n" +
            "\t\t\tgg.opened_new,\n" +
            "\t\t\tgg.Resolved,\n" +
            "\t\t\tgg.[Assignment group],\n" +
            "\t\t\tgg.resolved_new, \n" +
            "\t\t\tgg.Duration,\n" +
            "\t\t\tfloor( gg.Duration/ 24 ) AS day_num \n" +
            "\t\t\tfrom (\n" +
            "\t\tSELECT\n" +
            "\t\t\tyy.Number,\n" +
            "\t\t\tyy.Priority,\n" +
            "\t\t\tyy.opened,\n" +
            "\t\t\tyy.opened_new,\n" +
            "\t\t\tyy.Resolved,\n" +
            "\t\t\tyy.[Assignment group],\n" +
            "\t\t\tyy.resolved_new,\n" +
            "\t\t\t(\n" +
            "\t\t\t\tyy.DiffDate- ( SELECT COUNT ( * ) AS dd FROM sheet2 WHERE Hoilday >= yy.opened_new AND Hoilday <= yy.Resolved_new ) * 24 \n" +
            "\t\t\t) AS Duration\n" +
            "\t\tFROM\n" +
            "\t\t\t(\n" +
            "\t\t\tSELECT\n" +
            "\t\t\t\txx.Number,\n" +
            "\t\t\t\txx.Priority,\n" +
            "\t\t\t\txx.opened,\n" +
            "\t\t\t\txx.opened_new,\n" +
            "\t\t\t\txx.Resolved,\n" +
            "\t\t\t\txx.[Assignment group],\n" +
            "\t\t\t\txx.resolved_new,\n" +
            "\t\t\t\tDATEDIFF( HOUR, xx.opened_new, xx.resolved_new ) AS DiffDate \n" +
            "\t\t\tFROM\n" +
            "\t\t\t\t(\n" +
            "\t\t\t\tSELECT\n" +
            "\t\t\t\t\tPriority,\n" +
            "\t\t\t\t\tNumber,\n" +
            "\t\t\t\t\tmainData.opened,\n" +
            "\t\t\t\tCASE\n" +
            "\t\t\t\t\t\tWHEN mainData.calcdata IS NULL THEN\n" +
            "\t\t\t\t\t\tmainData.opened ELSE mainData.calcdata \n" +
            "\t\t\t\t\tEND AS opened_new,\n" +
            "\t\t\t\t\tmainData.Resolved,\n" +
            "\t\t\t\t\tmainData.[Assignment group],\n" +
            "\t\t\t\tCASE\n" +
            "\t\t\t\t\t\tWHEN endDate.calcdata IS NULL THEN\n" +
            "\t\t\t\t\t\tmainData.Resolved ELSE endDate.calcdata \n" +
            "\t\t\t\t\tEND AS resolved_new \n" +
            "\t\t\t\tFROM\n" +
            "\t\t\t\t\t(\n" +
            "\t\t\t\t\tSELECT\n" +
            "\t\t\t\t\t\tmainDate.Priority,\n" +
            "\t\t\t\t\t\tmainDate.opened,\n" +
            "\t\t\t\t\t\tmainDate.Resolved,\n" +
            "\t\t\t\t\t\tmainDate.Number,\n" +
            "\t\t\t\t\t\tstartDate.calcdata,\n" +
            "\t\t\t\t\t\tmainDate.[Assignment group] \n" +
            "\t\t\t\t\tFROM\n" +
            "\t\t\t\t\t\tL2Incindent AS mainDate\n" +
            "\t\t\t\t\t\tLEFT JOIN sheet2 AS startDate ON (\n" +
            "\t\t\t\t\t\tDATEPART( yyyy, mainDate.opened ) = DATEPART( yyyy, startDate.hoilday )) \n" +
            "\t\t\t\t\t\tAND (\n" +
            "\t\t\t\t\t\tDATEPART( m, mainDate.opened ) = DATEPART( m, startDate.hoilday )) \n" +
            "\t\t\t\t\t\tAND (\n" +
            "\t\t\t\t\t\tDATEPART( d, mainDate.opened ) = DATEPART( d, startDate.hoilday ))) AS mainData\n" +
            "\t\t\t\t\tLEFT JOIN sheet2 AS endDate ON (\n" +
            "\t\t\t\t\tDATEPART( yyyy, mainData.Resolved ) = DATEPART( yyyy, endDate.hoilday )) \n" +
            "\t\t\t\t\tAND (\n" +
            "\t\t\t\t\tDATEPART( m, mainData.Resolved ) = DATEPART( m, endDate.hoilday )) \n" +
            "\t\t\t\t\tAND (\n" +
            "\t\t\t\t\tDATEPART( d, mainData.Resolved ) = DATEPART( d, endDate.hoilday )) \n" +
            "\t\t\t\t) AS xx \n" +
            "\t\t\t) AS yy ) as gg\n" +
            "\t\t) AS zz \n" +
            "\t-- WHERE DateDiff(dd,Resolved,getdate())=1 AND CONVERT ( CHAR ( 8 ), Resolved, 108 ) >= '00:00:00' AND CONVERT ( CHAR ( 8 ), Resolved, 108 ) <= '23:59:59'  ")
    List<Map<String, Object>> getYestToDayDailyCompliByL2Sla();

    /**
     * 获取昨天L3 0点到23点59分的SLA数据 (INC)
     * @return
     */
    @Select(" SELECT\n" +
            "\tzz.Number,\n" +
            "\tzz.Priority,\n" +
            "\tzz.opened,\n" +
            "\tzz.opened_new,\n" +
            "\tzz.Resolved,\n" +
            "\tzz.[Assignment group],\n" +
            "\tzz.resolved_new,\n" +
            "\tday_num,\n" +
            "\tzz.Duration\n" +
            "\tFROM\n" +
            "\t\t(\n" +
            "\t\tselect gg.Number,\n" +
            "\t\t\tgg.Priority,\n" +
            "\t\t\tgg.opened,\n" +
            "\t\t\tgg.opened_new,\n" +
            "\t\t\tgg.Resolved,\n" +
            "\t\t\tgg.[Assignment group],\n" +
            "\t\t\tgg.resolved_new, \n" +
            "\t\t\tgg.Duration,\n" +
            "\t\t\tfloor( gg.Duration/ 24 ) AS day_num \n" +
            "\t\t\tfrom (\n" +
            "\t\tSELECT\n" +
            "\t\t\tyy.Number,\n" +
            "\t\t\tyy.Priority,\n" +
            "\t\t\tyy.opened,\n" +
            "\t\t\tyy.opened_new,\n" +
            "\t\t\tyy.Resolved,\n" +
            "\t\t\tyy.[Assignment group],\n" +
            "\t\t\tyy.resolved_new,\n" +
            "\t\t\t(\n" +
            "\t\t\t\tyy.DiffDate- ( SELECT COUNT ( * ) AS dd FROM sheet2 WHERE Hoilday >= yy.opened_new AND Hoilday <= yy.Resolved_new ) * 24 \n" +
            "\t\t\t) AS Duration\n" +
            "\t\tFROM\n" +
            "\t\t\t(\n" +
            "\t\t\tSELECT\n" +
            "\t\t\t\txx.Number,\n" +
            "\t\t\t\txx.Priority,\n" +
            "\t\t\t\txx.opened,\n" +
            "\t\t\t\txx.opened_new,\n" +
            "\t\t\t\txx.Resolved,\n" +
            "\t\t\t\txx.[Assignment group],\n" +
            "\t\t\t\txx.resolved_new,\n" +
            "\t\t\t\tDATEDIFF( HOUR, xx.opened_new, xx.resolved_new ) AS DiffDate \n" +
            "\t\t\tFROM\n" +
            "\t\t\t\t(\n" +
            "\t\t\t\tSELECT\n" +
            "\t\t\t\t\tPriority,\n" +
            "\t\t\t\t\tNumber,\n" +
            "\t\t\t\t\tmainData.opened,\n" +
            "\t\t\t\tCASE\n" +
            "\t\t\t\t\t\tWHEN mainData.calcdata IS NULL THEN\n" +
            "\t\t\t\t\t\tmainData.opened ELSE mainData.calcdata \n" +
            "\t\t\t\t\tEND AS opened_new,\n" +
            "\t\t\t\t\tmainData.Resolved,\n" +
            "\t\t\t\t\tmainData.[Assignment group],\n" +
            "\t\t\t\tCASE\n" +
            "\t\t\t\t\t\tWHEN endDate.calcdata IS NULL THEN\n" +
            "\t\t\t\t\t\tmainData.Resolved ELSE endDate.calcdata \n" +
            "\t\t\t\t\tEND AS resolved_new \n" +
            "\t\t\t\tFROM\n" +
            "\t\t\t\t\t(\n" +
            "\t\t\t\t\tSELECT\n" +
            "\t\t\t\t\t\tmainDate.Priority,\n" +
            "\t\t\t\t\t\tmainDate.opened,\n" +
            "\t\t\t\t\t\tmainDate.Resolved,\n" +
            "\t\t\t\t\t\tmainDate.Number,\n" +
            "\t\t\t\t\t\tstartDate.calcdata,\n" +
            "\t\t\t\t\t\tmainDate.[Assignment group] \n" +
            "\t\t\t\t\tFROM\n" +
            "\t\t\t\t\t\tL3Incindent AS mainDate\n" +
            "\t\t\t\t\t\tLEFT JOIN sheet2 AS startDate ON (\n" +
            "\t\t\t\t\t\tDATEPART( yyyy, mainDate.opened ) = DATEPART( yyyy, startDate.hoilday )) \n" +
            "\t\t\t\t\t\tAND (\n" +
            "\t\t\t\t\t\tDATEPART( m, mainDate.opened ) = DATEPART( m, startDate.hoilday )) \n" +
            "\t\t\t\t\t\tAND (\n" +
            "\t\t\t\t\t\tDATEPART( d, mainDate.opened ) = DATEPART( d, startDate.hoilday ))) AS mainData\n" +
            "\t\t\t\t\tLEFT JOIN sheet2 AS endDate ON (\n" +
            "\t\t\t\t\tDATEPART( yyyy, mainData.Resolved ) = DATEPART( yyyy, endDate.hoilday )) \n" +
            "\t\t\t\t\tAND (\n" +
            "\t\t\t\t\tDATEPART( m, mainData.Resolved ) = DATEPART( m, endDate.hoilday )) \n" +
            "\t\t\t\t\tAND (\n" +
            "\t\t\t\t\tDATEPART( d, mainData.Resolved ) = DATEPART( d, endDate.hoilday )) \n" +
            "\t\t\t\t) AS xx \n" +
            "\t\t\t) AS yy ) as gg\n" +
            "\t\t) AS zz \n" +
            "\tWHERE DateDiff(dd,Resolved,getdate())=1 AND CONVERT ( CHAR ( 8 ), Resolved, 108 ) >= '00:00:00' AND CONVERT ( CHAR ( 8 ), Resolved, 108 ) <= '23:59:59' ")
    List<Map<String,Object>> getYestToDayDailyCompliByL3Sla();


    /**
     * 查询每日达标 SLA L2 根据组名分组
     * @return
     */
    @Select("select \n" +
            "  yy.Number,\n" +
            "\tyy.Priority,\n" +
            "\tyy.opened,\n" +
            "\tyy.opened_new,\n" +
            "\tyy.Resolved,\n" +
            "\tyy.[Assignment group],\n" +
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
            "\txx.[Assignment group],\n" +
            "\txx.resolved_new,\n" +
            "\tDATEDIFF(hour,xx.opened_new,xx.resolved_new) AS DiffDate \n" +
            "\tfrom (\n" +
            "\tselect \n" +
            "\t Priority,\n" +
            "\t Number,\n" +
            "\t mainData.opened,\n" +
            "\t case when mainData.calcdata is null THEN mainData.opened else mainData.calcdata end as opened_new, \n" +
            "\t mainData.Resolved,\n" +
            "\t mainData.[Assignment group],\n" +
            "\t case when endDate.calcdata is null THEN mainData.Resolved else endDate.calcdata  end as resolved_new\n" +
            "\tfrom (\n" +
            "\t\tSELECT\n" +
            "\t\tmainDate.Priority,\n" +
            "\t\tmainDate.opened,\n" +
            "\t\tmainDate.Resolved,\n" +
            "\t\tmainDate.Number,\n" +
            "\t\tstartDate.calcdata,\n" +
            "\t  mainDate.[Assignment group]\n" +
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
            ")as yy where DateDiff(dd,Resolved,getdate())=0 ")
    List<Map<String, Object>> getDailyCompliByL2SlaByGroup();



    /**
     * 查询每日达标 SLA L3 根据组名分组
     * @return
     */
    @Select("select \n" +
            "  yy.Number,\n" +
            "\tyy.Priority,\n" +
            "\tyy.opened,\n" +
            "\tyy.opened_new,\n" +
            "\tyy.Resolved,\n" +
            "\tyy.[Assignment group],\n" +
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
            "\txx.[Assignment group],\n" +
            "\txx.resolved_new,\n" +
            "\tDATEDIFF(hour,xx.opened_new,xx.resolved_new) AS DiffDate \n" +
            "\tfrom (\n" +
            "\tselect \n" +
            "\t Priority,\n" +
            "\t Number,\n" +
            "\t mainData.opened,\n" +
            "\t case when mainData.calcdata is null THEN mainData.opened else mainData.calcdata end as opened_new, \n" +
            "\t mainData.Resolved,\n" +
            "\t mainData.[Assignment group],\n" +
            "\t case when endDate.calcdata is null THEN mainData.Resolved else endDate.calcdata  end as resolved_new\n" +
            "\tfrom (\n" +
            "\t\tSELECT\n" +
            "\t\tmainDate.Priority,\n" +
            "\t\tmainDate.opened,\n" +
            "\t\tmainDate.Resolved,\n" +
            "\t\tmainDate.Number,\n" +
            "\t\tstartDate.calcdata,\n" +
            "\t  mainDate.[Assignment group]\n" +
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
            " where DateDiff(dd,Resolved,getdate())=0")
    List<Map<String, Object>> getDailyCompliByL3SlaByGroup();


    /**
     * 根据表名查询L2或者L3 INC 当日的SLA数据
     * @param tableName
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
           "\t\t ${tableName} AS mainDate\n" +
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
           "  where DateDiff(dd,Resolved,getdate())=0")
   List<Map<String,Object>> getIncDataRange(@Param(value = "tableName") String tableName);

    /**
     * 根据表名查询L2或者L3 REQ 当日的SLA数据
     */
   @Select(" \t\t\t\t\t select \n" +
           "           yy.Number,\n" +
           "           yy.Priority,\n" +
           "           yy.opened,\n" +
           "           yy.opened_new,\n" +
           "           yy.[Closed] as Resolved,\n" +
           "           yy.resolved_new,\n" +
           "           (\n" +
           "           yy.DiffDate- ( SELECT COUNT ( * ) AS dd FROM sheet2 WHERE Hoilday >= yy.opened_new AND Hoilday <= yy.Resolved_new ) * 24 \n" +
           "           ) AS Duration \n" +
           "           from (\n" +
           "           select\n" +
           "           xx.Number,\n" +
           "           xx.Priority,\n" +
           "           xx.opened,\n" +
           "           xx.opened_new,\n" +
           "           xx.[Closed],\n" +
           "           xx.resolved_new,\n" +
           "           DATEDIFF(hour,xx.opened_new,xx.resolved_new) AS DiffDate \n" +
           "           from (\n" +
           "           select \n" +
           "            Priority,\n" +
           "            Number,\n" +
           "            mainData.opened,\n" +
           "            case when mainData.calcdata is null THEN mainData.opened else mainData.calcdata end as opened_new, \n" +
           "            mainData.[Closed],\n" +
           "            case when endDate.calcdata is null THEN mainData.[Closed] else endDate.calcdata  end as resolved_new\n" +
           "           from (\n" +
           "           SELECT\n" +
           "           mainDate.Priority,\n" +
           "           mainDate.opened,\n" +
           "           mainDate.[Closed],\n" +
           "           mainDate.Number,\n" +
           "           startDate.calcdata \n" +
           "           FROM\n" +
           "            ${tableName} AS mainDate\n" +
           "           LEFT JOIN sheet2 AS startDate ON (\n" +
           "           DATEPART( yyyy, mainDate.opened ) = DATEPART( yyyy, startDate.hoilday )) \n" +
           "           AND (\n" +
           "           DATEPART( m, mainDate.opened ) = DATEPART( m, startDate.hoilday )) \n" +
           "           AND (\n" +
           "           DATEPART( d, mainDate.opened ) = DATEPART( d, startDate.hoilday ))) AS mainData\n" +
           "           LEFT JOIN sheet2 AS endDate ON (\n" +
           "           DATEPART( yyyy, mainData.[Closed] ) = DATEPART( yyyy, endDate.hoilday )) \n" +
           "           AND (\n" +
           "           DATEPART( m, mainData.[Closed] ) = DATEPART( m, endDate.hoilday )) \n" +
           "           AND (\n" +
           "           DATEPART( d, mainData.[Closed] ) = DATEPART( d ,endDate.hoilday ))\n" +
           "           )as xx\n" +
           "           )as yy \n" +
           "            ")
   List<Map<String,Object>>  getReqDataRange(@Param(value = "tableName") String tableName);


    /**
     * 根据表名 查询昨天23点59分之前 REQ的数据
     * @param tableName
     * @return
     */
   @Select(" \t\t\t\t\t select \n" +
           "           yy.Number,\n" +
           "           yy.Priority,\n" +
           "           yy.opened,\n" +
           "           yy.opened_new,\n" +
           "           yy.[Closed] as Resolved,\n" +
           "           yy.resolved_new,\n" +
           "           (\n" +
           "           yy.DiffDate- ( SELECT COUNT ( * ) AS dd FROM sheet2 WHERE Hoilday >= yy.opened_new AND Hoilday <= yy.Resolved_new ) * 24 \n" +
           "           ) AS Duration \n" +
           "           from (\n" +
           "           select\n" +
           "           xx.Number,\n" +
           "           xx.Priority,\n" +
           "           xx.opened,\n" +
           "           xx.opened_new,\n" +
           "           xx.[Closed],\n" +
           "           xx.resolved_new,\n" +
           "           DATEDIFF(hour,xx.opened_new,xx.resolved_new) AS DiffDate \n" +
           "           from (\n" +
           "           select \n" +
           "            Priority,\n" +
           "            Number,\n" +
           "            mainData.opened,\n" +
           "            case when mainData.calcdata is null THEN mainData.opened else mainData.calcdata end as opened_new, \n" +
           "            mainData.[Closed],\n" +
           "            case when endDate.calcdata is null THEN mainData.[Closed] else endDate.calcdata  end as resolved_new\n" +
           "           from (\n" +
           "           SELECT\n" +
           "           mainDate.Priority,\n" +
           "           mainDate.opened,\n" +
           "           mainDate.[Closed],\n" +
           "           mainDate.Number,\n" +
           "           startDate.calcdata \n" +
           "           FROM\n" +
           "            ${tableName} AS mainDate\n" +
           "           LEFT JOIN sheet2 AS startDate ON (\n" +
           "           DATEPART( yyyy, mainDate.opened ) = DATEPART( yyyy, startDate.hoilday )) \n" +
           "           AND (\n" +
           "           DATEPART( m, mainDate.opened ) = DATEPART( m, startDate.hoilday )) \n" +
           "           AND (\n" +
           "           DATEPART( d, mainDate.opened ) = DATEPART( d, startDate.hoilday ))) AS mainData\n" +
           "           LEFT JOIN sheet2 AS endDate ON (\n" +
           "           DATEPART( yyyy, mainData.[Closed] ) = DATEPART( yyyy, endDate.hoilday )) \n" +
           "           AND (\n" +
           "           DATEPART( m, mainData.[Closed] ) = DATEPART( m, endDate.hoilday )) \n" +
           "           AND (\n" +
           "           DATEPART( d, mainData.[Closed] ) = DATEPART( d ,endDate.hoilday ))\n" +
           "           )as xx\n" +
           "           )as yy \n" +
           "\t\t\t\t\twhere DateDiff(dd,Closed,getdate())=1 AND CONVERT ( CHAR ( 8 ), Closed, 108 ) >= '00:00:00' AND CONVERT ( CHAR ( 8 ), Closed, 108 ) <= '23:59:59'  ")
   List<Map<String,Object>> getYestToDayReqDataRange(@Param(value = "tableName") String tableName);

    /**
     * 获取 INC 当天解决工单数量
     * @return
     */
    @Select("  select Resolved,[Close notes] from ${tableName} \n" +
            " where [Incident state]in ('Resolved','closed')\n" +
            "  ")
    List<Map<String,Object>> getINCAvgData(@Param(value = "tableName") String tableName);


    /**
     * 获取 REQ 当天解决工单数量
     * @return
     */
    @Select(" select Closed as Resolved,[Closure comments] as [Close notes] from ${tableName} \n" +
            " where [state]='Complete'\n" +
            " ")
    List<Map<String,Object>> getREQAvgData(@Param(value = "tableName") String tableName);


    /**
     * INC 昨天23点59分之前解决工单数量
     * @param l2Incindent
     * @return
     */
    @Select("  select [Close notes] from ${tableName} \n" +
            " where [Incident state]in ('Resolved','closed')\n" +
            "and DateDiff(dd,resolved,getdate())=1  \n" +
            "AND CONVERT ( CHAR ( 8 ), Resolved, 108 ) >= '00:00:00' AND CONVERT ( CHAR ( 8 ), Resolved, 108 ) <= '23:59:59'  ")
    List<String> getYestToDayINCAvgData(String l2Incindent);

    /**
     * REQ 昨天23点59分之前解决工单数量
     * @param l2Request
     * @return
     */
    @Select(" select [Closure comments] from ${tableName} \n" +
            " where [state]='Complete'\n" +
            " and DateDiff(dd,Closed,getdate())=1  AND CONVERT ( CHAR ( 8 ), Closed, 108 ) >= '00:00:00' AND CONVERT ( CHAR ( 8 ), Closed, 108 ) <= '23:59:59' ")
    List<String> getYestToDayREQAvgData(String l2Request);
}