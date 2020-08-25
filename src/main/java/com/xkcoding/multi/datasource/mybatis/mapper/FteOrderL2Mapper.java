package com.xkcoding.multi.datasource.mybatis.mapper;

import com.xkcoding.multi.datasource.mybatis.model.FteOrderL2;
import com.xkcoding.multi.datasource.mybatis.model.FteOrderL2Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FteOrderL2Mapper {
    long countByExample(FteOrderL2Example example);

    int deleteByExample(FteOrderL2Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(FteOrderL2 record);

    int insertSelective(FteOrderL2 record);

    List<FteOrderL2> selectByExample(FteOrderL2Example example);

    FteOrderL2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FteOrderL2 record, @Param("example") FteOrderL2Example example);

    int updateByExample(@Param("record") FteOrderL2 record, @Param("example") FteOrderL2Example example);

    int updateByPrimaryKeySelective(FteOrderL2 record);

    int updateByPrimaryKey(FteOrderL2 record);

    int deleteL2DataByToDay();
}