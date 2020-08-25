package com.xkcoding.multi.datasource.mybatis.mapper;

import com.xkcoding.multi.datasource.mybatis.model.CrComplaint;
import com.xkcoding.multi.datasource.mybatis.model.CrComplaintExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrComplaintMapper {
    long countByExample(CrComplaintExample example);

    int deleteByExample(CrComplaintExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CrComplaint record);

    int insertSelective(CrComplaint record);

    List<CrComplaint> selectByExample(CrComplaintExample example);

    CrComplaint selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CrComplaint record, @Param("example") CrComplaintExample example);

    int updateByExample(@Param("record") CrComplaint record, @Param("example") CrComplaintExample example);

    int updateByPrimaryKeySelective(CrComplaint record);

    int updateByPrimaryKey(CrComplaint record);
}