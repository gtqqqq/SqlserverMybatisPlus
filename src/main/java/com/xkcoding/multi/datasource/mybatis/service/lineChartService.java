package com.xkcoding.multi.datasource.mybatis.service;

import com.xkcoding.multi.datasource.mybatis.model.businessVolume;
import com.xkcoding.multi.datasource.mybatis.model.lineChart;
import com.xkcoding.multi.datasource.mybatis.model.lineChartBySqlServer;

import java.util.List;

/**
 * @author: smf 运营综合导航版 折线服务
 * @time: 7/6/2020 8:59 PM
 * @description:
 */
public interface lineChartService {

    /***
     * 录入 折线图
     */
    public Boolean insertLineChartList(List<lineChart> lineChartList);

    /***
     * 清line_chart表
     */
    public void deleteLineChart();

    /**
     * 查询导航版-L1关闭工单数
     */
    public List<lineChartBySqlServer> selectLineChartCloseOrderNum();


    /**
     * 查询导航版-L1创建工单数
     */
    public List<lineChartBySqlServer> selectLineChartCreateOrderNum();


    /**
     * 查询导航版-L1电话接入数
     */
    public List<lineChartBySqlServer> selectLineChartPhoneRespNum();

}
