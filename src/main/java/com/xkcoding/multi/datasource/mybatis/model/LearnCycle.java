package com.xkcoding.multi.datasource.mybatis.model;

import java.util.Date;

public class LearnCycle {
    private Integer id;

    private String lNum;

    private Integer learnCycle;

    private Integer learnTurn;

    private Date createDate;

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

    public String getlNum() {
        return lNum;
    }

    public void setlNum(String lNum) {
        this.lNum = lNum == null ? null : lNum.trim();
    }

    public Integer getLearnCycle() {
        return learnCycle;
    }

    public void setLearnCycle(Integer learnCycle) {
        this.learnCycle = learnCycle;
    }

    public Integer getLearnTurn() {
        return learnTurn;
    }

    public void setLearnTurn(Integer learnTurn) {
        this.learnTurn = learnTurn;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}