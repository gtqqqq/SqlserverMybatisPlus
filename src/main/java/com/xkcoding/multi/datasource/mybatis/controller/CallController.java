package com.xkcoding.multi.datasource.mybatis.controller;

import com.xkcoding.multi.datasource.mybatis.model.responseCall;
import com.xkcoding.multi.datasource.mybatis.model.responseWorkOrder;
import com.xkcoding.multi.datasource.mybatis.service.CallCalcService;
import com.xkcoding.multi.datasource.mybatis.service.CallService;
import com.xkcoding.multi.datasource.mybatis.service.responseCallService;
import com.xkcoding.multi.datasource.mybatis.service.responseWorkOrderService;
import com.xkcoding.multi.datasource.mybatis.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author: smf
 * @description: call控制层
 */
@RestController
public class CallController {


    @Autowired
    private CallService callService;

    @Autowired
    private responseCallService responseCallService;
    @Autowired
    private responseWorkOrderService responseWorkOrderService;


    /**
     * 查询call累计响应以,电话接入,以及累计解决
     */
    @GetMapping("/selectcallbycode")
//    @Scheduled(cron="${corn.time}")
    public ResponseMessage selectCallByCode() {
        try {
            List<responseCall> responseCallData = new ArrayList<responseCall>();
            responseCall responseCall = new responseCall();
            List<HashMap> hashMaps = callService.selectCallByCode(null);
            List<Object> list = callService.selectPhoneAll();
            List<Object> solve = callService.selectCallSolveByCode(null);
            if (null != hashMaps && hashMaps.size() > 0) {
                HashMap hashMap = hashMaps.get(0);
                Collection data = hashMap.values();
                Iterator iterator = data.iterator();
                while (iterator.hasNext()) {
                    // System.out.println(iterator.next());
                    responseCall.setRespSum((Integer) iterator.next());
                }
                if (null != list && list.size() > 0) {
                    for (Object obj : list) {
                        responseCall.setCallSum((Integer) list.get(0));
                    }
                }
                if (null != solve && solve.size() > 0) {
                    responseCall.setSolveSum((Integer) solve.get(0));
                }
                //responseCall.setRespSum(1);
                //responseCall.setSolveSum(1);
                responseCall.setTime(new Date());
                responseCallData.add(responseCall);
                responseCallService.deleteResponseCall();
                responseCallService.insertResponseCall(responseCallData);
                return ResponseMessage.newOkInstance(hashMaps, "200");
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseMessage.newErrorInstance(e, "500");
        }
        return ResponseMessage.newErrorInstance("500");
    }

    /**
     * L1累计工单派出
     * 暂时与L1确认没有筛选方式，不考虑该指标
     */
    @GetMapping("/selectworkorder")
//    @Scheduled(cron="${corn.time}")
    public ResponseMessage selectWorkOrder() {
        List<responseWorkOrder> list = new ArrayList<responseWorkOrder>();
        responseWorkOrder workOrder = new responseWorkOrder();
        try {
            List<Object> order = callService.selectWorkOrder();
            List<Object> orderResp = callService.selectWorkOrderResp();
            List<Object> solveSum = callService.selectWorkOrderSolveSum();
            if (null != order && order.size() > 0) {
                workOrder.setWorkOrderSum((Integer) order.get(0));

                if (null != orderResp && orderResp.size() > 0) {
                    workOrder.setRespSum((Integer) orderResp.get(0));
                }
                if (null != solveSum && solveSum.size() > 0) {
                    workOrder.setSolveSum((Integer) solveSum.get(0));
                }
                workOrder.setTime(new Date());
                list.add(workOrder);
//                list.add(workOrder);
                responseWorkOrderService.deleteWorkOrder();
                responseWorkOrderService.insertResponseWorkOrder(list);
                return ResponseMessage.newOkInstance(order, "200");
            }
        } catch (Exception e) {
            System.out.println(e);
            return ResponseMessage.newErrorInstance(e, "500");
        }
        return ResponseMessage.newErrorInstance("500");
    }


}
