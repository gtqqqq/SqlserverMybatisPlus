package com.xkcoding.multi.datasource.mybatis.service;

import com.xkcoding.multi.datasource.mybatis.model.TodayTotalModel;

import java.util.List;
import java.util.Map;

/**
 * @author fnchenxi
 */
public interface TodayOrderTotalService {
    /**
     * 今日创建的工单总量
     * @return
     */
    Integer getCreateOrderNum();

    /**
     * 今日关闭的工单总量
     * @return
     */
    Integer getCloseOrderNum();

    /**
     * 今日解决的工单总量
     * @return
     */
    Integer getFinishOrderNum();

    /**
     * 返回封装的实体对象
     * @return
     */
    TodayTotalModel getTodayTotalModelData();

    int insertSelective(TodayTotalModel record);

    /**
     * 获取今日服务热点
     * @return
     */
    List<Map<String,Object>> getServerHot();


    int deleteDataByToDay();
}
