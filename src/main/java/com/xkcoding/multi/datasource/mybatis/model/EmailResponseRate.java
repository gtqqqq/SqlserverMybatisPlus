package com.xkcoding.multi.datasource.mybatis.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

/**
 * @description:
 * @author: smf
 * @time: 8/11/2020
 * 邮件响应率 以及snow接单率 实体
 */
@Data
@TableName("email_response_rate")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmailResponseRate {

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
     * 邮件响应率分子-响应小时
     */
    private String MailRespRateMoleculeHour;
    /**
     * 邮件响应率分子-响应数
     */
    private String MailRespRateMoleculeNumber;
    /**
     * 邮件响应率分母-响应小时
     */
    private String MailRespRateDenominatorHour;
    /**
     * 邮件响应率分母-响应数
     */
    private String MailRespRateDenominatorNumber;
    /**
     * SNOW接单率分子-接单小时
     */
    private String SnowOrderRateMoleculeHour;
    /**
     * SNOW接单率分子-接单数
     */
    private String SnowOrderRateMoleculeNumber;
    /**
     * SNOW接单率分母-接单小时
     */
    private String SnowOrderRateDenominatorHour;
    /**
     * SNOW接单率分母-接单数
     */
    private String SnowOrderRateDenominatorNumber;
    /**
     * 截止时间
     */
    private Date EndTime;


}
