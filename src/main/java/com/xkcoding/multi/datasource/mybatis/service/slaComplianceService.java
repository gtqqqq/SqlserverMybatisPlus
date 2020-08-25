package com.xkcoding.multi.datasource.mybatis.service;

import com.xkcoding.multi.datasource.mybatis.model.businessVolume;
import com.xkcoding.multi.datasource.mybatis.model.slaCompliance;
import com.xkcoding.multi.datasource.mybatis.model.slaComplianceSqlServer;

import java.util.List;
import java.util.Map;

/**
 * @author: smf
 * @time: 7/7/2020 9:00 PM
 * @description: SD-L1 ：SLA 达标情况 服务层
 */
public interface slaComplianceService {

    /***
     * 录入 SD-L1 ：SLA 达标情况
     */
    public Boolean insertSlaComplianceList(List<slaCompliance> slaComplianceList);

    /**
     * 清表
     */
    public void deleteSlaCompliance();

    /**
     * 查询 SLA 达标情况-20秒内电话接通率
     *
     * @return
     */
    public List<slaComplianceSqlServer> selectCallAnswerRate();


    /**
     * 查询 SLA 达标情况-超20秒掉call率
     *
     * @return
     */
    public List<slaComplianceSqlServer> selectCallAnswerRateFallRate();

    /**
     * 查询 SLA 达标率 - L1-电话接听率(（Call Answer Rate (20s)）)
     *
     * @return
     */
    public List<slaCompliance> selectCallAnswerRate2();

    /**
     * 查询昨天十一点数据
     *
     * @return
     */
    public List<slaCompliance> selectYesterdayByTime();

    /**
     * 删除当天时间段23:00到零点之间数据
     */
    public void deleteByTime();


    /**
     * 查询 SLA 达标率 -电话放弃率(Call Abandon Rate (20s))
     *
     * @return
     */
    public List<slaCompliance> selectCallAnswerRateFallRate2();


    /**
     * 查询 SLA 达标情况-超20秒掉call率-查询昨天23:00至零点数据
     *
     * @return
     */
    public List<slaCompliance> selectCallAnswerRateFallRate2ByTime();



    /**
     * 删除当天时间段23:00到零点之间数据
     */
    public void deleteFallRate2ByTime();



}
