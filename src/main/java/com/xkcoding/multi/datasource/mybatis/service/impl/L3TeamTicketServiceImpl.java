package com.xkcoding.multi.datasource.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.xkcoding.multi.datasource.mybatis.mapper.L3TeamTicket3Mapper;
import com.xkcoding.multi.datasource.mybatis.mapper.L3TeamTicket3QueryMapper;
import com.xkcoding.multi.datasource.mybatis.mapper.TodayOrderTotalMapper;
import com.xkcoding.multi.datasource.mybatis.mapper.TodayTotalModelMapper;
import com.xkcoding.multi.datasource.mybatis.model.L3TeamTicket3;
import com.xkcoding.multi.datasource.mybatis.model.TodayTotalModel;
import com.xkcoding.multi.datasource.mybatis.service.L3TeamTicketService;
import com.xkcoding.multi.datasource.mybatis.service.TodayOrderTotalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@DS("slave")
@Slf4j
/**
 * @author fnchenxi
 */
public class L3TeamTicketServiceImpl implements L3TeamTicketService {

    @Autowired
    L3TeamTicket3QueryMapper l3TeamTicket3QueryMapper;

    @Autowired
    L3TeamTicket3Mapper l3TeamTicket3Mapper;

    /**
     * 查询L3总票数量
     * @return
     */
    @Override
    public Integer getTotalTickets() {
        Integer a = l3TeamTicket3QueryMapper.getTotalTicketsByIncindent();
        Integer b = l3TeamTicket3QueryMapper.getgetTotalTicketsByRequest();
        return a+b;
    }

    /**
     * 查询L3working票数量
     * @return
     */
    @Override
    public Integer getWorkIngTickets() {
        Integer a = l3TeamTicket3QueryMapper.getWorkIngTicketsByIncindent();
        Integer b = l3TeamTicket3QueryMapper.getWorkIngTicketsByRequest();
        return a+b;
    }

    /**
     * 查询L3待售票数
     * @return
     */
    @Override
    public Integer getPendingTickets() {
        Integer a = l3TeamTicket3QueryMapper.getPendingTicketsByIncindent();
        Integer b = l3TeamTicket3QueryMapper.getPendingTicketsByRequest();
        return a+b;
    }

    /**
     * 查询L3关闭票数量
     * @return
     */
    @Override
    public Integer getClosedTickets() {
        Integer a = l3TeamTicket3QueryMapper.getCloseTicketsByIncindent();
        Integer b = l3TeamTicket3QueryMapper.getCloseTicketsByRequest();
        return a+b;
    }

    /**
     * 查询L3等待票数
     * @return
     */
    @Override
    public Integer getWaitingTickets() {
        Integer a = l3TeamTicket3QueryMapper.getWaitTicketsByIncindent();
        Integer b = l3TeamTicket3QueryMapper.getWaitTicketsByRequest();
        return a+b;
    }

    /**
     * 把查询的结果封装为数据库实体对象
     * @return
     */
    @Override
    public L3TeamTicket3 getModelData() {
        L3TeamTicket3 teamTicket3=new L3TeamTicket3();

        Integer totalTickets = getTotalTickets();
        Integer workIngTickets = getWorkIngTickets();
        Integer pendingTickets = getPendingTickets();
        Integer closedTickets = getClosedTickets();
        Integer waitingTickets = getWaitingTickets();

        if((totalTickets+workIngTickets+pendingTickets+closedTickets+waitingTickets)!=0){
            teamTicket3.setTotalTickets(totalTickets);
            teamTicket3.setPendingTickets(pendingTickets);
            teamTicket3.setClosedTickets(closedTickets);
            teamTicket3.setWaitingTickets(waitingTickets);

            return teamTicket3;
        }
        return null;
    }

    @DS("master")
    @Override
    public int insertSelective(L3TeamTicket3 modelData) {
        return l3TeamTicket3Mapper.insertSelective(modelData);
    }

    @DS("master")
    @Override
    public int deleteDataByToDay() {
        return l3TeamTicket3Mapper.deleteDataByToDay();
    }
}
