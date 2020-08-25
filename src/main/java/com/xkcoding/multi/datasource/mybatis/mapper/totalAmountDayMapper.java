package com.xkcoding.multi.datasource.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xkcoding.multi.datasource.mybatis.model.slaPhoneIncident;
import com.xkcoding.multi.datasource.mybatis.model.totalAmountDay;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: smf
 * @time: 7/14/2020 9:24 AM
 * @description: 当日受理总量 持久层
 */
public interface totalAmountDayMapper extends BaseMapper<totalAmountDay> {

    /***
     * 录入 当日受理总量
     */
    @Insert({
            "<script>",
            "insert into total_amount_day(time, TicketsVol,Delivered,TargetHitTed) values ",
            "<foreach collection='totalAmountDayList' item='item' index='index' separator=','>",
            "( #{item.time}, #{item.TicketsVol},#{item.Delivered},#{item.TargetHitTed})",
            "</foreach>",
            "</script>"
    })
    public Boolean insertTotalAmountDayList(@Param("totalAmountDayList") List<totalAmountDay> totalAmountDayList);

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
