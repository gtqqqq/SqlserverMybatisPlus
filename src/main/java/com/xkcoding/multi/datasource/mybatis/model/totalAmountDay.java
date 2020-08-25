package com.xkcoding.multi.datasource.mybatis.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

/**
 * @description: 当日受理总量 实体
 * @author: smf
 * @time: 7/14/2020 9:15 AM
 */
@Data
@TableName("total_amount_day")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class totalAmountDay {
    /**
     * 当日受理总量 ID
     */
    private Integer id;
    /**
     * 当日受理总量Time
     */
    private Date time;
    /**
     * 当日受理总单量
     */
    private Integer TicketsVol;
    /**
     * 交付
     */
    private Integer Delivered;
    /**
     * 当日受理总量-跟目标比达标程度
     */
    private String TargetHitTed;


}
