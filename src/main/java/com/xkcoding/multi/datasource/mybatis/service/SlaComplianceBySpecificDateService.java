package com.xkcoding.multi.datasource.mybatis.service;

import com.xkcoding.multi.datasource.mybatis.model.SlaComplianceBySpecificDate;

import java.util.List;

/**
 * @author smf
 * @Description: 20秒内电话接通率，以及超20秒电话放弃率服务层
 * @date 2020/8/199:56
 */
public interface SlaComplianceBySpecificDateService {
    /**
     * 录入 SlaComplianceBySpecificDate
     *
     * @param specificDateList
     * @return
     */
    Boolean insertSlaComplianceBySpecificDate(List<SlaComplianceBySpecificDate> specificDateList);

    /**
     * 清表
     */
    void deleteSlaComplianceBySpecificDate();

    /**
     * 查询20s 电话接通率by年月日小时
     */
    List<SlaComplianceBySpecificDate> selectSlaComplianceBySpecificDate();


}
