package com.xkcoding.multi.datasource.mybatis.mapper;

import com.xkcoding.multi.datasource.mybatis.model.OrderUpL3;
import com.xkcoding.multi.datasource.mybatis.model.OrderUpL3Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderUpL3Mapper {
    long countByExample(OrderUpL3Example example);

    int deleteByExample(OrderUpL3Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderUpL3 record);

    int insertSelective(OrderUpL3 record);

    List<OrderUpL3> selectByExample(OrderUpL3Example example);

    OrderUpL3 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderUpL3 record, @Param("example") OrderUpL3Example example);

    int updateByExample(@Param("record") OrderUpL3 record, @Param("example") OrderUpL3Example example);

    int updateByPrimaryKeySelective(OrderUpL3 record);

    int updateByPrimaryKey(OrderUpL3 record);

    int deleteL3DataByToDay();
}