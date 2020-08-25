package com.xkcoding.multi.datasource.mybatis.mapper;

import com.xkcoding.multi.datasource.mybatis.model.ExceptionL1;
import com.xkcoding.multi.datasource.mybatis.model.ExceptionL1Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExceptionL1Mapper {
    long countByExample(ExceptionL1Example example);

    int deleteByExample(ExceptionL1Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExceptionL1 record);

    int insertSelective(ExceptionL1 record);

    List<ExceptionL1> selectByExample(ExceptionL1Example example);

    ExceptionL1 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExceptionL1 record, @Param("example") ExceptionL1Example example);

    int updateByExample(@Param("record") ExceptionL1 record, @Param("example") ExceptionL1Example example);

    int updateByPrimaryKeySelective(ExceptionL1 record);

    int updateByPrimaryKey(ExceptionL1 record);
}