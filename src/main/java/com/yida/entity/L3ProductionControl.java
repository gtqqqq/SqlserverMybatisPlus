package com.yida.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 作业生产量管控(每日)
 * </p>
 *
 * @author gtq
 * @since 2020-07-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("L3_production_control")
public class L3ProductionControl implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date createTime;

    /**
     * 总数
     */
    private Integer totalNum;

    @TableField("Responded")
    private Integer Responded;

    /**
     * 关闭数
     */
    private Integer closeNum;

    /**
     * 分组名称
     */
    private String assignmentGroup;

    /**
     * 工单类型
     */
    private Integer mark;

    /**
     * 来源
     */
    private Integer sourceType;

    private Date endTime;

}
