package com.xkcoding.multi.datasource.mybatis.mapper;

import com.xkcoding.multi.datasource.mybatis.model.L3TeamTicket3;
import com.xkcoding.multi.datasource.mybatis.model.L3TeamTicket3Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author fnchenxi
 */
public interface L3TeamTicket3Mapper {
    long countByExample(L3TeamTicket3Example example);

    int deleteByExample(L3TeamTicket3Example example);

    int insert(L3TeamTicket3 record);

    int insertSelective(L3TeamTicket3 record);

    List<L3TeamTicket3> selectByExample(L3TeamTicket3Example example);

    int updateByExampleSelective(@Param("record") L3TeamTicket3 record, @Param("example") L3TeamTicket3Example example);

    int updateByExample(@Param("record") L3TeamTicket3 record, @Param("example") L3TeamTicket3Example example);

    int deleteDataByToDay();
}