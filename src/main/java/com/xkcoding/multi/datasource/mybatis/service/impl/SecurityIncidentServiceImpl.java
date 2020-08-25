package com.xkcoding.multi.datasource.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.xkcoding.multi.datasource.mybatis.mapper.SecurityIncidentMapper;
import com.xkcoding.multi.datasource.mybatis.model.SecurityIncident;
import com.xkcoding.multi.datasource.mybatis.service.SecurityIncidentService;
import com.xkcoding.multi.datasource.mybatis.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 安全事件服务实现层
 */
@Service
@DS("slave")
@Slf4j
/**
 * @author fnchenxi
 */
public class SecurityIncidentServiceImpl implements SecurityIncidentService {

    @Autowired
    SecurityIncidentMapper securityIncidentMapper;

    @Override
    public SecurityIncident getL1ModelData() {
        return null;
    }

    @DS("master")
    @Override
    public int insertL1ModelData(SecurityIncident l1ModelData) {
        l1ModelData.setTime(new Date());
        l1ModelData.setLineNum("L1");
        l1ModelData.setEndTime(DateUtils.getCurrHourTime());
        return securityIncidentMapper.insertSelective(l1ModelData);
    }

    @Override
    public SecurityIncident getL2ModelData() {
        return null;
    }

    @DS("master")
    @Override
    public int insertL2ModelData(SecurityIncident l2ModelData) {
        l2ModelData.setTime(new Date());
        l2ModelData.setLineNum("L2");
        l2ModelData.setEndTime(DateUtils.getCurrHourTime());
        return securityIncidentMapper.insertSelective(l2ModelData);
    }

    @Override
    public SecurityIncident getL3ModelData() {
        return null;
    }

    @DS("master")
    @Override
    public int insertL3ModelData(SecurityIncident l3ModelData) {
        l3ModelData.setTime(new Date());
        l3ModelData.setLineNum("L3");
        l3ModelData.setEndTime(DateUtils.getCurrHourTime());
        return securityIncidentMapper.insertSelective(l3ModelData);
    }
}
