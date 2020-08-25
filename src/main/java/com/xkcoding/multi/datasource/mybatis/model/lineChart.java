package com.xkcoding.multi.datasource.mybatis.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description: 导航折线图实体
 * @author: smf
 * @time: 7/6/2020 8:56 PM
 */
@Data
@TableName("line_chart")
@NoArgsConstructor
@AllArgsConstructor
public class lineChart {

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
     * 关闭工单时间
     */
    private Integer workOrderClosedHour;
    /**
     * 关闭工单数量
     */
    private Integer workOrderClosedNum;
    /**
     * 创建工单时间
     */
    private Integer workOrderCreateHour;
    /**
     * 创建工单数量
     */
    private Integer workOrderCreateNum;
    /**
     * 电话接入时间
     */
    private Integer phoneRespHour;
    /**
     * 电话接入数量
     */
    private Integer phoneRespNum;

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

    public Integer getWorkOrderClosedHour() {
        return workOrderClosedHour;
    }

    public void setWorkOrderClosedHour(Integer workOrderClosedHour) {
        this.workOrderClosedHour = workOrderClosedHour;
    }

    public Integer getWorkOrderClosedNum() {
        return workOrderClosedNum;
    }

    public void setWorkOrderClosedNum(Integer workOrderClosedNum) {
        this.workOrderClosedNum = workOrderClosedNum;
    }

    public Integer getWorkOrderCreateHour() {
        return workOrderCreateHour;
    }

    public void setWorkOrderCreateHour(Integer workOrderCreateHour) {
        this.workOrderCreateHour = workOrderCreateHour;
    }

    public Integer getWorkOrderCreateNum() {
        return workOrderCreateNum;
    }

    public void setWorkOrderCreateNum(Integer workOrderCreateNum) {
        this.workOrderCreateNum = workOrderCreateNum;
    }

    public Integer getPhoneRespHour() {
        return phoneRespHour;
    }

    public void setPhoneRespHour(Integer phoneRespHour) {
        this.phoneRespHour = phoneRespHour;
    }

    public Integer getPhoneRespNum() {
        return phoneRespNum;
    }

    public void setPhoneRespNum(Integer phoneRespNum) {
        this.phoneRespNum = phoneRespNum;
    }
}
