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
 * @description: L1累计电话接入实体
 * @param null
 *
 */
@Data
@TableName("response_call")
@NoArgsConstructor
@AllArgsConstructor
public class responseCall implements Serializable {

    private static final long serialVersionUID = -1923859222295750467L;

    /**
     * id
     **/
    private Integer id;
    /**
     * 时间
     **/
    private Date time;
    /***
     * 累计电话接入
     */
    private Integer callSum;

    /***
     * 累计响应
     */
    private Integer respSum;

    /***
     * 累计解决
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

    public Integer getCallSum() {
        return callSum;
    }

    public void setCallSum(Integer callSum) {
        this.callSum = callSum;
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
