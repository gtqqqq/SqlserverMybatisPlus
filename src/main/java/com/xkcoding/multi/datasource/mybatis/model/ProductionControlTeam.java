package com.xkcoding.multi.datasource.mybatis.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

/**
 * @description: 作业生产量管控 实体
 * @author: smf
 * @time: 7/12/2020 8:43 AM
 */
@Data
@TableName("Production_Control_Team")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProductionControlTeam {
    private static final long serialVersionUID = -1923859222295750467L;

    /**
     * id
     **/
    private Integer id;
    /**
     * 时间
     **/
    private Date time;

    /**
     * 接入量
     */
    private Integer Incoming;
    /**
     * 响应量
     */
    private Integer Responded;
    /**
     * 关闭量
     */
    private Integer Closed;
    /**
     * 中文组
     */
    private String ChGroup;
    /***
     * ESM组
     */
    private String EsmGroup;
    /**
     * AA组
     */
    private String AAGroup;
    /**
     * 截止时间
     */
    private Date EndTime;
}
