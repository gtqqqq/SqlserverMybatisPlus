package com.xkcoding.multi.datasource.mybatis.mapper;

import com.xkcoding.multi.datasource.mybatis.model.ProductionControlTotal;
import com.xkcoding.multi.datasource.mybatis.model.ProductionControlTotalExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ProductionControlTotalMapper {
    long countByExample(ProductionControlTotalExample example);

    int deleteByExample(ProductionControlTotalExample example);

    int insert(ProductionControlTotal record);

    int insertSelective(ProductionControlTotal record);

    List<ProductionControlTotal> selectByExample(ProductionControlTotalExample example);

    int updateByExampleSelective(@Param("record") ProductionControlTotal record, @Param("example") ProductionControlTotalExample example);

    int updateByExample(@Param("record") ProductionControlTotal record, @Param("example") ProductionControlTotalExample example);

    int deleteDataByToDay();

    int batchInsert(List<ProductionControlTotal> proConmodelData);

    /**
     * 根据日期统计单量
     * @param map
     * @return
     */
    List<ProductionControlTotal> selectToDayList(Map map);
}