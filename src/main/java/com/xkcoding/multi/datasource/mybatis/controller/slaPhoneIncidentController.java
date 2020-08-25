package com.xkcoding.multi.datasource.mybatis.controller;

import com.xkcoding.multi.datasource.mybatis.model.slaCompliancePhoneIncidentSqlServer;
import com.xkcoding.multi.datasource.mybatis.model.slaPhoneIncident;
import com.xkcoding.multi.datasource.mybatis.service.slaPhoneIncidentService;
import com.xkcoding.multi.datasource.mybatis.util.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: 第一通电话解决率 以及一线解决率 控制层
 * @author: smf
 * @time: 7/10/2020 12:20 PM
 */
@Slf4j
@RestController
public class slaPhoneIncidentController {

    @Autowired
    private slaPhoneIncidentService slaPhoneIncidentService;

    /**
     * 查询 第一通电话解决率
     *
     * @return
     */
    @GetMapping("/selectSlaCompliancePhoneIncident")
//    @Scheduled(cron="${corn.time}")
    public ResponseMessage selectSlaCompliancePhoneIncident() {
        ResponseMessage responseMessage = new ResponseMessage();
        try {
            //第一通电话解决率
            List<slaPhoneIncident> data = new ArrayList<slaPhoneIncident>();
            List<slaCompliancePhoneIncidentSqlServer> sqlServerList = slaPhoneIncidentService.selectSlaCompliancePhoneIncident();
            if (null != sqlServerList && sqlServerList.size() > 0) {
                for (slaCompliancePhoneIncidentSqlServer sa : sqlServerList) {
                    slaPhoneIncident slaPhoneIncident = new slaPhoneIncident();
                    slaPhoneIncident.setOpenTimeOne(sa.getOpenTime1().toString());
                    slaPhoneIncident.setNumberOne(sa.getNumber1());
                    slaPhoneIncident.setOpenTimeTwo(sa.getOpenTime2().toString());
                    slaPhoneIncident.setNumberTwo(sa.getNumber2());
                    slaPhoneIncident.setFcrPhoneIncident(sa.getJjRate());
                    slaPhoneIncident.setTime(new Date());
                    data.add(slaPhoneIncident);
                }
            }
            slaPhoneIncidentService.deleteSlaPhoneIncident();
            slaPhoneIncidentService.insertSlaPhoneIncidentList(data);
            selectSlaCompliancePhoneFirstLine();
            return ResponseMessage.newOkInstance(data, "返回成功");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseMessage.newErrorInstance(e, "500");
        }
    }

    /**
     * 查询FLR 一线解决率
     *
     * @return
     */
    private void selectSlaCompliancePhoneFirstLine() {
        try {
            List<slaPhoneIncident> data = new ArrayList<slaPhoneIncident>();
            List<slaCompliancePhoneIncidentSqlServer> list = slaPhoneIncidentService.selectSlaComplianceFirstLineSolutionRate();
            if (null != list && list.size() > 0) {
                for (slaCompliancePhoneIncidentSqlServer sa : list) {
                    slaPhoneIncident slaPhoneIncident = new slaPhoneIncident();
                    slaPhoneIncident.setOpenDateTimeFirstLineOne(sa.getOpenTime1().toString());
                    slaPhoneIncident.setNumberFirstLineOne(sa.getNumber1());
                    slaPhoneIncident.setOpenDateTimeFirstLineTwo(sa.getOpenTime2().toString());
                    slaPhoneIncident.setNumberFirstLineTwo(sa.getNumber2());
                    slaPhoneIncident.setCallAbandonFirstLineRate(sa.getJjRate());
                    slaPhoneIncident.setTime(new Date());
                    data.add(slaPhoneIncident);
                }
                slaPhoneIncidentService.insertSlaPhoneIncidentList(data);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * 查询 SLA 达标率 -电话服务事件解决率（FCR）,以及昨天23点至零点(第一通电话解决率)
     *
     * @return
     */
    @GetMapping("/selectSlaCompliancePhoneIncident2")
    //@Scheduled(cron="${corn.time}")
    public ResponseMessage selectSlaCompliancePhoneIncident2() {
        try {
            //当天查询 SLA 达标率 -电话服务事件解决率（FCR）
            List<slaPhoneIncident> ByAllList = slaPhoneIncidentService.selectSlaCompliancePhoneIncident2();
            //查询SLA 达标率 -电话服务事件解决率（FCR）-昨天23点至零点时间段
//            List<slaPhoneIncident> ByTime = slaPhoneIncidentService.selectSlaCompliancePhoneIncident2BYTime();
            if (null != ByAllList && ByAllList.size() > 0) {
                slaPhoneIncidentService.deleteSlaPhoneIncident();
                //调用1线关单解决率（FLR）
                selectSlaComplianceFirstLineSolutionRate2();
                //录入 sla_phone_incident
                slaPhoneIncidentService.insertSlaPhoneIncidentList(ByAllList);
            }
           /* if (null != ByTime && ByTime.size() > 0) {
                //删除当天时间段23:00到零点之间数据
                slaPhoneIncidentService.deleteSlaPhoneIncidentByTime();
                slaPhoneIncidentService.insertSlaPhoneIncidentList(ByTime);
            }*/
            return ResponseMessage.newOkInstance(ByAllList, "200");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return ResponseMessage.newErrorInstance("500");
    }

    /**
     * 查询 SLA 达标率 -1线关单解决率（FLR），昨天23点至零点数据(一线解决率)
     *
     * @return
     */
    @GetMapping("/selectSlaComplianceFirstLineSolutionRate2")
    public ResponseMessage selectSlaComplianceFirstLineSolutionRate2() {
        try {
            //查询 当天SLA 达标率 -1线关单解决率（FLR）
            List<slaPhoneIncident> ByAllList = slaPhoneIncidentService.selectSlaComplianceFirstLineSolutionRate2();
            //查询 SLA 达标率 -1线关单解决率（FLR）,昨天23点至零点数据
//            List<slaPhoneIncident> ByTime = slaPhoneIncidentService.selectSlaComplianceFirstLineSolutionRate2ByTime();
            if (null != ByAllList && ByAllList.size() > 0) {
                slaPhoneIncidentService.insertSlaPhoneIncidentList(ByAllList);
            }
           /* if (null != ByTime && ByTime.size() > 0) {
                //删除当天时间段23:00到零点之间数据
                slaPhoneIncidentService.deleteSlaPhoneIncidentFirstLineSolutionRateByTime();
                slaPhoneIncidentService.insertSlaPhoneIncidentList(ByTime);
            }*/
            return ResponseMessage.newOkInstance(ByAllList, "200");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return ResponseMessage.newErrorInstance("500");
    }


}
