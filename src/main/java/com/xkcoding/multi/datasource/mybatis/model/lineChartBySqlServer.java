package com.xkcoding.multi.datasource.mybatis.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: smf
 * @time: 7/12/2020 4:55 AM
 */
@Data
@TableName("Incident_Test")
@NoArgsConstructor
@AllArgsConstructor
public class lineChartBySqlServer {
    /**
     * 小时
     */
    private Integer openTime;
    /**
     * 数量
     */
    private Integer Number;

    public Integer getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Integer openTime) {
        this.openTime = openTime;
    }

    public Integer getNumber() {
        return Number;
    }

    public void setNumber(Integer number) {
        Number = number;
    }
}
