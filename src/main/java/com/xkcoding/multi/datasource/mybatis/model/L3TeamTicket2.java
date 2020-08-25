package com.xkcoding.multi.datasource.mybatis.model;

import java.util.Date;
/**
 * @author fnchenxi
 */
public class L3TeamTicket2 {
    private Integer id;

    private Date createTime;

    private Date avgHandledTime;

    private Date avgWaitTime;

    private Date maxProcessingTime;

    private Date maxWaitTime;

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

    public Date getAvgHandledTime() {
        return avgHandledTime;
    }

    public void setAvgHandledTime(Date avgHandledTime) {
        this.avgHandledTime = avgHandledTime;
    }

    public Date getAvgWaitTime() {
        return avgWaitTime;
    }

    public void setAvgWaitTime(Date avgWaitTime) {
        this.avgWaitTime = avgWaitTime;
    }

    public Date getMaxProcessingTime() {
        return maxProcessingTime;
    }

    public void setMaxProcessingTime(Date maxProcessingTime) {
        this.maxProcessingTime = maxProcessingTime;
    }

    public Date getMaxWaitTime() {
        return maxWaitTime;
    }

    public void setMaxWaitTime(Date maxWaitTime) {
        this.maxWaitTime = maxWaitTime;
    }
}