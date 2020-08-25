package com.xkcoding.multi.datasource.mybatis.model;

import java.util.Date;
/**
 * @author fnchenxi
 */
public class TodayTotalModel {
    private Integer id;

    private Integer createNum;

    private Integer closeNum;

    private Integer finish;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreateNum() {
        return createNum;
    }

    public void setCreateNum(Integer createNum) {
        this.createNum = createNum;
    }

    public Integer getCloseNum() {
        return closeNum;
    }

    public void setCloseNum(Integer closeNum) {
        this.closeNum = closeNum;
    }

    public Integer getFinish() {
        return finish;
    }

    public void setFinish(Integer finish) {
        this.finish = finish;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "TodayTotalModel{" +
                "id=" + id +
                ", createNum=" + createNum +
                ", closeNum=" + closeNum +
                ", finish=" + finish +
                ", createTime=" + createTime +
                '}';
    }
}