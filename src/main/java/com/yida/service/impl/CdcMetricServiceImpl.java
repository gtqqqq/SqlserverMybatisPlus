package com.yida.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yida.entity.CdcMetric;
import com.yida.mapper.CdcMetricMapper;
import com.yida.service.ICdcMetricService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
public class CdcMetricServiceImpl extends ServiceImpl<CdcMetricMapper, CdcMetric> implements ICdcMetricService {

    //@Autowired
    //TODO service


}
