package com.yida.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yida.entity.L3Incindent;
import com.yida.mapper.L3IncindentMapper;
import com.yida.service.IL3IncindentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author guantianqi
 * @since 2020-07-06
 */
@Slf4j
@DS("slave")
@Service
public class L3IncindentServiceImpl extends ServiceImpl<L3IncindentMapper, L3Incindent> implements IL3IncindentService {

    @Override
    public List<Map<String, Object>> selectTeamProductList() {
        return baseMapper.selectTeamProductList();
    }

    @Override
    public Map<String, Integer> selectTeamProductTotalList() {
        return baseMapper.selectTeamProductTotalList();
    }
}
