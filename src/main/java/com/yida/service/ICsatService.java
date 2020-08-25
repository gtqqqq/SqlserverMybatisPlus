package com.yida.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yida.entity.Csat;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author guantianqi
 * @since 2020-07-06
 */
public interface ICsatService extends IService<Csat> {

    @Transactional
    @DS("master")
    Boolean remove(QueryWrapper<Csat> queryWrapper);
}
