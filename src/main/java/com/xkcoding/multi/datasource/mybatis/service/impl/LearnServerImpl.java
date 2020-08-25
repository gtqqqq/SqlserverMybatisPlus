package com.xkcoding.multi.datasource.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.xkcoding.multi.datasource.mybatis.mapper.LearnCycleMapper;
import com.xkcoding.multi.datasource.mybatis.mapper.LearnCycleQueryMapper;
import com.xkcoding.multi.datasource.mybatis.mapper.LearnListMapper;
import com.xkcoding.multi.datasource.mybatis.model.LearnCycle;
import com.xkcoding.multi.datasource.mybatis.model.LearnList;
import com.xkcoding.multi.datasource.mybatis.service.LearnServer;
import com.xkcoding.multi.datasource.mybatis.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 培训数据服务实现层
 */
@Service
@DS("slave")
@Slf4j
/**
 * @author fnchenxi
 */
public class LearnServerImpl implements LearnServer {

    @Autowired
    LearnCycleMapper learnCycleMapper;

    @Autowired
    LearnListMapper learnListMapper;

    @Autowired
    LearnCycleQueryMapper learnCycleQueryMapper;

    /**
     * 获取培训情况
     * @return
     */
    @Override
    public LearnCycle getModelData() {
        LearnCycle cycle=new LearnCycle();
        int courseNum = learnCycleQueryMapper.getCourseNumberByNewHiresTraining() + learnCycleQueryMapper.getCourseNumberBySchedule();
        int persionNum = learnCycleQueryMapper.getPersionNumByNewHiresTraining() + learnCycleQueryMapper.getPersionNumByTraining() + learnCycleQueryMapper.getPersionNumBySchedule();
        cycle.setCreateDate(new Date());
        cycle.setLearnCycle(courseNum);
        cycle.setLearnTurn(persionNum);
        cycle.setEndTime(DateUtils.getCurrHourTime());
        return cycle;
    }

    /**
     * 删除今天的培训数据
     * @return
     */
    @DS("master")
    @Override
    public int deleteDataByToDay() {
        return 0;
    }

    /**
     * 添加培训情况数据
     * @return
     */
    @DS("master")
    @Override
    public int insertModelData(LearnCycle l1) {
        l1.setCreateDate(new Date());
        return learnCycleMapper.insertSelective(l1);
    }

    /**
     * 获取培训列表
     * @return
     */
    @Override
    public List<LearnList> getModelDataList() {
        return null;
    }

    /**
     * 删除今天的培训列表
     * @return
     */
    @DS("master")
    @Override
    public int deleteDataListByToDay() {
        return 0;
    }

    /**
     * 批量添加培训列表数据
     * @param learnCycleList
     * @return
     */
    @DS("master")
    @Override
    public int batchInsertData(List<LearnList> learnCycleList) {
        if(!learnCycleList.isEmpty()){
            for (LearnList val:learnCycleList){
                val.setCreateTime(new Date());
                learnListMapper.insertSelective(val);
            }
            return 1;
        }
        return 0;
    }
}
