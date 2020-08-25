package com.xkcoding.multi.datasource.mybatis.service;

import com.xkcoding.multi.datasource.mybatis.model.*;

/**
 * 异常信息服务层
 */
public interface ExceptionService {
    /**
     * 获取L1异常信息数据
     * @return
     */
    ExceptionL1 getL1ModelData();

    /**
     * 添加L1异常信息数据
     * @return
     */
    int insertL1ModelData(ExceptionL1 l1);

    /**
     * 获取L2异常信息数据
     * @return
     */
    ExceptionL2 getL2ModelData();

    /**
     * 添加L2异常信息数据
     * @return
     */
    int insertL2ModelData(ExceptionL2 l2);

    /**
     * 获取L3异常信息数据
     * @return
     */
    ExceptionL3 getL3ModelData();

    /**
     * 添加L3异常信息数据
     * @return
     */
    int insertL3ModelData(ExceptionL3 l3);

}
