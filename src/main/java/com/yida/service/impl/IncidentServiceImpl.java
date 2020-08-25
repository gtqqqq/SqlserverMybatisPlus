package com.yida.service.impl;

import cn.hutool.core.date.DateUnit;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yida.entity.Incident;
import com.yida.entity.IncL1l2l3Num;
import com.yida.entity.Incident;
import com.yida.mapper.IncidentMapper;
import com.yida.service.IIncL1l2l3NumService;
import com.yida.service.IIncidentService;
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
 * inc统计
 * </p>
 *
 * @author guantianqi
 * @since 2020-07-02
 */
@Slf4j
@DS("slave")
@Service
public class IncidentServiceImpl extends ServiceImpl<IncidentMapper, Incident> implements IIncidentService {

    @Autowired
    IIncL1l2l3NumService iIncL1l2l3NumService;

    //sqlserverinc定时写入mysql

    public void taskIncident() {
        Integer l1Count = selectL1IncidentList();
        //@TODO log.info("sqlserver:当天统计数inc>>>>>>L1="+l1Count+"L2="+l2Count+"L3="+l3Count);
        String state = "Resolved";
        Integer l2Count = selectL2IncResolvedList(state);

        Integer l3Count = selectL3IncResolvedList(state);
        log.info("sqlserver:当天统计数inc>>>>>>L1=" + l1Count + "L2=" + l2Count + "L3=" + l3Count);
        IncL1l2l3Num incL1l2l3Num = new IncL1l2l3Num();
        incL1l2l3Num.setL1CreatNum(l1Count);
        incL1l2l3Num.setL2ResolvedNum(l2Count);
        incL1l2l3Num.setL3ResolvedNum(l3Count);
        incL1l2l3Num.setCreateTime(new Date());
        QueryWrapper<IncL1l2l3Num> queryWrapper = new QueryWrapper<IncL1l2l3Num>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyy-MM-dd");
        queryWrapper.eq("create_time", dateFormat.format(new Date()));
        try {
            List<IncL1l2l3Num> list = iIncL1l2l3NumService.list(queryWrapper);
            log.info("mysql:当天incL1L2L3统计数");
            if (list.size() > 0) {
                log.info("mysql:删除当天" + dateFormat.format(new Date()) + "的incL1L2L3统计数");
                iIncL1l2l3NumService.remove(queryWrapper);
                log.info("mysql:更新当天" + dateFormat.format(new Date()) + "的incL1L2L3统计数");
                iIncL1l2l3NumService.save(incL1l2l3Num);
            }else{
                log.info("mysql:首次添加当天" + dateFormat.format(new Date()) + "的incL1L2L3统计数");
                iIncL1l2l3NumService.save(incL1l2l3Num);
            }
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }

    /**
     * @see L1创建inc
     */
    @Override
    public Integer selectL1IncidentList() {
        return baseMapper.selectL1IncidentList();
    }
    /**
     * @see L2解决inc
     */
    @Override
    public Integer selectL2IncResolvedList(String state) {
        return baseMapper.selectL2IncResolvedList(state);
    }
    /**
     * @see L3解决inc
     */
    @Override
    public Integer selectL3IncResolvedList(String state) {
        return baseMapper.selectL3IncResolvedList(state);
    }

    @Override
    public List<Incident> selectL2L3IncTop5List() {
        return null;
    }


}
