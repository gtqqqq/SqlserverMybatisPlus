package com.xkcoding.multi.datasource.mybatis.service;

import com.sun.imageio.plugins.common.I18N;
import com.xkcoding.multi.datasource.mybatis.model.ComplianceCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: smf
 * @time: 7/12/2020 8:04 AM
 * @description: 服务水平管理参数展示-合规抽检-服务层
 */
public interface ComplianceCheckService {
    /**
     * 录入 合规抽检
     *
     * @param complianceCheckList
     * @return
     */
    public Boolean insertComplianceCheckList(List<ComplianceCheck> complianceCheckList);

    /**
     * 清表
     */
    public void deleteComplianceCheck();

    /**
     * 查询合规抽检-电话
     *
     * @return
     */
    public Integer selectComplianceCheckByPhone();

    /**
     * 查询合规抽检-工单
     *
     * @return
     */
    public Integer selectComplianceCheckWorkOrder();


    /**
     * 查询合规抽检-微信
     *
     * @return
     */
    public Integer selectComplianceCheckWeChat();

    /**
     * 查询合规抽检-邮件
     *
     * @return
     */
    public Integer selectComplianceEmail();


    /**
     * 查询合规抽检-抽检不合格
     *
     * @return
     */
    public Integer selectComplianceUnqualified();


    /**
     * 查询合规抽检-Defect rate
     *
     * @return
     */
    public String selectComplianceDefectRate();


    /**
     * 查询合规抽检-抽检率
     *
     * @return
     */
    public String selectComplianceSamplingRate();
}
