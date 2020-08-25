package com.yida.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 作业生产量管控(每日)总数统计
 * </p>
 *
 * @author gtq
 * @since 2020-07-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("L3_production_control_total")
public class L3ProductionControlTotal implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date createTime;

    /**
     * 统计名称
     */
    private String name;

    /**
     * 总数
     */
    private Integer ticketsVol;

    /**
     * 百分比
     */
    private BigDecimal delivered;

    /**
     * 目标率
     */
    private String targetHitted;



}
