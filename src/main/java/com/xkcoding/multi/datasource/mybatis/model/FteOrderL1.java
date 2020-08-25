package com.xkcoding.multi.datasource.mybatis.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

@Data
@TableName("fte_order_l1")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FteOrderL1 {
    private static final long serialVersionUID = -1923859222295750467L;
    private Integer id;

    private Date createTime;

    private String groupName;

    private Integer fte;

    private Integer total;

    private Integer respondedTickets;

    private Integer mark;

    private Integer sourceType;
    /**
     * 新增 截止时间
     */
    private Date endTime;


}