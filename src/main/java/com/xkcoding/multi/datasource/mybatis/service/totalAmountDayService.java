package com.xkcoding.multi.datasource.mybatis.service;

import com.xkcoding.multi.datasource.mybatis.model.totalAmountDay;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: smf
 * @time: 7/14/2020 9:22 AM
 * @description: 当日受理总量服务
 */
public interface totalAmountDayService {

    /***
     * 录入 当日受理总量
     */
    public Boolean insertTotalAmountDayList(List<totalAmountDay> totalAmountDayList);

    /**
     * 清表
     */
    @Delete({
            "<script>",
            "delete from total_amount_day",
            "</script>"
    })
    public void deleteTotalAmountDay();




}
