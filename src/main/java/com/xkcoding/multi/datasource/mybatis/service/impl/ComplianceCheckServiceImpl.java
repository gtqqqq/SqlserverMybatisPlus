package com.xkcoding.multi.datasource.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xkcoding.multi.datasource.mybatis.mapper.ComplianceCheckServiceMapper;
import com.xkcoding.multi.datasource.mybatis.mapper.businessVolumeMapper;
import com.xkcoding.multi.datasource.mybatis.model.ComplianceCheck;
import com.xkcoding.multi.datasource.mybatis.model.businessVolume;
import com.xkcoding.multi.datasource.mybatis.service.ComplianceCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 服务水平管理参数展示-合规抽检-服务层
 * @author: smf
 * @time: 7/12/2020 8:04 AM
 */
@Service
@DS("master")
public class ComplianceCheckServiceImpl extends ServiceImpl<ComplianceCheckServiceMapper, ComplianceCheck> implements ComplianceCheckService {
    @Autowired
    private ComplianceCheckServiceMapper complianceCheckServiceMapper;

    /**
     * 录入 合规抽检
     *
     * @param complianceCheckList
     * @return
     */
    @Override
    public Boolean insertComplianceCheckList(List<ComplianceCheck> complianceCheckList) {
        return complianceCheckServiceMapper.insertComplianceCheckList(complianceCheckList);
    }

    /**
     * 清表
     */
    @Override
    public void deleteComplianceCheck() {
        complianceCheckServiceMapper.deleteComplianceCheck();
    }

    /**
     * 查询合规抽检-电话
     *
     * @return
     */
    @DS("slave")
    @Override
    public Integer selectComplianceCheckByPhone() {
        return complianceCheckServiceMapper.selectComplianceCheckByPhone();
    }

    /**
     * 查询合规抽检-工单
     *
     * @return
     */
    @DS("slave")
    @Override
    public Integer selectComplianceCheckWorkOrder() {
        return baseMapper.selectComplianceCheckWorkOrder();
    }

    /**
     * 查询合规抽检-微信
     *
     * @return
     */
    @DS("slave")
    @Override
    public Integer selectComplianceCheckWeChat() {
        return baseMapper.selectComplianceCheckWeChat();
    }

    /**
     * 查询合规抽检-邮件
     *
     * @return
     */
    @DS("slave")
    @Override
    public Integer selectComplianceEmail() {
        return baseMapper.selectComplianceEmail();
    }

    /**
     * 查询合规抽检-抽检不合格
     *
     * @return
     */
    @DS("slave")
    @Override
    public Integer selectComplianceUnqualified() {
        return baseMapper.selectComplianceUnqualified();
    }

    /**
     * 查询合规抽检-Defect rate
     *
     * @return
     */
    @DS("slave")
    @Override
    public String selectComplianceDefectRate() {
        return baseMapper.selectComplianceDefectRate();
    }

    /**
     * 查询合规抽检-抽检率
     *
     * @return
     */
    @DS("slave")
    @Override
    public String selectComplianceSamplingRate() {
        return baseMapper.selectComplianceSamplingRate();
    }
}
