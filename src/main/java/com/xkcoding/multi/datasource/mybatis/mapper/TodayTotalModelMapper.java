package com.xkcoding.multi.datasource.mybatis.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.xkcoding.multi.datasource.mybatis.model.TodayTotalModel;
import com.xkcoding.multi.datasource.mybatis.model.TodayTotalModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author fnchenxi
 */
public interface TodayTotalModelMapper {
    long countByExample(TodayTotalModelExample example);

    int deleteByExample(TodayTotalModelExample example);

    int insert(TodayTotalModel record);

    int insertSelective(TodayTotalModel record);

    List<TodayTotalModel> selectByExample(TodayTotalModelExample example);

    int updateByExampleSelective(@Param("record") TodayTotalModel record, @Param("example") TodayTotalModelExample example);

    int updateByExample(@Param("record") TodayTotalModel record, @Param("example") TodayTotalModelExample example);

    int deleteDataByToDay();
}