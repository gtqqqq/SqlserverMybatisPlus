package com.xkcoding.multi.datasource.mybatis.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author: smf
 * @time: 7/7/2020 11:13 AM
 * @description: L1累计工单派出实体
 * @param null
 *
 */
@Data
@TableName("response_work_order")
@NoArgsConstructor
@AllArgsConstructor
public class responseWorkOrder implements Serializable {
    private static final long serialVersionUID = -1923859222295750467L;

    /**
     * L1工单派出ID
     */
    private Integer id;
    /**
     * L1工单派出时间
     */
    private Date time;
    /**
     * L1累计工单派出
     */
    private Integer workOrderSum;
    /**
     * L1累计响应
     */
    private Integer respSum;
    /**
     * l1累计解决
     */
    private Integer solveSum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getWorkOrderSum() {
        return workOrderSum;
    }

    public void setWorkOrderSum(Integer workOrderSum) {
        this.workOrderSum = workOrderSum;
    }

    public Integer getRespSum() {
        return respSum;
    }

    public void setRespSum(Integer respSum) {
        this.respSum = respSum;
    }

    public Integer getSolveSum() {
        return solveSum;
    }

    public void setSolveSum(Integer solveSum) {
        this.solveSum = solveSum;
    }
}
