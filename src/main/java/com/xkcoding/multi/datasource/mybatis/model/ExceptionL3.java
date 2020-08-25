package com.xkcoding.multi.datasource.mybatis.model;

import java.util.Date;

public class ExceptionL3 {
    private Integer id;

    private Date createTime;

    private String message;

    private Integer total;

    private Integer excNumber;

    private Integer excType;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getExcNumber() {
        return excNumber;
    }

    public void setExcNumber(Integer excNumber) {
        this.excNumber = excNumber;
    }

    public Integer getExcType() {
        return excType;
    }

    public void setExcType(Integer excType) {
        this.excType = excType;
    }
}