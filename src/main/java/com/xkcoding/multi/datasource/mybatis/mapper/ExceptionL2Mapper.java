package com.xkcoding.multi.datasource.mybatis.mapper;

import com.xkcoding.multi.datasource.mybatis.model.ExceptionL2;
import com.xkcoding.multi.datasource.mybatis.model.ExceptionL2Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExceptionL2Mapper {
    long countByExample(ExceptionL2Example example);

    int deleteByExample(ExceptionL2Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExceptionL2 record);

    int insertSelective(ExceptionL2 record);

    List<ExceptionL2> selectByExample(ExceptionL2Example example);

    ExceptionL2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExceptionL2 record, @Param("example") ExceptionL2Example example);

    int updateByExample(@Param("record") ExceptionL2 record, @Param("example") ExceptionL2Example example);

    int updateByPrimaryKeySelective(ExceptionL2 record);

    int updateByPrimaryKey(ExceptionL2 record);
}