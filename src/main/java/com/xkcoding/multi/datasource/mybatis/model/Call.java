package com.xkcoding.multi.datasource.mybatis.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Call表实体
 */
@Data
@TableName("Call")
@NoArgsConstructor
@AllArgsConstructor
public class Call implements Serializable {
    private static final long serialVersionUID = -1923859222295750467L;
    /**
     * 节点 ID - 会话 ID - 序号
     **/
    private String numBer;
    /**
     * 呼叫开始时间
     **/
    private Date startTime;
    /**
     * 呼叫结束时间
     **/
    private Date endTime;
    /**
     * 联系处置 1 未响应 2 响应
     **/
    private Double lxCz;
    /**
     * 发起方
     **/
    private Double fqf;
    /**
     * 目标 DN
     **/
    private Double mbDn;
    /**
     * 被叫号码
     **/
    private Double bjNumber;
    /**
     * 应用程序名称
     **/
    private String yycXmc;
    /**
     * 联系服务队列名称
     **/
    private String lxFuDlMc;
    /**
     * 排队时间
     **/
    private Date queuingTime;
    /**
     * 座席姓名
     **/
    private String zxMc;
    /**
     * 振铃时间
     **/
    private Date zlSj;
    /**
     * 通话时间
     **/
    private Date thSj;
    /**
     * 工作时间
     **/
    private Date gzSj;
    /**
     * 账号
     **/
    private String zh;
    /**
     * 问题类型
     **/
    private String wtLx;
    /**
     * CTI_一级
     **/
    private String ctiOne;
    /**
     * CTI_二级
     **/
    private String ctiTwo;
    /**
     * 来电小时
     **/
    private Double ldXs;

    public String getNumBer() {
        return numBer;
    }

    public void setNumBer(String numBer) {
        this.numBer = numBer;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Double getLxCz() {
        return lxCz;
    }

    public void setLxCz(Double lxCz) {
        this.lxCz = lxCz;
    }

    public Double getFqf() {
        return fqf;
    }

    public void setFqf(Double fqf) {
        this.fqf = fqf;
    }

    public Double getMbDn() {
        return mbDn;
    }

    public void setMbDn(Double mbDn) {
        this.mbDn = mbDn;
    }

    public Double getBjNumber() {
        return bjNumber;
    }

    public void setBjNumber(Double bjNumber) {
        this.bjNumber = bjNumber;
    }

    public String getYycXmc() {
        return yycXmc;
    }

    public void setYycXmc(String yycXmc) {
        this.yycXmc = yycXmc;
    }

    public String getLxFuDlMc() {
        return lxFuDlMc;
    }

    public void setLxFuDlMc(String lxFuDlMc) {
        this.lxFuDlMc = lxFuDlMc;
    }

    public Date getQueuingTime() {
        return queuingTime;
    }

    public void setQueuingTime(Date queuingTime) {
        this.queuingTime = queuingTime;
    }

    public String getZxMc() {
        return zxMc;
    }

    public void setZxMc(String zxMc) {
        this.zxMc = zxMc;
    }

    public Date getZlSj() {
        return zlSj;
    }

    public void setZlSj(Date zlSj) {
        this.zlSj = zlSj;
    }

    public Date getThSj() {
        return thSj;
    }

    public void setThSj(Date thSj) {
        this.thSj = thSj;
    }

    public Date getGzSj() {
        return gzSj;
    }

    public void setGzSj(Date gzSj) {
        this.gzSj = gzSj;
    }

    public String getZh() {
        return zh;
    }

    public void setZh(String zh) {
        this.zh = zh;
    }

    public String getWtLx() {
        return wtLx;
    }

    public void setWtLx(String wtLx) {
        this.wtLx = wtLx;
    }

    public String getCtiOne() {
        return ctiOne;
    }

    public void setCtiOne(String ctiOne) {
        this.ctiOne = ctiOne;
    }

    public String getCtiTwo() {
        return ctiTwo;
    }

    public void setCtiTwo(String ctiTwo) {
        this.ctiTwo = ctiTwo;
    }

    public Double getLdXs() {
        return ldXs;
    }

    public void setLdXs(Double ldXs) {
        this.ldXs = ldXs;
    }
}
