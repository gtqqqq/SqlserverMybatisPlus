package com.xkcoding.multi.datasource.mybatis.mapper;

import com.xkcoding.multi.datasource.mybatis.model.ProductionControl;
import com.xkcoding.multi.datasource.mybatis.model.ProductionControlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductionControlMapper {
    long countByExample(ProductionControlExample example);

    int deleteByExample(ProductionControlExample example);

    int insert(ProductionControl record);

    int insertSelective(ProductionControl record);

    List<ProductionControl> selectByExample(ProductionControlExample example);

    int updateByExampleSelective(@Param("record") ProductionControl record, @Param("example") ProductionControlExample example);

    int updateByExample(@Param("record") ProductionControl record, @Param("example") ProductionControlExample example);

    int batchInsert(List<ProductionControl> proConmodelData);

    int deleteDataByToDay();
}