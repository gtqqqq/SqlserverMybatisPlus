package com.xkcoding.multi.datasource.mybatis.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

/**
 * @description:
 * @author: smf
 * 微信响应率 以及snow在线响应率实体
 */
@Data
@TableName("wechat_response_rate")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class weChatResponseRate {

    private static final long serialVersionUID = -1923859222295750467L;

    /**
     * SLA 达标率-id
     */
    private Integer id;
    /**
     * SLA 达标率-time
     */
    private Date time;
    /**
     * 微信响应率分子-响应小时
     */
    private String WechatRespRateMoleculeHour;
    /**
     * 微信响应率分子-响应数
     */
    private String WechatRespRateMoleculeNumber;
    /**
     * 微信响应率分母-响应小时
     */
    private String WechatRespRateDenominatorHour;
    /**
     * 微信响应率分母-响应数
     */
    private String WechatRespRateDenominatorNumber;
    /**
     * 在线响应率分子-响应小时
     */
    private String SnowRespRateMoleculeHour;
    /**
     * SNOW在线响应率分子-响应数
     */
    private String SnowRespRateMoleculeNumber;
    /**
     * SNOW在线响应率分母-响应小时
     */
    private String SnowRespRateDenominatorHour;
    /**
     * SNOW在线响应率分母-响应数
     */
    private String SnowRespRateDenominatorNumber;
    /**
     * 截止时间
     */
    private Date EndTime;


}
