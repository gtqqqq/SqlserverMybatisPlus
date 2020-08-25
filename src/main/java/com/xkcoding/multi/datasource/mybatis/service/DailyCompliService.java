package com.xkcoding.multi.datasource.mybatis.service;

import com.xkcoding.multi.datasource.mybatis.model.DailyComplianceStatistics;
import com.xkcoding.multi.datasource.mybatis.model.DailyComplianceStatisticsL3;
import com.xkcoding.multi.datasource.mybatis.model.OrderComplianceAvg;
import com.xkcoding.multi.datasource.mybatis.model.TodayTotalModel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 每日达标server
 * @author fanchenxi
 */
public interface DailyCompliService {

    /**
     * 组装好查询的数据，封装为一个L2实体对象
     * @return
     */
    List<DailyComplianceStatistics> getModelL2Data();


    /**
     * 组装好查询的数据,根据组名分组，封装为一个L2实体List对象
     * @return
     */
    List<DailyComplianceStatistics> getModelL2GroupData();

    /**
     * 组装好查询的数据，封装为一个L3实体对象
     * @return
     */
    List<DailyComplianceStatisticsL3> getModelL3Data();

    /**
     * 组装好查询的数据,根据组名分组，封装为一个L3实体List对象
     * @return
     */
    List<DailyComplianceStatisticsL3> getModelL3GroupData();

    /**
     * 插入到L2的达标表里
     * @param record
     * @return
     */
    int insertSelectiveL2(List<DailyComplianceStatistics> record);

    /**
     * 批量插入到L2的达标表里
     * @param record
     * @return
     */
    int batchInsertSelectiveL2(List<DailyComplianceStatistics> record);

    /**
     * 插入到L3的达标表里
     * @param record
     * @return
     */
    int insertSelectiveL3(List<DailyComplianceStatisticsL3> record);

    /**
     * 批量插入到L3的达标表里
     * @param list
     * @return
     */
    int batchInsertSelectiveL3(List<DailyComplianceStatisticsL3> list);

    /**
     * 删除今日L3数据
     * @return
     */
    int deleteL3DataByToDay();

    /**
     * 删除今日L2的数据
     * @return
     */
    int deleteL2DataByToDay();

    /**
     * 获取当天Inc的数据，返回的数据为合格数量和总数，参数为表名（L2和L3的Inc视图）
     * @return
     */
    List<Map<String,Object>> getSlaRangeData(Map<String,String>map);

    /**
     * 工单平均解决时长
     * @return
     */
    Map<Date, Map<String, Object>> getAvgData(Map<String,String> map);

    /**
     * 封装L2和L3工单解决时长的数据为DB的格式
     * @return
     */
    List<OrderComplianceAvg> getModelData();

    /**
     * 删除当天平均时长表数据
     * @return
     */
    int deleteOrderCompliAvg();

    /**
     * 添加当天平均时长表数据
     * @param modelDataAvg
     * @return
     */
    int insertOrderCompliAvg(List<OrderComplianceAvg> modelDataAvg);




    List<DailyComplianceStatistics> getModelL2DataByReq();

    int deleteL2RqeDataByToDay();

    List<DailyComplianceStatisticsL3> getModelL3DataByReq();

    int deleteL3ReqDataByToDay();
}
