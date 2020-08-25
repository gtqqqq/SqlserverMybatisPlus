package com.xkcoding.multi.datasource.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xkcoding.multi.datasource.mybatis.mapper.businessVolumeMapper;
import com.xkcoding.multi.datasource.mybatis.mapper.slaComplianceMapper;
import com.xkcoding.multi.datasource.mybatis.model.businessVolume;
import com.xkcoding.multi.datasource.mybatis.model.slaCompliance;
import com.xkcoding.multi.datasource.mybatis.model.slaComplianceSqlServer;
import com.xkcoding.multi.datasource.mybatis.service.slaComplianceService;
import com.xkcoding.multi.datasource.mybatis.util.DateUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description: SD-L1 ：SLA 达标情况 服务层
 * @author: smf
 * @time: 7/7/2020 9:00 PM
 */
@Service
@Slf4j
@DS("master")
public class slaComplianceServiceImpl extends ServiceImpl<slaComplianceMapper, slaCompliance> implements slaComplianceService {
    @Autowired
    private slaComplianceMapper slaComplianceMapper;

    /**
     * 录入SD-L1 ：SLA 达标情况
     *
     * @param slaComplianceList
     * @return
     */
    @Override
    public Boolean insertSlaComplianceList(List<slaCompliance> slaComplianceList) {
        return slaComplianceMapper.insertSlaComplianceList(slaComplianceList);
    }

    /**
     * 清表
     */
    @Override
    public void deleteSlaCompliance() {
        slaComplianceMapper.deleteSlaCompliance();
    }

    /**
     * 查询 SLA 达标情况-20秒内电话接通率
     *
     * @return
     */
    @DS("slave")
    @Override
    public List<slaComplianceSqlServer> selectCallAnswerRate() {
        return baseMapper.selectCallAnswerRate();
    }

    /**
     * 查询 SLA 达标情况-超20秒掉call率
     *
     * @return
     */
    @DS("slave")
    @Override
    public List<slaComplianceSqlServer> selectCallAnswerRateFallRate() {
        return baseMapper.selectCallAnswerRateFallRate();
    }

    /**
     * 查询 SLA 达标率 - L1-电话接听率(（Call Answer Rate (20s)）)
     *
     * @return
     */
    @DS("slave")
    @Override
    @Transactional
    public List<slaCompliance> selectCallAnswerRate2() {
        List<slaCompliance> data = new ArrayList<slaCompliance>();
        try {
            List<Map<String, Object>> list = slaComplianceMapper.selectCallAnswerRate2();
            if (null != list && list.size() > 0) {
                for (Map<String, Object> da : list) {
                    slaCompliance slaCompliance = new slaCompliance();
                    String opendateTime1 = (String) da.get("opendateTime1");
                    int Number1 = Double.valueOf((Double) da.get("Number1")).intValue();
                    String opendateTime2 = (String) da.get("opendateTime2");
                    int Number2 = Double.valueOf((Double) da.get("Number2")).intValue();
                    String jtRate = (String) da.get("jtRate");
                    slaCompliance.setOpenDateTimeOne(opendateTime1);
                    slaCompliance.setNumberOne(Number1);
                    slaCompliance.setOpenDateTimeTwo(opendateTime2);
                    slaCompliance.setNumberTwo(Number2);
                    slaCompliance.setCallAnswerRate(jtRate);
                    slaCompliance.setTime(new Date());
                    slaCompliance.setEndTime(DateUtils.getAddHourTime(opendateTime1));
                    data.add(slaCompliance);
                }
            }
     /*       if (null != list && list.size() > 0) {
                for (Map<String, Object> da : list) {
                    Integer opdateTime = (Integer) da.get("opendateTime1");
                    if (opdateTime >= 23 && opdateTime <= 24) {
                        selectYesterdayByTime();
                    }
                }

            }*/
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return data;
    }

    /**
     * 查询昨天十一点数据
     *
     * @return
     */
    @DS("slave")
    @Override
    @Transactional
    public List<slaCompliance> selectYesterdayByTime() {
        List<slaCompliance> data = new ArrayList<>();
        try {
            List<Map<String, Object>> maps = slaComplianceMapper.selectYesterdayByTime();
            if (null != maps && maps.size() > 0) {
                for (Map<String, Object> da : maps) {
                    slaCompliance slaCompliance = new slaCompliance();
                    String opendateTime1 = (String) da.get("opendateTime1");
                    int number1 = Double.valueOf((Double) da.get("Number1")).intValue();
                    String opendateTime2 = (String) da.get("opendateTime2");
                    int Number2 = Double.valueOf((Double) da.get("Number2")).intValue();
                    String jtRate = (String) da.get("jtRate");
                    slaCompliance.setOpenDateTimeOne(opendateTime1);
                    slaCompliance.setNumberOne(number1);
                    slaCompliance.setOpenDateTimeTwo(opendateTime2);
                    slaCompliance.setNumberTwo(Number2);
                    slaCompliance.setCallAnswerRate(jtRate);
                    slaCompliance.setTime(new Date());
                    slaCompliance.setEndTime(DateUtils.getCurrHourTime());
                    data.add(slaCompliance);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return data;
    }

    /**
     * 删除当天时间段23:00到零点之间数据
     */
    @Override
    public void deleteByTime() {
        slaComplianceMapper.deleteByTime();
    }

    /**
     * 查询 SLA 达标率 -电话放弃率(Call Abandon Rate (20s))
     *
     * @return
     */
    @DS("slave")
    @Override
    @Transactional
    public List<slaCompliance> selectCallAnswerRateFallRate2() {
        List<slaCompliance> data = new ArrayList<slaCompliance>();
        try {
            List<Map<String, Object>> list = slaComplianceMapper.selectCallAnswerRateFallRate2();
            if (null != list && list.size() > 0) {
                for (Map<String, Object> da : list) {
                    slaCompliance slaCompliance = new slaCompliance();
                    String opendatetime1 = (String) da.get("opendateTime1");
                    int number1 = Double.valueOf((Double) da.get("Number1")).intValue();
                    String opendatetime2 = (String) da.get("opendateTime2");
                    int number2 = Double.valueOf((Double) da.get("Number2")).intValue();
                    String jtrate = (String) da.get("jtRate");
                    slaCompliance.setOpenDateTimeFallOne(opendatetime1);
                    slaCompliance.setNumberFallOne(number1);
                    slaCompliance.setOpenDateTimeFallTwo(opendatetime2);
                    slaCompliance.setNumberFallTwo(number2);
                    slaCompliance.setCallAbandonRate(jtrate);
                    slaCompliance.setTime(new Date());
                    slaCompliance.setEndTime(DateUtils.getAddHourTime(opendatetime1));
                    data.add(slaCompliance);
                }
            }
      /*      if (null != list && list.size() > 0) {
                for (Map<String, Object> da : list) {
                    Integer opendTimeOne = (Integer) da.get("opendateTime1");
                    if (opendTimeOne >= 23 && opendTimeOne <= 24) {
                        // 调用昨天23:00至零点
                        selectCallAnswerRateFallRate2ByTime();
                    }
                }

            }*/

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return data;
    }

    /**
     * 查询 SLA 达标情况-超20秒掉call率-查询昨天23:00至零点数据
     *
     * @return
     */
    @DS("slave")
    @Override
    @Transactional
    public List<slaCompliance> selectCallAnswerRateFallRate2ByTime() {
        List<slaCompliance> data = new ArrayList<slaCompliance>();
        try {
            List<Map<String, Object>> mapList = slaComplianceMapper.selectCallAnswerRateFallRate2ByTime();
            if (null != mapList && mapList.size() > 0 && !mapList.isEmpty()) {
                for (Map<String, Object> da : mapList) {
                    slaCompliance slaCompliance = new slaCompliance();
                    String opendateTime1 = (String) da.get("opendateTime1");
                    int number1 = Double.valueOf((Double) da.get("Number1")).intValue();
                    String opendateTime2 = (String) da.get("opendateTime2");
                    int number2 = Double.valueOf((Double) da.get("Number2")).intValue();
                    String jtRate = (String) da.get("jtRate");
                    slaCompliance.setOpenDateTimeFallOne(opendateTime1);
                    slaCompliance.setNumberFallOne(number1);
                    slaCompliance.setOpenDateTimeFallTwo(opendateTime2);
                    slaCompliance.setNumberFallTwo(number2);
                    slaCompliance.setCallAbandonRate(jtRate);
                    slaCompliance.setTime(new Date());
                    slaCompliance.setEndTime(DateUtils.getCurrHourTime());
                    data.add(slaCompliance);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return data;
    }

    /**
     * 删除当天时间段23:00到零点之间数据
     */
    @Override
    public void deleteFallRate2ByTime() {
        slaComplianceMapper.deleteFallRate2ByTime();
    }


}
