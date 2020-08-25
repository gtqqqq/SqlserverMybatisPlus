package com.yida.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
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
 * @since 2020-07-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("L2Request")
public class L2Request implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("Number")
    private String Number;

    @TableField("Requested for")
    private String Requested_for;

    @TableField("PRID")
    private String prid;

    @TableField("Short description")
    private String Short_description;

    @TableField("Priority")
    private String Priority;

    @TableField("State")
    private String State;

    @TableField("Assignment group")
    private String Assignment_group;

    @TableField("Name")
    private String Name;

    @TableField("Closed by")
    private String Closed_by;

    @TableField("Opened")
    private LocalDateTime Opened;

    @TableField("Actual Start")
    private LocalDateTime Actual_Start;

    @TableField("Actual End")
    private LocalDateTime Actual_End;

    @TableField("Duration")
    private Float Duration;

    @TableField("Closed")
    private LocalDateTime Closed;

    @TableField("Resolve Time")
    private String Resolve_Time;

    @TableField("Closure comments")
    private String Closure_comments;

    @TableField("Configuration item")
    private String Configuration_item;

    @TableField("Made SLA")
    private Boolean Made_SLA;

    @TableField("Description")
    private String Description;

    @TableField("Opened by")
    private String Opened_by;

    @TableField("Contact type")
    private String Contact_type;

    @TableField("Application")
    private String Application;

    @TableField("Category")
    private String Category;

    @TableField("CnDescription")
    private String CnDescription;

    @TableField("Hour")
    private String Hour;

    @TableField("SubApplication")
    private String SubApplication;


}
