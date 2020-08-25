package com.xkcoding.multi.datasource.mybatis.service.impl;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.xkcoding.multi.datasource.mybatis.mapper.ExceptionL1Mapper;
import com.xkcoding.multi.datasource.mybatis.mapper.ExceptionL2Mapper;
import com.xkcoding.multi.datasource.mybatis.mapper.ExceptionL3Mapper;
import com.xkcoding.multi.datasource.mybatis.model.ExceptionL1;
import com.xkcoding.multi.datasource.mybatis.model.ExceptionL2;
import com.xkcoding.multi.datasource.mybatis.model.ExceptionL3;
import com.xkcoding.multi.datasource.mybatis.service.ExceptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 异常信息服务实现层
 */
@Service
@DS("slave")
@Slf4j
/**
 * @author fnchenxi
 */
public class ExceptionServiceImpl implements ExceptionService {

    @Autowired
    ExceptionL1Mapper exceptionL1Mapper;

    @Autowired
    ExceptionL2Mapper exceptionL2Mapper;

    @Autowired
    ExceptionL3Mapper exceptionL3Mapper;

    @Override
    public ExceptionL1 getL1ModelData() {
        return null;
    }

    @DS("master")
    @Override
    public int insertL1ModelData(ExceptionL1 l1) {
        l1.setCreateTime(new Date());
        return exceptionL1Mapper.insertSelective(l1);
    }

    @Override
    public ExceptionL2 getL2ModelData() {
        return null;
    }

    @DS("master")
    @Override
    public int insertL2ModelData(ExceptionL2 l2) {
        l2.setCreateTime(new Date());
        return exceptionL2Mapper.insertSelective(l2);
    }

    @Override
    public ExceptionL3 getL3ModelData() {
        return null;
    }

    @DS("master")
    @Override
    public int insertL3ModelData(ExceptionL3 l3) {
        l3.setCreateTime(new Date());
        return exceptionL3Mapper.insertSelective(l3);
    }
}
