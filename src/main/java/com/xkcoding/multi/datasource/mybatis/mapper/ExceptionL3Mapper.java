package com.xkcoding.multi.datasource.mybatis.mapper;

import com.xkcoding.multi.datasource.mybatis.model.ExceptionL3;
import com.xkcoding.multi.datasource.mybatis.model.ExceptionL3Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExceptionL3Mapper {
    long countByExample(ExceptionL3Example example);

    int deleteByExample(ExceptionL3Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(ExceptionL3 record);

    int insertSelective(ExceptionL3 record);

    List<ExceptionL3> selectByExample(ExceptionL3Example example);

    ExceptionL3 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ExceptionL3 record, @Param("example") ExceptionL3Example example);

    int updateByExample(@Param("record") ExceptionL3 record, @Param("example") ExceptionL3Example example);

    int updateByPrimaryKeySelective(ExceptionL3 record);

    int updateByPrimaryKey(ExceptionL3 record);
}