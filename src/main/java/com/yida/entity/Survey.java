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
 * 
 * </p>
 *
 * @author guantianqi
 * @since 2020-07-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("Survey")
public class Survey implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("agent_ID")
    private String agentId;

    private String agentName;

    private Integer agentScore;

    @TableField("CLD")
    private String cld;

    private Date callinTime;

    private String surveyId;

    private String qName;


}
