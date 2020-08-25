package com.xkcoding.multi.datasource.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xkcoding.multi.datasource.mybatis.mapper.SlaComplianceBySpecificDateMapper;
import com.xkcoding.multi.datasource.mybatis.mapper.slaComplianceMapper;
import com.xkcoding.multi.datasource.mybatis.model.SlaComplianceBySpecificDate;
import com.xkcoding.multi.datasource.mybatis.model.slaCompliance;
import com.xkcoding.multi.datasource.mybatis.service.SlaComplianceBySpecificDateService;
import com.xkcoding.multi.datasource.mybatis.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author smf
 * @Description: 20秒内 电话接通率，以及超20秒电话放弃率服务层
 * @date 2020/8/199:57
 */
@Service
@Slf4j
@DS("master")
public class SlaComplianceBySpecificDateServiceImpl extends ServiceImpl<SlaComplianceBySpecificDateMapper, SlaComplianceBySpecificDate> implements SlaComplianceBySpecificDateService {
    @Autowired
    private SlaComplianceBySpecificDateMapper slaComplianceBySpecificDateMapper;

    /**
     * 录入 SlaComplianceBySpecificDate
     *
     * @param specificDateList
     * @return
     */
    @Override
    public Boolean insertSlaComplianceBySpecificDate(List<SlaComplianceBySpecificDate> specificDateList) {
        return slaComplianceBySpecificDateMapper.insertSlaComplianceBySpecificDate(specificDateList);
    }

    /**
     * 清表
     */
    @Override
    public void deleteSlaComplianceBySpecificDate() {
        slaComplianceBySpecificDateMapper.deleteSlaComplianceBySpecificDate();
    }

    /**
     * 查询20s 电话接通率by年月日小时
     */
    @DS("slave")
    @Override
    public List<SlaComplianceBySpecificDate> selectSlaComplianceBySpecificDate() {
        List<SlaComplianceBySpecificDate> data = new ArrayList<SlaComplianceBySpecificDate>();

        try {
            List<Map<String, Object>> list = slaComplianceBySpecificDateMapper.selectSlaComplianceBySpecificDate();
            if (null != list && list.size() > 0) {
                for (Map<String, Object> da : list) {
                    SlaComplianceBySpecificDate specificDate = new SlaComplianceBySpecificDate();
                    String opendateTime1 = (String) da.get("opendateTime1");
                    String Number1 = String.valueOf(da.get("Number1"));
                    String opendateTime2 = (String) da.get("opendateTime2");
                    String Number2 = String.valueOf(da.get("Number2"));
                    String jtRate = (String) da.get("jtRate");
                    specificDate.setTime(new Date());
                    specificDate.setTwentySecondsWithinMoleculeDate(opendateTime1);
                    specificDate.setTwentySecondsWithinMoleculeNum(Number1);
                    specificDate.setTwentySecondsWithinDenominatorDate(opendateTime2);
                    specificDate.setTwentySecondsWithinDenominatorNum(Number2);
                    specificDate.setEndTime(DateUtils.getCurrHourTime());
                    specificDate.setTwentySecondsWithinRate(jtRate);
                    data.add(specificDate);
                }
            }
            /*if (null != list && !list.isEmpty()) {
                for (Map<String, Object> da : list) {
                    SlaComplianceBySpecificDate sl = new SlaComplianceBySpecificDate();
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:00:00");
                    String opendateTime1 = (String) da.get("opendateTime1");
                    if (null != opendateTime1 && !"".equals(opendateTime1) && opendateTime1.length() != 0) {
                       *//* String time = format.format(opendateTime1);
                        Date ps = null;
                        ps = format.parse(time);
                        sl.setEndTime(ps);*//*
                    }
                }
            }*/


        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return data;
    }

}
