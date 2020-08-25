package com.xkcoding.multi.datasource.mybatis.service;

import com.xkcoding.multi.datasource.mybatis.model.slaCompliancePhoneIncidentSqlServer;
import com.xkcoding.multi.datasource.mybatis.model.slaPhoneIncident;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: smf
 * @time: 7/10/2020
 * @description: 第一通电话解决率 以及一线解决率 服务层
 */
public interface slaPhoneIncidentService {
    /**
     * 录入第一通电话解决率 以及一线解决率
     *
     * @param slaPhoneIncidentList
     * @return
     */
    public Boolean insertSlaPhoneIncidentList(List<slaPhoneIncident> slaPhoneIncidentList);

    /**
     * 清表
     */
    public void deleteSlaPhoneIncident();

    /**
     * 查询 第一通电话解决率
     *
     * @return
     */
    public List<slaCompliancePhoneIncidentSqlServer> selectSlaCompliancePhoneIncident();


    /**
     * 查询 一线解决率  //TODO  Incicent、Request、New Call
     *
     * @return
     */
    public List<slaCompliancePhoneIncidentSqlServer> selectSlaComplianceFirstLineSolutionRate();


    /**
     * 查询 SLA 达标率 -电话服务事件解决率（FCR）(第一通电话解决率)
     *
     * @return
     */
    public List<slaPhoneIncident> selectSlaCompliancePhoneIncident2();


    /**
     * 查询 SLA 达标率 -电话服务事件解决率（FCR）,昨天23点至零点时间段(第一通电话解决率)
     *
     * @return
     */
    public List<slaPhoneIncident> selectSlaCompliancePhoneIncident2BYTime();


    /**
     * 删除当天时间段23:00到零点之间数据
     */
    public void deleteSlaPhoneIncidentByTime();


    /**
     * 查询 SLA 达标率 -1线关单解决率（FLR一线解决率）
     *
     * @return
     */
    public List<slaPhoneIncident> selectSlaComplianceFirstLineSolutionRate2();

    /**
     * 查询 SLA 达标率 -1线关单解决率（FLR）,昨天23点至零点时间段数据(一线解决率)
     *
     * @return
     */
    public List<slaPhoneIncident> selectSlaComplianceFirstLineSolutionRate2ByTime();


    /**
     * 删除当天时间段23:00到零点之间数据
     */
    public void deleteSlaPhoneIncidentFirstLineSolutionRateByTime();


}
