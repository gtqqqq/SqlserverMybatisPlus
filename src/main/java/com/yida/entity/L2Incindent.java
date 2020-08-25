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
@TableName("L2Incindent")
public class L2Incindent implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("Number")
    private String Number;

    @TableField("Caller")
    private String Caller;

    @TableField("PRID")
    private String prid;

    @TableField("Shortdescription")
    private String Short_description;

    @TableField("Priority")
    private String Priority;

    @TableField("Incident state")
    private String Incident_state;

    @TableField("Assignment group")
    private String Assignment_group;

    @TableField("Name")
    private String Name;

    @TableField("Resolved by")
    private String Resolved_by;

    @TableField("Opened")
    private LocalDateTime Opened;

    @TableField("Actual Start")
    private LocalDateTime Actual_Start;

    @TableField("Duration")
    private Float Duration;

    @TableField("Resolved")
    private LocalDateTime Resolved;

    @TableField("Actual resolved time")
    private Float Actual_resolved_time;

    @TableField("Close notes")
    private String Close_notes;

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

    @TableField("Business Service")
    private String Business_Service;

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
