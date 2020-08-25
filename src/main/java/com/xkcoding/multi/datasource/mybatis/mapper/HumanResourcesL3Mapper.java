package com.xkcoding.multi.datasource.mybatis.mapper;

import com.xkcoding.multi.datasource.mybatis.model.HumanResourcesL3;
import com.xkcoding.multi.datasource.mybatis.model.HumanResourcesL3Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HumanResourcesL3Mapper {
    long countByExample(HumanResourcesL3Example example);

    int deleteByExample(HumanResourcesL3Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(HumanResourcesL3 record);

    int insertSelective(HumanResourcesL3 record);

    List<HumanResourcesL3> selectByExample(HumanResourcesL3Example example);

    HumanResourcesL3 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HumanResourcesL3 record, @Param("example") HumanResourcesL3Example example);

    int updateByExample(@Param("record") HumanResourcesL3 record, @Param("example") HumanResourcesL3Example example);

    int updateByPrimaryKeySelective(HumanResourcesL3 record);

    int updateByPrimaryKey(HumanResourcesL3 record);
}