package com.xkcoding.multi.datasource.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.xkcoding.multi.datasource.mybatis.mapper.FteOrderL1Mapper;
import com.xkcoding.multi.datasource.mybatis.mapper.FteOrderL2Mapper;
import com.xkcoding.multi.datasource.mybatis.mapper.FteOrderL3Mapper;
import com.xkcoding.multi.datasource.mybatis.mapper.FteOrderQueryMapper;
import com.xkcoding.multi.datasource.mybatis.model.FteOrderL1;
import com.xkcoding.multi.datasource.mybatis.model.FteOrderL2;
import com.xkcoding.multi.datasource.mybatis.model.FteOrderL3;
import com.xkcoding.multi.datasource.mybatis.service.FteService;
import com.xkcoding.multi.datasource.mybatis.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * FTE服务实现层
 */
@Service
@DS("slave")
@Slf4j
/**
 * @author fnchenxi
 */
public class FteServiceImpl implements FteService {

    @Autowired
    FteOrderL1Mapper fteOrderL1Mapper;

    @Autowired
    FteOrderL2Mapper fteOrderL2Mapper;

    @Autowired
    FteOrderL3Mapper fteOrderL3Mapper;

    @Autowired
    FteOrderQueryMapper fteOrderQueryMapper;


    @Override
    public List<FteOrderL2> getL2FteOrderList() {
        List<FteOrderL2> fteOrderL2List = new ArrayList<>();
        List<Map<String, Object>> list = fteOrderQueryMapper.getL2FteOrder();
        if (list != null && !list.isEmpty()) {
            for (Map<String, Object> data : list) {
                FteOrderL2 fte = new FteOrderL2();
                fte.setCreateTime(new Date());
                fte.setFte(data.get("FTE")==null?null:(Integer) data.get("FTE"));
                fte.setGroupName(data.get("assignment group")==null?null:(String) data.get("assignment group"));
                fte.setTotal(data.get("total")==null?null:(Integer) data.get("total"));
                fte.setMark(data.get("mark")==null?null:(Integer) data.get("mark"));
                fte.setRespondedTickets(data.get("reqeust_num")==null?null:(Integer) data.get("reqeust_num"));
                fte.setSourceType(1);
                fte.setEndTime(DateUtils.getAddHourTime(data.get("opened")==null?null:(String)data.get("opened")));
                fteOrderL2List.add(fte);
            }
        }
        return fteOrderL2List;
    }

    @Override
    public List<FteOrderL3> getL3FteOrderList() {
        List<FteOrderL3> fteOrderL3List = new ArrayList<>();
        List<Map<String, Object>>  list = fteOrderQueryMapper.getL3FteOrder();
        if (list != null && !list.isEmpty()) {
            for (Map<String, Object> data : list) {
                FteOrderL3 fte = new FteOrderL3();
                fte.setCreateTime(new Date());
                fte.setFte(data.get("FTE")==null?null:(Integer) data.get("FTE"));
                fte.setGroupName(data.get("assignment group")==null?null:(String)data.get("assignment group"));
                fte.setTotal(data.get("total")==null?null:(Integer) data.get("total"));
                fte.setMark(data.get("mark")==null?null:(Integer) data.get("mark"));
                fte.setRespondedTickets(data.get("reqeust_num")==null?null:(Integer) data.get("reqeust_num"));
                fte.setSourceType(1);
                fte.setEndTime(DateUtils.getAddHourTime(data.get("opened")==null?null:(String)data.get("opened")));
                fteOrderL3List.add(fte);
            }
        }
        return fteOrderL3List;
    }

    @DS("master")
    @Override
    public int insertL2ModelData(List<FteOrderL2> l2FteOrderList) {
        if (l2FteOrderList != null && !l2FteOrderList.isEmpty()) {
            for (FteOrderL2 l2 : l2FteOrderList) {
                fteOrderL2Mapper.insertSelective(l2);
            }
            return 1;
        }
        return 0;
    }

    @DS("master")
    @Override
    public int insertL3ModelData(List<FteOrderL3> l3FteOrderList) {
        if (l3FteOrderList != null && !l3FteOrderList.isEmpty()) {
            for (FteOrderL3 l3 : l3FteOrderList) {
                fteOrderL3Mapper.insertSelective(l3);
            }
            return 1;
        }
        return 0;
    }

    /**
     * 查询 FTE ,分组AVG ,以及Responded Tickets
     *
     * @return
     */
//    @DS("slave")
    @Override
    public List<FteOrderL1> getL1FteOrderList() {
        List<FteOrderL1> data = new ArrayList<FteOrderL1>();
        try {
            List<Map<String, Object>> l1FteOrderList = fteOrderQueryMapper.getL1FteOrderList();
            if (null != l1FteOrderList && l1FteOrderList.size() > 0) {
                for (Map<String, Object> da : l1FteOrderList) {
                    FteOrderL1 fteOrderL1 = new FteOrderL1();
                    String groupName = (String) da.get("groupName");
                    Integer total = (Integer) da.get("total");
                    Integer fte = (Integer) da.get("FTE");
                    Integer resNum = (Integer) da.get("resNum");
                    Integer mark = (Integer) da.get("Mark");
                    String opentime =(String) da.get("opentime");
                    fteOrderL1.setGroupName(groupName);
                    fteOrderL1.setCreateTime(new Date());
                    fteOrderL1.setTotal(total);
                    fteOrderL1.setFte(fte);
                    fteOrderL1.setRespondedTickets(resNum);
                    fteOrderL1.setMark(mark);
                    fteOrderL1.setEndTime(DateUtils.getCurrHourTime());
                    fteOrderL1.setSourceType(mark);
                    fteOrderL1.setEndTime(DateUtils.getAddHourTime(opentime));
                    data.add(fteOrderL1);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return data;
    }

    /**
     * 录入 fte_order_l1
     *
     * @return
     */
    @DS("master")
    @Override
    public Boolean insertL1ModelData(List<FteOrderL1> fteOrderL1s) {
        if (null != fteOrderL1s && fteOrderL1s.size() > 0) {
            for (FteOrderL1 da : fteOrderL1s) {
                fteOrderL1Mapper.insertSelective(da);
            }
        }
        return true;
    }

    /**
     * 清表fte_order_l1
     *
     * @return
     */
    @DS("master")
    @Override
    public int deleteFteOrderL1() {
        return fteOrderL1Mapper.deleteByExample(null);
    }

    @DS("master")
    @Override
    public int deleteL2DataByToDay() {
        return fteOrderL2Mapper.deleteL2DataByToDay();
    }

    @DS("master")
    @Override
    public int deleteL3DataByToDay() {
        return fteOrderL3Mapper.deleteL3DataByToDay();
    }

    @DS("master")
    @Override
    public int deleteL1DataByToDay() {
        return fteOrderL1Mapper.deleteL1DataByToDay();
    }
}
