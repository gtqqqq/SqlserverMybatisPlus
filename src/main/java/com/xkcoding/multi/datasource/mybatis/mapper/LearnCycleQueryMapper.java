package com.xkcoding.multi.datasource.mybatis.mapper;

import com.xkcoding.multi.datasource.mybatis.model.LearnCycle;
import org.apache.ibatis.annotations.Select;

public interface LearnCycleQueryMapper {

    /**
     * 查询课程数1
     * @return
     */
    @Select(" select count(DISTINCT(system)) from [New HiresTraining] where datediff(day, date ,getdate())=0  ")
    Integer getCourseNumberByNewHiresTraining();


    /**
     * 查询课程数2
     * @return
     */
    @Select(" select count(DISTINCT([KT Contents])) from [CDC L3_KT Schedule] where datediff(day, date ,getdate())=0 ")
    Integer getCourseNumberBySchedule();

    /**
     * 查询人数1
     * @return
     */
    @Select(" select count(DISTINCT(Trainer)) from [New HiresTraining] where datediff(day, date ,getdate())=0 ")
    Integer getPersionNumByNewHiresTraining();

    /**
     * 查询人数2
     * @return
     */
    @Select(" select count(DISTINCT(name)) from [Refresh Training] where datediff(day, [start date] ,getdate())=0 ")
    Integer getPersionNumByTraining();

    /**
     * 查询人数3
     * @return
     */
    @Select(" select count(DISTINCT([KT Owner])) from [CDC L3_KT Schedule] where datediff(day, date ,getdate())=0 ")
    Integer getPersionNumBySchedule();


}