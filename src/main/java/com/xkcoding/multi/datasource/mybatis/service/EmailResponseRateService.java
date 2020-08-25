package com.xkcoding.multi.datasource.mybatis.service;

import com.xkcoding.multi.datasource.mybatis.model.EmailResponseRate;

import java.util.List;

/**
 * @author: smf
 * @time: 8/11/2020
 * @description: 邮件响应率 以及snow接单率 服务层
 */
public interface EmailResponseRateService {
    /**
     * 录入邮件响应率 以及snow接单率
     *
     * @return
     */
    Boolean insertEmailResponseRateByList(List<EmailResponseRate> emailResponseRateList);


    /**
     * 清表
     */
    void deleteEmailResponseRate();

    /**
     * 查询 邮件响应率
     *
     * @return
     */
    List<EmailResponseRate> selectEmailResponseRate();

}
