package com.xkcoding.multi.datasource.mybatis.mapper;

import com.xkcoding.multi.datasource.mybatis.model.LearnList;

public interface LearnListMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LearnList record);

    int insertSelective(LearnList record);

    LearnList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LearnList record);

    int updateByPrimaryKey(LearnList record);
}