package com.xkcoding.multi.datasource.mybatis.model;

import java.util.Date;

public class SecurityIncident {
    private Integer id;

    private Date time;

    private String seclevel;

    private String secEventtype;

    private Integer secnumber;

    private String lineNum;

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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getSeclevel() {
        return seclevel;
    }

    public void setSeclevel(String seclevel) {
        this.seclevel = seclevel == null ? null : seclevel.trim();
    }

    public String getSecEventtype() {
        return secEventtype;
    }

    public void setSecEventtype(String secEventtype) {
        this.secEventtype = secEventtype == null ? null : secEventtype.trim();
    }

    public Integer getSecnumber() {
        return secnumber;
    }

    public void setSecnumber(Integer secnumber) {
        this.secnumber = secnumber;
    }

    public String getLineNum() {
        return lineNum;
    }

    public void setLineNum(String lineNum) {
        this.lineNum = lineNum;
    }
}