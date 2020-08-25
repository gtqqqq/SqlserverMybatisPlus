package com.xkcoding.multi.datasource.mybatis.controller;

import com.xkcoding.multi.datasource.mybatis.model.responseWorkOrder;
import com.xkcoding.multi.datasource.mybatis.service.responseWorkOrderService;

import com.xkcoding.multi.datasource.mybatis.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: L1累计工单 控制层
 * @author: smf
 * @time: 7/6/2020
 */
@RestController
public class responseWorkOrderController {

    @Autowired
    private responseWorkOrderService responseWorkOrderService;

    /**
     * 查询L1累计工单
     *
     * @return
     */
    @GetMapping("/selectbyresp")
    //@Scheduled(cron="${corn.time}")
    public ResponseMessage selectCumulativeResponse() {

        try {
            List<responseWorkOrder> data = new ArrayList<responseWorkOrder>();
            responseWorkOrder responseWorkOrder = new responseWorkOrder();
            //查询L1累计工单派出-累计响应ByIncident
            Integer byIncident = responseWorkOrderService.selectResponseOrderByIncident();
            //查询L1累计工单派出-累计响应ByRequest
            Integer byRequest = responseWorkOrderService.selectResponseOrderByRequest();
            //查询L1累计工单派出-累计响应ByNewCall
            Integer byNewCall = responseWorkOrderService.selectResponseOrderByNewCall();
            if (null != byIncident && null != byRequest && null != byNewCall) {
                //L1累计响应
                responseWorkOrder.setRespSum(byIncident + byRequest + byNewCall);
            }
            //查询L1累计工单派出-累计解决ByIncident
            Integer bySolveIncident = responseWorkOrderService.selectResponseOrderSolveByIncident();
            //查询L1累计工单派出-累计解决ByRequest
            Integer bySolveRequest = responseWorkOrderService.selectResponseOrderSolveByRequest();
            //查询L1累计工单派出-累计解决ByNewCall
            Integer bySolveNewCall = responseWorkOrderService.selectResponseOrderSolveByNewCall();
            if (null != bySolveIncident && null != bySolveRequest && null != bySolveNewCall) {
                //l1累计解决
                responseWorkOrder.setSolveSum(bySolveIncident + bySolveRequest + bySolveNewCall);
            }
            responseWorkOrder.setTime(new Date());
            data.add(responseWorkOrder);
            responseWorkOrderService.deleteWorkOrder();
            responseWorkOrderService.insertResponseWorkOrder(data);
            return ResponseMessage.newOkInstance(data, "返回成功");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseMessage.newErrorInstance(e, "500");
        }
    }

}
