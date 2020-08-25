package com.xkcoding.multi.datasource.mybatis.mapper;

import com.xkcoding.multi.datasource.mybatis.model.QualityCheckL1;
import com.xkcoding.multi.datasource.mybatis.model.QualityCheckL1Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QualityCheckL1Mapper {
    long countByExample(QualityCheckL1Example example);

    int deleteByExample(QualityCheckL1Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(QualityCheckL1 record);

    int insertSelective(QualityCheckL1 record);

    List<QualityCheckL1> selectByExample(QualityCheckL1Example example);

    QualityCheckL1 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QualityCheckL1 record, @Param("example") QualityCheckL1Example example);

    int updateByExample(@Param("record") QualityCheckL1 record, @Param("example") QualityCheckL1Example example);

    int updateByPrimaryKeySelective(QualityCheckL1 record);

    int updateByPrimaryKey(QualityCheckL1 record);
}