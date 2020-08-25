package com.xkcoding.multi.datasource.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.xkcoding.multi.datasource.mybatis.mapper.NotCloseModelMapper;
import com.xkcoding.multi.datasource.mybatis.mapper.NotCloseOrderMapper;
import com.xkcoding.multi.datasource.mybatis.model.NotCloseModel;
import com.xkcoding.multi.datasource.mybatis.service.NotCloseOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 尚未关闭模块的查询
 * @author fanchenxi
 */
@Service
@DS("slave")
@Slf4j
public class NotCloseOrderServiceImpl implements NotCloseOrderService {

    @Autowired
    NotCloseOrderMapper notCloseOrderMapper;

    @Autowired
    NotCloseModelMapper notCloseModelMapper;


    /**
     * 查询当天尚未关闭工单数
     * @return
     */
    @Override
    public Integer getNotCloseOrderNum() {
        Integer num1 = notCloseOrderMapper.getIncidentNum();
        Integer requestNum = notCloseOrderMapper.getRequestNum();
        Integer cdcRequestNum = notCloseOrderMapper.getCDCRequestNum();
        Integer cdcIncidentNum = notCloseOrderMapper.getCDCIncidentNum();
        return num1+requestNum+cdcRequestNum+cdcIncidentNum;
    }

    /**
     * 查询当天滞留的工单数量
     * @return
     */
    @Override
    public Integer getStopOrderNum() {
        Integer stopCDCIncident = notCloseOrderMapper.getStopCDCIncident();
        Integer stopCDCRequestNum = notCloseOrderMapper.getStopCDCRequestNum();
        Integer stopIncidentNum = notCloseOrderMapper.getStopIncidentNum();
        Integer stopRequestNum = notCloseOrderMapper.getStopRequestNum();
        return stopCDCIncident+stopCDCRequestNum+stopIncidentNum+stopRequestNum;
    }

    /**
     * 查询当天进行中的工单数量
     * @return
     */

    @Override
    public Integer getOnGoingOrderNum(){
        Integer onGoingCDCIncident = notCloseOrderMapper.getOnGoingCDCIncident();
        Integer onGoingCDCRequest = notCloseOrderMapper.getOnGoingCDCRequest();
        Integer onGoingIncident = notCloseOrderMapper.getOnGoingIncident();
        Integer onGoingRequest = notCloseOrderMapper.getOnGoingRequest();
        return onGoingCDCIncident+onGoingCDCRequest+onGoingIncident+onGoingRequest;
    }

    /**
     * 返回封装的实体对象
     * @return
     */
    @Override
    public NotCloseModel getNotCloseModelData() {
        NotCloseModel notCloseModel=new NotCloseModel();
        /**
         * 1.查询出尚未关闭,滞留和进行中的工单数
         */
        Integer notCloseNum= getNotCloseOrderNum();
        Integer stopOrder= getStopOrderNum();
        Integer onGoingNum= getOnGoingOrderNum();

        /**
         * 2.如果查询出来了数据就赋值到对象并且添加到mysql数据库里
         */
        if((notCloseNum+stopOrder+onGoingNum)!=0){
            notCloseModel.setCreateTime(new Date());
            notCloseModel.setNotCloseNum(notCloseNum);
            notCloseModel.setStopNum(stopOrder);
            notCloseModel.setOngoingNum(onGoingNum);

            /**
             * 3.返回添加到mysql的实体
             */
            return notCloseModel;
        }
        return null;
    }

    @DS("master")
    @Override
    public int insertSelective(NotCloseModel record) {
        return notCloseModelMapper.insertSelective(record);
    }

    @DS("master")
    @Override
    public int deleteDataByToDay() {
        return notCloseModelMapper.deleteDataByToDay();
    }


}
