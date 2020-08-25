package com.xkcoding.multi.datasource.mybatis.service;

import com.xkcoding.multi.datasource.mybatis.model.CrComplaint;

/**
 * 客户投诉服务层
 */
public interface ComplaintService {

    /**
     * 获取L1客户投诉
     * @return
     */
    CrComplaint getL1ModelData();

    /**
     * 添加L1客户投诉
     * @param l1ModelData
     * @return
     */
    int insertL1ModelData(CrComplaint l1ModelData);

    /**
     * 获取L2客户投诉
     * @return
     */
    CrComplaint getL2ModelData();

    /**
     * 添加L2客户投诉
     * @param l2ModelData
     * @return
     */
    int insertL2ModelData(CrComplaint l2ModelData);

    /**
     * 获取L3客户投诉
     * @return
     */
    CrComplaint getL3ModelData();

    /**
     * 添加L3客户投诉
     * @param l3ModelData
     * @return
     */
    int insertL3ModelData(CrComplaint l3ModelData);
}
