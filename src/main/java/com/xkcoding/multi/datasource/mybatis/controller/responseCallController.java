package com.xkcoding.multi.datasource.mybatis.controller;

import com.xkcoding.multi.datasource.mybatis.model.responseCall;
import com.xkcoding.multi.datasource.mybatis.service.responseCallService;
import com.xkcoding.multi.datasource.mybatis.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description: L1累计电话接入 累计响应 累计解决
 * @author: smf
 * @time: 7/6/2020
 */
@RestController
public class responseCallController {
    @Autowired
    private responseCallService responseCallService;

    @GetMapping("/selectallcall")
    //@Scheduled(cron="${corn.time}")
    public ResponseMessage selectCall() {
        try {
            List<responseCall> data = new ArrayList<responseCall>();
            responseCall responseCall = new responseCall();
            //L1累计电话接入
            Integer call = responseCallService.selectResponseCall();
            //L1累计电话接入-累计响应
            Integer byResponseCall = responseCallService.selectByResponseCall();
            //L1累计电话接入-累计解决
            Integer bySoleResponseCall = responseCallService.selectBySoleResponseCall();
            if (null != call && null != byResponseCall && null != bySoleResponseCall) {
                responseCall.setCallSum(call);
                responseCall.setRespSum(byResponseCall);
                responseCall.setSolveSum(bySoleResponseCall);
            }
            responseCall.setTime(new Date());
            data.add(responseCall);
            responseCallService.deleteResponseCall();
            responseCallService.insertResponseCall(data);
            return ResponseMessage.newOkInstance(data, "返回成功");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseMessage.newErrorInstance(e, "500");
        }

    }

}
