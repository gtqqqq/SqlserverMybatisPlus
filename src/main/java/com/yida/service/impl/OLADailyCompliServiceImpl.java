package com.yida.service.impl;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yida.entity.DailyComplianceStatistics;
import com.yida.mapper.CdcMetricMapper;
import com.yida.mapper.OLADailyComplianceStatisticsMapper;
import com.yida.service.OLADailyCompliService;
import com.yida.utils.CopyField;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

/**
 * @author fnchenxi
 */
@Slf4j
@Service
@DS("slave")
public class OLADailyCompliServiceImpl extends ServiceImpl<OLADailyComplianceStatisticsMapper, DailyComplianceStatistics> implements OLADailyCompliService {

    @Autowired
    CdcMetricMapper cdcMetricMapper;

    @Autowired
    OLADailyComplianceStatisticsMapper OLADailyComplianceStatisticsMapper;


    @Override
    public List<DailyComplianceStatistics> getModelL2Data() {
        List<DailyComplianceStatistics>Vallist= new ArrayList<>();
        List<Map<String, Object>> list = cdcMetricMapper.selectL2OLAList();
        if (!list.isEmpty()) {
            /**
             * 根据年月日分组,然后遍历添加
             */
            Map<String,List<Map<String,Object>>> dayMap=groupByDay(list);
            for (Map.Entry<String,List<Map<String, Object>>> entry : dayMap.entrySet()) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                try{
                    Date parseDate = format.parse(entry.getKey());
                    DailyComplianceStatistics model = new DailyComplianceStatistics();
                    /**
                     * 调用之前的接口 把工单的解决时间记录到数据库里
                     */
                    model = operationMap(entry.getValue(), model,"OLA",parseDate);
                    Vallist.add(model);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            return Vallist;
        }
        return null;
    }

    /**
     * 根据年月日分组
     * @param list
     * @return
     */
    private Map<String,List<Map<String, Object>>> groupByDay(List<Map<String, Object>> list){
        /**
         * 1.按照年月日进行分组
         */
        Map<String, List<Map<String, Object>>> map=list.stream().collect(Collectors.groupingBy(p->(new SimpleDateFormat("yyyy-MM-dd").format((Date)p.get("Resolved")))));

        /**
         * 2.给每个集合里的key增加一个解决时间，作为记录到数据里的工单的解决时间
         */
        for (Map.Entry<String,List<Map<String, Object>>> entry : map.entrySet()) {
            String key = entry.getKey();
            for(Map<String, Object> i:entry.getValue()){
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                try{
                    i.put("newDate",format.parse(key));
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    continue;
                }
            }
        }
        return map;
    }

    @Override
    public List<DailyComplianceStatistics> getModelL3Data() {
        List<DailyComplianceStatistics> Vallist=new ArrayList<>();
        List<Map<String, Object>> list = cdcMetricMapper.selectL3OLAList();
        if (!list.isEmpty()) {
            /**
             * 根据年月日分组,然后遍历添加
             */
            Map<String,List<Map<String,Object>>> dayMap=groupByDay(list);
            for (Map.Entry<String,List<Map<String, Object>>> entry : dayMap.entrySet()) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                try{
                    Date parseDate = format.parse(entry.getKey());
                    DailyComplianceStatistics model = new DailyComplianceStatistics();
                    /**
                     * 调用之前的接口 把工单的解决时间记录到数据库里
                     */
                    model = operationMap(entry.getValue(), model,"OLA",parseDate);
                    Vallist.add(model);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            return Vallist;

        }
        return null;
    }
    @Override
    public List<DailyComplianceStatistics> getModelL2ListData() {
        DailyComplianceStatistics model = new DailyComplianceStatistics();
        List<Map<String, Object>> list = cdcMetricMapper.selectL2OLAList();
        if (!list.isEmpty()) {
            return operationMap2(list,  "OLA");
        }
        return null;
    }

    @Override
    public List<DailyComplianceStatistics> getModelL3ListData() {
        List<Map<String, Object>> list = cdcMetricMapper.selectL3OLAList();
        if (!list.isEmpty()) {
            return  operationMap2(list,  "OLA");
        }
        return null;
    }
    /**
     * 操作查询的结果，统计达标率和封装为数据库需要的实体对象
     *
     * @param list
     * @param model
     * @return
     */
    public DailyComplianceStatistics operationMap(List<Map<String, Object>> list, DailyComplianceStatistics model, String type,Date resolved) {
        Map<Integer, List<Map<String, Object>>> format = new HashMap<>();
        /**
         * 1.把查询的结果根据小时(H)进行分组
         */
        if (!list.isEmpty()) {
            for (Map<String, Object> val : list) {
                Date opened = (Date) val.get("opened");
                int hours = opened.getHours();
                if (format.get(hours) == null) {
                    List<Map<String, Object>> openedList = new ArrayList<>();
                    openedList.add(val);
                    format.put(hours, openedList);
                } else {
                    format.get(hours).add(val);
                }
            }
        }

        /**
         * 2.遍历封装好的数据 统计哪些数据达标,统一分配一个标识状态，下一步做统计
         */
        for (List<Map<String, Object>> values : format.values()) {
            for (Map<String, Object> i : values) {
                String priority = (String) i.get("Priority");
                Integer duration = i.get("Duration") != null ? (Integer) i.get("Duration") : 0;
                Date startTime = (Date) i.get("opened");
                Date endTime = (Date) i.get("Resolved");
                Long diffDay = DateUtil.between(startTime, endTime, DateUnit.DAY);
                int noon= (Integer) i.get("hoilday_noon_1hour");
                if (diffDay > 0) {
                    duration = duration - ((diffDay.intValue()- noon) * 15);
                }
                if (priority != null && "Priority 4".equals(priority)) {
                    if (duration < 2) {
                        i.put("status", true);
                    } else {
                        i.put("status", false);
                    }
                } else if (priority != null && "Priority 3".equals(priority)) {
                    if (duration < 2) {
                        i.put("status", true);
                    } else {
                        i.put("status", false);
                    }
                } else if (priority != null && "Priority 2".equals(priority)) {
                    if (duration < 1) {
                        i.put("status", true);
                    } else {
                        i.put("status", false);
                    }
                } else {
                    if (duration < 1) {
                        i.put("status", true);
                    } else {
                        i.put("status", false);
                    }
                }
            }
        }

        /**
         * 3.根据status的标识值计算百分百 算法为:合格/该小时的总数量
         */

        for (List<Map<String, Object>> values : format.values()) {
            BigDecimal range = new BigDecimal(0);
            int total = 0;
            for (Map<String, Object> i : values) {
                Boolean status = (Boolean) i.get("status");
                if (status) {
                    total += 1;
                }
            }
            int queryMailNum = values.size();
            // 创建一个数值格式化对象
            NumberFormat numberFormat = NumberFormat.getInstance();
            // 设置精确到小数点后2位
            numberFormat.setMaximumFractionDigits(2);
            String result = numberFormat.format((float) total / (float) queryMailNum * 100);
            System.out.println("百分比为:" + result + "%");
        }

        int dailyCases = 0;
        for (Map.Entry<Integer, List<Map<String, Object>>> en : format.entrySet()) {
            Integer key = en.getKey();
            List<Map<String, Object>> values = en.getValue();
            dailyCases += values.size();
            int total = 0;
            for (Map<String, Object> i : values) {
                Boolean status = (Boolean) i.get("status");
                if (status) {
                    total += 1;
                }
            }
            int queryMailNum = values.size();
            // 创建一个数值格式化对象
            NumberFormat numberFormat = NumberFormat.getInstance();
            // 设置精确到小数点后2位
            numberFormat.setMaximumFractionDigits(2);
            String result = numberFormat.format((float) total / (float) queryMailNum * 100);

            /**
             * 4.把最后的结果封装为DB数据库的实体对象格式返回
             */
            CopyField.setModelField(model, new BigDecimal(total), key, "hour", "Ok");
            CopyField.setModelField(model, new BigDecimal(values.size()), key, "hour", "All");
        }

        model.setType(type);
        model.setCreateTime(new Date());
        int allDailyCases = CopyField.fieldSum(model, "hour", "All").intValue();
        model.setAllDailyCases(allDailyCases);//24小时总数
        model.setWorkDailyCases(dailyCases);//工作时间总数
        model.setResolved(resolved);
        model.setEndTime(resolved);
        return model;

    }


    /**
     * 操作查询的结果，统计达标率和封装为数据库需要的实体对象
     *
     * @param list
     * @param type
     * @return
     */
    public List<DailyComplianceStatistics> operationMap2(List<Map<String, Object>> list,  String type) {
        //list按group分组
        List<DailyComplianceStatistics> models = new CopyOnWriteArrayList<DailyComplianceStatistics>();
        Map<String, List<Map<String, Object>>> formatGroup = new HashMap<>();
        for (Map<String, Object> val : list) {
            String groups = (String) val.get("group_name");
            if (formatGroup.get(groups) == null) {
                List<Map<String, Object>> GroupList = new ArrayList<>();
                GroupList.add(val);
                formatGroup.put(groups, GroupList);
            } else {
                formatGroup.get(groups).add(val);
            }
        }
        //每个组的所有小时结果
        int keys =0;
        for (List<Map<String, Object>> valueList : formatGroup.values()) {
           DailyComplianceStatistics model = new DailyComplianceStatistics();
            Map<Integer, List<Map<String, Object>>> format = new HashMap<>();
            model.setGroupName(formatGroup.keySet().toArray()[keys].toString());
            keys++;
            for (Map<String, Object> val : valueList) {
                Date opened = (Date) val.get("opened");
                int hours = opened.getHours();
                if (format.get(hours) == null) {
                    List<Map<String, Object>> openedList = new ArrayList<>();
                    openedList.add(val);
                    format.put(hours, openedList);
                } else {
                    format.get(hours).add(val);
                }
            }

            /**
             * 2.遍历封装好的数据 统计哪些数据达标,统一分配一个标识状态，下一步做统计
             */
            for (List<Map<String, Object>> values : format.values()) {
                for (Map<String, Object> i : values) {
                    String priority = (String) i.get("Priority");
                    Integer duration = i.get("Duration") != null ? (Integer) i.get("Duration") : 0;
                    Date startTime = (Date) i.get("opened");
                    Date endTime = (Date) i.get("Resolved");
                    Long diffDay = DateUtil.between(startTime, endTime, DateUnit.DAY);
                   int noon= (Integer) i.get("hoilday_noon_1hour");
                    if (diffDay > 0) {
                        duration = duration - ((diffDay.intValue()- noon) * 15);
                    }
                    ;
                    if (priority != null && "Priority 4".equals(priority)) {
                        if (duration < 2) {
                            i.put("status", true);
                        } else {
                            i.put("status", false);
                        }
                    } else if (priority != null && "Priority 3".equals(priority)) {
                        if (duration < 2) {
                            i.put("status", true);
                        } else {
                            i.put("status", false);
                        }
                    } else if (priority != null && "Priority 2".equals(priority)) {
                        if (duration < 1) {
                            i.put("status", true);
                        } else {
                            i.put("status", false);
                        }
                    } else {
                        if (duration < 1) {
                            i.put("status", true);
                        } else {
                            i.put("status", false);
                        }
                    }
                }
            }

            /**
             * 3.根据status的标识值计算百分百 算法为:合格/该小时的总数量
             */

            for (List<Map<String, Object>> values : format.values()) {
                BigDecimal range = new BigDecimal(0);
                int total = 0;
                for (Map<String, Object> i : values) {
                    Boolean status = (Boolean) i.get("status");
                    if (status) {
                        total += 1;
                    }
                }
                int queryMailNum = values.size();
                // 创建一个数值格式化对象
                NumberFormat numberFormat = NumberFormat.getInstance();
                // 设置精确到小数点后2位
                numberFormat.setMaximumFractionDigits(2);
                String result = numberFormat.format((float) total / (float) queryMailNum * 100);
                System.out.println("百分比为:" + result + "%");
            }

            int dailyCases = 0;
            for (Map.Entry<Integer, List<Map<String, Object>>> en : format.entrySet()) {
                Integer key = en.getKey();
                List<Map<String, Object>> values = en.getValue();
                dailyCases += values.size();
                int total = 0;
                for (Map<String, Object> i : values) {
                    Boolean status = (Boolean) i.get("status");
                    if (status) {
                        total += 1;
                    }
                }
                int queryMailNum = values.size();
                // 创建一个数值格式化对象
                NumberFormat numberFormat = NumberFormat.getInstance();
                // 设置精确到小数点后2位
                numberFormat.setMaximumFractionDigits(2);
                String result = numberFormat.format((float) total / (float) queryMailNum * 100);

                /**
                 * 4.把最后的结果封装为DB数据库的实体对象格式返回
                 */
                CopyField.setModelField(model, new BigDecimal(total), key, "hour", "Ok");
                CopyField.setModelField(model, new BigDecimal(values.size()), key, "hour", "All");
            }
            model.setType(type);
            model.setCreateTime(new Date());
            int allDailyCases = CopyField.fieldSum(model, "hour", "All").intValue();
            model.setAllDailyCases(allDailyCases);//24小时总数
            model.setWorkDailyCases(dailyCases);//工作时间总数
            models.add(model);
        }
        return models;

    }


    @Override
    @DS("master")
    public int insertSelective(DailyComplianceStatistics record) {
        return baseMapper.insertSelective(record);
    }


    @Override
    @DS("master")
    public List<DailyComplianceStatistics> list(QueryWrapper<DailyComplianceStatistics> queryWrapper) {
        return super.list(queryWrapper);
    }

    @Transactional
    @Override
    @DS("master")
    public boolean remove(QueryWrapper<DailyComplianceStatistics> queryWrapper) {
        return super.remove(queryWrapper);
    }

    @Transactional
    @Override
    @DS("master")
    public boolean save(DailyComplianceStatistics dailyComplianceStatistics) {
        return super.save(dailyComplianceStatistics);
    }
}

