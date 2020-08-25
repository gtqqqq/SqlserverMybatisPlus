package com.xkcoding.multi.datasource.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xkcoding.multi.datasource.mybatis.mapper.serviceLevelLaborProductivityMapper;
import com.xkcoding.multi.datasource.mybatis.model.serviceLevelLaborProductivity;
import com.xkcoding.multi.datasource.mybatis.service.serviceLevelLaborProductivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 作业生产量管控- L1关单量服务层
 * @author: smf
 * @time: 7/12/2020 6:48 PM
 */
@Service
@DS("master")
public class serviceLevelLaborProductivityServiceImpl extends ServiceImpl<serviceLevelLaborProductivityMapper, serviceLevelLaborProductivity> implements serviceLevelLaborProductivityService {

    @Autowired
    private serviceLevelLaborProductivityMapper serviceLevelLaborProductivityMapper;

    /**
     * 录入作业生产量管控-L1关单量
     *
     * @param serviceLevelLaborProductivityList
     * @return
     */
    @Override
    public Boolean insertServiceLevelLaborProductivity(List<serviceLevelLaborProductivity> serviceLevelLaborProductivityList) {
        return serviceLevelLaborProductivityMapper.insertServiceLevelLaborProductivity(serviceLevelLaborProductivityList);
    }

    /**
     * 清表
     */
    @Override
    public void deleteServiceLevelLaborProductivity() {
        serviceLevelLaborProductivityMapper.deleteServiceLevelLaborProductivity();
    }

    /**
     * FTE-指人数  TODO 不确定
     *
     * @return
     */
    @DS("slave")
    @Override
    public Integer selectServiceLevelLaborProductByPerson() {
        return baseMapper.selectServiceLevelLaborProductByPerson();
    }
}
