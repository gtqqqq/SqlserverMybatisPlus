package com.xkcoding.multi.datasource.mybatis.mapper;

import com.xkcoding.multi.datasource.mybatis.model.FteOrderL1;
import com.xkcoding.multi.datasource.mybatis.model.FteOrderL1Example;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface FteOrderQueryMapper {


    /**
     * 获取L2的Fte等相关的数据
     *
     * @return
     */
    @Select(" SELECT T.*,1 AS mark from (\n" +
            "            select [assignment group],count(DISTINCT[Resolved by])as FTE,count([Resolved by])as total,SUBSTRING(CONVERT(VARCHAR(100),Opened,20),1,13)as 'opened',\n" +
            "            (select count(*) from L2Incindent a where a.[Assignment group]=L2Incindent.[Assignment group] \n" +
            "            and (a.[Incident state] like '%In progress%' or a.[Incident state] like '%Pending%') \n" +
            "            )as reqeust_num \n" +
            "            from L2Incindent where 1=1\n" +
            "            group by [assignment group],SUBSTRING(CONVERT(VARCHAR(100),Opened,20),1,13)\n" +
            "            )T\n" +
            "            union \n" +
            "            select T.*,2 as mark from(\n" +
            "            select [assignment group],count(DISTINCT[Closed by])as FTE,count([Closed by])as total,SUBSTRING(CONVERT(VARCHAR(100),Opened,20),1,13)as 'opened',\n" +
            "            (select count(*) from L2Request a where a.[Assignment group]=L2Request.[Assignment group] \n" +
            "            and (a.state like '%Work in progress%' or a.state like '%Hold%')\n" +
            "            )as reqeust_num \n" +
            "            from L2Request where 1=1\n" +
            "            group by [assignment group],SUBSTRING(CONVERT(VARCHAR(100),Opened,20),1,13)\n" +
            "            )T  ")
    List<Map<String, Object>> getL2FteOrder();

    /**
     * 获取昨天23点59分 L2的Fte等相关的数据
     *
     * @return
     */
    @Select(" SELECT T.*,1 AS mark from (\n" +
            "select [assignment group],count(DISTINCT[Resolved by])as FTE,count([Resolved by])as total,\n" +
            "(select count(*) from L2Incindent a where a.[Assignment group]=L2Incindent.[Assignment group] \n" +
            "and (a.[Incident state] like '%In progress%' or a.[Incident state] like '%Pending%') \n" +
            " and datediff(day, Resolved,getdate())=1 AND CONVERT ( CHAR ( 8 ), Resolved, 108 ) >= '00:00:00' AND CONVERT ( CHAR ( 8 ), Resolved, 108 ) <= '23:59:59'  \n" +
            ")as reqeust_num \n" +
            "from L2Incindent where 1=1\n" +
            "and datediff(day, Resolved,getdate())=1 AND CONVERT ( CHAR ( 8 ), Resolved, 108 ) >= '00:00:00' AND CONVERT ( CHAR ( 8 ), Resolved, 108 ) <= '23:59:59' \n" +
            "group by [assignment group]\n" +
            ")T\n" +
            "union \n" +
            "select T.*,2 as mark from(\n" +
            "select [assignment group],count(DISTINCT[Closed by])as FTE,count([Closed by])as total,\n" +
            "(select count(*) from L2Request a where a.[Assignment group]=L2Request.[Assignment group] \n" +
            "and (a.state like '%Work in progress%' or a.state like '%Hold%')\n" +
            "and datediff(day, Closed,getdate())=1 AND CONVERT ( CHAR ( 8 ), Closed, 108 ) >= '00:00:00' AND CONVERT ( CHAR ( 8 ), Closed, 108 ) <= '23:59:59' \n" +
            ")as reqeust_num \n" +
            "from L2Request where 1=1\n" +
            "and datediff(day, Closed,getdate())=1 AND CONVERT ( CHAR ( 8 ), Closed, 108 ) >= '00:00:00' AND CONVERT ( CHAR ( 8 ), Closed, 108 ) <= '23:59:59'\n" +
            "group by [assignment group]\n" +
            ")T ")
    List<Map<String, Object>> getYesToDayL2FteOrder();

    /**
     * 获取L3的Fte等相关的数据
     *
     * @return
     */
    @Select(" SELECT T.*,1 AS mark from (\n" +
            "            select [assignment group],count(DISTINCT[Resolved by])as FTE,count([Resolved by])as total,SUBSTRING(CONVERT(VARCHAR(100),Opened,20),1,13)as 'opened',\n" +
            "            (select count(*) from L3Incindent a where a.[Assignment group]=L3Incindent.[Assignment group]\n" +
            "            and (a.[Incident state] like '%In progress%' or a.[Incident state] like '%Pending%')\n" +
            "            )as reqeust_num \n" +
            "            from L3Incindent \n" +
            "            where 1=1\n" +
            "            group by [assignment group],SUBSTRING(CONVERT(VARCHAR(100),Opened,20),1,13)\n" +
            "            )T\n" +
            "            union \n" +
            "            select T.*,2 as mark from(\n" +
            "            select [assignment group],count(DISTINCT[Closed by])as FTE,count([Closed by])as total,SUBSTRING(CONVERT(VARCHAR(100),Opened,20),1,13)as 'opened',\n" +
            "            (select count(*) from L3Request a where a.[Assignment group]=L3Request.[Assignment group] \n" +
            "            and (a.state like '%Work in progress%' or a.state like '%Hold%')\n" +
            "            )as reqeust_num \n" +
            "            from L3Request where 1=1\n" +
            "            group by [assignment group],SUBSTRING(CONVERT(VARCHAR(100),Opened,20),1,13)\n" +
            "            )T ")
    List<Map<String, Object>> getL3FteOrder();

    /**
     * 获取昨天23点59分之前的L3的Fte等相关的数据
     *
     * @return
     */
    @Select(" SELECT T.*,1 AS mark from (\n" +
            "select [assignment group],count(DISTINCT[Resolved by])as FTE,count([Resolved by])as total,\n" +
            "(select count(*) from L3Incindent a where a.[Assignment group]=L3Incindent.[Assignment group] \n" +
            "and (a.[Incident state] like '%In progress%' or a.[Incident state] like '%Pending%')\n" +
            "and datediff(day, Resolved,getdate())=1 AND CONVERT ( CHAR ( 8 ), Resolved, 108 ) >= '00:00:00' AND CONVERT ( CHAR ( 8 ), Resolved, 108 ) <= '23:59:59' \n" +
            ")as reqeust_num \n" +
            "from L3Incindent \n" +
            "where 1=1\n" +
            "and datediff(day, Resolved,getdate())=1 AND CONVERT ( CHAR ( 8 ), Resolved, 108 ) >= '00:00:00' AND CONVERT ( CHAR ( 8 ), Resolved, 108 ) <= '23:59:59' \n" +
            "group by [assignment group]\n" +
            ")T\n" +
            "union \n" +
            "select T.*,2 as mark from(\n" +
            "select [assignment group],count(DISTINCT[Closed by])as FTE,count([Closed by])as total,\n" +
            "(select count(*) from L3Request a where a.[Assignment group]=L3Request.[Assignment group] \n" +
            "and (a.state like '%Work in progress%' or a.state like '%Hold%')\n" +
            "and datediff(day, Closed,getdate())=1 AND CONVERT ( CHAR ( 8 ), Closed, 108 ) >= '00:00:00' AND CONVERT ( CHAR ( 8 ), Closed, 108 ) <= '23:59:59' \n" +
            ")as reqeust_num \n" +
            "from L3Request where 1=1\n" +
            "and datediff(day, Closed,getdate())=1 AND CONVERT ( CHAR ( 8 ), Closed, 108 ) >= '00:00:00' AND CONVERT ( CHAR ( 8 ), Closed, 108 ) <= '23:59:59' \n" +
            "group by [assignment group]\n" +
            ")T ")
    List<Map<String, Object>> getL3YesToDayFteOrder();


    /**
     * 查询 FTE ,分组AVG ,以及Responded Tickets
     *
     * @return
     */
    @Select({
          "select * from fte_order_l1"
    })
    List<Map<String, Object>> getL1FteOrderList();


}