package com.xkcoding.multi.datasource.mybatis.model;

import java.math.BigDecimal;
import java.util.Date;

public class OrderUpL1 {
    private Integer id;

    private Date createTime;

    private Integer total;

    private Integer orderNumber;

    private Integer sourceType;

    private String groupName;

    private Integer fte;

    private Integer avgTickets;

    private Integer respondedTickets;

    private BigDecimal escalationTickets;

    private Integer mark;

    public Integer getToNextNumber() {
        return toNextNumber;
    }

    public void setToNextNumber(Integer toNextNumber) {
        this.toNextNumber = toNextNumber;
    }

    /** 2020 08 10 新增字段
     * 转出单量
     */
    private  Integer toNextNumber;

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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
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

    public Integer getAvgTickets() {
        return avgTickets;
    }

    public void setAvgTickets(Integer avgTickets) {
        this.avgTickets = avgTickets;
    }

    public Integer getRespondedTickets() {
        return respondedTickets;
    }

    public void setRespondedTickets(Integer respondedTickets) {
        this.respondedTickets = respondedTickets;
    }

    public BigDecimal getEscalationTickets() {
        return escalationTickets;
    }

    public void setEscalationTickets(BigDecimal escalationTickets) {
        this.escalationTickets = escalationTickets;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }
}