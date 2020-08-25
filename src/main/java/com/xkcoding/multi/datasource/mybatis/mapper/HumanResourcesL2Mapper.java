package com.xkcoding.multi.datasource.mybatis.mapper;

import com.xkcoding.multi.datasource.mybatis.model.HumanResourcesL2;
import com.xkcoding.multi.datasource.mybatis.model.HumanResourcesL2Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HumanResourcesL2Mapper {
    long countByExample(HumanResourcesL2Example example);

    int deleteByExample(HumanResourcesL2Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(HumanResourcesL2 record);

    int insertSelective(HumanResourcesL2 record);

    List<HumanResourcesL2> selectByExample(HumanResourcesL2Example example);

    HumanResourcesL2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HumanResourcesL2 record, @Param("example") HumanResourcesL2Example example);

    int updateByExample(@Param("record") HumanResourcesL2 record, @Param("example") HumanResourcesL2Example example);

    int updateByPrimaryKeySelective(HumanResourcesL2 record);

    int updateByPrimaryKey(HumanResourcesL2 record);
}