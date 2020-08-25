package com.xkcoding.multi.datasource.mybatis.controller;

import com.xkcoding.multi.datasource.mybatis.model.lineChart;
import com.xkcoding.multi.datasource.mybatis.model.lineChartBySqlServer;
import com.xkcoding.multi.datasource.mybatis.service.lineChartService;
import com.xkcoding.multi.datasource.mybatis.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: 运营综合导航版 控制层
 * @author: smf
 * @time: 7/6/2020 9:15 PM
 */
@RestController
public class lineChartController {

    @Autowired
    private lineChartService lineChartService;

    /**
     * 导航版 折线
     *
     * @return
     */
    @GetMapping("/selectlinechartall")
    //@Scheduled(cron="${corn.time}")
    public ResponseMessage selectLineChartAll() {
        try {
            List<lineChart> lineChartList = new ArrayList<lineChart>();
            //导航版-L1关闭工单数
            List<lineChartBySqlServer> closeOrderNum = lineChartService.selectLineChartCloseOrderNum();
            if (null != closeOrderNum && closeOrderNum.size() > 0) {
                for (lineChartBySqlServer sa : closeOrderNum) {
                    lineChart lineChart = new lineChart();
                    lineChart.setWorkOrderClosedHour(sa.getOpenTime());
                    lineChart.setWorkOrderClosedNum(sa.getNumber());
                    lineChart.setTime(new Date());
                    lineChartList.add(lineChart);
                }
            }

            lineChartService.deleteLineChart();
            selectCreateOrder();
            selectPhoneResp();
            lineChartService.insertLineChartList(lineChartList);
            return ResponseMessage.newOkInstance(lineChartList, "返回成功");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseMessage.newErrorInstance(e, "500");
        }
    }

    /**
     * 创建工单
     */
    private void selectCreateOrder() {
        try {
            List<lineChart> lineChartList = new ArrayList<lineChart>();
            List<lineChartBySqlServer> createOrderNum = lineChartService.selectLineChartCreateOrderNum();
            if (null != createOrderNum && createOrderNum.size() > 0) {
                for (lineChartBySqlServer cr : createOrderNum) {
                    lineChart lineChart = new lineChart();
                    lineChart.setWorkOrderCreateHour(cr.getOpenTime());
                    lineChart.setWorkOrderCreateNum(cr.getNumber());
                    lineChart.setTime(new Date());
                    lineChartList.add(lineChart);
                }
            }
            lineChartService.insertLineChartList(lineChartList);
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

    }

    /**
     * 电话接入数
     */
    private void selectPhoneResp() {
        try {
            List<lineChart> lineChartList = new ArrayList<lineChart>();
            List<lineChartBySqlServer> phoneRespNum = lineChartService.selectLineChartPhoneRespNum();
            if (null != phoneRespNum && phoneRespNum.size() > 0) {
                for (lineChartBySqlServer ph : phoneRespNum) {
                    lineChart lineChart = new lineChart();
                    lineChart.setPhoneRespHour(ph.getOpenTime());
                    lineChart.setPhoneRespNum(ph.getNumber());
                    lineChart.setTime(new Date());
                    lineChartList.add(lineChart);
                }
            }
            lineChartService.insertLineChartList(lineChartList);
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
    }


}
