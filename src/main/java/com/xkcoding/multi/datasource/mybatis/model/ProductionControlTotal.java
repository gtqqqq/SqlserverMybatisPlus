package com.xkcoding.multi.datasource.mybatis.model;

import java.math.BigDecimal;
import java.util.Date;

public class ProductionControlTotal {
    private Integer id;

    private Date createTime;

    private String name;

    private Integer ticketsVol;

    private BigDecimal delivered;

    private String targetHitted;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getTicketsVol() {
        return ticketsVol;
    }

    public void setTicketsVol(Integer ticketsVol) {
        this.ticketsVol = ticketsVol;
    }

    public BigDecimal getDelivered() {
        return delivered;
    }

    public void setDelivered(BigDecimal delivered) {
        this.delivered = delivered;
    }

    public String getTargetHitted() {
        return targetHitted;
    }

    public void setTargetHitted(String targetHitted) {
        this.targetHitted = targetHitted == null ? null : targetHitted.trim();
    }

    @Override
    public String toString() {
        return "ProductionControlTotal{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", name='" + name + '\'' +
                ", ticketsVol=" + ticketsVol +
                ", delivered=" + delivered +
                ", targetHitted='" + targetHitted + '\'' +
                '}';
    }
}