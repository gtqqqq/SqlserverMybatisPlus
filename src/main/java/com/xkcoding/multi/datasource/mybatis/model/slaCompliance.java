package com.xkcoding.multi.datasource.mybatis.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

/**
 * @description: SD-L1 ：SLA 达标情况实体
 * @author: smf
 * @time: 7/7/2020 8:48 PM
 */
@Data
@TableName("sla_compliance")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class slaCompliance {
    private static final long serialVersionUID = -1923859222295750467L;
    /**
     * SLA 达标情况 ID
     */
    private Integer id;
    /**
     * SLA 达标情况 Time
     */
    private Date time;
    /**
     * SLA 达标情况-20s内电话接通-小时数
     */
    private String OpenDateTimeOne;
    /**
     * SLA 达标情况-20秒内电话接通-电话数
     */
    private Integer NumberOne;
    /**
     * SLA 达标情况-所有电话接通-小时数
     */
    private String OpenDateTimeTwo;
    /**
     * SLA 达标情况-所有电话接通-电话数
     */
    private Integer NumberTwo;
    /**
     * SLA 达标情况-20秒内电话接通率
     */
    private String CallAnswerRate;

    /**
     * SLA 达标情况-超20S掉CALL-小时数
     */
    private String OpenDateTimeFallOne;
    /**
     * SLA 达标情况-超20S掉CALL-电话数
     */
    private Integer NumberFallOne;
    /**
     * SLA 达标情况-所有CALL-小时数
     */
    private String OpenDateTimeFallTwo;
    /**
     * SLA 达标情况-所有CALL-电话数
     */
    private Integer NumberFallTwo;
    /**
     * SLA 达标情况-超20秒掉call率
     */
    private String CallAbandonRate;
    /**
     * SLA 达标情况-10分钟内响应率
     */
    private String WeChat;
    /**
     * SLA 达标情况-预留字段
     */
    private String LiveChatServiceNow;
    /**
     * SLA 达标情况-邮箱
     */
    private String Email;
    /**
     * SLA 达标情况-预留字段-服务通知单
     */
    private String ServiceNowTickets;
    /**
     * 截止时间
     */
    private Date EndTime;

}
