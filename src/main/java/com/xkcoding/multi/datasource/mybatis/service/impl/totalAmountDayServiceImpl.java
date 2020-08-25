package com.xkcoding.multi.datasource.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xkcoding.multi.datasource.mybatis.mapper.totalAmountDayMapper;
import com.xkcoding.multi.datasource.mybatis.model.totalAmountDay;
import com.xkcoding.multi.datasource.mybatis.service.totalAmountDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 当日受理总量服务
 * @author: smf
 * @time: 7/14/2020 9:22 AM
 */
@Service
@DS("master")
public class totalAmountDayServiceImpl extends ServiceImpl<totalAmountDayMapper, totalAmountDay> implements totalAmountDayService {
    @Autowired
    private totalAmountDayMapper totalAmountDayMapper;

    /***
     * 录入 当日受理总量
     */
    @Override
    public Boolean insertTotalAmountDayList(List<totalAmountDay> totalAmountDayList) {
        return totalAmountDayMapper.insertTotalAmountDayList(totalAmountDayList);
    }

    /**
     * 清表
     */
    @Override
    public void deleteTotalAmountDay() {
        totalAmountDayMapper.deleteTotalAmountDay();
    }
}
