package com.xkcoding.multi.datasource.mybatis.model;

import java.util.Date;
/**
 * @author fnchenxi
 */
public class L3TeamTicket3 {
    private Integer id;

    private Date createTime;

    private Integer totalTickets;

    private Integer closedTickets;

    private Integer pendingTickets;

    private Integer waitingTickets;

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

    public Integer getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(Integer totalTickets) {
        this.totalTickets = totalTickets;
    }

    public Integer getClosedTickets() {
        return closedTickets;
    }

    public void setClosedTickets(Integer closedTickets) {
        this.closedTickets = closedTickets;
    }

    public Integer getPendingTickets() {
        return pendingTickets;
    }

    public void setPendingTickets(Integer pendingTickets) {
        this.pendingTickets = pendingTickets;
    }

    public Integer getWaitingTickets() {
        return waitingTickets;
    }

    public void setWaitingTickets(Integer waitingTickets) {
        this.waitingTickets = waitingTickets;
    }
}