package com.yida.service.impl.mysql;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xkcoding.multi.datasource.mybatis.util.DateUtils;
import com.yida.entity.L3ProductionControl;
import com.yida.entity.L3ProductionControlTotal;
import com.yida.mapper.L3ProductionControlTotalMapper;
import com.yida.service.IL3IncindentService;
import com.yida.service.IL3ProductionControlTotalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author guantianqi
 * @since 2020-07-06
 */
@Slf4j
@DS("master")
@Service
public class L3ProductionControlTotalServiceImpl extends ServiceImpl<L3ProductionControlTotalMapper, L3ProductionControlTotal> implements IL3ProductionControlTotalService {

    @Autowired
    IL3IncindentService il3IncindentService;

    //sqlserver L3ProductionControlTotal统计数定时写入mysql
    public void taskL3ProductionControlTotal() {
        Date createTime = new Date();
        Map<String, Integer> map = il3IncindentService.selectTeamProductTotalList();
        if (map!=null && !map.keySet().isEmpty())
        for (String str : map.keySet()) {
            String name = str.replace("_num", "");
            Integer ticketsVol = map.get(name + "_num");
            BigDecimal delivered = null;
            String targetHitted = null;
            L3ProductionControlTotal l3ProductionControlTotal = new L3ProductionControlTotal();
            l3ProductionControlTotal.setCreateTime(createTime);
            l3ProductionControlTotal.setName(name);
            l3ProductionControlTotal.setTicketsVol(ticketsVol);
            l3ProductionControlTotal.setDelivered(delivered);
            l3ProductionControlTotal.setTargetHitted(targetHitted);
            QueryWrapper<L3ProductionControlTotal> queryWrapper = new QueryWrapper<L3ProductionControlTotal>();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyy-MM-dd");
            queryWrapper.eq("name", name);
            queryWrapper.apply(" DATE_FORMAT(create_time,'%Y-%m-%d')= DATE_FORMAT({0},'%Y-%m-%d')", new Date());
            saveMysql(l3ProductionControlTotal, queryWrapper, dateFormat);
        }
    }

    private void saveMysql(L3ProductionControlTotal l3ProductionControlTotal, QueryWrapper<L3ProductionControlTotal> queryWrapper, SimpleDateFormat dateFormat) {
        try {
            List<L3ProductionControlTotal> list = this.list(queryWrapper);
            if (list.size() > 0) {
                log.info("mysql:删除当天" + dateFormat.format(new Date()) + "的L3ProductionControlTotal统计数");
                this.remove(queryWrapper);
                log.info("mysql:更新当天" + dateFormat.format(new Date()) + "的L3ProductionControlTotal统计数");
                this.save(l3ProductionControlTotal);
            } else {
                log.info("mysql:首次添加当天" + dateFormat.format(new Date()) + "的L3ProductionControlTotal统计数");
                this.save(l3ProductionControlTotal);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
    @Transactional
    @Override
    public Boolean remove(QueryWrapper<L3ProductionControlTotal> queryWrapper) {
        return super.remove(queryWrapper);
    }

    @Transactional
    @Override
    public boolean save(L3ProductionControlTotal l3ProductionControlTotal) {
        return super.save(l3ProductionControlTotal);
    }
}
