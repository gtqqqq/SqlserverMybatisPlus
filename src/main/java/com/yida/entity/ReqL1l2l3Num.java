package com.yida.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author guantianqi
 * @since 2020-07-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ReqL1l2l3Num implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer l1CreatNum;

    @TableField("l2_Resolved_num")
    private Integer l2ResolvedNum;

    @TableField("l3_Resolved_num")
    private Integer l3ResolvedNum;

    private Date createTime;


}
