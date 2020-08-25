package com.yida.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

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
public class Csat implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value="id",type = IdType.AUTO)
    private Long id;

    @TableField("create_Day")
    private Date createDay;

    private Date endTime;

    private String csatType;

    private Integer h0=0;

    private Integer h1=0;

    private Integer h2=0;

    private Integer h3=0;

    private Integer h4=0;

    private Integer h5=0;

    private Integer h6=0;

    private Integer h7=0;

    private Integer h8=0;

    private Integer h9=0;

    private Integer h10=0;

    private Integer h11=0;

    private Integer h12=0;

    private Integer h13=0;

    private Integer h14=0;

    private Integer h15=0;

    private Integer h16=0;

    private Integer h17=0;

    private Integer h18=0;

    private Integer h19=0;

    private Integer h20=0;

    private Integer h21=0;

    private Integer h22=0;

    private Integer h23=0;
    private Integer allH0=0;

    private Integer allH1=0;

    private Integer allH2=0;

    private Integer allH3=0;

    private Integer allH4=0;

    private Integer allH5=0;

    private Integer allH6=0;

    private Integer allH7=0;

    private Integer allH8=0;

    private Integer allH9=0;

    private Integer allH10=0;

    private Integer allH11=0;

    private Integer allH12=0;

    private Integer allH13=0;

    private Integer allH14=0;

    private Integer allH15=0;

    private Integer allH16=0;

    private Integer allH17=0;

    private Integer allH18=0;

    private Integer allH19=0;

    private Integer allH20=0;

    private Integer allH21=0;

    private Integer allH22=0;

    private Integer allH23=0;




}
