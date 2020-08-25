package com.xkcoding.multi.datasource.mybatis.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 查询sql server 数据源 封装返回实体
 * @author: smf
 * @time: 7/10/2020 12:12 PM
 */
@Data
@TableName("Incident_Test")
@NoArgsConstructor
@AllArgsConstructor
public class slaCompliancePhoneIncidentSqlServer {

    private Integer openTime1;
    private Integer Number1;
    private Integer openTime2;
    private Integer Number2;
    private String jjRate;


    public Integer getOpenTime1() {
        return openTime1;
    }

    public void setOpenTime1(Integer openTime1) {
        this.openTime1 = openTime1;
    }

    public Integer getNumber1() {
        return Number1;
    }

    public void setNumber1(Integer number1) {
        Number1 = number1;
    }

    public Integer getOpenTime2() {
        return openTime2;
    }

    public void setOpenTime2(Integer openTime2) {
        this.openTime2 = openTime2;
    }

    public Integer getNumber2() {
        return Number2;
    }

    public void setNumber2(Integer number2) {
        Number2 = number2;
    }

    public String getJjRate() {
        return jjRate;
    }

    public void setJjRate(String jjRate) {
        this.jjRate = jjRate;
    }
}
