package com.yida.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xkcoding.multi.datasource.mybatis.model.DailyComplianceStatistics;
import com.xkcoding.multi.datasource.mybatis.util.ResponseMessage;
import com.yida.entity.L3ProductionControlTotal;
import com.yida.service.IL3ProductionControlTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

/**
 * L3 单量统计
 */
@RequestMapping("/orderNumber")
@RestController
public class L3OrderNumberController {

    @Autowired
    IL3ProductionControlTotalService il3ProductionControlTotalService;

    /**
     * l3单量统计结果
     * @return
     */
    @GetMapping("/l3/list")
    public ResponseMessage getl3OrderNumberList(DailyComplianceStatistics param){
        QueryWrapper<L3ProductionControlTotal> queryWrapper = new QueryWrapper<>();
        Calendar calender = Calendar.getInstance();
        calender.setTime(param.getCreateTime());
        if ("1".equals(param.getType())){
            queryWrapper.apply("YEAR(create_time) = {0} AND  MONTH(create_time) = {1} AND DAY(create_time)={2}",
                    calender.get(Calendar.YEAR),calender.get(Calendar.MONTH)+1,calender.get(Calendar.DATE));
        }else if ("2".equals(param.getType())){
            queryWrapper.apply("YEAR(create_time) = {0} AND  MONTH(create_time) = {1}",
                    calender.get(Calendar.YEAR),calender.get(Calendar.MONTH)+1);
        }else if ("3".equals(param.getType())){
            queryWrapper.apply("YEAR(create_time) = {0} ",
                    calender.get(Calendar.YEAR));
        }else {
            queryWrapper.apply(" DATE_FORMAT(create_time,'%y/%m/%d')=DATE_FORMAT(SYSDATE(),'%y/%m/%d')");
        }
        List<L3ProductionControlTotal> list = il3ProductionControlTotalService.list(queryWrapper);
        return ResponseMessage.newOkInstance(list, "返回成功");
    }

}
