package com.xkcoding.multi.datasource.mybatis.model;

import java.math.BigDecimal;
import java.util.Date;

public class OrderComplianceAvg {
    private Integer id;

    private Date createTime;

    private BigDecimal compliAvg;

    private BigDecimal totalTime;

    private Integer size;

    private Date endTime;

    private String team;

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

    public BigDecimal getCompliAvg() {
        return compliAvg;
    }

    public void setCompliAvg(BigDecimal compliAvg) {
        this.compliAvg = compliAvg;
    }

    public BigDecimal getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(BigDecimal totalTime) {
        this.totalTime = totalTime;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team == null ? null : team.trim();
    }
}