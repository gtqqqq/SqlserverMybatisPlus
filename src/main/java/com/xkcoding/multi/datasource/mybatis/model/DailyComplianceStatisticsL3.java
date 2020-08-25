package com.xkcoding.multi.datasource.mybatis.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class DailyComplianceStatisticsL3 {
    private Integer id;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private BigDecimal workAverage;

    private BigDecimal allAverage;

    private BigDecimal hour0Ok;

    private BigDecimal hour0All;

    private BigDecimal hour1Ok;

    private BigDecimal hour1All;

    private BigDecimal hour2Ok;

    private BigDecimal hour2All;

    private BigDecimal hour3Ok;

    private BigDecimal hour3All;

    private BigDecimal hour4Ok;

    private BigDecimal hour4All;

    private BigDecimal hour5Ok;

    private BigDecimal hour5All;

    private BigDecimal hour6Ok;

    private BigDecimal hour6All;

    private BigDecimal hour7Ok;

    private BigDecimal hour7All;

    private BigDecimal hour8Ok;

    private BigDecimal hour8All;

    private BigDecimal hour9Ok;

    private BigDecimal hour9All;

    private BigDecimal hour10Ok;

    private BigDecimal hour10All;

    private BigDecimal hour11Ok;

    private BigDecimal hour11All;

    private BigDecimal hour12Ok;

    private BigDecimal hour12All;

    private BigDecimal hour13Ok;

    private BigDecimal hour13All;

    private BigDecimal hour14Ok;

    private BigDecimal hour14All;

    private BigDecimal hour15Ok;

    private BigDecimal hour15All;

    private BigDecimal hour16Ok;

    private BigDecimal hour16All;

    private BigDecimal hour17Ok;

    private BigDecimal hour17All;

    private BigDecimal hour18Ok;

    private BigDecimal hour18All;

    private BigDecimal hour19Ok;

    private BigDecimal hour19All;

    private BigDecimal hour20Ok;

    private BigDecimal hour20All;

    private BigDecimal hour21Ok;

    private BigDecimal hour21All;

    private BigDecimal hour22Ok;

    private BigDecimal hour22All;

    private BigDecimal hour23Ok;

    private BigDecimal hour23All;

    private Integer workDailyCases;

    private Integer allDailyCases;

    private String type;

    public Date getResolved() {
        return resolved;
    }

    public void setResolved(Date resolved) {
        this.resolved = resolved;
    }

    private Date resolved;

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    private Date endTime;



    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    private String groupName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getWorkAverage() {
        return workAverage;
    }

    public void setWorkAverage(BigDecimal workAverage) {
        this.workAverage = workAverage;
    }

    public BigDecimal getAllAverage() {
        return allAverage;
    }

    public void setAllAverage(BigDecimal allAverage) {
        this.allAverage = allAverage;
    }

    public BigDecimal getHour0Ok() {
        return hour0Ok;
    }

    public void setHour0Ok(BigDecimal hour0Ok) {
        this.hour0Ok = hour0Ok;
    }

    public BigDecimal getHour0All() {
        return hour0All;
    }

    public void setHour0All(BigDecimal hour0All) {
        this.hour0All = hour0All;
    }

    public BigDecimal getHour1Ok() {
        return hour1Ok;
    }

    public void setHour1Ok(BigDecimal hour1Ok) {
        this.hour1Ok = hour1Ok;
    }

    public BigDecimal getHour1All() {
        return hour1All;
    }

    public void setHour1All(BigDecimal hour1All) {
        this.hour1All = hour1All;
    }

    public BigDecimal getHour2Ok() {
        return hour2Ok;
    }

    public void setHour2Ok(BigDecimal hour2Ok) {
        this.hour2Ok = hour2Ok;
    }

    public BigDecimal getHour2All() {
        return hour2All;
    }

    public void setHour2All(BigDecimal hour2All) {
        this.hour2All = hour2All;
    }

    public BigDecimal getHour3Ok() {
        return hour3Ok;
    }

    public void setHour3Ok(BigDecimal hour3Ok) {
        this.hour3Ok = hour3Ok;
    }

    public BigDecimal getHour3All() {
        return hour3All;
    }

    public void setHour3All(BigDecimal hour3All) {
        this.hour3All = hour3All;
    }

    public BigDecimal getHour4Ok() {
        return hour4Ok;
    }

    public void setHour4Ok(BigDecimal hour4Ok) {
        this.hour4Ok = hour4Ok;
    }

    public BigDecimal getHour4All() {
        return hour4All;
    }

    public void setHour4All(BigDecimal hour4All) {
        this.hour4All = hour4All;
    }

    public BigDecimal getHour5Ok() {
        return hour5Ok;
    }

    public void setHour5Ok(BigDecimal hour5Ok) {
        this.hour5Ok = hour5Ok;
    }

    public BigDecimal getHour5All() {
        return hour5All;
    }

    public void setHour5All(BigDecimal hour5All) {
        this.hour5All = hour5All;
    }

    public BigDecimal getHour6Ok() {
        return hour6Ok;
    }

    public void setHour6Ok(BigDecimal hour6Ok) {
        this.hour6Ok = hour6Ok;
    }

    public BigDecimal getHour6All() {
        return hour6All;
    }

    public void setHour6All(BigDecimal hour6All) {
        this.hour6All = hour6All;
    }

    public BigDecimal getHour7Ok() {
        return hour7Ok;
    }

    public void setHour7Ok(BigDecimal hour7Ok) {
        this.hour7Ok = hour7Ok;
    }

    public BigDecimal getHour7All() {
        return hour7All;
    }

    public void setHour7All(BigDecimal hour7All) {
        this.hour7All = hour7All;
    }

    public BigDecimal getHour8Ok() {
        return hour8Ok;
    }

    public void setHour8Ok(BigDecimal hour8Ok) {
        this.hour8Ok = hour8Ok;
    }

    public BigDecimal getHour8All() {
        return hour8All;
    }

    public void setHour8All(BigDecimal hour8All) {
        this.hour8All = hour8All;
    }

    public BigDecimal getHour9Ok() {
        return hour9Ok;
    }

    public void setHour9Ok(BigDecimal hour9Ok) {
        this.hour9Ok = hour9Ok;
    }

    public BigDecimal getHour9All() {
        return hour9All;
    }

    public void setHour9All(BigDecimal hour9All) {
        this.hour9All = hour9All;
    }

    public BigDecimal getHour10Ok() {
        return hour10Ok;
    }

    public void setHour10Ok(BigDecimal hour10Ok) {
        this.hour10Ok = hour10Ok;
    }

    public BigDecimal getHour10All() {
        return hour10All;
    }

    public void setHour10All(BigDecimal hour10All) {
        this.hour10All = hour10All;
    }

    public BigDecimal getHour11Ok() {
        return hour11Ok;
    }

    public void setHour11Ok(BigDecimal hour11Ok) {
        this.hour11Ok = hour11Ok;
    }

    public BigDecimal getHour11All() {
        return hour11All;
    }

    public void setHour11All(BigDecimal hour11All) {
        this.hour11All = hour11All;
    }

    public BigDecimal getHour12Ok() {
        return hour12Ok;
    }

    public void setHour12Ok(BigDecimal hour12Ok) {
        this.hour12Ok = hour12Ok;
    }

    public BigDecimal getHour12All() {
        return hour12All;
    }

    public void setHour12All(BigDecimal hour12All) {
        this.hour12All = hour12All;
    }

    public BigDecimal getHour13Ok() {
        return hour13Ok;
    }

    public void setHour13Ok(BigDecimal hour13Ok) {
        this.hour13Ok = hour13Ok;
    }

    public BigDecimal getHour13All() {
        return hour13All;
    }

    public void setHour13All(BigDecimal hour13All) {
        this.hour13All = hour13All;
    }

    public BigDecimal getHour14Ok() {
        return hour14Ok;
    }

    public void setHour14Ok(BigDecimal hour14Ok) {
        this.hour14Ok = hour14Ok;
    }

    public BigDecimal getHour14All() {
        return hour14All;
    }

    public void setHour14All(BigDecimal hour14All) {
        this.hour14All = hour14All;
    }

    public BigDecimal getHour15Ok() {
        return hour15Ok;
    }

    public void setHour15Ok(BigDecimal hour15Ok) {
        this.hour15Ok = hour15Ok;
    }

    public BigDecimal getHour15All() {
        return hour15All;
    }

    public void setHour15All(BigDecimal hour15All) {
        this.hour15All = hour15All;
    }

    public BigDecimal getHour16Ok() {
        return hour16Ok;
    }

    public void setHour16Ok(BigDecimal hour16Ok) {
        this.hour16Ok = hour16Ok;
    }

    public BigDecimal getHour16All() {
        return hour16All;
    }

    public void setHour16All(BigDecimal hour16All) {
        this.hour16All = hour16All;
    }

    public BigDecimal getHour17Ok() {
        return hour17Ok;
    }

    public void setHour17Ok(BigDecimal hour17Ok) {
        this.hour17Ok = hour17Ok;
    }

    public BigDecimal getHour17All() {
        return hour17All;
    }

    public void setHour17All(BigDecimal hour17All) {
        this.hour17All = hour17All;
    }

    public BigDecimal getHour18Ok() {
        return hour18Ok;
    }

    public void setHour18Ok(BigDecimal hour18Ok) {
        this.hour18Ok = hour18Ok;
    }

    public BigDecimal getHour18All() {
        return hour18All;
    }

    public void setHour18All(BigDecimal hour18All) {
        this.hour18All = hour18All;
    }

    public BigDecimal getHour19Ok() {
        return hour19Ok;
    }

    public void setHour19Ok(BigDecimal hour19Ok) {
        this.hour19Ok = hour19Ok;
    }

    public BigDecimal getHour19All() {
        return hour19All;
    }

    public void setHour19All(BigDecimal hour19All) {
        this.hour19All = hour19All;
    }

    public BigDecimal getHour20Ok() {
        return hour20Ok;
    }

    public void setHour20Ok(BigDecimal hour20Ok) {
        this.hour20Ok = hour20Ok;
    }

    public BigDecimal getHour20All() {
        return hour20All;
    }

    public void setHour20All(BigDecimal hour20All) {
        this.hour20All = hour20All;
    }

    public BigDecimal getHour21Ok() {
        return hour21Ok;
    }

    public void setHour21Ok(BigDecimal hour21Ok) {
        this.hour21Ok = hour21Ok;
    }

    public BigDecimal getHour21All() {
        return hour21All;
    }

    public void setHour21All(BigDecimal hour21All) {
        this.hour21All = hour21All;
    }

    public BigDecimal getHour22Ok() {
        return hour22Ok;
    }

    public void setHour22Ok(BigDecimal hour22Ok) {
        this.hour22Ok = hour22Ok;
    }

    public BigDecimal getHour22All() {
        return hour22All;
    }

    public void setHour22All(BigDecimal hour22All) {
        this.hour22All = hour22All;
    }

    public BigDecimal getHour23Ok() {
        return hour23Ok;
    }

    public void setHour23Ok(BigDecimal hour23Ok) {
        this.hour23Ok = hour23Ok;
    }

    public BigDecimal getHour23All() {
        return hour23All;
    }

    public void setHour23All(BigDecimal hour23All) {
        this.hour23All = hour23All;
    }

    public Integer getWorkDailyCases() {
        return workDailyCases;
    }

    public void setWorkDailyCases(Integer workDailyCases) {
        this.workDailyCases = workDailyCases;
    }

    public Integer getAllDailyCases() {
        return allDailyCases;
    }

    public void setAllDailyCases(Integer allDailyCases) {
        this.allDailyCases = allDailyCases;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}