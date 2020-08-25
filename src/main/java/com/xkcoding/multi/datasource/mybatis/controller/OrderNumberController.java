package com.xkcoding.multi.datasource.mybatis.controller;

import com.xkcoding.multi.datasource.mybatis.model.DailyComplianceStatistics;
import com.xkcoding.multi.datasource.mybatis.model.OrderComplianceAvg;
import com.xkcoding.multi.datasource.mybatis.model.ProductionControlTotal;
import com.xkcoding.multi.datasource.mybatis.service.DailyCompliService;
import com.xkcoding.multi.datasource.mybatis.service.ProductionControlService;
import com.xkcoding.multi.datasource.mybatis.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * L2 单量统计
 */
@RequestMapping("/orderNumber")
@RestController
public class OrderNumberController {

    @Autowired
    ProductionControlService productionControlService;

    /**
     * l2单量统计结果
     * @return
     */
    @PostMapping("/l2/list")
    public ResponseMessage getl2OrderNumberList(@RequestBody DailyComplianceStatistics param){
        List<ProductionControlTotal> data = productionControlService.getl2OrderNumberList(param);
        return ResponseMessage.newOkInstance(data, "返回成功");
    }

}
