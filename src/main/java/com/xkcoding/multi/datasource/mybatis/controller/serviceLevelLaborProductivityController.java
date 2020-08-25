package com.xkcoding.multi.datasource.mybatis.controller;

import com.xkcoding.multi.datasource.mybatis.service.serviceLevelLaborProductivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Action;

/**
 * @description: 作业生产量管控-Labor Productivity: 控制层
 * @author: smf
 * @time: 7/12/2020 7:01 PM
 */
@RestController
public class serviceLevelLaborProductivityController {
    @Autowired
    private serviceLevelLaborProductivityService serviceLevelLaborProductivityService;


}
