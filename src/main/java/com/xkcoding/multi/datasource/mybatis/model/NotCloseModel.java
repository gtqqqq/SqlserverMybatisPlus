package com.xkcoding.multi.datasource.mybatis.model;

import java.util.Date;
/**
 * @author fnchenxi
 */
public class NotCloseModel {
    private Integer id;

    private Integer notCloseNum;

    private Integer stopNum;

    private Integer ongoingNum;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNotCloseNum() {
        return notCloseNum;
    }

    public void setNotCloseNum(Integer notCloseNum) {
        this.notCloseNum = notCloseNum;
    }

    public Integer getStopNum() {
        return stopNum;
    }

    public void setStopNum(Integer stopNum) {
        this.stopNum = stopNum;
    }

    public Integer getOngoingNum() {
        return ongoingNum;
    }

    public void setOngoingNum(Integer ongoingNum) {
        this.ongoingNum = ongoingNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "NotCloseModel{" +
                "id=" + id +
                ", notCloseNum=" + notCloseNum +
                ", stopNum=" + stopNum +
                ", ongoingNum=" + ongoingNum +
                ", createTime=" + createTime +
                '}';
    }
}