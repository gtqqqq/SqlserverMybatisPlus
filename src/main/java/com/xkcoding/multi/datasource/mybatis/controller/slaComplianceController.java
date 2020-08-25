package com.xkcoding.multi.datasource.mybatis.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.xkcoding.multi.datasource.mybatis.model.slaCompliance;
import com.xkcoding.multi.datasource.mybatis.model.slaComplianceSqlServer;
import com.xkcoding.multi.datasource.mybatis.service.slaComplianceService;
import com.xkcoding.multi.datasource.mybatis.util.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description: SD-L1 ：SLA 达标情况 控制层
 * @author: smf
 * @time: 7/7/2020 9:29 PM
 */
@Slf4j
@RestController
public class slaComplianceController {
    @Autowired
    private slaComplianceService slaComplianceService;


    /**
     * 20秒内电话接通率
     *
     * @return
     */
    /*@GetMapping("/selectcallanswerrate")
//    @Scheduled(cron="${corn.time}")
    public ResponseMessage selectCallAnswerRate() {
        try {
            List<slaCompliance> data = new ArrayList<slaCompliance>();
            List<slaComplianceSqlServer> slaCompliances = slaComplianceService.selectCallAnswerRate();
            if (null != slaCompliances && slaCompliances.size() > 0) {
                for (slaComplianceSqlServer da : slaCompliances) {
                    slaCompliance slaCompliance = new slaCompliance();
                    slaCompliance.setOpenDateTimeOne(da.getOpendateTime1());
                    slaCompliance.setNumberOne(da.getNumber1());
                    slaCompliance.setOpenDateTimeTwo(da.getOpendateTime2());
                    slaCompliance.setNumberTwo(da.getNumber2());
                    slaCompliance.setCallAnswerRate(da.getJtRate());
                    slaCompliance.setTime(new Date());
                    data.add(slaCompliance);
                }
            }

            slaComplianceService.deleteSlaCompliance();
            selectCallAnswerRateFall();
            slaComplianceService.insertSlaComplianceList(data);
            return ResponseMessage.newOkInstance(data, "返回成功");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseMessage.newErrorInstance(e, "500");
        }

    }

    *//**
     * 超20秒掉call率  //TODO
     *//*
    private void selectCallAnswerRateFall() {
        List<slaCompliance> da = new ArrayList<slaCompliance>();
        try {
            List<slaComplianceSqlServer> list = slaComplianceService.selectCallAnswerRateFallRate();
            if (null != list && list.size() > 0) {
                for (slaComplianceSqlServer sq : list) {
                    slaCompliance slaComplianceFall = new slaCompliance();
                    slaComplianceFall.setOpenDateTimeFallOne(sq.getOpendateTime1());
                    slaComplianceFall.setNumberFallOne(sq.getNumber1());
                    slaComplianceFall.setOpenDateTimeFallTwo(sq.getOpendateTime2());
                    slaComplianceFall.setNumberFallTwo(sq.getNumber2());
                    slaComplianceFall.setCallAbandonRate(sq.getJtRate());
                    slaComplianceFall.setTime(new Date());
                    da.add(slaComplianceFall);
                }
            }
            slaComplianceService.insertSlaComplianceList(da);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
*/
    /**
     * 查询 SLA 达标率 - L1-电话接听率，以及昨天23点到零点时间段
     *
     * @return
     */
    @GetMapping("/selectCallAnswerRate2ByTime")
    //@Scheduled(cron="${corn.time}")
    public ResponseMessage selectCallAnswerRate2ByTime() {
        List<slaCompliance> ByTime = new ArrayList<>();
        try {
            //查询当天所有数据
            List<slaCompliance> ByAllList = slaComplianceService.selectCallAnswerRate2();
            //查询昨天23点至零点
//            List<slaCompliance> ByTimeList = slaComplianceService.selectYesterdayByTime();
            if (null != ByAllList && ByAllList.size() > 0) {
                slaComplianceService.deleteSlaCompliance();
                //调用SLA 达标率 -电话放弃率
                selectCallAnswerRateFallRate2();
                //录入SLA 达标情况-sla_compliance
                slaComplianceService.insertSlaComplianceList(ByAllList);
            }
         /*   if (null != ByTimeList && ByTimeList.size() > 0) {
                //删除当天时间段23:00到零点之间数据
                slaComplianceService.deleteByTime();
                //录入SLA 达标情况-sla_compliance
                slaComplianceService.insertSlaComplianceList(ByTimeList);
            }*/
            return ResponseMessage.newOkInstance(ByAllList, "200");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseMessage.newErrorInstance(e, "500");
        }

    }

    /**
     * 查询 SLA 达标率 -电话放弃率，以及昨天23点到零点时间段(Call Abandon Rate (20s))
     *
     * @return
     */
    @GetMapping("/selectCallAnswerRateFallRate2")
    public ResponseMessage selectCallAnswerRateFallRate2() {
        try {
            //查询当天SLA 达标率 -电话放弃率（Call Abandon Rate (20s)）
            List<slaCompliance> ByAllList = slaComplianceService.selectCallAnswerRateFallRate2();
            //查询 SLA 达标情况-超20秒掉call率-查询昨天23:00至零点数据
//            List<slaCompliance> ByTime = slaComplianceService.selectCallAnswerRateFallRate2ByTime();
            if (null != ByAllList && ByAllList.size() > 0 && !ByAllList.isEmpty()) {
                slaComplianceService.insertSlaComplianceList(ByAllList);
            }
          /*  if (null != ByTime && ByTime.size() > 0) {
                //删除当天时间段23:00到零点之间数据
                slaComplianceService.deleteFallRate2ByTime();
                //录入SLA 达标情况-sla_compliance
                slaComplianceService.insertSlaComplianceList(ByTime);
            }*/
            return ResponseMessage.newOkInstance(ByAllList, "200");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseMessage.newErrorInstance(e, "500");
        }
    }


}
