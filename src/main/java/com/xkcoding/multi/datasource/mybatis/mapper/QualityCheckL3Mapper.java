package com.xkcoding.multi.datasource.mybatis.mapper;

import com.xkcoding.multi.datasource.mybatis.model.QualityCheckL3;
import com.xkcoding.multi.datasource.mybatis.model.QualityCheckL3Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QualityCheckL3Mapper {
    long countByExample(QualityCheckL3Example example);

    int deleteByExample(QualityCheckL3Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(QualityCheckL3 record);

    int insertSelective(QualityCheckL3 record);

    List<QualityCheckL3> selectByExample(QualityCheckL3Example example);

    QualityCheckL3 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QualityCheckL3 record, @Param("example") QualityCheckL3Example example);

    int updateByExample(@Param("record") QualityCheckL3 record, @Param("example") QualityCheckL3Example example);

    int updateByPrimaryKeySelective(QualityCheckL3 record);

    int updateByPrimaryKey(QualityCheckL3 record);

    int deleteDataByToDay();
}