package com.xkcoding.multi.datasource.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xkcoding.multi.datasource.mybatis.mapper.businessVolumeMapper;
import com.xkcoding.multi.datasource.mybatis.mapper.lineChartMapper;
import com.xkcoding.multi.datasource.mybatis.model.businessVolume;
import com.xkcoding.multi.datasource.mybatis.model.lineChart;
import com.xkcoding.multi.datasource.mybatis.model.lineChartBySqlServer;
import com.xkcoding.multi.datasource.mybatis.service.lineChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 导航版服务层
 * @author: smf
 * @time: 7/6/2020 9:00 PM
 */
@Service
@DS("master")
public class lineChartServiceImpl extends ServiceImpl<lineChartMapper, lineChart> implements lineChartService {

    @Autowired
    private lineChartMapper lineChartMapper;

    /***
     * 录入 折线图
     */
    @Override
    public Boolean insertLineChartList(List<lineChart> lineChartList) {
        return lineChartMapper.insertLineChartList(lineChartList);
    }

    /***
     * 清line_chart表
     */
    @Override
    public void deleteLineChart() {
        lineChartMapper.deleteLineChart();
    }

    /**
     * 查询导航版-L1关闭工单数
     */
    @DS("slave")
    @Override
    public List<lineChartBySqlServer> selectLineChartCloseOrderNum() {
        return baseMapper.selectLineChartCloseOrderNum();
    }

    /**
     * 查询导航版-L1创建工单数
     */
    @DS("slave")
    @Override
    public List<lineChartBySqlServer> selectLineChartCreateOrderNum() {
        return baseMapper.selectLineChartCreateOrderNum();
    }

    /**
     * 查询导航版-L1电话接入数
     */
    @DS("slave")
    @Override
    public List<lineChartBySqlServer> selectLineChartPhoneRespNum() {
        return baseMapper.selectLineChartPhoneRespNum();
    }


}
