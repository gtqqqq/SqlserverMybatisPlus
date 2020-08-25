package com.xkcoding.multi.datasource.mybatis.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

/**
 * @description: 作业生产量管控- L1关单量 -实体
 * @author: smf
 * @time: 7/12/2020 6:41 PM
 */
@Data
@TableName("service_level_Labor_Productivity")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class serviceLevelLaborProductivity {

    private static final long serialVersionUID = -1923859222295750467L;

    /**
     * 作业生产量管控- L1关单量ID
     */
    private Integer id;
    /**
     * 作业生产量管控- L1关单量时间
     */
    private Date time;
    /**
     * 接入量
     */
    private Integer FTE;
    /**
     * 响应量
     */
    private Integer AVGTickets;
    /**
     * 关闭量
     */
    private Integer TargetHitTed;
    /**
     * 中文组
     */
    private Integer ChGroup;
    /**
     * ESM组
     */
    private Integer EsmGroup;
    /**
     * AA组
     */
    private Integer AAGroup;


}
