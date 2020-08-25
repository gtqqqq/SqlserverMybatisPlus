package com.xkcoding.multi.datasource.mybatis.controller;

import com.xkcoding.multi.datasource.mybatis.model.DailyComplianceStatistics;
import com.xkcoding.multi.datasource.mybatis.model.DailyComplianceStatisticsL3;
import com.xkcoding.multi.datasource.mybatis.service.DailyCompliService;
import com.xkcoding.multi.datasource.mybatis.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * SLA 达标情况控制层
 */
@RequestMapping("/complianceStatistics")
@RestController
public class L2ComplianceController {

    @Autowired
    DailyCompliService dailyCompliService;



}
