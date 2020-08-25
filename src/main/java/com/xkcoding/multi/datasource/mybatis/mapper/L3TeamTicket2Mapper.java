package com.xkcoding.multi.datasource.mybatis.mapper;

import com.xkcoding.multi.datasource.mybatis.model.L3TeamTicket2;
import com.xkcoding.multi.datasource.mybatis.model.L3TeamTicket2Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author fnchenxi
 */
public interface L3TeamTicket2Mapper {
    long countByExample(L3TeamTicket2Example example);

    int deleteByExample(L3TeamTicket2Example example);

    int insert(L3TeamTicket2 record);

    int insertSelective(L3TeamTicket2 record);

    List<L3TeamTicket2> selectByExample(L3TeamTicket2Example example);

    int updateByExampleSelective(@Param("record") L3TeamTicket2 record, @Param("example") L3TeamTicket2Example example);

    int updateByExample(@Param("record") L3TeamTicket2 record, @Param("example") L3TeamTicket2Example example);
}