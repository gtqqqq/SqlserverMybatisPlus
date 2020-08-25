package com.xkcoding.multi.datasource.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.xkcoding.multi.datasource.mybatis.mapper.TodayOrderTotalMapper;
import com.xkcoding.multi.datasource.mybatis.mapper.TodayTotalModelMapper;
import com.xkcoding.multi.datasource.mybatis.model.NotCloseModel;
import com.xkcoding.multi.datasource.mybatis.model.TodayTotalModel;
import com.xkcoding.multi.datasource.mybatis.service.TodayOrderTotalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author fnchenxi
 */
@Service
@DS("slave")
@Slf4j
public class TodayOrderTotalServiceImpl implements TodayOrderTotalService {

    @Autowired
    TodayOrderTotalMapper todayOrderTotalMapper;

    @Autowired
    TodayTotalModelMapper todayTotalModelMapper;

    /**
     * 今日创建的工单总量
     * @return
     */
    @Override
    public Integer getCreateOrderNum() {
        Integer CDCIncident = todayOrderTotalMapper.getTodayCreateOrderByCDCIncident();
        Integer CDCRequest =todayOrderTotalMapper.getTodayCreateOrderByCDCRequest();
        Integer Incident =todayOrderTotalMapper.getTodayCreateOrderByIncident();
        Integer NewCall =todayOrderTotalMapper.getTodayCreateOrderByNewCall();
        Integer Request =todayOrderTotalMapper.getTodayCreateOrderByRequest();
        return CDCIncident+CDCRequest+Incident+NewCall+Request;
    }

    /**
     * 今日关闭的工单总量
     * @return
     */
    @Override
    public Integer getCloseOrderNum() {
        Integer Incident =todayOrderTotalMapper.getTodayCloseOrderByIncident();
        Integer Request =todayOrderTotalMapper.getTodayCloseOrderByRequest();
        Integer CDCIncident =todayOrderTotalMapper.getTodayCloseOrderByCDCIncident();
        Integer CDCRequest =todayOrderTotalMapper.getTodayCloseOrderByCDCRequest();
        Integer NewCall =todayOrderTotalMapper.getTodayCloseOrderByNewCall();
        return CDCIncident+CDCRequest+Incident+NewCall+Request;
    }

    /**
     * 今日解决的工单总量
     * @return
     */
    @Override
    public Integer getFinishOrderNum() {
        /**
         * 1.计算L1 3张表的解决数量
         */
        Integer incident = todayOrderTotalMapper.getTodayCompliOrderByIncident();
        Integer Request =todayOrderTotalMapper.getTodayCompliOrderByRequest();
        Integer NewCall =todayOrderTotalMapper.getTodayCompliOrderByNewCall();
        /**
         * 2. 计算L2 的合格的数量
         */
        List<Map<String, Object>> l2List = todayOrderTotalMapper.getTodayCompliOrderByL2Incident();
        Integer l2Num = getSlaTotalNum(l2List);
        /**
         * 3. 计算L3 的合格的数量
         */
        List<Map<String, Object>> l3List =todayOrderTotalMapper.getTodayCompliOrderByL3Incident();
        Integer l3Num = getSlaTotalNum(l3List);
        return incident+Request+NewCall+l2Num+l3Num;
    }

    /**
     * 返回封装的实体对象
     * @return
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    public TodayTotalModel getTodayTotalModelData() {
        TodayTotalModel model=new TodayTotalModel();

        /**
         * 1.查询出今日创建,关闭,解决的工单数量
         */
        Integer CreateOrderNum= getCreateOrderNum();
        Integer CloseOrderNum= getCloseOrderNum();
        Integer FinishOrderNum= getFinishOrderNum();

        /**
         * 2.如果查询出来了数据就赋值到对象并且添加到mysql数据库里,同时把selServer的数据删除掉
         */
        if((CreateOrderNum+CloseOrderNum+FinishOrderNum)!=0){
            model.setCreateTime(new Date());
            model.setCreateNum(CreateOrderNum);
            model.setCloseNum(CloseOrderNum);
            model.setFinish(FinishOrderNum);

            /**
             * 3.返回添加到mysql的实体
             */
            return model;
        }

        return null;
    }

    @DS("master")
    @Override
    public int insertSelective(TodayTotalModel record) {
        return todayTotalModelMapper.insertSelective(record);
    }

    /**
     * 获取今日服务热点
     * @return
     */
    @Override
    public List<Map<String, Object>> getServerHot() {
        List<Map<String, Object>> list=todayOrderTotalMapper.getServerHot();
        System.out.println(list);
        if (!list.isEmpty()){
            for (Map<String, Object> val:list){
                Integer num=(Integer)val.get("total_count");
                String name=(String)val.get("Business Service");
                System.out.println("name:"+name+",num:"+num);
            }
        }

        return null;

    }

    @DS("master")
    @Override
    public int deleteDataByToDay() {
        return todayTotalModelMapper.deleteDataByToDay();
    }


    /**
     * 计算合格达标的数据
     * @param list
     * @return
     */
    public Integer getSlaTotalNum(List<Map<String,Object>>list){
        Integer l2Num=0;
        if (!list.isEmpty()){
            for (Map<String, Object> l2Data:list){
                String priority =(String)l2Data.get("Priority");
                Integer duration=(Integer) l2Data.get("Duration");
                if(priority!=null && "Priority 4".equals(priority)){
                    if(duration<48){
                        l2Num+=1;
                    }
                }else if(priority!=null && "Priority 3".equals(priority)){
                    if(duration<36){
                        l2Num+=1;
                    }
                }else if(priority!=null && "Priority 2".equals(priority)){
                    if(duration<8){
                        l2Num+=1;
                    }
                }else{
                    if(duration<3){
                        l2Num+=1;
                    }
                }
            }
        }
      return l2Num;
    }
}
