package com.yida.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("daily_compliance_statistics_l3")
public class OLADailyComplianceStatisticsL3 {
    @TableId(value="id",type = IdType.AUTO)
    private Integer id;

    private String groupName;

    private Date createTime;

    private BigDecimal workAverage;

    private BigDecimal allAverage;
    @TableField("hour_0_ok")
    private BigDecimal hour0Ok;
    @TableField("hour_0_all")
    private BigDecimal hour0All;
    @TableField("hour_1_ok")
    private BigDecimal hour1Ok;
    @TableField("hour_1_all")
    private BigDecimal hour1All;
    @TableField("hour_2_ok")
    private BigDecimal hour2Ok;
    @TableField("hour_2_all")
    private BigDecimal hour2All;
    @TableField("hour_3_ok")
    private BigDecimal hour3Ok;
    @TableField("hour_3_all")
    private BigDecimal hour3All;
    @TableField("hour_4_ok")
    private BigDecimal hour4Ok;
    @TableField("hour_4_all")
    private BigDecimal hour4All;
    @TableField("hour_5_ok")
    private BigDecimal hour5Ok;
    @TableField("hour_5_all")
    private BigDecimal hour5All;
    @TableField("hour_6_ok")
    private BigDecimal hour6Ok;
    @TableField("hour_6_all")
    private BigDecimal hour6All;
    @TableField("hour_7_ok")
    private BigDecimal hour7Ok;
    @TableField("hour_7_all")
    private BigDecimal hour7All;
    @TableField("hour_8_ok")
    private BigDecimal hour8Ok;
    @TableField("hour_8_all")
    private BigDecimal hour8All;
    @TableField("hour_9_ok")
    private BigDecimal hour9Ok;
    @TableField("hour_9_all")
    private BigDecimal hour9All;
    @TableField("hour_10_ok")
    private BigDecimal hour10Ok;
    @TableField("hour_10_all")
    private BigDecimal hour10All;
    @TableField("hour_11_ok")
    private BigDecimal hour11Ok;
    @TableField("hour_11_all")
    private BigDecimal hour11All;
    @TableField("hour_12_ok")
    private BigDecimal hour12Ok;
    @TableField("hour_12_all")
    private BigDecimal hour12All;
    @TableField("hour_13_ok")
    private BigDecimal hour13Ok;
    @TableField("hour_13_all")
    private BigDecimal hour13All;
    @TableField("hour_14_ok")
    private BigDecimal hour14Ok;
    @TableField("hour_14_all")
    private BigDecimal hour14All;
    @TableField("hour_15_ok")
    private BigDecimal hour15Ok;
    @TableField("hour_15_all")
    private BigDecimal hour15All;
    @TableField("hour_16_ok")
    private BigDecimal hour16Ok;
    @TableField("hour_16_all")
    private BigDecimal hour16All;
    @TableField("hour_17_ok")
    private BigDecimal hour17Ok;
    @TableField("hour_17_all")
    private BigDecimal hour17All;
    @TableField("hour_18_ok")
    private BigDecimal hour18Ok;
    @TableField("hour_18_all")
    private BigDecimal hour18All;
    @TableField("hour_19_ok")
    private BigDecimal hour19Ok;
    @TableField("hour_19_all")
    private BigDecimal hour19All;
    @TableField("hour_20_ok")
    private BigDecimal hour20Ok;
    @TableField("hour_20_all")
    private BigDecimal hour20All;
    @TableField("hour_21_ok")
    private BigDecimal hour21Ok;
    @TableField("hour_21_all")
    private BigDecimal hour21All;
    @TableField("hour_22_ok")
    private BigDecimal hour22Ok;
    @TableField("hour_22_all")
    private BigDecimal hour22All;
    @TableField("hour_23_ok")
    private BigDecimal hour23Ok;
    @TableField("hour_23_all")
    private BigDecimal hour23All;

    private Integer workDailyCases;

    private Integer allDailyCases;

    private String type;

    private Date endTime;

    private Date resolved;


}