package com.xkcoding.multi.datasource.mybatis.mapper;

import com.xkcoding.multi.datasource.mybatis.model.OrderUpL1;
import com.xkcoding.multi.datasource.mybatis.model.OrderUpL1Example;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface OrderUpQueryMapper {

    /**
     * L2 总数，自开单 工单类型
     * @return
     */
    @Select(" select \n" +
            "            count(*)as order_number,\n" +
            "            CDC_incident.[Assignment group],\n" +
            "\t\t\t\t\t\tSUBSTRING(CONVERT(VARCHAR(100),Opened,20),1,13)as 'opened',\n" +
            "            (\n" +
            "            select sum(t.num) from (\n" +
            "            select count(*)as num from incident as a inner join CDC_Incident as b on a.Number=b.Number and b.[Assignment group]=CDC_incident.[Assignment group] \n" +
            "\t\t\t\t\t\tand SUBSTRING(CONVERT(VARCHAR(100),CDC_incident.Opened,20),1,13)= SUBSTRING(CONVERT(VARCHAR(100),b.Opened,20),1,13)\n" +
            "            union \n" +
            "            select count(*)as num from CDC_incident as a where CDC_incident.[Assignment group]=a.[Assignment group] and a.[Opened by] in (select Assignee from personnel where Role='L2' ) \n" +
            "\t\t\t\t\t\tand SUBSTRING(CONVERT(VARCHAR(100),CDC_incident.Opened,20),1,13)= SUBSTRING(CONVERT(VARCHAR(100),a.Opened,20),1,13)\n" +
            "            )as t\n" +
            "            )as total,\n" +
            "            1 as mark,\n" +
            "            (select count(*)as num from L3Incindent where L3Incindent.[Assignment group]=CDC_incident.[Assignment group] \n" +
            "\t\t\t\t\t\tand [Opened by] is not null and [Opened by] not in( select Assignee from personnel where Role='L3')\n" +
            "\t\t\t\t\t\tand SUBSTRING(CONVERT(VARCHAR(100),CDC_incident.Opened,20),1,13)= SUBSTRING(CONVERT(VARCHAR(100),L3Incindent.Opened,20),1,13)\n" +
            "            )as to_next_number\n" +
            "            from CDC_incident where 1=1\n" +
            "            and [Opened by] in (select Assignee from personnel where Role='L2' ) \n" +
            "            GROUP BY [Assignment group],SUBSTRING(CONVERT(VARCHAR(100),Opened,20),1,13)\n" +
            "            union\n" +
            "            select \n" +
            "            count(*)as order_number,\n" +
            "            CDC_Request.[Assignment group],\n" +
            "\t\t\t\t\t\tSUBSTRING(CONVERT(VARCHAR(100),Opened,20),1,13)as 'opened',\n" +
            "            (\n" +
            "            select sum(t.num) from(\n" +
            "            select count(*)as num from request as a  inner join CDC_Request as b on a.Number=b.Number \n" +
            "\t\t\t\t\t\tand b.[Assignment group]=CDC_Request.[Assignment group]\n" +
            "\t\t\t\t\t\tand SUBSTRING(CONVERT(VARCHAR(100),CDC_Request.Opened,20),1,13)= SUBSTRING(CONVERT(VARCHAR(100),b.Opened,20),1,13)\n" +
            "            union \n" +
            "            select count(*)as num from CDC_Request as a  where a.[Assignment group]=CDC_Request.[Assignment group] and a.[Opened by] in (select Assignee from personnel where Role='L2' ) \n" +
            "\t\t\t\t\t\tand SUBSTRING(CONVERT(VARCHAR(100),CDC_Request.Opened,20),1,13)= SUBSTRING(CONVERT(VARCHAR(100),a.Opened,20),1,13)\n" +
            "            )as t \n" +
            "            )as total,\n" +
            "            2 as mark,\n" +
            "            (select count(*)as num from L3Request where L3Request.[Assignment group]=CDC_Request.[Assignment group] \n" +
            "            and [Opened by] is not null and [Opened by] not in( select Assignee from personnel where Role='L3' )\n" +
            "            )as to_next_number\n" +
            "            from CDC_Request where 1=1\n" +
            "            and [Opened by] in (select Assignee from personnel where Role='L2' ) \n" +
            "            GROUP BY [Assignment group],SUBSTRING(CONVERT(VARCHAR(100),Opened,20),1,13) ")
    List<Map<String,Object>> getL2OrderUp();

    /**
     * L3 总数，自开单 工单类型
     * @return
     */
    @Select(" select \n" +
            "            count(*)as order_number,\n" +
            "            [Assignment group],\n" +
            "\t\t\t\t\t\tSUBSTRING(CONVERT(VARCHAR(100),Opened,20),1,13)as 'opened',\n" +
            "            (\n" +
            "            select sum(t.num) from (\n" +
            "            select count(*)as num from L3Incindent where L3Incindent.[Assignment group]=CDC_incident.[Assignment group]\n" +
            "            and [Opened by] is not null and [Opened by] not in( select Assignee from personnel where Role='L3') \n" +
            "            and SUBSTRING(CONVERT(VARCHAR(100),CDC_incident.Opened,20),1,13)= SUBSTRING(CONVERT(VARCHAR(100),L3Incindent.Opened,20),1,13)\n" +
            "            union\n" +
            "            select count(*)as num from CDC_incident as a where 1=1\n" +
            "            and a.[Assignment group]=CDC_incident.[Assignment group] \n" +
            "\t\t\t\t\t\tand SUBSTRING(CONVERT(VARCHAR(100),CDC_incident.Opened,20),1,13)= SUBSTRING(CONVERT(VARCHAR(100),a.Opened,20),1,13)\n" +
            "            and a.[Opened by] in (select Assignee from personnel where Role='L3' ) \n" +
            "            )as t\n" +
            "            )as total,\n" +
            "            1 as mark\n" +
            "            from CDC_incident where 1=1\n" +
            "            and [Opened by] in (select Assignee from personnel where Role='L3' ) \n" +
            "            GROUP BY [Assignment group],SUBSTRING(CONVERT(VARCHAR(100),Opened,20),1,13)\n" +
            "            union\n" +
            "            select \n" +
            "            count(*)as count,\n" +
            "            [Assignment group],\n" +
            "\t\t\t\t\t\tSUBSTRING(CONVERT(VARCHAR(100),Opened,20),1,13)as 'opened',\n" +
            "            (\n" +
            "            select sum(t.num) from(\n" +
            "            select count(*)as num from L3Request where 1=1\n" +
            "            and L3Request.[Assignment group]=CDC_Request.[Assignment group]\n" +
            "\t\t\t\t\t\tand SUBSTRING(CONVERT(VARCHAR(100),CDC_Request.Opened,20),1,13)= SUBSTRING(CONVERT(VARCHAR(100),L3Request.Opened,20),1,13)\n" +
            "            and [Opened by] is not null and [Opened by] not in( select Assignee from personnel where Role='L3' ) \n" +
            "            union\n" +
            "            select count(*)as num from CDC_Request as a where 1=1\n" +
            "            and a.[Assignment group]=CDC_Request.[Assignment group]\n" +
            "\t\t\t\t\t\tand SUBSTRING(CONVERT(VARCHAR(100),CDC_Request.Opened,20),1,13)= SUBSTRING(CONVERT(VARCHAR(100),a.Opened,20),1,13)\n" +
            "            and a.[Opened by] in (select Assignee from personnel where Role='L3' )  \n" +
            "            )as t\n" +
            "            )as total,\n" +
            "            2 as mark\n" +
            "            from CDC_Request where [Opened by] in (select Assignee from personnel where Role='L3' ) \n" +
            "            GROUP BY [Assignment group],SUBSTRING(CONVERT(VARCHAR(100),Opened,20),1,13) ")
    List<Map<String,Object>> getL3OrderUp();

    /**
     * 获取昨天23点59分之前的数据
     * @return
     */
    @Select(" select \n" +
            "count(*)as order_number,\n" +
            "CDC_incident.[Assignment group],\n" +
            "(\n" +
            "\tselect sum(t.num) from (\n" +
            "\t\tselect count(*)as num from incident as a inner join CDC_Incident as b on a.Number=b.Number and b.[Assignment group]=CDC_incident.[Assignment group] \n" +
            "\t\twhere and datediff(day, a.opened,getdate())=1 AND CONVERT ( CHAR ( 8 ), a.opened, 108 ) >= '00:00:00' AND CONVERT ( CHAR ( 8 ), a.opened, 108 ) <= '23:59:59'\n" +
            "\t\tunion \n" +
            "\t\tselect count(*)as num from CDC_incident as a where CDC_incident.[Assignment group]=a.[Assignment group] and a.[Opened by] in (select Assignee from personnel where Role='L2' ) \n" +
            "\t\tand datediff(day, a.opened,getdate())=1 AND CONVERT ( CHAR ( 8 ), a.opened, 108 ) >= '00:00:00' AND CONVERT ( CHAR ( 8 ), a.opened, 108 ) <= '23:59:59'\n" +
            "\t)as t\n" +
            ")as total,\n" +
            "1 as mark,\n" +
            "(select count(*)as num from L3Incindent where L3Incindent.[Assignment group]=CDC_incident.[Assignment group] and [Opened by] is not null and [Opened by] not in( select Assignee from personnel where Role='L3')\n" +
            "and datediff(day, opened,getdate())=1 AND CONVERT ( CHAR ( 8 ), opened, 108 ) >= '00:00:00' AND CONVERT ( CHAR ( 8 ), opened, 108 ) <= '23:59:59' \n" +
            ")as to_next_number\n" +
            "from CDC_incident where 1=1\n" +
            "and [Opened by] in (select Assignee from personnel where Role='L2' ) \n" +
            "and datediff(day, opened,getdate())=1 \n" +
            "AND CONVERT ( CHAR ( 8 ), opened, 108 ) >= '00:00:00' AND CONVERT ( CHAR ( 8 ), opened, 108 ) <= '23:59:59'\n" +
            "GROUP BY [Assignment group]\n" +
            "union\n" +
            "-- req 分组\n" +
            "select \n" +
            "count(*)as order_number,\n" +
            "CDC_Request.[Assignment group],\n" +
            "(\n" +
            "\tselect sum(t.num) from(\n" +
            "\t\tselect count(*)as num from request as a  inner join CDC_Request as b on a.Number=b.Number and b.[Assignment group]=CDC_Request.[Assignment group]  where  datediff(day, opened,getdate())=1\n" +
            "\t\tAND CONVERT ( CHAR ( 8 ), opened, 108 ) >= '00:00:00' AND CONVERT ( CHAR ( 8 ), a.opened, 108 ) <= '23:59:59'\n" +
            "\t\tunion \n" +
            "\t\tselect count(*)as num from CDC_Request as a  where a.[Assignment group]=CDC_Request.[Assignment group] and a.[Opened by] in (select Assignee from personnel where Role='L2' ) and datediff(day, a.opened,getdate())=1 \n" +
            "\t\tAND CONVERT ( CHAR ( 8 ), a.opened, 108 ) >= '00:00:00' AND CONVERT ( CHAR ( 8 ), a.opened, 108 ) <= '23:59:59'\n" +
            "\t)as t \n" +
            ")as total,\n" +
            "2 as mark,\n" +
            "(select count(*)as num from L3Request where L3Request.[Assignment group]=CDC_Request.[Assignment group] \n" +
            "and [Opened by] is not null and [Opened by] not in( select Assignee from personnel where Role='L3' )\n" +
            "and datediff(day, opened,getdate())=1 AND CONVERT ( CHAR ( 8 ), opened, 108 ) >= '00:00:00' AND CONVERT ( CHAR ( 8 ), opened, 108 ) <= '23:59:59'\n" +
            ")as to_next_number\n" +
            "from CDC_Request where 1=1\n" +
            "and [Opened by] in (select Assignee from personnel where Role='L2' ) \n" +
            "and datediff(day, opened,getdate())=1\n" +
            "AND CONVERT ( CHAR ( 8 ), opened, 108 ) >= '00:00:00' AND CONVERT ( CHAR ( 8 ), opened, 108 ) <= '23:59:59'\n" +
            "GROUP BY [Assignment group]\n ")
    List<Map<String, Object>> getYesToDayL2OrderUp();

    /**
     * 获取昨天23点59分 L3 总数，自开单 工单类型
     * @return
     */
    @Select(" select \n" +
            "count(*)as order_number,\n" +
            "[Assignment group],\n" +
            "(\n" +
            "select sum(t.num) from (\n" +
            "select count(*)as num from L3Incindent where L3Incindent.[Assignment group]=CDC_incident.[Assignment group]\n" +
            "and [Opened by] is not null and [Opened by] not in( select Assignee from personnel where Role='L3') \n" +
            "and datediff(day, opened,getdate())=1 \n" +
            "union\n" +
            "select count(*)as num from CDC_incident as a where 1=1\n" +
            "and a.[Assignment group]=CDC_incident.[Assignment group] \n" +
            "and a.[Opened by] in (select Assignee from personnel where Role='L3' ) \n" +
            "and datediff(day, a.opened,getdate())=1\n" +
            ")as t\n" +
            ")as total,\n" +
            "1 as mark\n" +
            "from CDC_incident where 1=1\n" +
            "and [Opened by] in (select Assignee from personnel where Role='L3' ) \n" +
            "and datediff(day, opened,getdate())=1 \n" +
            "GROUP BY [Assignment group]\n" +
            "union\n" +
            "select \n" +
            "count(*)as count,\n" +
            "[Assignment group],\n" +
            "(\n" +
            "select sum(t.num) from(\n" +
            "select count(*)as num from L3Request where 1=1\n" +
            "and L3Request.[Assignment group]=CDC_Request.[Assignment group]\n" +
            "and [Opened by] is not null and [Opened by] not in( select Assignee from personnel where Role='L3' ) \n" +
            "and datediff(day, opened,getdate())=1 \n" +
            "union\n" +
            "select count(*)as num from CDC_Request as a where 1=1\n" +
            "and a.[Assignment group]=CDC_Request.[Assignment group]\n" +
            "and a.[Opened by] in (select Assignee from personnel where Role='L3' ) \n" +
            "and datediff(day, a.opened,getdate())=1 \n" +
            ")as t\n" +
            ")as total,\n" +
            "2 as mark\n" +
            "from CDC_Request where [Opened by] in (select Assignee from personnel where Role='L3' ) \n" +
            "and datediff(day, opened,getdate())=1 \n" +
            "GROUP BY [Assignment group] ")
    List<Map<String,Object>> getYesToDayL3OrderUp();

    /**
     * 查询L1 当天 升单量
     * @return
     */
   /*
    @Select({
            "-- L1  当天升单\\n\" +\n" +
                    "select \n" +
                    "count(*)as orderNumber,\n" +
                    "t1.[Owned By] as groupName,\n" +
                    "1 as mark,\n" +
                    "(select count(*)as num from incident as a inner join CDC_Incident as b on a.Number=b.Number \n" +
                    "and a.[Owned By] = t1.[Owned By]\n" +
                    "-- where datediff(day, a.Opened,getdate())=0 and DATEPART(hh, getDate())>DATEPART(hh, a.Opened)  +\n" +
                    ")as toNextNumber\n" +
                    " from incident t1\n" +
                    " where datediff(day, Opened,getdate())=0 and DATEPART(hh, getDate())>DATEPART(hh, Opened)  \n" +
                    "--   and t1.[Owned By] in ('AZ AsiaPac IT Service Desk ','AZ China Shanghai Service Desk','AZ ESM Level 1 Support')\n" +
                    " GROUP BY t1.[Owned By]\n" +
                    " UNION ALL\n" +
                    " select \n" +
                    " count(*)as orderNumber,\n" +
                    "t2.[Assignment Group] as groupName,\n" +
                    " 2 as mark,\n" +
                    " (select count(*)as num from request as a  inner join CDC_Request as b on a.Number=b.Number \n" +
                    " where datediff(day, a.Opened,getdate())=0 and DATEPART(hh, getDate())>DATEPART(hh, a.Opened) \n" +
                    "  )as toNextNumber\n" +
                    "  from Request t2\n" +
                    "   where datediff(day, Opened,getdate())=0 \n" +
                    "\t and DATEPART(hh, getDate())>DATEPART(hh, Opened) \n" +
                    "\t and t2.[Assignment Group] in ('AZ AsiaPac IT Service Desk ','AZ China Shanghai Service Desk','AZ ESM Level 1 Support')\n" +
                    "\tGROUP BY t2.[Assignment Group]"
    })*/
    // 查询一线升单历史数据
    @Select({
            "-- L1  当天升单\n" +
                    "select \n" +
                    "count(*)as orderNumber,\n" +
                    "t1.[Owned By] as groupName,\n" +
                    "1 as mark,\n" +
                    "SUBSTRING(CONVERT(VARCHAR(110),t1.Opened,20), 1, 13) as opentime,\n" +
                    "(select count(*)as num from incident as a inner join CDC_Incident as b on a.Number=b.Number \n" +
                    " and a.[Owned By] = t1.[Owned By]\n" +
                    " )as toNextNumber\n" +
                    "  from incident t1\n" +
                    "  where  DATEPART(hh, getDate())>DATEPART(hh, Opened)  \n" +
                    "  GROUP BY t1.[Owned By], SUBSTRING(CONVERT(VARCHAR(110),t1.Opened,20), 1, 13)\n" +
                    "  UNION ALL\n" +
                    "  select \n" +
                    "  count(*)as orderNumber,\n" +
                    " t2.[Assignment Group] as groupName,\n" +
                    "  2 as mark,\n" +
                    "\tSUBSTRING(CONVERT(VARCHAR(110),t2.Opened,20), 1, 13) as opentime,\n" +
                    "  (select count(*)as num from request as a  inner join CDC_Request as b on a.Number=b.Number \n" +
                    "where  DATEPART(hh, getDate())>DATEPART(hh, a.Opened) \n" +
                    " )as toNextNumber\n" +
                    " from Request t2\n" +
                    "  where  DATEPART(hh, getDate())>DATEPART(hh, Opened) \n" +
                    "  and t2.[Assignment Group] in ('AZ AsiaPac IT Service Desk ','AZ China Shanghai Service Desk','AZ ESM Level 1 Support')\n" +
                    "GROUP BY t2.[Assignment Group],SUBSTRING(CONVERT(VARCHAR(110),t2.Opened,20), 1, 13) "
    })
    public  List<Map<String,Object>> selectOrderUpByL1();



    /**
     * 查询L1 昨天 23点至零点
     * @return
     */
    /*@Select({
           "-- L1 升单 昨天 23点至零点\n" +
                   "select \n" +
                   "count(*)as orderNumber,\n" +
                   "1 as mark,\n" +
                   "(select count(*)as num from incident as a inner join CDC_Incident as b on a.Number=b.Number\n" +
                   "where datediff(day, a.Opened,getdate())=1 AND CONVERT (CHAR(8), a.Opened, 108 ) >= '00:00:00' AND CONVERT ( CHAR ( 8 ), a.Opened, 108 ) <= '23:59:59'  \n" +
                   "-- and DATEPART(hh, getDate())>DATEPART(hh, Opened) \n" +
                   ")as toNextNumber\n" +
                   "from incident \n" +
                   "where datediff(day, Opened,getdate())=1 AND CONVERT (CHAR (8), Opened, 108 ) >= '00:00:00' AND CONVERT ( CHAR ( 8 ), Opened, 108 ) <= '23:59:59'  \n" +
                   "UNION ALL\n" +
                   "select \n" +
                   "count(*)as orderNumber,\n" +
                   "2 as mark,\n" +
                   "(select count(*)as num from request as a  inner join CDC_Request as b on a.Number=b.Number\n" +
                   "where datediff(day, a.Opened,getdate())=1 AND CONVERT (CHAR(8), a.Opened, 108 ) >= '00:00:00' AND CONVERT ( CHAR ( 8 ), a.Opened, 108 ) <= '23:59:59'  \n" +
                   ")as toNextNumber\n" +
                   "from Request \n" +
                   "where datediff(day, Opened,getdate())=1  AND CONVERT (CHAR(8), opened, 108 ) >= '00:00:00'  AND CONVERT ( CHAR ( 8 ), opened, 108 ) <= '23:59:59'\n" +
                   "-- and DATEPART(hh, getDate())>DATEPART(hh, Opened) \n" +
                   "\n"
    })*/
    @Select({
           "-- L1 升单 昨天 23点至零点\\n\" +\n" +
                   "select \n" +
                   "count(*)as orderNumber,\n" +
                   "t1.[Owned By] as groupName,\n" +
                   "1 as mark,\n" +
                   " (select count(*)as num from incident as a inner join CDC_Incident as b on a.Number=b.Number\n" +
                   "where datediff(day, a.Opened,getdate())=1 \n" +
                   "AND CONVERT (CHAR(8), a.Opened, 108 ) >= '00:00:00' \n" +
                   "AND CONVERT ( CHAR ( 8 ), a.Opened, 108 ) <= '23:59:59'  \n" +
                   "and a.[Owned By] = t1.[Owned By]\n" +
                   " -- and DATEPART(hh, getDate())>DATEPART(hh, Opened) \\n\" +\n" +
                   " )as toNextNumber\n" +
                   " from incident t1\n" +
                   " where datediff(day, Opened,getdate())=1 \n" +
                   " AND CONVERT (CHAR (8), Opened, 108 ) >= '00:00:00'\n" +
                   " AND CONVERT ( CHAR ( 8 ), Opened, 108 ) <= '23:59:59'  \n" +
                   " GROUP BY t1.[Owned By]\n" +
                   " \n" +
                   "UNION ALL\n" +
                   "select \n" +
                   "count(*)as orderNumber,\n" +
                   "t2.[Assignment Group] as groupName,\n" +
                   "2 as mark,\n" +
                   "(select count(*)as num from request as a  inner join CDC_Request as b on a.Number=b.Number\n" +
                   "  where datediff(day, a.Opened,getdate())=1 AND CONVERT (CHAR(8), a.Opened, 108 ) >= '00:00:00' \n" +
                   "\tAND CONVERT ( CHAR ( 8 ), a.Opened, 108 ) <= '23:59:59'  \n" +
                   ")as toNextNumber\n" +
                   "from Request t2\n" +
                   "where datediff(day, Opened,getdate())=1  \n" +
                   "AND CONVERT (CHAR(8), opened, 108 ) >= '00:00:00'  \n" +
                   "AND CONVERT ( CHAR ( 8 ), opened, 108 ) <= '23:59:59'\n" +
                   "and t2.[Assignment Group] in ('AZ AsiaPac IT Service Desk ','AZ China Shanghai Service Desk','AZ ESM Level 1 Support')\n" +
                   "GROUP BY t2.[Assignment Group]\n" +
                   "-- and DATEPART(hh, getDate())>DATEPART(hh, Opened) \\n\" +\n"
    })
    public  List<Map<String,Object>> selectYesToDayOrderUpByL1();


}