package com.yida.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xkcoding.multi.datasource.mybatis.model.DailyComplianceStatisticsL3;
import com.xkcoding.multi.datasource.mybatis.util.DateUtils;
import com.yida.entity.DailyComplianceStatistics;
import com.yida.entity.OLADailyComplianceStatisticsL3;
import com.yida.service.IOLADailyComplianceStatisticsL3Service;
import com.yida.service.OLADailyCompliService;
import com.yida.service.impl.CsatServiceImpl;
import com.yida.service.impl.RequestServiceImpl;
import com.yida.service.impl.mysql.L2TeamticketServiceImpl;
import com.yida.service.impl.mysql.L3ProductionControlServiceImpl;
import com.yida.service.impl.mysql.L3ProductionControlTotalServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @desc spirngboot 定时任务使用：
 * 1、通过@Scheduled声明一个计划任务,Scheduled包含cron(unix下定时任务)、fixDelay(延时执行)、fixRate(间隔固定时间执行)。
 * 2、在启动类上增加@EnableScheduling注解开启对计划任务的支持。
 */
@Slf4j
@Component
public class TaskManager {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    OLADailyCompliService olaDailyCompliService;
    @Autowired
    IOLADailyComplianceStatisticsL3Service IOLADailyComplianceStatisticsL3Service;
    @Autowired
    CsatServiceImpl CsatServiceImpl;
    @Autowired
    RequestServiceImpl requestService;
    //    @Autowired
//    IncidentServiceImpl incidentService;
    @Autowired
    L3ProductionControlTotalServiceImpl l3ProductionControlTotalService;
    @Autowired
    L3ProductionControlServiceImpl l3ProductionControlService;
    @Autowired
    L2TeamticketServiceImpl l2TeamticketService;

    //fixedRate:上一次开始执行时间点后再次执行；间隔22秒执行一次
    @Scheduled(fixedRate = 1000 * 44)
    //@Scheduled(cron="${corn.time}")
    public void testTask() {
       // taskOLA();
         CsatServiceImpl.taskCsatNum();
        //l3ProductionControlTotalService.taskL3ProductionControlTotal();
      //  l3ProductionControlService.taskL3Production();
        // CsatServiceImpl.taskCsat();
        //l2TeamticketService.taskL2Teamticket();
        // requestService.taskRequest();
        //incidentService.taskIncident();
        System.out.println(">>>>>> fixRateTime >>>>>间隔22秒执行一次..：" + dateFormat.format(new Date()));

    }

    public void taskOLA() {
       List<DailyComplianceStatistics> modelL2ListData = olaDailyCompliService.getModelL2Data();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyy-MM-dd");
            //l2OLA
            QueryWrapper<DailyComplianceStatistics> queryWrapper = new QueryWrapper<DailyComplianceStatistics>();
            queryWrapper.eq("type", "OLA");

            savemysqlL2(modelL2ListData, queryWrapper, dateFormat);
            //l3OLA
        List<DailyComplianceStatistics> dataL3 = olaDailyCompliService.getModelL3Data();
            QueryWrapper<OLADailyComplianceStatisticsL3> queryWrapperl3 = new QueryWrapper<OLADailyComplianceStatisticsL3>();
            queryWrapperl3.eq("type", "OLA");
            List<OLADailyComplianceStatisticsL3> l3List=new ArrayList<>();
            for(DailyComplianceStatistics l3Data:dataL3){
                OLADailyComplianceStatisticsL3 l3 = new OLADailyComplianceStatisticsL3();
                BeanUtils.copyProperties(l3Data, l3);
                l3List.add(l3);
            }
            savemysqlL3(l3List, queryWrapperl3, dateFormat);
    }

    private void savemysqlL2(List<DailyComplianceStatistics> dailyComplianceStatistics, QueryWrapper<DailyComplianceStatistics> queryWrapper, SimpleDateFormat dateFormat) {
        try {
            List<DailyComplianceStatistics> list = olaDailyCompliService.list(queryWrapper);
            if (list.size() > 0) {
                log.info("mysql:删除当天" + dateFormat.format(new Date()) + "的OLA");
                olaDailyCompliService.remove(queryWrapper);
                log.info("mysql:更新当天" + dateFormat.format(new Date()) + "的OLA");
                for(DailyComplianceStatistics l2Data:dailyComplianceStatistics){
                    olaDailyCompliService.save(l2Data);
                }
            } else {
                log.info("mysql:首次添加当天" + dateFormat.format(new Date()) + "的OLA");
                for(DailyComplianceStatistics l2Data:dailyComplianceStatistics){
                    olaDailyCompliService.save(l2Data);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    private void savemysqlL3(List<OLADailyComplianceStatisticsL3> OLADailyComplianceStatisticsL3, QueryWrapper<OLADailyComplianceStatisticsL3> queryWrapper, SimpleDateFormat dateFormat) {
        try {
            List<OLADailyComplianceStatisticsL3> list = IOLADailyComplianceStatisticsL3Service.list(queryWrapper);
            if (list.size() > 0) {
                log.info("mysql:删除当天" + dateFormat.format(new Date()) + "的OLA");
                IOLADailyComplianceStatisticsL3Service.remove(queryWrapper);
                log.info("mysql:更新当天" + dateFormat.format(new Date()) + "的OLA");
                for(OLADailyComplianceStatisticsL3 l3:OLADailyComplianceStatisticsL3){
                    IOLADailyComplianceStatisticsL3Service.save(l3);
                }
            } else {
                log.info("mysql:首次添加当天" + dateFormat.format(new Date()) + "的OLA");
                for(OLADailyComplianceStatisticsL3 l3:OLADailyComplianceStatisticsL3){
                    IOLADailyComplianceStatisticsL3Service.save(l3);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }


    public static void main(String[] args) {
        System.out.println(">>>>> fixedDelayStringTime >>>>>从配置文件加载任务信息，当前时间：");
    }
}
