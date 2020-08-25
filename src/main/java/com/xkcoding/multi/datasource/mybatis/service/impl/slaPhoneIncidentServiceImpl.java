package com.xkcoding.multi.datasource.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xkcoding.multi.datasource.mybatis.mapper.slaPhoneIncidentMapper;
import com.xkcoding.multi.datasource.mybatis.model.slaCompliancePhoneIncidentSqlServer;
import com.xkcoding.multi.datasource.mybatis.model.slaPhoneIncident;
import com.xkcoding.multi.datasource.mybatis.service.slaPhoneIncidentService;
import com.xkcoding.multi.datasource.mybatis.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description: 第一通电话解决率 以及一线解决率 服务层
 * @author: smf
 * @time: 7/10/2020 11:51 AM
 */
@Service
@DS("master")
public class slaPhoneIncidentServiceImpl extends ServiceImpl<slaPhoneIncidentMapper, slaPhoneIncident> implements slaPhoneIncidentService {
    @Autowired
    private slaPhoneIncidentMapper slaPhoneIncidentMapper;

    /***
     * 录入 SD-L1 ：SLA 达标情况  FCR - Phone Incident and L1 - FLR%
     */
    @Override
    public Boolean insertSlaPhoneIncidentList(List<slaPhoneIncident> slaPhoneIncidentList) {
        return slaPhoneIncidentMapper.insertSlaPhoneIncidentList(slaPhoneIncidentList);
    }

    /**
     * 清表
     */
    @Override
    public void deleteSlaPhoneIncident() {
        slaPhoneIncidentMapper.deleteSlaPhoneIncident();
    }

    /**
     * 查询 第一通电话解决率
     *
     * @return
     */
    @DS("slave")
    @Override
    public List<slaCompliancePhoneIncidentSqlServer> selectSlaCompliancePhoneIncident() {
        return baseMapper.selectSlaCompliancePhoneIncident();
    }

    /**
     * 查询 一线解决率
     *
     * @return
     */
    @DS("slave")
    @Override
    public List<slaCompliancePhoneIncidentSqlServer> selectSlaComplianceFirstLineSolutionRate() {
        return baseMapper.selectSlaComplianceFirstLineSolutionRate();
    }

    /**
     * 查询 SLA 达标率 -电话服务事件解决率（FCR）(第一通电话解决率)
     *
     * @return
     */
    @DS("slave")
    @Override
    @Transactional
    public List<slaPhoneIncident> selectSlaCompliancePhoneIncident2() {
        List<slaPhoneIncident> data = new ArrayList<slaPhoneIncident>();
        try {
            List<Map<String, Object>> list = slaPhoneIncidentMapper.selectSlaCompliancePhoneIncident2();
            if (null != list && list.size() > 0) {
                for (Map<String, Object> da : list) {
                    slaPhoneIncident slaPhoneIncident = new slaPhoneIncident();
                    String openTime1 = (String) da.get("openTime1");
                    int number1 = Double.valueOf((Double) da.get("Number1")).intValue();
                    String openTime2 = (String) da.get("openTime2");
                    int number2 = Double.valueOf((Double) da.get("Number2")).intValue();
                    String jjRate = (String) da.get("jjRate");
                    slaPhoneIncident.setOpenTimeOne(openTime1);
                    slaPhoneIncident.setNumberOne(number1);
                    slaPhoneIncident.setOpenTimeTwo(openTime2);
                    slaPhoneIncident.setNumberTwo(number2);
                    slaPhoneIncident.setFcrPhoneIncident(jjRate);
                    slaPhoneIncident.setTime(new Date());
                    slaPhoneIncident.setEndTime(DateUtils.getAddHourTime(openTime1));
                    data.add(slaPhoneIncident);
                }
            }
            /*if (null != list && list.size() > 0) {
                for (Map<String, Object> da : list) {
                    Integer openTime1 = (Integer) da.get("openTime1");
                    if (openTime1 >= 23 && openTime1 <= 24) {
                        //调用昨天23:点至零点
                        selectSlaCompliancePhoneIncident2BYTime();
                    }
                }
            }*/

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return data;
    }

    /**
     * 查询 SLA 达标率 -电话服务事件解决率（FCR）,昨天23点至零点时间段(第一通电话解决率)
     *
     * @return
     */
    @DS("slave")
    @Override
    @Transactional
    public List<slaPhoneIncident> selectSlaCompliancePhoneIncident2BYTime() {
        List<slaPhoneIncident> data = new ArrayList<slaPhoneIncident>();
        try {
            List<Map<String, Object>> mapList = slaPhoneIncidentMapper.selectSlaCompliancePhoneIncident2BYTime();
            if (null != mapList && mapList.size() > 0) {
                for (Map<String, Object> da : mapList) {
                    slaPhoneIncident slaPhoneIncident = new slaPhoneIncident();
                    String openTime1 = (String) da.get("openTime1");
                    int number1 = Double.valueOf((Double) da.get("Number1")).intValue();
                    String openTime2 = (String) da.get("openTime2");
                    int number2 = Double.valueOf((Double) da.get("Number2")).intValue();
                    String jjRate = (String) da.get("jjRate");
                    slaPhoneIncident.setOpenTimeOne(openTime1);
                    slaPhoneIncident.setNumberOne(number1);
                    slaPhoneIncident.setOpenTimeTwo(openTime2);
                    slaPhoneIncident.setNumberTwo(number2);
                    slaPhoneIncident.setFcrPhoneIncident(jjRate);
                    slaPhoneIncident.setTime(new Date());
                    slaPhoneIncident.setEndTime(DateUtils.getCurrHourTime());
                    data.add(slaPhoneIncident);
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
    public void deleteSlaPhoneIncidentByTime() {
        slaPhoneIncidentMapper.deleteSlaPhoneIncidentByTime();
    }

    /**
     * 查询 SLA 达标率 -1线关单解决率（FLR），昨天23点至零点数据(一线解决率)
     *
     * @return
     */
    @DS("slave")
    @Override
    @Transactional
    public List<slaPhoneIncident> selectSlaComplianceFirstLineSolutionRate2() {
        List<slaPhoneIncident> data = new ArrayList<slaPhoneIncident>();
        try {
            List<Map<String, Object>> list = slaPhoneIncidentMapper.selectSlaComplianceFirstLineSolutionRate2();
            if (null != list && list.size() > 0) {
                for (Map<String, Object> da : list) {
                    slaPhoneIncident slaPhoneIncident = new slaPhoneIncident();
                    String openTime1 = (String) da.get("openTime1");
                    int number1 = Double.valueOf((Double) da.get("Number1")).intValue();
                    String openTime2 = (String) da.get("openTime2");
                    int number2 = Double.valueOf((Double) da.get("Number2")).intValue();
                    String jjRate = (String) da.get("jjRate");
                    slaPhoneIncident.setOpenDateTimeFirstLineOne(openTime1);
                    slaPhoneIncident.setNumberFirstLineOne(number1);
                    slaPhoneIncident.setOpenDateTimeFirstLineTwo(openTime2);
                    slaPhoneIncident.setNumberFirstLineTwo(number2);
                    slaPhoneIncident.setCallAbandonFirstLineRate(jjRate);
                    slaPhoneIncident.setTime(new Date());
                    slaPhoneIncident.setEndTime(DateUtils.getAddHourTime(openTime1));
                    data.add(slaPhoneIncident);
                }
            }
      /*      if (null != list && list.size() > 0) {
                for (Map<String, Object> da : list) {
                    Integer openTime1 = (Integer) da.get("openTime1");
                    if (openTime1 >= 23 && openTime1 <= 24) {
                        //调用23点至零点
                        selectSlaComplianceFirstLineSolutionRate2ByTime();
                    }
                }
            }*/

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return data;
    }

    /**
     * 查询 SLA 达标率 -1线关单解决率（FLR）,昨天23点至零点时间段数据(一线解决率)
     *
     * @return
     */
    @DS("slave")
    @Override
    @Transactional
    public List<slaPhoneIncident> selectSlaComplianceFirstLineSolutionRate2ByTime() {
        List<slaPhoneIncident> data = new ArrayList<slaPhoneIncident>();
        try {
            List<Map<String, Object>> mapList = slaPhoneIncidentMapper.selectSlaComplianceFirstLineSolutionRate2ByTime();
            if (null != mapList && mapList.size() > 0) {
                for (Map<String, Object> da : mapList) {
                    slaPhoneIncident slaPhoneIncident = new slaPhoneIncident();
                    String openTime1 = (String) da.get("openTime1");
                    int number1 = Double.valueOf((Double) da.get("Number1")).intValue();
                    String openTime2 = (String) da.get("openTime2");
                    int number2 = Double.valueOf((Double) da.get("Number2")).intValue();
                    String jjRate = (String) da.get("jjRate");
                    slaPhoneIncident.setOpenDateTimeFirstLineOne(openTime1);
                    slaPhoneIncident.setNumberFirstLineOne(number1);
                    slaPhoneIncident.setNumberFirstLineTwo(number2);
                    slaPhoneIncident.setOpenDateTimeFirstLineTwo(openTime2);
                    slaPhoneIncident.setCallAbandonFirstLineRate(jjRate);
                    slaPhoneIncident.setTime(new Date());
                    slaPhoneIncident.setEndTime(DateUtils.getCurrHourTime());
                    data.add(slaPhoneIncident);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return data;
    }

    /**
     * 删除当天23点至零点数据
     */
    @Override
    public void deleteSlaPhoneIncidentFirstLineSolutionRateByTime() {
        slaPhoneIncidentMapper.deleteSlaPhoneIncidentFirstLineSolutionRateByTime();
    }
}
