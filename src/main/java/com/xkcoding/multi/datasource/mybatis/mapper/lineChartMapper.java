package com.xkcoding.multi.datasource.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xkcoding.multi.datasource.mybatis.model.lineChart;
import com.xkcoding.multi.datasource.mybatis.model.lineChartBySqlServer;
import com.xkcoding.multi.datasource.mybatis.model.responseCall;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @description: 运营综合导航版 数据层
 * @author: smf
 * @time: 7/6/2020 9:15 PM
 */
public interface lineChartMapper extends BaseMapper<lineChart> {


    /***
     * 录入 折线图
     */
    @Insert({
            "<script>",
            "insert into line_chart(time, workOrderClosedHour,workOrderClosedNum,workOrderCreateHour,workOrderCreateNum,phoneRespHour,phoneRespNum) values ",
            "<foreach collection='lineChartList' item='item' index='index' separator=','>",
            "( #{item.time}, #{item.workOrderClosedHour},#{item.workOrderClosedNum},#{item.workOrderCreateHour},#{item.workOrderCreateNum},#{item.phoneRespHour},#{item.phoneRespNum})",
            "</foreach>",
            "</script>"
    })
    public Boolean insertLineChartList(@Param("lineChartList") List<lineChart> lineChartList);

    /***
     * 清line_chart表
     */
    @Delete({
            "<script>",
            "delete from line_chart",
            "</script>"
    })
    public void deleteLineChart();


    /**
     * 查询导航版-L1关闭工单数
     */
    /*@Select({   //TODO  以下条件为需求文档图片上
            " -- l1关闭工单数\n" +
                    " select a.openTime as openTime,\n" +
                    " sum(a.Number) as Number\n" +
                    " from(\n" +
                    " select  \n" +
                    "  DATEPART(hh, t1.Opened) as openTime,\n" +
                    "  COUNT(*) as Number\n" +
                    "  from Incident_Test t1\n" +
                    "  where DATEDIFF(month, t1.Opened, GETDATE()) =1\n" +
                    "  and t1.[Assignment Group] in (select * from L1_AssignmentGroup )\n" +
                    "  and t1.[Business Service] is not NULL\n" +
                    "  and t1.[Business Service] !=''\n" +
                    "  GROUP BY DATEPART(hh, t1.Opened)\n" +
                    " union all\n" +
                    " --  LEFT JOIN \n" +
                    "  -- L1 关闭工单数Request_Test\n" +
                    "  select  \n" +
                    "  DATEPART(hh, t1.Opened) as openTime,\n" +
                    "  COUNT(*) as Number\n" +
                    "  from Request_Test t1\n" +
                    "  where DATEDIFF(week, t1.Opened, GETDATE()) =1\n" +
                    "  and t1.[Assignment Group] in (select * from L1_AssignmentGroup )\n" +
                    "  and t1.[Business Service] is not NULL\n" +
                    "  and t1.[Business Service] !=''\n" +
                    "  GROUP BY DATEPART(hh, t1.Opened)\n" +
                    " union all\n" +
                    " -- on abc.openTime = qwe.openTime\n" +
                    " --  L1 关闭工单数NewCall_Test\n" +
                    " -- LEFT JOIN \n" +
                    " select  \n" +
                    " DATEPART(hh, t1.Opened) as OpenedTime,\n" +
                    " COUNT(*) as Number\n" +
                    " from NewCall_Test t1\n" +
                    " where DATEDIFF(week, t1.Opened, GETDATE()) =1\n" +
                    "  and t1.[Business Service] is not NULL\n" +
                    "  and t1.[Business Service] !=''\n" +
                    " --  and t1.[Call type]  in ('Status Call','Wrong Number')\n" +
                    " GROUP BY t1.Opened\n" +
                    " )a\n" +
                    " GROUP BY a.openTime"
    })*/
    @Select({
            "-- l1关闭工单数\\n\" +\n" +
                    "select a.openTime as openTime,\n" +
                    "sum(a.Number) as Number\n" +
                    "from(\n" +
                    "select \n" +
                    " DATEPART(hh, t1.Opened) as openTime,\n" +
                    " COUNT(*) as Number\n" +
                    " from Incident_Test t1\n" +
                    " where DATEDIFF(day, t1.Opened, GETDATE()) =0\n" +
                    " and t1.[Assignment Group] in (select * from L1_AssignmentGroup )\n" +
                    " and t1.[Business Service] is not NULL\n" +
                    " and t1.[Business Service] !=''\n" +
                    " GROUP BY DATEPART(hh, t1.Opened)\n" +
                    "union all\n" +
                    "--  LEFT JOIN \n" +
                    " -- L1 关闭工单数Request_Test\\n\" +\n" +
                    " select  \n" +
                    " DATEPART(hh, t1.Opened) as openTime,\n" +
                    " COUNT(*) as Number\n" +
                    " from Request_Test t1\n" +
                    " where DATEDIFF(day, t1.Opened, GETDATE()) =0\n" +
                    " and t1.[Assignment Group] in (select * from L1_AssignmentGroup )\n" +
                    " and t1.[Business Service] is not NULL\n" +
                    " and t1.[Business Service] !=''\n" +
                    " GROUP BY DATEPART(hh, t1.Opened)\n" +
                    "union all\n" +
                    "-- on abc.openTime = qwe.openTime\\n\" +\n" +
                    "--  L1 关闭工单数NewCall_Test\\n\" +\n" +
                    "-- LEFT JOIN \\n\" +\n" +
                    "select  \n" +
                    "DATEPART(hh, t1.Opened) as OpenedTime,\n" +
                    "COUNT(*) as Number\n" +
                    "from NewCall_Test t1\n" +
                    "where DATEDIFF(day, t1.Opened, GETDATE()) =0\n" +
                    " and t1.[Business Service] is not NULL\n" +
                    " and t1.[Business Service] !=''\n" +
                    " and t1.[Assignment Group] in (select * from L1_AssignmentGroup )\n" +
                    "--  and t1.[Call type]  in ('Status Call','Wrong Number')\\n\" +\n" +
                    "GROUP BY t1.Opened\n" +
                    ")a\n" +
                    "GROUP BY a.openTime\n"
    })
    public List<lineChartBySqlServer> selectLineChartCloseOrderNum();


    /**
     * 查询导航版-L1创建工单数
     */
   /* @Select({  //TODO  以下条件为需求文档图片上
            "--L1 创建工单数\n" +
                    "select  \n" +
                    "total.OpenedTime as openTime,\n" +
                    "sum(total.num) as Number\n" +
                    "from (\n" +
                    "--  L1 创建工单数 Incident_Test\n" +
                    "select \n" +
                    "DATEPART(hh, t1.Opened) as OpenedTime,\n" +
                    "COUNT(*) as num \n" +
                    "from Incident_Test t1 \n" +
                    "where DATEDIFF(month, t1.[Opened], GETDATE()) =1 \n" +
                    "and t1.[Assignment Group] in (select * from L1_AssignmentGroup )\n" +
                    "and t1.[Business Service] is not null \n" +
                    "and t1.[Business Service] !=''\n" +
                    "GROUP BY t1.Opened\n" +
                    "UNION ALL\n" +
                    "--  L1 创建工单数 Request_Test\n" +
                    "select \n" +
                    "DATEPART(hh, t1.Opened) as OpenedTime,\n" +
                    "COUNT(*) as num \n" +
                    "from Request_Test t1 \n" +
                    "where DATEDIFF(week, t1.[Opened], GETDATE()) =1 \n" +
                    "and t1.[Assignment Group] in (select * from L1_AssignmentGroup )\n" +
                    "and t1.[Business Service] is not null \n" +
                    "and t1.[Business Service] !=''\n" +
                    "GROUP BY t1.Opened\n" +
                    "UNION ALL\n" +
                    "-- L1 创建工单数 NewCall_Test\n" +
                    "select \n" +
                    "DATEPART(hh, t1.Opened) as OpenedTime,\n" +
                    "COUNT(*) as num \n" +
                    "from NewCall_Test t1 \n" +
                    "where DATEDIFF(week, t1.[Opened], GETDATE()) =1 \n" +
                    "-- and t1.[Assignment Group] in (select * from L1_AssignmentGroup )\n" +
                    "and t1.[Business Service] is not null \n" +
                    "and t1.[Business Service] !=''\n" +
                    "GROUP BY t1.Opened\n" +
                    ") total\n" +
                    "GROUP BY total.OpenedTime"
    })*/
    @Select({
            "--L1 创建工单数\\n\" +\n" +
                    "select  \n" +
                    "total.OpenedTime as openTime,\n" +
                    "sum(total.num) as Number\n" +
                    "from (\n" +
                    "--  L1 创建工单数 Incident_Test\\n\" +\n" +
                    "select \n" +
                    "DATEPART(hh, t1.Opened) as OpenedTime,\n" +
                    "COUNT(*) as num \n" +
                    "from Incident_Test t1 \n" +
                    "where DATEDIFF(day, t1.[Opened], GETDATE()) =0\n" +
                    "-- and t1.[Assignment Group] in (select * from L1_AssignmentGroup )\n" +
                    "and t1.[Business Service] is not null\n" +
                    "and t1.[Business Service] !=''\n" +
                    "GROUP BY t1.Opened\n" +
                    "UNION ALL\n" +
                    "--  L1 创建工单数 Request_Test\\n\" +\n" +
                    "select \n" +
                    "DATEPART(hh, t1.Opened) as OpenedTime,\n" +
                    "COUNT(*) as num \n" +
                    "from Request_Test t1 \n" +
                    "where DATEDIFF(day, t1.[Opened], GETDATE()) =0\n" +
                    "-- and t1.[Assignment Group] in (select * from L1_AssignmentGroup )\n" +
                    "and t1.[Business Service] is not null \n" +
                    "and t1.[Business Service] !=''\n" +
                    "GROUP BY t1.Opened\n" +
                    "UNION ALL\n" +
                    "-- L1 创建工单数 NewCall_Test\n" +
                    "select \n" +
                    "DATEPART(hh, t1.Opened) as OpenedTime,\n" +
                    "COUNT(*) as num \n" +
                    "from NewCall_Test t1 \n" +
                    "where DATEDIFF(day, t1.[Opened], GETDATE()) =0\n" +
                    "-- and t1.[Assignment Group] in (select * from L1_AssignmentGroup )\n" +
                    "and t1.[Business Service] is not null \n" +
                    "and t1.[Business Service] !=''\n" +
                    "GROUP BY t1.Opened\n" +
                    ") total\n" +
                    "GROUP BY total.OpenedTime"
    })
    public List<lineChartBySqlServer> selectLineChartCreateOrderNum();

    /**
     * 查询导航版-L1电话接入数
     */
    @Select({
            "select \n" +
                    "DATEPART(hh, t1.[呼叫开始时间]) as openTime,\n" +
                    "COUNT(*) as Number\n" +
                    "from Call_Test  t1\n" +
                    "where DATEDIFF(day, t1.[呼叫开始时间], GETDATE())=0\n" +
                    "GROUP BY [呼叫开始时间]\n"
    })
    public List<lineChartBySqlServer> selectLineChartPhoneRespNum();


}
