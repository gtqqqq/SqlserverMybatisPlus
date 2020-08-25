package com.xkcoding.multi.datasource.mybatis.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * CallCalcTable 实体
 */
@Data
@TableName("callcalctable")
@NoArgsConstructor
@AllArgsConstructor
public class CallCalcTable implements Serializable {
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
     * 电话总量
     **/
    private Double CallSum;
    /**
     * 接起量
     */
    private Double HanDerSum;
    /**
     * 掉量
     */
    private Double MissSum;


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

    public Double getCallSum() {
        return CallSum;
    }

    public void setCallSum(Double callSum) {
        CallSum = callSum;
    }

    public Double getHanDerSum() {
        return HanDerSum;
    }

    public void setHanDerSum(Double hanDerSum) {
        HanDerSum = hanDerSum;
    }

    public Double getMissSum() {
        return MissSum;
    }

    public void setMissSum(Double missSum) {
        MissSum = missSum;
    }


}
