package com.xkcoding.multi.datasource.mybatis.service;

import com.xkcoding.multi.datasource.mybatis.model.businessVolume;
import com.xkcoding.multi.datasource.mybatis.model.responseCall;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @description: 服务层
 * @author: smf
 * @time: 7/6/2020
 */
public interface businessVolumeService {
    /***
     * 录入 Business Volume
     */
    public Boolean insertBusinessVolumeList(List<businessVolume> businessVolumeList);

    /***
     * 清business_volume表
     */
    public void deleteBusinessVolume();

    /**
     * 查询公告板Business Volume Closed Tickets关闭的工单数ByIncident
     * @return
     */
    public List<Integer> selectClosedTicketsByIncident();


    /**
     * 查询公告板Business Volume Closed Tickets关闭的工单数ByRequest
     * @return
     */
    public List<Integer> selectClosedTicketsByRequest();

    /**
     * 查询公告板Business Volume Closed Tickets关闭的工单数ByNewCall
     * @return
     */
    public List<Integer> selectClosedTicketsByNewCall();


    /**
     * 查询公告板Business Volume Pending Tickets L1未关闭的工单数ByIncident
     * @return
     */
    public List<Integer> selectPendingTicketsByIncident();

    /**
     * 查询公告板Business Volume Pending Tickets L1未关闭的工单数ByRequest
     * @return
     */
    public List<Integer> selectPendingTicketsByRequest();

    /**
     * 查询公告板Business Volume Waiting TicketsBy:CDC_Incident
     * @return
     */
    public List<Integer> selectPendingTicketsByCDCIncident();

    /**
     * 查询公告板Business Volume Waiting TicketsBy:CDC_Request
     * @return
     */
    public List<Integer> selectPendingTicketsByCDCRequest();



}
