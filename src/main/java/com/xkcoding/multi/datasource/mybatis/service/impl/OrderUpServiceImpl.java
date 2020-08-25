package com.xkcoding.multi.datasource.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.xkcoding.multi.datasource.mybatis.mapper.*;
import com.xkcoding.multi.datasource.mybatis.model.OrderUpL1;
import com.xkcoding.multi.datasource.mybatis.model.OrderUpL2;
import com.xkcoding.multi.datasource.mybatis.model.OrderUpL3;
import com.xkcoding.multi.datasource.mybatis.service.OrderUpService;
import com.xkcoding.multi.datasource.mybatis.service.QualityCheckService;
import com.xkcoding.multi.datasource.mybatis.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 升单量服务实现层
 */
@Service
@DS("slave")
@Slf4j
/**
 * @author fnchenxi
 */
public class OrderUpServiceImpl implements OrderUpService {

    @Autowired
    OrderUpL1Mapper orderUpL1Mapper;

    @Autowired
    OrderUpL2Mapper orderUpL2Mapper;

    @Autowired
    OrderUpL3Mapper orderUpL3Mapper;

    @Autowired
    OrderUpQueryMapper orderUpQueryMapper;

    /**
     * 获取L1的升单量数据
     * @return
     */
    @Override
    public List<OrderUpL1> getL1ModelData() {
        List<OrderUpL1> data = new ArrayList<OrderUpL1>();
        List<Map<String,Object>> orderUpL1List;
        try {
           /* if (new Date().getTime()!=0){
                //查询当天

            } else{
                // 查询昨天23点至零点
                orderUpL1List= orderUpQueryMapper.selectYesToDayOrderUpByL1();
            }*/
            // 全量查询历史数据，之前查询当天去掉   2020 08 21
            orderUpL1List = orderUpQueryMapper.selectOrderUpByL1();
            if (null !=orderUpL1List && orderUpL1List.size()>0){
                for (Map<String,Object> da:orderUpL1List) {
                    OrderUpL1 orderUpL1 = new OrderUpL1();
                    orderUpL1.setOrderNumber(da.get("orderNumber")==null?null:(Integer)da.get("orderNumber"));
                    orderUpL1.setMark(da.get("mark")==null?null:(Integer) da.get("mark"));
                    orderUpL1.setToNextNumber(da.get("toNextNumber")==null?null:(Integer) da.get("toNextNumber"));
                    orderUpL1.setTotal(da.get("orderNumber")==null?null:(Integer)da.get("orderNumber"));
                    orderUpL1.setGroupName(da.get("groupName")==null?null:(String) da.get("groupName"));
                    orderUpL1.setSourceType(da.get("mark")==null?null:(Integer) da.get("mark"));
                    String opentime =(String) da.get("opentime");
                    orderUpL1.setCreateTime(new Date());
                    orderUpL1.setEndTime(DateUtils.getAddHourTime(opentime));
                    data.add(orderUpL1);
                }
            }
        }catch (Exception e){
            log.error(e.getMessage(),e);
        }
        return data;
    }

    /**
     * 清表 order_up_l1
     *
     * @return
     */
    @DS("master")
    @Override
    public int deleteL1ModelData() {
        return orderUpL1Mapper.deleteByExample(null);
    }

    /**
     * 添加L1的升单量数据
     * @return
     */
    @DS("master")
    @Override
    public int insertL1ModelData(List<OrderUpL1> orderUpL1List) {
        if (null !=orderUpL1List && orderUpL1List.size()>0){
            for (OrderUpL1 da:orderUpL1List) {
                orderUpL1Mapper.insertSelective(da);
            }
            return  1;
        }
      return  0;
    }

    /**
     * 获取L2的升单量数据
     * @return
     */
    @Override
    public List<OrderUpL2> getL2ModelData() {
        List<OrderUpL2> list=new ArrayList<>();
        List<Map<String, Object>> orderUp2List;
        orderUp2List = orderUpQueryMapper.getL2OrderUp();
        if(orderUp2List!=null && !orderUp2List.isEmpty()){
            for(Map<String, Object> orderUp:orderUp2List){
                OrderUpL2 orderUpL2=new OrderUpL2();
                orderUpL2.setToNextNumber(orderUp.get("to_next_number")==null?null:(Integer)orderUp.get("to_next_number"));
                orderUpL2.setTotal(orderUp.get("total")==null?null:(Integer)orderUp.get("total"));
                orderUpL2.setOrderNumber(orderUp.get("order_number")==null?null:(Integer)orderUp.get("order_number"));
                orderUpL2.setMark(orderUp.get("mark")==null?null:(Integer)orderUp.get("mark"));
                orderUpL2.setGroupName(orderUp.get("Assignment group")==null?null:(String)orderUp.get("Assignment group"));
                orderUpL2.setSourceType(1);
                orderUpL2.setCreateTime(new Date());
                orderUpL2.setEndTime(DateUtils.getAddHourTime(orderUp.get("opened")==null?null:(String)orderUp.get("opened")));
                list.add(orderUpL2);
            }
        }
        return list;
    }

    @DS("master")
    @Override
    public int insertL2ModelData(List<OrderUpL2> l2) {
        if (!l2.isEmpty()){
            for (OrderUpL2 orderUpL2:l2){
                orderUpL2Mapper.insertSelective(orderUpL2);
            }
            return 1;
        }
        return 0;
    }


    /**
     * 获取L3的升单量数据
     * @return
     */
    @Override
    public List<OrderUpL3> getL3ModelData() {
        List<OrderUpL3> list=new ArrayList<>();
        List<Map<String, Object>> orderUp3List;
        orderUp3List = orderUpQueryMapper.getL3OrderUp();
        if(orderUp3List!=null && !orderUp3List.isEmpty()){
            for(Map<String, Object> orderUp:orderUp3List){
                OrderUpL3 orderUpL3=new OrderUpL3();
                orderUpL3.setTotal( orderUp.get("total")==null?null:(Integer) orderUp.get("total"));
                orderUpL3.setOrderNumber(orderUp.get("order_number")==null?null:(Integer) orderUp.get("order_number"));
                orderUpL3.setMark(orderUp.get("mark")==null?null:(Integer)orderUp.get("mark"));
                orderUpL3.setGroupName(orderUp.get("Assignment group")==null?null:(String)orderUp.get("Assignment group"));
                orderUpL3.setSourceType(1);
                orderUpL3.setCreateTime(new Date());
                orderUpL3.setEndTime(DateUtils.getAddHourTime(orderUp.get("opened")==null?null:(String)orderUp.get("opened")));
                list.add(orderUpL3);
            }
        }
        return list;
    }

    @DS("master")
    @Override
    public int insertL3ModelData(List<OrderUpL3> l3) {
        if (!l3.isEmpty()){
            for (OrderUpL3 orderUpL3:l3){
                orderUpL3Mapper.insertSelective(orderUpL3);
            }
            return 1;
        }
        return 0;
    }

    @DS("master")
    @Override
    public int deleteL1DataByToDay() {
        return orderUpL1Mapper.deleteL1DataByToDay();
    }

    @DS("master")
    @Override
    public int deleteL2DataByToDay() {
        return orderUpL2Mapper.deleteL2DataByToDay();
    }

    @DS("master")
    @Override
    public int deleteL3DataByToDay() {
        return orderUpL3Mapper.deleteL3DataByToDay();
    }
}

