package com.xkcoding.multi.datasource.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.xkcoding.multi.datasource.mybatis.mapper.ProductionControlMapper;
import com.xkcoding.multi.datasource.mybatis.mapper.ProductionControlQueryMapper;
import com.xkcoding.multi.datasource.mybatis.mapper.ProductionControlTotalMapper;
import com.xkcoding.multi.datasource.mybatis.model.DailyComplianceStatistics;
import com.xkcoding.multi.datasource.mybatis.model.ProductionControl;
import com.xkcoding.multi.datasource.mybatis.model.ProductionControlTotal;
import com.xkcoding.multi.datasource.mybatis.service.ProductionControlService;
import com.xkcoding.multi.datasource.mybatis.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author fnchenxi
 */
@Service
@DS("slave")
@Slf4j
public class ProductionControlServiceImpl implements ProductionControlService {

    @Autowired
    ProductionControlMapper productionControlMapper;

    @Autowired
    ProductionControlQueryMapper productionControlQueryMapper;

    @Autowired
    ProductionControlTotalMapper productionControlTotalMapper;

    @DS("master")
    @Override
    public int deleteDataByToDay() {
        return productionControlMapper.deleteDataByToDay();
    }

    @DS("master")
    @Override
    public int insertSelective(ProductionControl record) {
        return productionControlMapper.insertSelective(record);
    }

    /**
     * 查询作业生产量管控(每日) 并封装为一个DB的对象
     * @return
     */
    @Override
    public List<ProductionControl> getModelData() {
        List<Map<String, Object>> list = productionControlQueryMapper.getProductionControlByToDay();
        if(!list.isEmpty()){
            List<ProductionControl> resultList=new ArrayList<>();
            for (Map<String, Object> val:list){
                ProductionControl control=new ProductionControl();
                String assignment_group = val.get("Assignment group")==null?null:(String)val.get("Assignment group");
                Integer total_num = val.get("total_num")==null?null:(Integer)val.get("total_num");
                Integer respond_num=val.get("respond_num")==null?null:(Integer)val.get("respond_num");
                Integer close_num=val.get("close_num")==null?null:(Integer)val.get("close_num");
                control.setAssignmentGroup(assignment_group);
                control.setMark(val.get("mark")==null?null:(Integer)val.get("mark"));
                control.setSourceType(1);
                control.setTotalNum(total_num);
                control.setResponded(respond_num);
                control.setCloseNum(close_num);
                control.setCreateTime(new Date());
                control.setEndTime(DateUtils.getAddHourTime(val.get("opened")==null?null:(String)val.get("opened")));
                resultList.add(control);
            }
            return resultList;
        }
        return null;
    }

    @DS("master")
    @Override
    public int batchInsert(List<ProductionControl> proConmodelData) {
        return productionControlMapper.batchInsert(proConmodelData);
    }

    /**
     * 查询作业生产量管控(每日)汇总的数据 并封装为一个DB的对象
     * @return
     */
    @Override
    public List<ProductionControlTotal> getModelTotalData() {
        List<Map<String, Object>> list = productionControlQueryMapper.getProductionControlTotalByToDay();
        if(!list.isEmpty()){
            List<ProductionControlTotal> resultList=new ArrayList<>();
            for (Map<String, Object> val:list){
                ProductionControlTotal control=new ProductionControlTotal();
                String name = (String)val.get("name");
                Integer total_num = (Integer)val.get("total_num");
                control.setName(name);
                control.setTicketsVol(total_num);
                control.setCreateTime(new Date());
                resultList.add(control);
            }
            return resultList;
        }
        return null;
    }

    @DS("master")
    @Override
    public int deleteTotalDataByToDay() {
        return productionControlTotalMapper.deleteDataByToDay();
    }


    @DS("master")
    @Override
    public int batchInsertTotalData(List<ProductionControlTotal> proConmodelData) {
        return productionControlTotalMapper.batchInsert(proConmodelData);
    }

    @DS("master")
    @Override
    public List<ProductionControlTotal> getl2OrderNumberList(DailyComplianceStatistics data) {
        Map map=new HashMap();
        if(data.getType()!=null){
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calender = Calendar.getInstance();
            calender.setTime(data.getCreateTime());

            map.put("type",data.getType());
            map.put("year",calender.get(Calendar.YEAR));
            map.put("month",calender.get(Calendar.MONTH)+1);
            map.put("day",calender.get(Calendar.DATE));
        }
        return productionControlTotalMapper.selectToDayList(map);
    }

}
