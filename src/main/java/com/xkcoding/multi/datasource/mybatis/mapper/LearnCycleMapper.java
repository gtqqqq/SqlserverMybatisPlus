package com.xkcoding.multi.datasource.mybatis.mapper;

import com.xkcoding.multi.datasource.mybatis.model.LearnCycle;

public interface LearnCycleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LearnCycle record);

    int insertSelective(LearnCycle record);

    LearnCycle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LearnCycle record);

    int updateByPrimaryKey(LearnCycle record);
}