package com.xkcoding.multi.datasource.mybatis.model;

import java.util.Date;
/**
 * @author fnchenxi
 */
public class L3TeamTicket1 {
    private Integer id;

    private Date createTime;

    private Integer totalAvailableEngineers;

    private Integer onlineEngineers;

    private Integer notReadyAgents;

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

    public Integer getTotalAvailableEngineers() {
        return totalAvailableEngineers;
    }

    public void setTotalAvailableEngineers(Integer totalAvailableEngineers) {
        this.totalAvailableEngineers = totalAvailableEngineers;
    }

    public Integer getOnlineEngineers() {
        return onlineEngineers;
    }

    public void setOnlineEngineers(Integer onlineEngineers) {
        this.onlineEngineers = onlineEngineers;
    }

    public Integer getNotReadyAgents() {
        return notReadyAgents;
    }

    public void setNotReadyAgents(Integer notReadyAgents) {
        this.notReadyAgents = notReadyAgents;
    }
}