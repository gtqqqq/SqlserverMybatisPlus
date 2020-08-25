package com.xkcoding.multi.datasource.mybatis.mapper;

import com.xkcoding.multi.datasource.mybatis.model.L3TeamTicket1;
import com.xkcoding.multi.datasource.mybatis.model.L3TeamTicket1Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author fnchenxi
 */
public interface L3TeamTicket1Mapper {
    long countByExample(L3TeamTicket1Example example);

    int deleteByExample(L3TeamTicket1Example example);

    int insert(L3TeamTicket1 record);

    int insertSelective(L3TeamTicket1 record);

    List<L3TeamTicket1> selectByExample(L3TeamTicket1Example example);

    int updateByExampleSelective(@Param("record") L3TeamTicket1 record, @Param("example") L3TeamTicket1Example example);

    int updateByExample(@Param("record") L3TeamTicket1 record, @Param("example") L3TeamTicket1Example example);
}