package com.xkcoding.multi.datasource.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.xkcoding.multi.datasource.mybatis.mapper.CrComplaintMapper;
import com.xkcoding.multi.datasource.mybatis.model.CrComplaint;
import com.xkcoding.multi.datasource.mybatis.service.ComplaintService;
import com.xkcoding.multi.datasource.mybatis.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@DS("slave")
@Slf4j
/**
 * 客户投诉服务实现层
 * @author fnchenxi
 */
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    CrComplaintMapper crComplaintMapper;

    @Override
    public CrComplaint getL1ModelData() {
        return null;
    }

    @DS("master")
    @Override
    public int insertL1ModelData(CrComplaint l1ModelData) {
        l1ModelData.setlNum("L1");
        l1ModelData.setTime(new Date());
        l1ModelData.setEndTime(DateUtils.getCurrHourTime());
        return crComplaintMapper.insertSelective(l1ModelData);
    }

    @Override
    public CrComplaint getL2ModelData() {
        return null;
    }

    @DS("master")
    @Override
    public int insertL2ModelData(CrComplaint l2ModelData) {
        l2ModelData.setlNum("L2");
        l2ModelData.setTime(new Date());
        l2ModelData.setEndTime(DateUtils.getCurrHourTime());
        return crComplaintMapper.insertSelective(l2ModelData);
    }

    @Override
    public CrComplaint getL3ModelData() {
        return null;
    }

    @DS("master")
    @Override
    public int insertL3ModelData(CrComplaint l3ModelData) {
        l3ModelData.setlNum("L3");
        l3ModelData.setTime(new Date());
        l3ModelData.setEndTime(DateUtils.getCurrHourTime());
        return crComplaintMapper.insertSelective(l3ModelData);
    }
}
