package com.yida.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yida.entity.IncL1l2l3Num;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yida.entity.Incident;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author guantianqi
 * @since 2020-07-03
 */
public interface IIncL1l2l3NumService extends IService<IncL1l2l3Num> {

    public boolean remove(QueryWrapper<IncL1l2l3Num> queryWrapper) ;


    public boolean save(IncL1l2l3Num incL1l2l3Num);
}
