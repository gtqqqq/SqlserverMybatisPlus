package com.yida.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yida.entity.L3ProductionControl;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 作业生产量管控(每日) 服务类
 * </p>
 *
 * @author gtq
 * @since 2020-07-12
 */
public interface IL3ProductionControlService extends IService<L3ProductionControl> {

    public Boolean remove(QueryWrapper<L3ProductionControl> queryWrapper);

    public boolean save(L3ProductionControl l3ProductionControl);
}
