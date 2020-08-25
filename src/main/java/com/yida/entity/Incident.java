package com.yida.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

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
@TableName("Incident")
public class Incident implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("Created")
    private Date Created;

    @TableField("Opened")
    private Date Opened;

    @TableId("Number")
    private String Number;

    @TableField("Priority")
    private String Priority;

    @TableField("Short Description")
    private String Short_Description;

    @TableField("Task type")
    private String Task_type;

    @TableField("Display Name")
    private String Display_Name;

    @TableField("User name")
    private String User_name;

    @TableField("Resolved")
    private Date Resolved;

    @TableField("PRID")
    private String prid;

    @TableField("Caller")
    private String Caller;

    @TableField("Contact type")
    private String Contact_type;

    @TableField("Created by")
    private String Created_by;

    @TableField("State")
    private String State;

    @TableField("Assignment Group")
    private String Assignment_Group;

    @TableField("Assigned to")
    private String Assigned_to;

    @TableField("Opened by")
    private String Opened_by;

    @TableField("Resolve time")
    private Integer Resolve_time;

    @TableField("Resolved by")
    private String Resolved_by;

    @TableField("Duration")
    private Float Duration;

    @TableField("Reopen count")
    private Float Reopen_count;

    @TableField("Reassignment count")
    private Float Reassignment_count;

    @TableField("Updated")
    private Date Updated;

    @TableField("Updates")
    private String Updates;

    @TableField("Sys Update")
    private Float Sys_Update;

    @TableField("Description")
    private String Description;

    @TableField("Configuration item")
    private String Configuration_item;

    @TableField("First Contact Resolution")
    private Boolean First_Contact_Resolution;

    @TableField("Owned By")
    private String Owned_By;

    @TableField("Business Service")
    private String Business_Service;

    @TableField("User type")
    private String User_type;

    @TableField("Close notes")
    private String Close_notes;

    @TableField("Category")
    private String Category;

    @TableField("Business Service Subcategory")
    private String Business_Service_Subcategory;

    @TableField("3rd Party External")
    private Boolean _3rd_Party_External;

    @TableField("IT Function")
    private String IT_Function;

    @TableField("Parent Incident")
    private String Parent_Incident;

    @TableField("Location")
    private String Location;

    @TableField("Knowledge Used?")
    private String Knowledge_Used;


}
