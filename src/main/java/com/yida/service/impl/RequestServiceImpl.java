package com.yida.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.bcel.internal.generic.IFNULL;
import com.yida.entity.IncL1l2l3Num;
import com.yida.entity.ReqL1l2l3Num;
import com.yida.entity.Request;
import com.yida.mapper.RequestMapper;
import com.yida.service.IReqL1l2l3NumService;
import com.yida.service.IRequestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author guantianqi
 * @since 2020-07-02
 */
@DS("slave")
@Slf4j
@Service
public class RequestServiceImpl extends ServiceImpl<RequestMapper, Request> implements IRequestService {

    @Autowired
    IReqL1l2l3NumService iReqL1l2l3NumService;


    public void taskRequest() {

        Integer l1count = selectL1Request();

        String state = "Complete";

        Integer l2count = selectL2Request(state);

        Integer l3count = selectL2Request(state);
        log.info("sqlserver:当天计数req>>>>>>L1="+l1count+"L2="+l1count+"L3="+l1count);
        ReqL1l2l3Num reqL1l2l3Num = new ReqL1l2l3Num();
        reqL1l2l3Num.setCreateTime(new Date());
        reqL1l2l3Num.setL1CreatNum(l1count);
        reqL1l2l3Num.setL2ResolvedNum(l2count);
        reqL1l2l3Num.setL3ResolvedNum(l3count);
        QueryWrapper<ReqL1l2l3Num> queryWrapper = new QueryWrapper<ReqL1l2l3Num>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyy-MM-dd");
        queryWrapper.apply(" DATE_FORMAT(create_time,'%Y-%m-%d')= DATE_FORMAT({0},'%Y-%m-%d')", new Date());
        try {
            List<ReqL1l2l3Num> list = iReqL1l2l3NumService.list(queryWrapper);
            if (list.size() > 0) {
                log.info("mysql:req删除当天"+dateFormat.format(new Date())+"的incL1L2L3计数");
                iReqL1l2l3NumService.remove(queryWrapper);
                iReqL1l2l3NumService.save(reqL1l2l3Num);

            } else {
                log.info("mysql:req首次添加当天"+dateFormat.format(new Date())+"的incL1L2L3计数");
                iReqL1l2l3NumService.save(reqL1l2l3Num);
            }


        } catch (Exception e) {

            log.error(e.getLocalizedMessage(), e);
        }
    }

    @Override
    public Integer selectL1Request() {
        return baseMapper.selectL1Request();
    }

    @Override
    public Integer selectL2Request(String state) {
        return baseMapper.selectL2Request(state);
    }

    @Override
    public Integer selectL3Request(String state) {
        return baseMapper.selectL3Request(state);
    }

    @Transactional
    @Override
    public boolean remove(QueryWrapper<Request> queryWrapper) {
        return super.remove(queryWrapper);
    }

    @Transactional
    @Override
    public boolean save(Request request) {
        return super.save(request);
    }
}
