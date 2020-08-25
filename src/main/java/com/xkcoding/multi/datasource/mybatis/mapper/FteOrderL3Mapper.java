package com.xkcoding.multi.datasource.mybatis.mapper;

import com.xkcoding.multi.datasource.mybatis.model.FteOrderL3;
import com.xkcoding.multi.datasource.mybatis.model.FteOrderL3Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FteOrderL3Mapper {
    long countByExample(FteOrderL3Example example);

    int deleteByExample(FteOrderL3Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(FteOrderL3 record);

    int insertSelective(FteOrderL3 record);

    List<FteOrderL3> selectByExample(FteOrderL3Example example);

    FteOrderL3 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FteOrderL3 record, @Param("example") FteOrderL3Example example);

    int updateByExample(@Param("record") FteOrderL3 record, @Param("example") FteOrderL3Example example);

    int updateByPrimaryKeySelective(FteOrderL3 record);

    int updateByPrimaryKey(FteOrderL3 record);

    int deleteL3DataByToDay();
}