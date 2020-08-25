package com.yida.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author guantianqi
 * @since 2020-07-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("Request")
public class Request implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("Number")
    private String Number;

    @TableField("Opened")
    private Date Opened;

    @TableField("State")
    private String State;

    @TableField("Short Description")
    private String Short_Description;

    @TableField("Contact type")
    private String Contact_type;

    @TableField("Createdby")
    private String Created_by;

    @TableField("Assigned to")
    private String Assigned_to;

    @TableField("Assignment Group")
    private String Assignment_Group;

    @TableField("Name")
    private String Name;

    @TableField("Business Service")
    private String Business_Service;

    @TableField("Active")
    private Boolean Active;

    @TableField("Requested for")
    private String Requested_for;

    @TableField("Closure comments")
    private String Closure_comments;

    @TableField("Manager")
    private String Manager;

    @TableField("Location")
    private String Location;

    @TableField("Updated")
    private Date Updated;

    @TableField("Created")
    private Date Created;

    @TableField("Closed")
    private Date Closed;

    @TableField("PRID")
    private String prid;

    @TableField("Description")
    private String Description;

    @TableField("ReqNumber")
    private String ReqNumber;

    @TableField("RitmNumber")
    private String RitmNumber;


}
