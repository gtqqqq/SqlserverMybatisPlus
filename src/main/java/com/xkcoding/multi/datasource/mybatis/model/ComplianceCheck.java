package com.xkcoding.multi.datasource.mybatis.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @description: 服务水平管理参数展示-合规抽查 控制层
 * @author: smf
 * @time: 7/12/2020 7:57 AM
 */
@Data
@TableName("service_level_compliance_check")
@NoArgsConstructor
@AllArgsConstructor
public class ComplianceCheck {

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
     * 完成记录
     */
    private Integer CompleteRecord;
    /**
     * 电话
     */
    private Integer Phone;
    /**
     * 工单
     */
    private Integer WorkOrder;
    /**
     * 微信
     */
    private Integer WeChat;
    /**
     * 邮箱
     */
    private Integer Email;
    /**
     * 抽检不合格
     */
    private Integer CompleteUnqualified;
    /**
     * 缺陷率
     */
    private Integer DefectRate;
    /**
     * 抽检率
     */
    private Integer SamplingRate;
    /**
     * 中文组
     */
    private String ChGroup;
    /**
     * ESM组
     */
    private String EsmGroup;
    /**
     * AA组
     */
    private String AAGroup;

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

    public Integer getCompleteRecord() {
        return CompleteRecord;
    }

    public void setCompleteRecord(Integer completeRecord) {
        CompleteRecord = completeRecord;
    }

    public Integer getPhone() {
        return Phone;
    }

    public void setPhone(Integer phone) {
        Phone = phone;
    }

    public Integer getWorkOrder() {
        return WorkOrder;
    }

    public void setWorkOrder(Integer workOrder) {
        WorkOrder = workOrder;
    }

    public Integer getWeChat() {
        return WeChat;
    }

    public void setWeChat(Integer weChat) {
        WeChat = weChat;
    }

    public Integer getEmail() {
        return Email;
    }

    public void setEmail(Integer email) {
        Email = email;
    }

    public Integer getCompleteUnqualified() {
        return CompleteUnqualified;
    }

    public void setCompleteUnqualified(Integer completeUnqualified) {
        CompleteUnqualified = completeUnqualified;
    }

    public Integer getDefectRate() {
        return DefectRate;
    }

    public void setDefectRate(Integer defectRate) {
        DefectRate = defectRate;
    }

    public Integer getSamplingRate() {
        return SamplingRate;
    }

    public void setSamplingRate(Integer samplingRate) {
        SamplingRate = samplingRate;
    }

    public String getChGroup() {
        return ChGroup;
    }

    public void setChGroup(String chGroup) {
        ChGroup = chGroup;
    }

    public String getEsmGroup() {
        return EsmGroup;
    }

    public void setEsmGroup(String esmGroup) {
        EsmGroup = esmGroup;
    }

    public String getAAGroup() {
        return AAGroup;
    }

    public void setAAGroup(String AAGroup) {
        this.AAGroup = AAGroup;
    }
}
