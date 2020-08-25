package com.xkcoding.multi.datasource.mybatis.model;

import java.util.Date;

public class ProductionControl {
    private Integer id;

    private Date createTime;

    private Integer totalNum;

    private Integer responded;

    private Integer closeNum;

    private String assignmentGroup;

    private Integer mark;

    private Integer sourceType;

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    private Date endTime;

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

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getResponded() {
        return responded;
    }

    public void setResponded(Integer responded) {
        this.responded = responded;
    }

    public Integer getCloseNum() {
        return closeNum;
    }

    public void setCloseNum(Integer closeNum) {
        this.closeNum = closeNum;
    }

    public String getAssignmentGroup() {
        return assignmentGroup;
    }

    public void setAssignmentGroup(String assignmentGroup) {
        this.assignmentGroup = assignmentGroup == null ? null : assignmentGroup.trim();
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }
}