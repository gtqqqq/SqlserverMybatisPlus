package com.xkcoding.multi.datasource.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.xkcoding.multi.datasource.mybatis.mapper.*;
import com.xkcoding.multi.datasource.mybatis.model.*;
import com.xkcoding.multi.datasource.mybatis.service.DailyCompliService;
import com.xkcoding.multi.datasource.mybatis.service.QualityCheckService;
import com.xkcoding.multi.datasource.mybatis.util.CopyField;
import com.xkcoding.multi.datasource.mybatis.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 质量检测服务实现层
 */
@Service
@DS("slave")
@Slf4j
/**
 * @author fnchenxi
 */
public class QualityCheckServiceImpl implements QualityCheckService {

    @Autowired
    QualityCheckL1Mapper qualityCheckL1Mapper;

    @Autowired
    QualityCheckL2Mapper qualityCheckL2Mapper;

    @Autowired
    QualityCheckL3Mapper qualityCheckL3Mapper;
    
    @Autowired
    QualityCheckQueryMapper qualityCheckQueryMapper;

    /**
     * 获取质量检测L1的数据
     * @return
     */
    @Override
    public List<QualityCheckL1> getL1ModelData() {
        List<QualityCheckL1> qualityCheckList=new ArrayList<>();
        List<Map<String, Object>> list;
        list = qualityCheckQueryMapper.getQualityData();

        if(list!=null && !list.isEmpty()){
            for(Map<String, Object> val:list){
                QualityCheckL1 qualityCheckL1=new QualityCheckL1();
                qualityCheckL1.setCreateTime(new Date());
                qualityCheckL1.setTotal(val.get("total")==null?null:(Integer) val.get("total"));
                qualityCheckL1.setCheckNumber(val.get("check_number")==null?null:(Integer) val.get("check_number"));
                qualityCheckL1.setFailNumber(val.get("fail_number")==null?null:(Integer)val.get("fail_number"));
                qualityCheckL1.setSourceType(Integer.valueOf(val.get("source_type")==null?null:(String)val.get("source_type")));
                qualityCheckL1.setGroupName(val.get("group_name")==null?null:(String)val.get("group_name"));
                qualityCheckL1.setEndTime(val.get("end_time")==null?null:(Date)val.get("end_time"));
                qualityCheckList.add(qualityCheckL1);
            }
        }
        return qualityCheckList;
    }

    /**
     * 添加数据到L1质量检测
     * @return
     */
    @DS("master")
    @Override
    public int insertL1ModelData(List<QualityCheckL1> l1) {
        if(!l1.isEmpty()){
            for (QualityCheckL1 val:l1){
                 qualityCheckL1Mapper.insertSelective(val);
            }
            return 1;
        }
        return 0;
    }

    /**
     * 获取质量检测L2的数据
     * @return
     */
    @Override
    public QualityCheckL2 getL2ModelData() {
        Date sysdate=qualityCheckQueryMapper.getSysDate();
        System.out.println("当前时间为："+sysdate.getHours()+"时"+sysdate.getMinutes()+"分");
        return null;
    }

    /**
     * 添加数据到L2质量检测
     * @return
     */
    @DS("master")
    @Override
    public int insertL2ModelData(QualityCheckL2 l2) {
        l2.setCreateTime(new Date());
        return qualityCheckL2Mapper.insertSelective(l2);
    }

    /**
     * 获取质量检测L3的数据
     * @return
     */
    @Override
    public QualityCheckL3 getL3ModelData() {
        return null;
    }

    /**
     * 添加数据到L3质量检测
     * @return
     */
    @DS("master")
    @Override
    public int insertL3ModelData(QualityCheckL3 l3) {
        l3.setCreateTime(new Date());
        return qualityCheckL3Mapper.insertSelective(l3);
    }

    @DS("master")
    @Override
    public int deleteDataByToDay() {
        return qualityCheckL3Mapper.deleteDataByToDay();
    }
}

