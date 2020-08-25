package com.xkcoding.multi.datasource.mybatis.service;

import com.xkcoding.multi.datasource.mybatis.model.weChatResponseRate;

import java.util.List;

/**
 * @author: smf
 * @description:微信响应率 以及snow在线响应率 服务层
 */
public interface weChatResponseRateService {


    /**
     * 录入微信响应率以及snow在线响应率
     *
     * @return
     */
     Boolean insertWeChatResponseRate(List<weChatResponseRate> weChatResponseRateList);

    /**
     * 清表
     */
     void deleteWeChatResponseRate();

    /**
     * 查询 微信响应率
     *
     * @return
     */
     List<weChatResponseRate> selectWeChatResponseRate();


    /**
     * 查询 SNOW在线响应率
     *
     * @return
     */
     List<weChatResponseRate> selectSnowRate();

}
