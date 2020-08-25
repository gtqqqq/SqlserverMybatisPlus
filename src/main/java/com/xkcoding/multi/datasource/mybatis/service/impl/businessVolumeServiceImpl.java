package com.xkcoding.multi.datasource.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xkcoding.multi.datasource.mybatis.mapper.businessVolumeMapper;
import com.xkcoding.multi.datasource.mybatis.mapper.responseCallMapper;
import com.xkcoding.multi.datasource.mybatis.model.businessVolume;
import com.xkcoding.multi.datasource.mybatis.model.responseCall;
import com.xkcoding.multi.datasource.mybatis.service.businessVolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: Business Volume 服务层
 * @author: smf
 * @time: 7/6/2020
 */
@Service
@DS("master")
public class businessVolumeServiceImpl extends ServiceImpl<businessVolumeMapper, businessVolume> implements businessVolumeService {

    @Autowired
    private businessVolumeMapper businessVolumeMapper;

    /**
     * 录入Business Volume 表
     *
     * @param businessVolumeList
     * @return
     */
    @Override
    public Boolean insertBusinessVolumeList(List<businessVolume> businessVolumeList) {
        return businessVolumeMapper.insertBusinessVolumeList(businessVolumeList);
    }

    /***
     * 清business_volume表
     */
    @Override
    public void deleteBusinessVolume() {
        businessVolumeMapper.deleteBusinessVolume();
    }

    /**
     * 查询公告板Business Volume Closed Tickets关闭的工单数
     *
     * @return
     */
    @DS("slave")
    @Override
    public List<Integer> selectClosedTicketsByIncident() {
        return baseMapper.selectClosedTicketsByIncident();
    }

    /**
     * 查询公告板Business Volume Closed Tickets关闭的工单数ByRequest
     *
     * @return
     */
    @DS("slave")
    @Override
    public List<Integer> selectClosedTicketsByRequest() {
        return baseMapper.selectClosedTicketsByRequest();
    }

    /**
     * 查询公告板Business Volume Closed Tickets关闭的工单数ByNewCall
     *
     * @return
     */
    @DS("slave")
    @Override
    public List<Integer> selectClosedTicketsByNewCall() {
        return baseMapper.selectClosedTicketsByNewCall();
    }

    /**
     * 查询公告板Business Volume Pending Tickets L1未关闭的工单数ByIncident
     *
     * @return
     */
    @DS("slave")
    @Override
    public List<Integer> selectPendingTicketsByIncident() {
        return baseMapper.selectPendingTicketsByIncident();
    }

    /**
     * 查询公告板Business Volume Pending Tickets L1未关闭的工单数ByRequest
     *
     * @return
     */
    @DS("slave")
    @Override
    public List<Integer> selectPendingTicketsByRequest() {
        return baseMapper.selectPendingTicketsByRequest();
    }

    /**
     * 查询公告板Business Volume Waiting TicketsBy:CDC_Incident
     *
     * @return
     */
    @DS("slave")
    @Override
    public List<Integer> selectPendingTicketsByCDCIncident() {
        return baseMapper.selectPendingTicketsByCDCIncident();
    }

    /**
     * 查询公告板Business Volume Waiting TicketsBy:CDC_Request
     *
     * @return
     */
    @DS("slave")
    @Override
    public List<Integer> selectPendingTicketsByCDCRequest() {
        return baseMapper.selectPendingTicketsByCDCRequest();
    }
}
