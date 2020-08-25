package com.xkcoding.multi.datasource.mybatis.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

/**
 * @description: 作业生产量管控(每日)
 * @author: smf
 * @time: 8/3/2020 3:42 PM
 */
@Data
@TableName("production_control_team_group")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductionControlTeamGroup {
    private static final long serialVersionUID = -1923859222295750467L;
    /**
     * id
     **/
    private Integer id;
    /**
     * 时间
     **/
    //@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Date time;
    /**
     * 总数
     */
    private Integer InComing;
    /**
     * 响应数
     */
    private Integer Responded;
    /**
     * 关闭数
     */
    private Integer Closed;
    /**
     * 分组名称
     */
    private String AssignmentGroup;
    /**
     * 工单类型-1-Incident，2-Request
     */
    private String MaRk;
    /**
     * 数据来源-1工单 2电话 3微信 4邮件
     */
    private String SourceType;
    /**
     * 截止时间
     */
    private Date EndTime;

}
