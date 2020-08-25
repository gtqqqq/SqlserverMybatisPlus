package com.xkcoding.multi.datasource.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xkcoding.multi.datasource.mybatis.mapper.EmailResponseRateMapper;
import com.xkcoding.multi.datasource.mybatis.model.EmailResponseRate;
import com.xkcoding.multi.datasource.mybatis.service.EmailResponseRateService;
import com.xkcoding.multi.datasource.mybatis.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 邮件响应率以及snow接单率服务层
 */
@Service
@DS("master")
public class EmailResponseRateServiceImpl extends ServiceImpl<EmailResponseRateMapper, EmailResponseRate> implements EmailResponseRateService {

    @Autowired
    private EmailResponseRateMapper emailResponseRateMapper;

    /**
     * 录入邮件响应率 以及snow接单率
     *
     * @return
     */
    @Override
    public Boolean insertEmailResponseRateByList(List<EmailResponseRate> emailResponseRateList) {
        return emailResponseRateMapper.insertEmailResponseRateByList(emailResponseRateList);
    }

    /**
     * 清表
     */
    @Override
    public void deleteEmailResponseRate() {
        emailResponseRateMapper.deleteEmailResponseRate();
    }

    /**
     * 查询 邮件响应率
     *
     * @return
     */
    @DS("slave")
    @Override
    public List<EmailResponseRate> selectEmailResponseRate() {
        List<EmailResponseRate> data = new ArrayList<EmailResponseRate>();
        try {
            List<Map<String, Object>> list = emailResponseRateMapper.selectEmailResponseRate();
            if (null != list && list.size() > 0) {
                for (Map<String, Object> da : list) {
                    EmailResponseRate emailResponseRate = new EmailResponseRate();
                    emailResponseRate.setMailRespRateMoleculeHour(da.get("opendateTime1").toString());
                    int number1 = Double.valueOf((Double) da.get("Number1")).intValue();
                    String str = String.valueOf(number1);
                    emailResponseRate.setMailRespRateMoleculeNumber(str);
                    emailResponseRate.setMailRespRateDenominatorHour(da.get("opendateTime2").toString());
                    int number2 = Double.valueOf((Double) da.get("Number2")).intValue();
                    String str2 = String.valueOf(number2);
                    emailResponseRate.setMailRespRateDenominatorNumber(str2);
                    emailResponseRate.setTime(new Date());
                    emailResponseRate.setEndTime(DateUtils.getCurrHourTime());
                    data.add(emailResponseRate);
                }
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return data;
    }
}
