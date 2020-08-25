package com.xkcoding.multi.datasource.mybatis.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description: business_volume 实体
 * @author: smf
 * @time: 7/6/2020
 */
@Data
@TableName("business_volume")
@NoArgsConstructor
@AllArgsConstructor
public class businessVolume {

    private static final long serialVersionUID = -1923859222295750467L;

    /**
     * id
     **/
    private Integer id;
    /**
     * 时间
     **/
    private Date time;
    /***
     * 升级工单
     */
    private Integer EscalatedTickets;

    /***
     * 关闭工单
     */
    private Integer ClosedTickets;

    /***
     * 进行中工单
     */
    private Integer PendingTickets;
    /**
     * 等待工单
     */
    private Integer WaitingTickets;


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

    public Integer getEscalatedTickets() {
        return EscalatedTickets;
    }

    public void setEscalatedTickets(Integer escalatedTickets) {
        EscalatedTickets = escalatedTickets;
    }

    public Integer getClosedTickets() {
        return ClosedTickets;
    }

    public void setClosedTickets(Integer closedTickets) {
        ClosedTickets = closedTickets;
    }

    public Integer getPendingTickets() {
        return PendingTickets;
    }

    public void setPendingTickets(Integer pendingTickets) {
        PendingTickets = pendingTickets;
    }

    public Integer getWaitingTickets() {
        return WaitingTickets;
    }

    public void setWaitingTickets(Integer waitingTickets) {
        WaitingTickets = waitingTickets;
    }
}
