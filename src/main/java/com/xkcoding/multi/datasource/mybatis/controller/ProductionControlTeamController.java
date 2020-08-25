package com.xkcoding.multi.datasource.mybatis.controller;

import com.xkcoding.multi.datasource.mybatis.model.ProductionControlTeam;
import com.xkcoding.multi.datasource.mybatis.model.ProductionControlTeamGroup;
import com.xkcoding.multi.datasource.mybatis.service.ProductionControlTeamService;
import com.xkcoding.multi.datasource.mybatis.util.DateUtils;
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
 * @description: 作业生产量管控-SD-L1 Team 控制层
 * @author: smf
 * @time: 7/12/2020 8:48 AM
 */
@Slf4j
@RestController
public class ProductionControlTeamController {
    @Autowired
    private ProductionControlTeamService productionControlTeamService;

    @GetMapping("/selectproductioncontrolbyl1team")
//    @Scheduled(cron="${corn.time}")
    public ResponseMessage selectProductionControlByL1Team() {
        try {
            List<ProductionControlTeam> data = new ArrayList<ProductionControlTeam>();
            //作业生产量管控-incoming
            Integer incoming = productionControlTeamService.selectProductionControlIncoming();
            //作业生产量管控-responded
            Integer responded = productionControlTeamService.selectProductionControlResponded();
            //作业生产量管控-closed
            Integer closed = productionControlTeamService.selectProductionControlClosed();
            if (null != incoming && null != responded && null != closed) {
                ProductionControlTeam controlTeam = new ProductionControlTeam();
                controlTeam.setIncoming(incoming);
                controlTeam.setResponded(responded);
                controlTeam.setClosed(closed);
                controlTeam.setTime(new Date());
                controlTeam.setEndTime(DateUtils.getCurrHourTime());
                data.add(controlTeam);
            }
            productionControlTeamService.deleteProductionControlTeam();
            productionControlTeamService.insertProductionControlTeamList(data);
            return ResponseMessage.newOkInstance(data, "200");

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseMessage.newErrorInstance(e, "500");
        }

    }

    //测试日期接口
    @GetMapping("/selectduration")
    public ResponseMessage selectByDuration(String starDuration, String endDuration, String year, String month) {
        try {
            Integer integer = productionControlTeamService.selectByDuration(starDuration, endDuration, year, month);
            if (null != integer) {
                return ResponseMessage.newOkInstance(integer, "200");
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /*@GetMapping("/selectProductionControlByL1Team2")
    public ResponseMessage selectProductionControlByL1Team2() {
        try {
            List<ProductionControlTeam> incoming2 = productionControlTeamService.selectProductionControlIncoming2();
            List<ProductionControlTeam> byTime = productionControlTeamService.selectProductionControlIncomingByTime();
            if (null != incoming2 && incoming2.size() > 0) {
                productionControlTeamService.deleteProductionControlTeam();
                productionControlTeamService.insertProductionControlTeamList(incoming2);

            }
            if (null != byTime && byTime.size() > 0) {
                productionControlTeamService.deleteIncomingByTime();
                productionControlTeamService.insertProductionControlTeamList(byTime);
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }
*/

    /**
     * 分组 查询Responded
     *
     * @return
     */
    @GetMapping("/selectProductionControlRespondedByGroup")
    //    @Scheduled(cron="${corn.time}")
    public ResponseMessage selectProductionControlRespondedByGroup() {
        List<ProductionControlTeamGroup> data = new ArrayList<ProductionControlTeamGroup>();
        try {
            //分组统计RESPONDED 以及close
            List<ProductionControlTeamGroup> teamGroups = productionControlTeamService.selectProductionControlRespondedByGroup();
            if (null != teamGroups && teamGroups.size() > 0) {
                productionControlTeamService.deleteProductionControlTeamGroup();
                //分组统计Close
//                selectProductionControlCloseByGroup();
                //统计incoming
                //selectProductionControlIncoming();
                selectIncomingByDate();
                productionControlTeamService.insertProductionControlTeamGroup(teamGroups);
            }
            return ResponseMessage.newOkInstance(teamGroups, "200");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return ResponseMessage.newErrorInstance("500");
    }

    /**
     * 分组统计Close
     */
    public void selectProductionControlCloseByGroup() {
        try {
            List<ProductionControlTeamGroup> groupList = productionControlTeamService.selectProductionControlCloseByGroup();
            if (null != groupList && groupList.size() > 0) {
                productionControlTeamService.insertProductionControlTeamGroup(groupList);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

    }

    /**
     * 统计 incoming
     */
    public void selectProductionControlIncoming() {
        List<ProductionControlTeamGroup> data = new ArrayList<ProductionControlTeamGroup>();
        try {
            Integer incoming = productionControlTeamService.selectProductionControlIncoming();
            if (null != incoming) {
                ProductionControlTeamGroup group = new ProductionControlTeamGroup();
                group.setInComing(incoming);
                group.setMaRk("0");
                group.setSourceType("2");
                group.setTime(new Date());
                group.setEndTime(DateUtils.getCurrHourTime());
                data.add(group);
            }
            productionControlTeamService.insertProductionControlTeamGroup(data);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

    }

    /**
     * 查询 全部Incoming
     */
    public void selectIncomingByDate() {
        List<ProductionControlTeamGroup> productionControlTeamGroups = productionControlTeamService.selectIncomingByDate();
        if (null != productionControlTeamGroups && productionControlTeamGroups.size() > 0) {
            productionControlTeamService.insertProductionControlTeamGroup(productionControlTeamGroups);
        }


    }
}
