package com.xkcoding.multi.datasource.mybatis.service;

import com.xkcoding.multi.datasource.mybatis.model.SecurityIncident;

/**
 * 安全事件服务层
 */
public interface SecurityIncidentService {

    /**
     *获取L1的安全事件数据
     * @return
     */
    SecurityIncident getL1ModelData();

    /**
     * 添加L1的安全事件数据
     * @param l1ModelData
     * @return
     */
    int insertL1ModelData(SecurityIncident l1ModelData);

    /**
     *获取L2的安全事件数据
     * @return
     */
    SecurityIncident getL2ModelData();

    /**
     * 添加L2的安全事件数据
     * @param l2ModelData
     * @return
     */
    int insertL2ModelData(SecurityIncident l2ModelData);

    /**
     *获取L3的安全事件数据
     * @return
     */
    SecurityIncident getL3ModelData();

    /**
     * 添加L3的安全事件数据
     * @param l3ModelData
     * @return
     */
    int insertL3ModelData(SecurityIncident l3ModelData);
}
