package com.xkcoding.multi.datasource.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.sun.org.apache.bcel.internal.generic.ANEWARRAY;
import com.xkcoding.multi.datasource.mybatis.mapper.DailyCompliQueryMapper;
import com.xkcoding.multi.datasource.mybatis.mapper.DailyComplianceStatisticsL3Mapper;
import com.xkcoding.multi.datasource.mybatis.mapper.DailyComplianceStatisticsMapper;
import com.xkcoding.multi.datasource.mybatis.mapper.OrderComplianceAvgMapper;
import com.xkcoding.multi.datasource.mybatis.model.DailyComplianceStatistics;
import com.xkcoding.multi.datasource.mybatis.model.DailyComplianceStatisticsL3;
import com.xkcoding.multi.datasource.mybatis.model.OrderComplianceAvg;
import com.xkcoding.multi.datasource.mybatis.service.DailyCompliService;
import com.xkcoding.multi.datasource.mybatis.util.CopyField;
import com.xkcoding.multi.datasource.mybatis.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
@DS("slave")
@Slf4j
/**
 * @author fnchenxi
 */
public class DailyCompliServiceImpl implements DailyCompliService {

    @Autowired
    DailyCompliQueryMapper dailyCompliQueryMapper;

    @Autowired
    DailyComplianceStatisticsMapper dailyComplianceStatisticsMapper;

    @Autowired
    DailyComplianceStatisticsL3Mapper dailyComplianceStatisticsL3Mapper;

    @Autowired
    OrderComplianceAvgMapper orderComplianceAvgMapper;

    /**
     * 组装好查询的数据，封装为一个L2实体对象
     * @return
     */
    @Override
    public List<DailyComplianceStatistics> getModelL2Data() {
        List<DailyComplianceStatistics>Vallist= new ArrayList<>();
        List<Map<String, Object>> list = dailyCompliQueryMapper.getDailyCompliByL2Sla();
        if(!list.isEmpty()){
            /**
             * 根据年月日分组,然后遍历添加
             */
             Map<String,List<Map<String,Object>>> dayMap=groupByDay(list);
            for (Map.Entry<String,List<Map<String, Object>>> entry : dayMap.entrySet()) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                try{
                    Date parseDate = format.parse(entry.getKey());
                    DailyComplianceStatistics model=new DailyComplianceStatistics();

                    /**
                     * 调用之前的接口 把工单的解决时间记录到数据库里
                     */
                    model = operationMap(entry.getValue(), model,"SLA",null,parseDate);
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

    /**
     * L2根据组名进行分组，然后进一步根据时间分组，返回实体对象 (暂废弃)
     * @return
     */
    @Override
    public List<DailyComplianceStatistics> getModelL2GroupData() {
        DailyComplianceStatistics model=new DailyComplianceStatistics();
        List<Map<String, Object>> list = dailyCompliQueryMapper.getDailyCompliByL2SlaByGroup();
        if(!list.isEmpty()){
            Date date=(Date)list.get(0).get("Resolved");
            List<DailyComplianceStatistics> slaList = operationMapL2(list, model, "SLA",date);
            return slaList;
        }
        return null;
    }

    /**
     * 组装好查询的数据，封装为一个L3实体对象
     * @return
     */
    @Override
    public List<DailyComplianceStatisticsL3> getModelL3Data() {
        List<DailyComplianceStatisticsL3> Vallist=new ArrayList<>();
        List<Map<String, Object>> list = dailyCompliQueryMapper.getDailyCompliByL3Sla();
        if(!list.isEmpty()){
            /**
             * 根据年月日分组,然后遍历添加
             */
            Map<String,List<Map<String,Object>>> dayMap=groupByDay(list);
            for (Map.Entry<String,List<Map<String, Object>>> entry : dayMap.entrySet()) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                try{
                    Date parseDate = format.parse(entry.getKey());
                    DailyComplianceStatisticsL3 model=new DailyComplianceStatisticsL3();

                    /**
                     * 调用之前的接口 把工单的解决时间记录到数据库里
                     */
                    model = operationMapL3(entry.getValue(), model,"SLA",null,parseDate);
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
     * L3根据组名进行分组，然后进一步根据时间分组，返回实体对象
     * @return
     */
    @Override
    public List<DailyComplianceStatisticsL3> getModelL3GroupData() {
        DailyComplianceStatisticsL3 model=new DailyComplianceStatisticsL3();
        List<Map<String, Object>> list = dailyCompliQueryMapper.getDailyCompliByL3SlaByGroup();
        if(!list.isEmpty()){
            Date date=(Date)list.get(0).get("Resolved");
            List<DailyComplianceStatisticsL3> slaList = operationMapL3(list, model, "SLA",date);
            return slaList;
        }
        return null;
    }

    /**
     * 添加L2的Inc数据
     * @param record
     * @return
     */
    @DS("master")
    @Override
    public int insertSelectiveL2(List<DailyComplianceStatistics> record) {
        for(DailyComplianceStatistics i:record){
            i.setEndTime(i.getResolved());
            dailyComplianceStatisticsMapper.insert(i);
        }
        return 1;
    }

    /**
     * 批量添加L2的Inc数据
     * @param list
     * @return
     */
    @DS("master")
    @Override
    public int batchInsertSelectiveL2(List<DailyComplianceStatistics> list) {
        if(!list.isEmpty()){
            for (DailyComplianceStatistics data:list){
                dailyComplianceStatisticsMapper.insert(data);
            }
        }
        return 0;
    }

    /**
     * 添加L3的Inc数据
     * @param record
     * @return
     */
    @DS("master")
    @Override
    public int insertSelectiveL3(List<DailyComplianceStatisticsL3> record) {
        for(DailyComplianceStatisticsL3 i:record){
            i.setEndTime(i.getResolved());
            dailyComplianceStatisticsL3Mapper.insert(i);
        }
        return 1;
    }

    /**
     * 批量添加L3的Inc数据
     * @param list
     * @return
     */
    @DS("master")
    @Override
    public int batchInsertSelectiveL3(List<DailyComplianceStatisticsL3> list) {
        if(!list.isEmpty()){
            for (DailyComplianceStatisticsL3 data:list){
                dailyComplianceStatisticsL3Mapper.insert(data);
            }
        }
        return 0;
    }

    /**
     * 删除L3的今日数据
     * @return
     */
    @DS("master")
    @Override
    public int deleteL3DataByToDay() {
        return dailyComplianceStatisticsL3Mapper.deleteDataByToDay();
    }

    /**
     * 添加L2的今日数据
     * @return
     */
    @DS("master")
    @Override
    public int deleteL2DataByToDay() {
        /**
         * 如果当前时间是0点 则删除昨天的数据，因为是昨天0-11点的数据 现在添加的是昨天0-23:59分的数据
         */
        /*if(new Date().getHours()==0){
            dailyComplianceStatisticsMapper.deleteYestToDayL2Sla();
        }*/
        return dailyComplianceStatisticsMapper.deleteDataByToDay();
    }

    /**
     * 获取当天Inc的数据，返回的数据为合格数量和总数，参数为表名（L2和L3的Inc视图）
     * @param map
     * @return
     */
    @Override
    public List<Map<String, Object>> getSlaRangeData(Map<String,String> map) {
        /**
         * 1.声明Inc和Req的2个集合，要么查询L2的Inc和Req 要么查询L3的Inc和Req
         *  PS:如果传入的是L2的INC和L3的Inc或者L3的REQ和L3的REQ 后面的就会覆盖前面的数据,
         *  需求是L2的INC+REQ 或者L3的INC+REQ
         */
        List<Map<String, Object>> IncList=new ArrayList<>();
        List<Map<String, Object>> ReqList=new ArrayList<>();

        if(map.get("L2Incindent")!=null){
            IncList = dailyCompliQueryMapper.getIncDataRange(map.get("L2Incindent"));
        }
        if(map.get("L2Request")!=null){
            ReqList =dailyCompliQueryMapper.getReqDataRange(map.get("L2Request"));
        }
        if(map.get("L3Incindent")!=null){
            IncList = dailyCompliQueryMapper.getIncDataRange(map.get("L3Incindent"));
        }
        if(map.get("L3Request")!=null){
            ReqList =dailyCompliQueryMapper.getReqDataRange(map.get("L3Request"));
        }

        IncList.addAll(ReqList);
        if(!IncList.isEmpty()){
            int total=0;
            for(Map<String, Object> l2SalData:IncList){
                String priority = (String)l2SalData.get("Priority");
                Integer duration = (Integer)l2SalData.get("Duration");
                if(priority==null || duration==null ){
                    continue;
                }
                if(priority!=null && "Priority 4".equals(priority)){
                    if(duration!=null && duration<48){
                        total++;
                    }
                }else if(priority!=null && "Priority 3".equals(priority)){
                    if(duration!=null && duration<36){
                        total++;
                    }
                }else if(priority!=null && "Priority 2".equals(priority)){
                    if(duration!=null && duration<8){
                        total++;
                    }
                }else{
                    if(duration!=null && duration<3){
                        total++;
                    }
                }
            }

            System.out.println("百分比率："+(total*100)/(IncList.size()*100/100)+"%");
        }
        return IncList;
    }

    /**
     * 工单平均解决时长
     * @return
     */
    @Override
    public Map<Date, Map<String, Object>> getAvgData(Map<String,String> map) {
        List<Map<String,Object>> incList=new ArrayList<>();
        List<Map<String,Object>> reqList=new ArrayList<>();
        if(map.get("L2Incindent")!=null){
            incList=dailyCompliQueryMapper.getINCAvgData(map.get("L2Incindent"));
        }
        if(map.get("L2Request")!=null){
            reqList = dailyCompliQueryMapper.getREQAvgData(map.get("L2Request"));
        }

        if(map.get("L3Incindent")!=null){
            incList=dailyCompliQueryMapper.getINCAvgData(map.get("L3Incindent"));
        }
        if(map.get("L3Request")!=null){
            reqList = dailyCompliQueryMapper.getREQAvgData(map.get("L3Request"));
        }
        incList.addAll(reqList);

        Map<Date, Map<String, Object>> dateMapMap = groupByHour(incList);
        return dateMapMap;
    }


    /**
     * 年月日小时分组
     * @return
     */
    public Map<Date,Map<String,Object>> groupByHour(List<Map<String,Object>> list){
        if(list!=null&&!list.isEmpty()){
            Map<Date,Map<String,Object>> result=new HashMap<>();
            /**
             * 1.把查询的到的全部数据按照年月日时进行分组，key为时间，values为该时间内的数据
             */
            Map<String, List<Map<String, Object>>> map=list.stream().collect(Collectors.groupingBy(p->(new SimpleDateFormat("yyyy-MM-dd HH").format((Date)p.get("Resolved")))));
            for (Map.Entry<String,List<Map<String, Object>>> entry : map.entrySet()) {
                /**
                 * 2.取得每个list里面有关的字段数据，返回一个List的结果，然后调用getCompliOrderAvgData()返回一个统计总时长，工单数量，平均解决时长的Map
                 */
                List<String> close_notes = entry.getValue().stream().map(p -> (String)p.get("Close notes")).collect(Collectors.toList());
                Map<String, Object> data = getCompliOrderAvgData(close_notes);
                /**
                 * 3.最后调用getAddHourTime添加一个end_time时间，把业务时间+1小时取整
                 */
                result.put(DateUtils.getAddHourTime(entry.getKey()),data);
            }
            return result;
        }
        return null;
    }

    /**
     * 封装L2和L3工单解决时长的数据为DB的格式
     * @return
     */
    @Override
    public List<OrderComplianceAvg> getModelData() {

        OrderComplianceAvg orderComplianceAvg=new OrderComplianceAvg();

        Map<String,String>map=new HashMap<>();
        map.put("L2Incindent","L2Incindent");
        map.put("L2Request","L2Request");
        Map<Date, Map<String, Object>> l2avgData = getAvgData(map);

        Map<String,String>map2=new HashMap<>();
        map2.put("L3Incindent","L3Incindent");
        map2.put("L3Request","L3Request");
        Map<Date, Map<String, Object>> l3avgData = getAvgData(map2);

        List<OrderComplianceAvg> l2 = packageData(l2avgData, "L2");
        List<OrderComplianceAvg> l3 = packageData(l3avgData,"L3");
        l2.addAll(l3);

        return l2;
    }

    /**
     * 把map数据封装成数据库需要的对象并返回
     * @param map
     * @param team
     * @return
     */
    public List<OrderComplianceAvg> packageData(Map<Date, Map<String, Object>> map,String team){
        List<OrderComplianceAvg> list =new ArrayList<>();
        if(map!=null&&!map.isEmpty()){
            for (Map.Entry<Date,Map<String, Object>> entry : map.entrySet()) {
                OrderComplianceAvg avg=new OrderComplianceAvg();
                avg.setEndTime(entry.getKey());
                avg.setCreateTime(new Date());
                avg.setTotalTime(entry.getValue().get("total")==null?null:(BigDecimal)entry.getValue().get("total"));
                avg.setSize(entry.getValue().get("size")==null?null:(Integer)entry.getValue().get("size"));
                avg.setCompliAvg(entry.getValue().get("avg")==null?null:(BigDecimal)entry.getValue().get("avg"));
                avg.setTeam(team);
                list.add(avg);
            }
            return list;
        }
        return null;
    }

    /**
     *  删除当天平均时长表数据
     * @return
     */
    @DS("master")
    @Override
    public int deleteOrderCompliAvg() {
        return orderComplianceAvgMapper.deleteDataByToDay();
    }

    /**
     * 添加当天平均时长表数据
     * @param modelDataAvg
     * @return
     */
    @DS("master")
    @Override
    public int insertOrderCompliAvg(List<OrderComplianceAvg> modelDataAvg) {
        if(!modelDataAvg.isEmpty()){
            for(OrderComplianceAvg avg:modelDataAvg){
                orderComplianceAvgMapper.insertSelective(avg);
            }
            return 1;
        }
        return 0;
    }

    @Override
    public List<DailyComplianceStatistics> getModelL2DataByReq() {
        List<DailyComplianceStatistics>Vallist= new ArrayList<>();
        List<Map<String, Object>> list = dailyCompliQueryMapper.getReqDataRange("L2Request");
        if(!list.isEmpty()){
            /**
             * 根据年月日分组,然后遍历添加
             */
            Map<String,List<Map<String,Object>>> dayMap=groupByDay(list);
            for (Map.Entry<String,List<Map<String, Object>>> entry : dayMap.entrySet()) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                try{
                    Date parseDate = format.parse(entry.getKey());
                    DailyComplianceStatistics model=new DailyComplianceStatistics();

                    /**
                     * 调用之前的接口 把工单的解决时间记录到数据库里
                     */
                    model = operationMap(entry.getValue(), model,"REQ",null,parseDate);
                    Vallist.add(model);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            return Vallist;
        }
        return null;
    }

    @DS("master")
    @Override
    public int deleteL2RqeDataByToDay() {
        return dailyComplianceStatisticsMapper.deleteReqDataByToDay();
    }

    @Override
    public List<DailyComplianceStatisticsL3> getModelL3DataByReq() {
        List<DailyComplianceStatisticsL3> Vallist=new ArrayList<>();
        List<Map<String, Object>> list = dailyCompliQueryMapper.getReqDataRange("L3Request");
        if(!list.isEmpty()){
            /**
             * 根据年月日分组,然后遍历添加
             */
            Map<String,List<Map<String,Object>>> dayMap=groupByDay(list);
            for (Map.Entry<String,List<Map<String, Object>>> entry : dayMap.entrySet()) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                try{
                    Date parseDate = format.parse(entry.getKey());
                    DailyComplianceStatisticsL3 model=new DailyComplianceStatisticsL3();
                    /**
                     * 调用之前的接口 把工单的解决时间记录到数据库里
                     */
                    model = operationMapL3(entry.getValue(), model,"REQ",null,parseDate);
                    Vallist.add(model);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            return Vallist;
        }
        return null;
    }

    @DS("master")
    @Override
    public int deleteL3ReqDataByToDay() {

        return dailyComplianceStatisticsL3Mapper.deleteDataByToDayByReq();
    }

    /**
     * 传入一个list 将数据切割和裁剪后计算平均值
     * @param list
     * @return
     */
    public  Map<String,Object> getCompliOrderAvgData(List<String> list){
        Map<String,Object>map=new HashMap<>();
        if (!list.isEmpty()){
            BigDecimal total=new BigDecimal("0.00");
            for (String i:list){
                if(i==null){
                    continue;
                }
                int lastIndex = i.lastIndexOf("@");
                if(lastIndex!=-1){
                    String substring = i.substring(0,lastIndex );
                    String[] split = substring.split("@", 0);
                    total=total.add(new BigDecimal(Integer.valueOf(split[split.length - 1])));
                }else{
                    continue;
                }
            }
            System.out.println("总时长为："+total+" ms,数据条目为:"+list.size());
            BigDecimal avg = total.divide(new BigDecimal(list.size()),2, BigDecimal.ROUND_HALF_UP);

            map.put("total",total);
            map.put("size",list.size());
            map.put("avg",avg);
            return map;
        }
        return map;
    }


    /**
     * 操作L2查询的结果，统计达标率和封装为数据库需要的实体对象
     * @param list
     * @param model
     * @return
     */
    public DailyComplianceStatistics operationMap(List<Map<String, Object>>list,DailyComplianceStatistics model,String type,String groupName,Date resolved){
        Map<Integer,List<Map<String,Object>>>format=new HashMap<>();
        /**
         * 1.把查询的结果根据小时(H)进行分组
         */
        if(!list.isEmpty()){
            for (Map<String,Object> val:list){
                Date opened=(Date)val.get("Resolved");
                if(opened==null){
                    continue;
                }
                int hours = opened.getHours();
                if(format.get(hours)==null){
                    List<Map<String,Object>> openedList=new ArrayList<>();
                    openedList.add(val);
                    format.put(hours,openedList);
                }else{
                    List<Map<String, Object>> maps = format.get(hours);
                    maps.add(val);
                }
            }

            /**
             * 2.遍历封装好的数据 统计哪些数据达标,统一分配一个标识状态，下一步做统计
             */
            for(List<Map<String, Object>> values:format.values()){
                for (Map<String, Object> i:values){
                    String priority = (String)i.get("Priority");
                    Integer duration = (Integer)i.get("Duration");

                    if(priority!=null && "Priority 4".equals(priority)){
                        if(duration!=null && duration<48){
                            i.put("status",true);
                        }else{
                            i.put("status",false);
                        }
                    }else if(priority!=null && "Priority 3".equals(priority)){
                        if(duration!=null && duration<36){
                            i.put("status",true);
                        }else{
                            i.put("status",false);
                        }
                    }else if(priority!=null && "Priority 2".equals(priority)){
                        if(duration!=null && duration<8){
                            i.put("status",true);
                        }else{
                            i.put("status",false);
                        }
                    }else{
                        if(duration!=null && duration<3){
                            i.put("status",true);
                        }else{
                            i.put("status",false);
                        }
                    }
                }
            }

            /**
             * 3.根据status的标识值计算百分百 算法为:合格/该小时的总数量
             */
            for(List<Map<String, Object>> values:format.values()){
                BigDecimal range=new BigDecimal(0);
                int total=0;
                for (Map<String, Object> i:values){
                    Boolean status = (Boolean)i.get("status");
                    if(status){
                        total+=1;
                    }
                }
                int queryMailNum=values.size();
                // 创建一个数值格式化对象
                NumberFormat numberFormat = NumberFormat.getInstance();
                // 设置精确到小数点后2位
                numberFormat.setMaximumFractionDigits(2);
                String result = numberFormat.format((float)total/(float)queryMailNum*100);
                System.out.println("百分比为:" + result + "%");
            }

            int dailyCases=0;
            for(Map.Entry<Integer, List<Map<String, Object>>> en:format.entrySet()){
                Integer key = en.getKey();
                List<Map<String, Object>> values = en.getValue();
                if(key>=9 && key<=18){
                    dailyCases+=values.size();
                }
                int total=0;
                for (Map<String, Object> i:values){
                    Boolean status = (Boolean)i.get("status");
                    if(status){
                        total+=1;
                    }
                }
                int queryMailNum=values.size();
                // 创建一个数值格式化对象
                NumberFormat numberFormat = NumberFormat.getInstance();
                // 设置精确到小数点后2位
                numberFormat.setMaximumFractionDigits(2);
                String result = numberFormat.format((float)total/(float)queryMailNum*100);

                /**
                 * 4.把最后的结果封装为DB数据库的实体对象格式返回
                 */
                CopyField.setModelField(model, new BigDecimal(total), key, "hour","Ok");
                CopyField.setModelField(model, new BigDecimal(values.size()), key, "hour","All");
            }
            model.setType(type);
            model.setCreateTime(new Date());
            model.setGroupName(groupName);
            model.setResolved(resolved);
            int allDailyCases = CopyField.fieldSum(model, "hour", "All").intValue();
            model.setAllDailyCases(allDailyCases);//24小时总数
            model.setWorkDailyCases(dailyCases);//工作时间总数
        }
        return model;
    }

    /**
     * 2版本  新增分组的字段
     * @param list
     * @param model
     * @param type
     * @return
     */
    public List<DailyComplianceStatistics> operationMapL2(List<Map<String, Object>>list,DailyComplianceStatistics model,String type,Date date){
        List<DailyComplianceStatistics> dataList=new ArrayList<>();
        //1.根据组名进行分组
        Map<String, List<Map<String, Object>>> groupList = list.stream().collect(Collectors.groupingBy(p -> ((String) p.get("Assignment group"))));

        //2.遍历每个组分的数据
        for(Map.Entry<String, List<Map<String, Object>>> group: groupList.entrySet()){
            List<Map<String, Object>> maps = groupList.get(group.getKey());
            //3.遍历每个组里面的数据
            DailyComplianceStatistics modeData=new DailyComplianceStatistics();
            DailyComplianceStatistics sla = operationMap(maps, modeData, type,group.getKey(),date);
            dataList.add(sla);
        }
        return dataList;
    }

    /**
     * 2版本  新增分组的字段
     * @param list
     * @param model
     * @param type
     * @return
     */
    public List<DailyComplianceStatisticsL3> operationMapL3(List<Map<String, Object>>list,DailyComplianceStatisticsL3 model,String type,Date date){
        List<DailyComplianceStatisticsL3> dataList=new ArrayList<>();
        //1.根据组名进行分组
        Map<String, List<Map<String, Object>>> groupList = list.stream().collect(Collectors.groupingBy(p -> ((String) p.get("Assignment group"))));

        //2.遍历每个组分的数据
        for(Map.Entry<String, List<Map<String, Object>>> group: groupList.entrySet()){
            List<Map<String, Object>> maps = groupList.get(group.getKey());
            //3.遍历每个组里面的数据
            DailyComplianceStatisticsL3 modeData=new DailyComplianceStatisticsL3();
            DailyComplianceStatisticsL3 l3Sal = operationMapL3(maps, modeData, type, group.getKey(),date);
            dataList.add(l3Sal);
        }
        return dataList;
    }



    /**
     * 操作L3查询的结果，统计达标率和封装为数据库需要的实体对象
     * @param list
     * @param model
     * @return
     */
    public DailyComplianceStatisticsL3 operationMapL3(List<Map<String, Object>>list,DailyComplianceStatisticsL3 model,String type,String groupName,Date resolved){
        Map<Integer,List<Map<String,Object>>>format=new HashMap<>();
        /**
         * 1.把查询的结果根据小时(H)进行分组
         */
        if(!list.isEmpty()){
            for (Map<String,Object> val:list){
                Date opened=(Date)val.get("Resolved");
                int hours = opened.getHours();
                if(format.get(hours)==null){
                    List<Map<String,Object>> openedList=new ArrayList<>();
                    openedList.add(val);
                    format.put(hours,openedList);
                }else{
                    List<Map<String, Object>> maps = format.get(hours);
                    maps.add(val);
                }
            }

            /**
             * 2.遍历封装好的数据 统计哪些数据达标,统一分配一个标识状态，下一步做统计
             */
            for(List<Map<String, Object>> values:format.values()){
                for (Map<String, Object> i:values){
                    String priority = (String)i.get("Priority");
                    Integer duration = (Integer)i.get("Duration");

                    if(priority!=null && "Priority 4".equals(priority)){
                        if(duration!=null && duration<48){
                            i.put("status",true);
                        }else{
                            i.put("status",false);
                        }
                    }else if(priority!=null && "Priority 3".equals(priority)){
                        if(duration!=null && duration<36){
                            i.put("status",true);
                        }else{
                            i.put("status",false);
                        }
                    }else if(priority!=null && "Priority 2".equals(priority)){
                        if(duration!=null && duration<8){
                            i.put("status",true);
                        }else{
                            i.put("status",false);
                        }
                    }else{
                        if(duration!=null && duration<3){
                            i.put("status",true);
                        }else{
                            i.put("status",false);
                        }
                    }
                }
            }

            /**
             * 3.根据status的标识值计算百分百 算法为:合格/该小时的总数量
             */
            for(List<Map<String, Object>> values:format.values()){
                BigDecimal range=new BigDecimal(0);
                int total=0;
                for (Map<String, Object> i:values){
                    Boolean status = (Boolean)i.get("status");
                    if(status){
                        total+=1;
                    }
                }
                int queryMailNum=values.size();
                // 创建一个数值格式化对象
                NumberFormat numberFormat = NumberFormat.getInstance();
                // 设置精确到小数点后2位
                numberFormat.setMaximumFractionDigits(2);
                String result = numberFormat.format((float)total/(float)queryMailNum*100);
                System.out.println("百分比为:" + result + "%");
            }

            int dailyCases=0;
            for(Map.Entry<Integer, List<Map<String, Object>>> en:format.entrySet()){
                Integer key = en.getKey();
                List<Map<String, Object>> values = en.getValue();
                if(key>=9 && key<=18){
                    dailyCases+=values.size();
                }
                int total=0;
                for (Map<String, Object> i:values){
                    Boolean status = (Boolean)i.get("status");
                    if(status){
                        total+=1;
                    }
                }
                int queryMailNum=values.size();
                // 创建一个数值格式化对象
                NumberFormat numberFormat = NumberFormat.getInstance();
                // 设置精确到小数点后2位
                numberFormat.setMaximumFractionDigits(2);
                String result = numberFormat.format((float)total/(float)queryMailNum*100);

                /**
                 * 4.把最后的结果封装为DB数据库的实体对象格式返回
                 */
                CopyField.setModelField(model, new BigDecimal(total), key, "hour","Ok");
                CopyField.setModelField(model, new BigDecimal(values.size()), key, "hour","All");
            }
            model.setType(type);
            model.setCreateTime(new Date());
            model.setGroupName(groupName);
            model.setResolved(resolved);
            int allDailyCases = CopyField.fieldSum(model, "hour", "All").intValue();
            model.setAllDailyCases(allDailyCases);//24小时总数
            model.setWorkDailyCases(dailyCases);//工作时间总数

        }
        return model;
    }

    /**
     * 计算平均值
     * @param list
     * @return
     */
    public Double avgValues(List<Double> list){
        double total=0.0d;
        if(!list.isEmpty()){
            for (Double arg:list){
                total+=arg==null?0.0d:arg;
            }
            return total/list.size();
        }
        return total;
    }
}

