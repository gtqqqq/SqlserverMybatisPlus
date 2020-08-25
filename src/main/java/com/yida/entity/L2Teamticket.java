package com.yida.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDate;
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
 * @since 2020-07-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("L2_TeamTicket")
public class L2Teamticket implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("Total_Tickets")
    private Integer totalTickets;

    @TableField("Closed_Tickets")
    private Integer closedTickets;

    @TableField("Pending_Tickets")
    private Integer pendingTickets;

    @TableField("Waiting_Tickets")
    private Integer waitingTickets;

    @TableField("Working_Tickets")
    private Integer workingTickets;

    private Date optDate;


}
