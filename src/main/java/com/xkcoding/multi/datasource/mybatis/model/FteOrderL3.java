package com.xkcoding.multi.datasource.mybatis.model;

import java.util.Date;

public class FteOrderL3 {
    private Integer id;

    private Date createTime;

    private String groupName;

    private Integer fte;

    private Integer total;

    private Integer respondedTickets;

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

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public Integer getFte() {
        return fte;
    }

    public void setFte(Integer fte) {
        this.fte = fte;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getRespondedTickets() {
        return respondedTickets;
    }

    public void setRespondedTickets(Integer respondedTickets) {
        this.respondedTickets = respondedTickets;
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