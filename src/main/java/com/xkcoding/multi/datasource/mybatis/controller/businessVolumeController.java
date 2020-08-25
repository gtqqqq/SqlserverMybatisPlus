package com.xkcoding.multi.datasource.mybatis.controller;

import com.xkcoding.multi.datasource.mybatis.model.businessVolume;
import com.xkcoding.multi.datasource.mybatis.service.businessVolumeService;
import com.xkcoding.multi.datasource.mybatis.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: 公告板控制层
 * @author: smf
 * @time: 7/6/2020
 */
@RestController
public class businessVolumeController {

    @Autowired
    private businessVolumeService businessVolumeService;

    /**
     * 查询公告板Business Volume-ClosedTickets
     *
     * @return
     */
    @GetMapping("/selectbsvo")
    //@Scheduled(cron="${corn.time}")
    public ResponseMessage selectBusinessVolumeByClosedTickets() {
        try {
            List<businessVolume> data = new ArrayList<businessVolume>();
            businessVolume businessVolume = new businessVolume();
            //L1 Closed Tickets关闭的工单数
            List<Integer> byIncident = businessVolumeService.selectClosedTicketsByIncident();
            List<Integer> byRequest = businessVolumeService.selectClosedTicketsByRequest();
            List<Integer> byNewCall = businessVolumeService.selectClosedTicketsByNewCall();
            if (null != byIncident && byIncident.size() > 0 && null != byRequest && null != byNewCall) {
                businessVolume.setClosedTickets(byIncident.get(0) + byRequest.get(0) + byNewCall.get(0));
            }
            //L1 Pending Tickets L1未关闭的工单数
            List<Integer> byPendingIncident = businessVolumeService.selectPendingTicketsByIncident();
            List<Integer> byPendingRequest = businessVolumeService.selectPendingTicketsByRequest();
            if (null != byPendingIncident && byPendingIncident.size() > 0 && null != byPendingRequest && byPendingRequest.size() > 0) {
                businessVolume.setPendingTickets(byPendingIncident.get(0) + byPendingRequest.get(0));
            }
            //5，	Waiting Ticket
            List<Integer> byCDCIncident = businessVolumeService.selectPendingTicketsByCDCIncident();
            List<Integer> byCDCRequest = businessVolumeService.selectPendingTicketsByCDCRequest();
            if (null != byCDCIncident && byCDCIncident.size() > 0 && null != byCDCRequest && byCDCRequest.size() > 0) {
                businessVolume.setWaitingTickets(byCDCIncident.get(0) + byCDCRequest.get(0));
            }
            businessVolume.setTime(new Date());
            data.add(businessVolume);
            businessVolumeService.deleteBusinessVolume();
            businessVolumeService.insertBusinessVolumeList(data);
            return ResponseMessage.newOkInstance(data, "返回成功");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseMessage.newErrorInstance(e, "500");
        }
    }
//ProductionControl  Production_Control_Team   TotalAmountDay  TicketsVol  TargetHitTed

}
