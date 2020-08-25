package com.xkcoding.multi.datasource.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xkcoding.multi.datasource.mybatis.model.businessVolume;
import com.xkcoding.multi.datasource.mybatis.model.responseWorkOrder;
import com.xkcoding.multi.datasource.mybatis.model.serviceLevelLaborProductivity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: smf
 * @time: 7/12/2020 6:49 PM
 * @description: 作业生产量管控- L1关单量 持久层
 */
public interface serviceLevelLaborProductivityMapper extends BaseMapper<serviceLevelLaborProductivity> {

    /***
     * 录入 Business Volume
     */
    @Insert({
            "<script>",
            "insert into service_level_Labor_Productivity(time, FTE,AVGTickets,TargetHitTed,ChGroup,EsmGroup,AAGroup) values ",
            "<foreach collection='serviceLevelLaborProductivityList' item='item' index='index' separator=','>",
            "( #{item.time}, #{item.FTE},#{item.AVGTickets},#{item.TargetHitTed},#{item.ChGroup},#{item.EsmGroup},#{item.AAGroup})",
            "</foreach>",
            "</script>"
    })
    public Boolean insertServiceLevelLaborProductivity(@Param("serviceLevelLaborProductivityList") List<serviceLevelLaborProductivity> serviceLevelLaborProductivityList);


    /***
     * 清business_volume表
     */
    @Delete({
            "<script>",
            "delete from service_level_Labor_Productivity",
            "</script>"
    })
    public void deleteServiceLevelLaborProductivity();

    /**
     * FTE-指人数  TODO ！！
     *
     * @return
     */
    @Select({
            "select \n" +
                    "COUNT(*) as num \n" +
                    "from Incident_Test t1 "
    })
    public Integer selectServiceLevelLaborProductByPerson();


}
