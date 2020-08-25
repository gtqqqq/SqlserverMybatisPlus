package com.xkcoding.multi.datasource.mybatis.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.xkcoding.multi.datasource.mybatis.model.NotCloseModel;
import com.xkcoding.multi.datasource.mybatis.model.NotCloseModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author fnchenxi
 */
public interface NotCloseModelMapper {
    long countByExample(NotCloseModelExample example);

    int deleteByExample(NotCloseModelExample example);

    int insert(NotCloseModel record);

    int insertSelective(NotCloseModel record);

    List<NotCloseModel> selectByExample(NotCloseModelExample example);

    int updateByExampleSelective(@Param("record") NotCloseModel record, @Param("example") NotCloseModelExample example);

    int updateByExample(@Param("record") NotCloseModel record, @Param("example") NotCloseModelExample example);

    int deleteDataByToDay();
}