package com.xkcoding.multi.datasource.mybatis.controller;

import com.xkcoding.multi.datasource.mybatis.service.ComplianceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 服务水平管理参数展示-合规抽检 控制层
 * @author: smf
 * @time: 7/12/2020 8:30 AM
 */
@RestController
public class ComplianceCheckController {

    @Autowired
    private ComplianceCheckService complianceCheckService;


}
