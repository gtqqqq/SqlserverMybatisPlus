package com.xkcoding.multi.datasource.mybatis.mapper;

import com.xkcoding.multi.datasource.mybatis.model.OrderUpL2;
import com.xkcoding.multi.datasource.mybatis.model.OrderUpL2Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderUpL2Mapper {
    long countByExample(OrderUpL2Example example);

    int deleteByExample(OrderUpL2Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderUpL2 record);

    int insertSelective(OrderUpL2 record);

    List<OrderUpL2> selectByExample(OrderUpL2Example example);

    OrderUpL2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderUpL2 record, @Param("example") OrderUpL2Example example);

    int updateByExample(@Param("record") OrderUpL2 record, @Param("example") OrderUpL2Example example);

    int updateByPrimaryKeySelective(OrderUpL2 record);

    int updateByPrimaryKey(OrderUpL2 record);

    int deleteL2DataByToDay();

}