package com.xkcoding.multi.datasource.mybatis.mapper;

import com.xkcoding.multi.datasource.mybatis.model.FteOrderL1;
import com.xkcoding.multi.datasource.mybatis.model.FteOrderL1Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FteOrderL1Mapper {
    long countByExample(FteOrderL1Example example);

    int deleteByExample(FteOrderL1Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(FteOrderL1 record);

    int insertSelective(FteOrderL1 record);

    List<FteOrderL1> selectByExample(FteOrderL1Example example);

    FteOrderL1 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FteOrderL1 record, @Param("example") FteOrderL1Example example);

    int updateByExample(@Param("record") FteOrderL1 record, @Param("example") FteOrderL1Example example);

    int updateByPrimaryKeySelective(FteOrderL1 record);

    int updateByPrimaryKey(FteOrderL1 record);

    int deleteL1DataByToDay();
}