package com.xkcoding.multi.datasource.mybatis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xkcoding.multi.datasource.mybatis.model.Call;
import com.xkcoding.multi.datasource.mybatis.model.CallCalcTable;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
* CallCalcTable服务层
* */
public interface CallCalcService extends IService<CallCalcTable> {

    /**
     * 录入CallCalcTable
     * */
    public  Boolean insertCallCalc(@Param("calcTableList") List<CallCalcTable> calcTableList);

}
