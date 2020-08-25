package com.xkcoding.multi.datasource.mybatis.model;

import java.util.Date;

public class CrComplaint {
    private Integer id;

    private String lNum;

    private Integer crComplaintNum;

    private String complaintCheck;

    private String groupName;

    private String complaintName;

    private Date time;

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
        this.lNum = lNum;
    }

    public Integer getCrComplaintNum() {
        return crComplaintNum;
    }

    public void setCrComplaintNum(Integer crComplaintNum) {
        this.crComplaintNum = crComplaintNum;
    }

    public String getComplaintCheck() {
        return complaintCheck;
    }

    public void setComplaintCheck(String complaintCheck) {
        this.complaintCheck = complaintCheck == null ? null : complaintCheck.trim();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getComplaintName() {
        return complaintName;
    }

    public void setComplaintName(String complaintName) {
        this.complaintName = complaintName == null ? null : complaintName.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}