package com.xkcoding.multi.datasource.mybatis.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: Call Answer Rate 20秒内电话接通率 超20秒掉call率 封装返回实体
 * @author: smf
 * @time: 7/9/2020 6:20 PM
 */
@Data
@TableName("Call_Test")
@NoArgsConstructor
@AllArgsConstructor
public class slaComplianceSqlServer {

    private Integer opendateTime1;
    private Integer Number1;
    private Integer opendateTime2;
    private Integer Number2;
    private String jtRate;


    public Integer getNumber1() {
        return Number1;
    }

    public void setNumber1(Integer number1) {
        Number1 = number1;
    }

    public Integer getOpendateTime2() {
        return opendateTime2;
    }

    public void setOpendateTime2(Integer opendateTime2) {
        this.opendateTime2 = opendateTime2;
    }

    public Integer getNumber2() {
        return Number2;
    }

    public void setNumber2(Integer number2) {
        Number2 = number2;
    }

    public String getJtRate() {
        return jtRate;
    }

    public void setJtRate(String jtRate) {
        this.jtRate = jtRate;
    }

    public Integer getOpendateTime1() {
        return opendateTime1;
    }

    public void setOpendateTime1(Integer opendateTime1) {
        this.opendateTime1 = opendateTime1;
    }
}
