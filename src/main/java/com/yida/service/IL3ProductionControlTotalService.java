package com.yida.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yida.entity.L3ProductionControlTotal;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 作业生产量管控(每日)总数统计 服务类
 * </p>
 *
 * @author gtq
 * @since 2020-07-12
 */
public interface IL3ProductionControlTotalService extends IService<L3ProductionControlTotal> {


    @Transactional
    Boolean remove(QueryWrapper<L3ProductionControlTotal> queryWrapper);
}
