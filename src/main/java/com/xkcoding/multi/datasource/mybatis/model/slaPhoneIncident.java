package com.xkcoding.multi.datasource.mybatis.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

/**
 * @description: 第一通电话解决率第一通电话解决率  以及 一线解决率 实体
 * @author: smf
 * @time: 7/10/2020 11:38 AM
 */
@Data
@TableName("sla_phone_incident")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class slaPhoneIncident {
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
     * 第一通电话解决率分子-小时数
     */
    private String openTimeOne;
    /**
     * 第一通电话解决率分子-电话数
     */
    private Integer NumberOne;
    /**
     * 第一通电话解决率分母-小时数
     */
    private String OpenTimeTwo;
    /**
     * 第一通电话解决率分母-电话数
     */
    private Integer NumberTwo;
    /**
     * 第一通电话解决率
     */
    private String FcrPhoneIncident;
    /**
     * 一线解决率分子-小时数
     */
    private String OpenDateTimeFirstLineOne;
    /**
     * 一线解决率分子-电话数
     */
    private Integer NumberFirstLineOne;
    /**
     * 一线解决率分母-小时数
     */
    private String OpenDateTimeFirstLineTwo;
    /**
     * 一线解决率分母-电话数
     */
    private Integer NumberFirstLineTwo;
    /**
     * L1 - FLR%—1线解决率
     */
    private String CallAbandonFirstLineRate;
    /**
     * 预留字段
     */
    private String ReopenIncident;
    /**
     * 截止时间
     */
    private Date EndTime;

}
