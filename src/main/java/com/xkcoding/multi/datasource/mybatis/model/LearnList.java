package com.xkcoding.multi.datasource.mybatis.model;

import java.math.BigDecimal;
import java.util.Date;

public class LearnList {
    private Integer id;

    private Integer batchNum;

    private Date startTiime;

    private Integer learnPersonNum;

    private Integer finishNum;

    private BigDecimal onePassRate;

    private Date createTime;

    private String teacher;

    private Integer recodeWell;

    private String lNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(Integer batchNum) {
        this.batchNum = batchNum;
    }

    public Date getStartTiime() {
        return startTiime;
    }

    public void setStartTiime(Date startTiime) {
        this.startTiime = startTiime;
    }

    public Integer getLearnPersonNum() {
        return learnPersonNum;
    }

    public void setLearnPersonNum(Integer learnPersonNum) {
        this.learnPersonNum = learnPersonNum;
    }

    public Integer getFinishNum() {
        return finishNum;
    }

    public void setFinishNum(Integer finishNum) {
        this.finishNum = finishNum;
    }

    public BigDecimal getOnePassRate() {
        return onePassRate;
    }

    public void setOnePassRate(BigDecimal onePassRate) {
        this.onePassRate = onePassRate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }

    public Integer getRecodeWell() {
        return recodeWell;
    }

    public void setRecodeWell(Integer recodeWell) {
        this.recodeWell = recodeWell;
    }

    public String getlNum() {
        return lNum;
    }

    public void setlNum(String lNum) {
        this.lNum = lNum == null ? null : lNum.trim();
    }
}