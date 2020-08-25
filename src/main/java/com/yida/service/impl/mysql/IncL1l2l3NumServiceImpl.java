package com.yida.service.impl.mysql;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yida.entity.IncL1l2l3Num;
import com.yida.mapper.IncL1l2l3NumMapper;
import com.yida.service.IIncL1l2l3NumService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author guantianqi
 * @since 2020-07-03
 */
@DS("master")
@Service
public class IncL1l2l3NumServiceImpl extends ServiceImpl<IncL1l2l3NumMapper, IncL1l2l3Num> implements IIncL1l2l3NumService {

    @Transactional
    @Override
    public boolean remove(QueryWrapper<IncL1l2l3Num> queryWrapper) {
        return super.remove(queryWrapper);
    }

    @Transactional
    @Override
    public boolean save(IncL1l2l3Num incL1l2l3Num){
        return super.save(incL1l2l3Num);
    }
}
