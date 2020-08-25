package com.xkcoding.multi.datasource.mybatis.mapper;

import com.xkcoding.multi.datasource.mybatis.model.QualityCheckL2;
import com.xkcoding.multi.datasource.mybatis.model.QualityCheckL2Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QualityCheckL2Mapper {
    long countByExample(QualityCheckL2Example example);

    int deleteByExample(QualityCheckL2Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(QualityCheckL2 record);

    int insertSelective(QualityCheckL2 record);

    List<QualityCheckL2> selectByExample(QualityCheckL2Example example);

    QualityCheckL2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QualityCheckL2 record, @Param("example") QualityCheckL2Example example);

    int updateByExample(@Param("record") QualityCheckL2 record, @Param("example") QualityCheckL2Example example);

    int updateByPrimaryKeySelective(QualityCheckL2 record);

    int updateByPrimaryKey(QualityCheckL2 record);
}