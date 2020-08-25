package com.xkcoding.multi.datasource.mybatis.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

/**
 * @author smf
 * @Description: 20秒内 电话接通率，以及超20秒电话放弃率实体
 * @date 2020/8/19 9:43
 */
@Data
@TableName("sla_compliance_by_specific_date")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SlaComplianceBySpecificDate {

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
     * 20s内电话接通-分子日期
     */
    private String twentySecondsWithinMoleculeDate;

    /**
     * 20秒内电话接通-分子数量
     */
    private String twentySecondsWithinMoleculeNum;

    /**
     * 20s内电话接通-分母日期
     */
    private String twentySecondsWithinDenominatorDate;

    /**
     * 20秒内电话接通-分母数量
     */
    private String twentySecondsWithinDenominatorNum;

    /**
     * 20秒内电话接通率
     */
    private String twentySecondsWithinRate;

    /**
     * 超20S掉CALL-分子日期
     */
    private String twentySecondsLaterMoleculeDate;

    /**
     * 超20S掉CALL-分子数量
     */
    private String twentySecondsLaterMoleculeNum;

    /**
     * 超20S掉CALL-分母日期
     */
    private String twentySecondsLaterDenominatorDate;

    /**
     * 超20S掉CALL-分母数量
     */
    private String twentySecondsLaterDenominatorNum;

    /**
     * 超20秒掉call率
     */
    private String twentySecondsLaterRate;

    /**
     * 截止时间
     */
    private Date EndTime;


}
