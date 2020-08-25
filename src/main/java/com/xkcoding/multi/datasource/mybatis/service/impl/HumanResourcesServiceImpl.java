package com.xkcoding.multi.datasource.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.xkcoding.multi.datasource.mybatis.mapper.HumanResourcesL1Mapper;
import com.xkcoding.multi.datasource.mybatis.mapper.HumanResourcesL2Mapper;
import com.xkcoding.multi.datasource.mybatis.mapper.HumanResourcesL3Mapper;
import com.xkcoding.multi.datasource.mybatis.model.HumanResourcesL1;
import com.xkcoding.multi.datasource.mybatis.model.HumanResourcesL2;
import com.xkcoding.multi.datasource.mybatis.model.HumanResourcesL3;
import com.xkcoding.multi.datasource.mybatis.service.HumanResourcesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 人力资源服务实现层
 */
@Service
@DS("slave")
@Slf4j
/**
 * @author fnchenxi
 */
public class HumanResourcesServiceImpl implements HumanResourcesService {

    @Autowired
    HumanResourcesL1Mapper humanResourcesL1Mapper;

    @Autowired
    HumanResourcesL2Mapper humanResourcesL2Mapper;

    @Autowired
    HumanResourcesL3Mapper humanResourcesL3Mapper;

    @Override
    public HumanResourcesL1 getL1ModelData() {
        return null;
    }

    @DS("master")
    @Override
    public int insertL1ModelData(HumanResourcesL1 l1) {
        l1.setCreateTime(new Date());
        return humanResourcesL1Mapper.insertSelective(l1);
    }

    @Override
    public HumanResourcesL2 getL2ModelData() {
        return null;
    }

    @DS("master")
    @Override
    public int insertL2ModelData(HumanResourcesL2 l2) {
        l2.setCreateTime(new Date());
        return humanResourcesL2Mapper.insertSelective(l2);
    }

    @Override
    public HumanResourcesL3 getL3ModelData() {
        return null;
    }

    @DS("master")
    @Override
    public int insertL3ModelData(HumanResourcesL3 l3) {
        l3.setCreateTime(new Date());
        return humanResourcesL3Mapper.insertSelective(l3);
    }
}
