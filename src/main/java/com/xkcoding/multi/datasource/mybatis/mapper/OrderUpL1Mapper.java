package com.xkcoding.multi.datasource.mybatis.mapper;

import com.xkcoding.multi.datasource.mybatis.model.OrderUpL1;
import com.xkcoding.multi.datasource.mybatis.model.OrderUpL1Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderUpL1Mapper {
    long countByExample(OrderUpL1Example example);

    int deleteByExample(OrderUpL1Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderUpL1 record);

    int insertSelective(OrderUpL1 record);

    List<OrderUpL1> selectByExample(OrderUpL1Example example);

    OrderUpL1 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderUpL1 record, @Param("example") OrderUpL1Example example);

    int updateByExample(@Param("record") OrderUpL1 record, @Param("example") OrderUpL1Example example);

    int updateByPrimaryKeySelective(OrderUpL1 record);

    int updateByPrimaryKey(OrderUpL1 record);

    int deleteL1DataByToDay();
}