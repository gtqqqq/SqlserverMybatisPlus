package com.xkcoding.multi.datasource.mybatis.service;

import com.xkcoding.multi.datasource.mybatis.model.LearnCycle;
import com.xkcoding.multi.datasource.mybatis.model.LearnList;

import java.util.List;

/**
 * 培训数据服务层
 */
public interface LearnServer {

    /**
     * 获取培训情况
     * @return
     */
    LearnCycle getModelData();

    /**
     * 删除今天的培训数据
     * @return
     */
    int deleteDataByToDay();

    /**
     * 添加培训情况数据
     * @return
     */
    int insertModelData(LearnCycle l1);

    /**
     * 获取培训列表
     * @return
     */
    List<LearnList> getModelDataList();

    /**
     * 删除今天的培训列表
     * @return
     */
    int deleteDataListByToDay();

    /**
     * 批量添加培训列表数据
     * @param learnCycleList
     * @return
     */
    int batchInsertData(List<LearnList> learnCycleList);
}
