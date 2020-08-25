package com.xkcoding.multi.datasource.mybatis.mapper;

import com.xkcoding.multi.datasource.mybatis.model.HumanResourcesL1;
import com.xkcoding.multi.datasource.mybatis.model.HumanResourcesL1Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HumanResourcesL1Mapper {
    long countByExample(HumanResourcesL1Example example);

    int deleteByExample(HumanResourcesL1Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(HumanResourcesL1 record);

    int insertSelective(HumanResourcesL1 record);

    List<HumanResourcesL1> selectByExample(HumanResourcesL1Example example);

    HumanResourcesL1 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HumanResourcesL1 record, @Param("example") HumanResourcesL1Example example);

    int updateByExample(@Param("record") HumanResourcesL1 record, @Param("example") HumanResourcesL1Example example);

    int updateByPrimaryKeySelective(HumanResourcesL1 record);

    int updateByPrimaryKey(HumanResourcesL1 record);
}