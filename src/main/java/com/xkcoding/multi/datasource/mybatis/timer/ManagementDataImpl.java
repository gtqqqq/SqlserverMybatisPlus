package com.xkcoding.multi.datasource.mybatis.timer;

import com.xkcoding.multi.datasource.mybatis.model.*;
import com.xkcoding.multi.datasource.mybatis.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: smf
 * 操作微信响应率 snow在线响应率 邮件响应率 ,以及事件复开率
 */
@Service
@Slf4j
public class ManagementDataImpl {

    @Autowired
    private weChatResponseRateService weChatResponseRateService;  //微信响应率以及，snow在线响应率服务

    @Autowired
    private EmailResponseRateService emailResponseRateService; //邮件响应率 以及snow接单率 服务

    @Autowired
    private SlaComplianceBySpecificDateService slaComplianceBySpecificDateService; //20秒内电话接通率，以及超20秒电话放弃率服务层
    @Autowired
    private FteService fteService;  //FTE服务层 测试1线
    @Autowired
    private OrderUpService orderUpService;  // 升单量服务层 测试1线

    //@Scheduled(cron = "${corn.time}")
    public void taskManagementData() {
        //selectWeChatResponseRate(); // 微信响应率，以及snow在线响应率

        //selectEmailResponseRate(); //邮件响应率

        //selectSlaComplianceBySpecificDate();  // 查询20s 电话接通率by年月日小时

        //fteService();// 测试 FTE 人数
        //getL1ModelData();// 测试 1线升单
    }

    /**
     * 查询 微信响应率
     *
     * @return
     */
    private void selectWeChatResponseRate() {
        List<weChatResponseRate> responseRates = weChatResponseRateService.selectWeChatResponseRate();
        if (null != responseRates && responseRates.size() > 0) {
            weChatResponseRateService.deleteWeChatResponseRate();
            //查询 SNOW在线响应率
            selectSnowRate();
            weChatResponseRateService.insertWeChatResponseRate(responseRates);
        }
    }

    /**
     * 查询 SNOW在线响应率
     */
    private void selectSnowRate() {
        List<weChatResponseRate> snowRate = weChatResponseRateService.selectSnowRate();
        if (null != snowRate && snowRate.size() > 0) {
            weChatResponseRateService.insertWeChatResponseRate(snowRate);
        }

    }

    /**
     * 查询 邮件响应率
     *
     * @return
     */
    private void selectEmailResponseRate() {
        List<EmailResponseRate> emailResponseRates = emailResponseRateService.selectEmailResponseRate();
        if (null != emailResponseRates && emailResponseRates.size() > 0) {
            emailResponseRateService.deleteEmailResponseRate();
            emailResponseRateService.insertEmailResponseRateByList(emailResponseRates);

        }

    }

    /**
     * 查询20s 电话接通率by年月日小时
     */
    private void selectSlaComplianceBySpecificDate() {
        List<SlaComplianceBySpecificDate> bySpecificDates = slaComplianceBySpecificDateService.selectSlaComplianceBySpecificDate();
        if (null != bySpecificDates && bySpecificDates.size() > 0) {
            slaComplianceBySpecificDateService.deleteSlaComplianceBySpecificDate();
            slaComplianceBySpecificDateService.insertSlaComplianceBySpecificDate(bySpecificDates);

        }

    }

    /**
     * 测试一线 Fte
     */
    private void fteService() {
        List<FteOrderL1> l1FteOrderList = fteService.getL1FteOrderList();
        if (null != l1FteOrderList && !l1FteOrderList.isEmpty()) {
            int dataByToDay = fteService.deleteL1DataByToDay();
            System.out.printf("删除L1FTE" + dataByToDay);
            Boolean re = fteService.insertL1ModelData(l1FteOrderList);
            System.out.println(re);

        }

    }

    /**
     * 测试1线升单
     */
    private void getL1ModelData() {
        List<OrderUpL1> data = orderUpService.getL1ModelData();
        if (null != data && data.size() > 0) {
            int testl1 = orderUpService.insertL1ModelData(data);
            System.out.println("录入1线升单" + testl1);


        }


    }


}
