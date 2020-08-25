package com.yida.service.impl.mysql;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yida.entity.OLADailyComplianceStatisticsL3;
import com.yida.mapper.OLADailyComplianceStatisticsL3Mapper;
import com.yida.service.IOLADailyComplianceStatisticsL3Service;
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
@DS("master")
@Service
public class OLADailyComplianceStatisticsL3ServiceImpl extends ServiceImpl<OLADailyComplianceStatisticsL3Mapper, OLADailyComplianceStatisticsL3> implements IOLADailyComplianceStatisticsL3Service {


}
