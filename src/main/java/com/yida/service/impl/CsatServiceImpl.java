package com.yida.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xkcoding.multi.datasource.mybatis.util.CopyField;
import com.xkcoding.multi.datasource.mybatis.util.DateUtils;
import com.yida.entity.Csat;
import com.yida.mapper.CsatMapper;
import com.yida.service.ICsatService;
import com.yida.service.ISurveyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author guantianqi
 * @since 2020-07-06
 */
@Slf4j
@DS("master")
@Service
public class CsatServiceImpl<main> extends ServiceImpl<CsatMapper, Csat> implements ICsatService {


    @Autowired
    ISurveyService iSurveyService;

    public void taskCsat() {
        Date createDay = new Date();
        Csat csatPhone = new Csat();
        csatPhone.setCreateDay(createDay);
        csatPhone.setCsatType("Phone");
        Field[] Fields = csatPhone.getClass().getDeclaredFields();
        for (Field field : Fields) {
            field.setAccessible(true);
            if (field.getName().startsWith("h")) {
                Integer hour = Integer.valueOf(field.getName().substring(1));
                Integer rate = iSurveyService.selectCsatPhone(hour);
                try {
                    field.set(csatPhone, rate);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        Csat csatInc = new Csat();
        csatInc.setCreateDay(createDay);
        csatInc.setCsatType("Incident");
        Field[] iFields = csatInc.getClass().getDeclaredFields();
        for (Field field : iFields) {
            field.setAccessible(true);
            if (field.getName().startsWith("h")) {
                Integer hour = Integer.valueOf(field.getName().substring(1));
                Integer rate = iSurveyService.selectCsatIncident(hour);
                try {
                    field.set(csatInc, rate);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }


        Csat csatReq = new Csat();
        csatReq.setCreateDay(createDay);
        csatReq.setCsatType("Request");
        Field[] rFields = csatReq.getClass().getDeclaredFields();
        for (Field field : rFields) {
            field.setAccessible(true);
            if (field.getName().startsWith("h")) {
                Integer hour = Integer.valueOf(field.getName().substring(1));
                try {
                    Integer rate = iSurveyService.selectCsatRequest(hour);
                    field.set(csatReq, rate);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    log.info("mysql:插入当天" +hour+ "时的Csat统计数异常");
                }
            }
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyy-MM-dd");
        QueryWrapper<Csat> queryWrapper = new QueryWrapper<Csat>();
        queryWrapper.eq("csat_type", "Phone");
        //queryWrapper.apply(" DATE_FORMAT(create_Day,'%Y-%m-%d')= DATE_FORMAT({0},'%Y-%m-%d')", new Date());
        //savemysql(csatPhone, queryWrapper, dateFormat);
        QueryWrapper<Csat> queryWrapper2 = new QueryWrapper<Csat>();
        queryWrapper2.eq("csat_type", "Request");
        //queryWrapper2.apply(" DATE_FORMAT(create_Day,'%Y-%m-%d')= DATE_FORMAT({0},'%Y-%m-%d')", new Date());
        //savemysql(csatReq, queryWrapper2, dateFormat);
        QueryWrapper<Csat> queryWrapper3 = new QueryWrapper<Csat>();
        queryWrapper3.eq("csat_type", "Incident");
        //queryWrapper3.apply(" DATE_FORMAT(create_Day,'%Y-%m-%d')= DATE_FORMAT({0},'%Y-%m-%d')", new Date());
        //savemysql(csatInc, queryWrapper3, dateFormat);
    }
    public void taskCsatNum() {
        List<Csat> csatsList1=new ArrayList<>();
        List<Csat> csatsList2=new ArrayList<>();
        List<Csat> csatsList3=new ArrayList<>();
        Date createDay = new Date();
        List<String> dateList = iSurveyService.selectCsatDateList();
        Map<String, List<Map<String, String>>> incidentNumMap = ListParseMap(iSurveyService.selectCsatIncidentNumMap());
        Map<String, List<Map<String, String>>> incidentTotalNumMap = ListParseMap(iSurveyService.selectCsatIncidentTotalNumMap());
        Map<String, List<Map<String, String>>> requestNumMap = ListParseMap(iSurveyService.selectCsatRequestNumMap());
        Map<String, List<Map<String, String>>> requestTotalNumMap = ListParseMap(iSurveyService.selectCsatRequestTotalNumMap());
        Map<String, List<Map<String, String>>> phoneNumMap = ListParseMap(iSurveyService.selectCsatPhoneNumMap());
        Map<String, List<Map<String, String>>> phoneTotalNumMap =  ListParseMap(iSurveyService.selectCsatPhoneTotalNumMap());
        for (String sp : phoneTotalNumMap.keySet()) {
            //其中一天的数据
            List<Map<String, String>> datesData = phoneNumMap.get(sp.substring(0, 10));
            Csat csatPhone = new Csat();
            csatPhone.setCreateDay(createDay);
            csatPhone.setCsatType("Phone");
            csatPhone.setEndTime(DateUtil.parseDate(sp.substring(0, 10)));
            for (Map<String, String> datesDatum : datesData) {
                Integer hour = Integer.valueOf(datesDatum.get("dates").substring(12,13));
                CopyField.setModelField(csatPhone,datesDatum.get("num"),hour,"h","");
            }
            csatsList1.add(csatPhone);
        }
        for (Csat csatPhones : csatsList1) {
            List<Map<String, String>> totalmaps = phoneTotalNumMap.get(DateUtil.format(csatPhones.getEndTime(), "yyyy-MM-dd"));
            if(totalmaps!=null){
                for (Map<String, String> datesDatum : totalmaps) {
                    Integer hour = Integer.valueOf(datesDatum.get("dates").substring(12,13));
                    CopyField.setModelField(csatPhones,datesDatum.get("num"),hour,"allH","");
                }
            }
        }

        for (String sp : incidentTotalNumMap.keySet()) {
            //其中一天的数据
            List<Map<String, String>> datesData = incidentNumMap.get(sp.substring(0, 10));
            Csat csatInc = new Csat();
            csatInc.setCreateDay(createDay);
            csatInc.setCsatType("Incident");
            csatInc.setEndTime(DateUtil.parseDate(sp.substring(0, 10)));
            for (Map<String, String> datesDatum : datesData) {
                Integer hour = Integer.valueOf(datesDatum.get("dates").substring(12,13));
                CopyField.setModelField(csatInc,datesDatum.get("num"),hour,"h","");
            }
            csatsList2.add(csatInc);
        }
        for (Csat csatIncs : csatsList2) {
            List<Map<String, String>> totalmaps = incidentTotalNumMap.get(DateUtil.format(csatIncs.getEndTime(), "yyyy-MM-dd"));
            if(totalmaps!=null){
                for (Map<String, String> datesDatum : totalmaps) {
                    Integer hour = Integer.valueOf(datesDatum.get("dates").substring(12,13));
                    CopyField.setModelField(csatIncs,datesDatum.get("num"),hour,"allH","");
                }
            }
        }
        for (String sp :requestTotalNumMap.keySet()) {
            //其中一天的数据
            List<Map<String, String>> datesData = requestNumMap.get(sp.substring(0, 10));
            Csat csatReq = new Csat();
            csatReq.setCreateDay(createDay);
            csatReq.setCsatType("Request");
            csatReq.setEndTime(DateUtil.parseDate(sp.substring(0, 10)));
            for (Map<String, String> datesDatum : datesData) {
                Integer hour = Integer.valueOf(datesDatum.get("dates").substring(12,13));
                CopyField.setModelField(csatReq,datesDatum.get("num"),hour,"h","");
            }
            csatsList3.add(csatReq);
        }
        for (Csat csatreqs : csatsList3) {
            List<Map<String, String>> totalmaps = requestTotalNumMap.get(DateUtil.format(csatreqs.getEndTime(), "yyyy-MM-dd"));
            if(totalmaps!=null){
                for (Map<String, String> datesDatum : totalmaps) {
                    Integer hour = Integer.valueOf(datesDatum.get("dates").substring(12,13));
                    CopyField.setModelField(csatreqs,datesDatum.get("num"),hour,"allH","");
                }
            }
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyy-MM-dd");
        QueryWrapper<Csat> queryWrapper = new QueryWrapper<Csat>();
        queryWrapper.eq("csat_type", "Phone");
        //queryWrapper.apply(" DATE_FORMAT(end_time,'%Y-%m-%d')= {0}", dates);
        savemysql(csatsList1, queryWrapper, dateFormat);
        QueryWrapper<Csat> queryWrapper2 = new QueryWrapper<Csat>();
        queryWrapper2.eq("csat_type", "Request");
        //queryWrapper2.apply(" DATE_FORMAT(end_time,'%Y-%m-%d')= {0}", dates);
        savemysql(csatsList3, queryWrapper2, dateFormat);
        QueryWrapper<Csat> queryWrapper3 = new QueryWrapper<Csat>();
        queryWrapper3.eq("csat_type", "Incident");
       // queryWrapper3.apply(" DATE_FORMAT(end_time,'%Y-%m-%d')= {0}", dates);
        savemysql(csatsList2, queryWrapper3, dateFormat);
    }
    private void savemysql(List<Csat> csat, QueryWrapper<Csat> queryWrapper, SimpleDateFormat dateFormat) {
        try {
            List<Csat> list = this.list(queryWrapper);
            if (list.size() > 0) {
                log.info("mysql:删除当天" + dateFormat.format(new Date()) + "的Csat统计数");
                this.remove(queryWrapper);
                log.info("mysql:更新当天" + dateFormat.format(new Date()) + "的Csat统计数");
                for (Csat c:csat){
                    this.save(c);
                }
            } else {
                log.info("mysql:首次添加当天" + dateFormat.format(new Date()) + "的Csat统计数");
                for (Csat c:csat){
                    this.save(c);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
    @Transactional
    @Override
    public Boolean remove(QueryWrapper<Csat> queryWrapper) {
        return super.remove(queryWrapper);
    }

    @Transactional
    @Override
    public boolean save(Csat csat) {
        return super.save(csat);
    }

    private Map<String,List<Map<String ,String>>> ListParseMap(List<Map<String ,String>> listMap){
        Map<String,List<Map<String ,String>>> mapList= new HashMap<>();
        for (Map<String, String> stringMap : listMap) {
            if (mapList.get(stringMap.get("dates").substring(0,10))!=null&&mapList.get(stringMap.get("dates").substring(0,10)).size()>0){
                mapList.get(stringMap.get("dates").substring(0,10)).add(stringMap);
            }else{
                List<Map<String ,String>> tempMap = new ArrayList<>();
                tempMap.add(stringMap);
                mapList.put(stringMap.get("dates").substring(0,10),tempMap);
            }
        }
        return mapList;
    }

    public  static void main(String[] iSurveyService) {
        System.out.println(Integer.valueOf("01")); ;
    }
}
