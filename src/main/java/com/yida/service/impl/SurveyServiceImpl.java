package com.yida.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yida.entity.Survey;
import com.yida.mapper.SurveyMapper;
import com.yida.service.ISurveyService;
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
public class SurveyServiceImpl extends ServiceImpl<SurveyMapper, Survey> implements ISurveyService {


    @Override
    public Integer selectCsatRequest(int hour) {
        return baseMapper.selectCsatRequest(hour);
    }

    @Override
    public Integer selectCsatIncident(int hour) {
        return baseMapper.selectCsatIncident(hour);
    }

    @Override
    public Integer selectCsatPhone(int hour) {
        return baseMapper.selectCsatPhone(hour);
    }

    @Override
    public List<Map<String ,String>> selectCsatRequestNumMap() {
        return baseMapper.selectCsatRequestNumMap();
    }

    @Override
    public List<Map<String ,String>> selectCsatPhoneNumMap() {
        return baseMapper.selectCsatPhoneNumMap();
    }

    @Override
    public List<Map<String ,String>> selectCsatIncidentNumMap() {
        return baseMapper.selectCsatIncidentNumMap();
    }

    @Override
    public List<Map<String ,String>> selectCsatRequestTotalNumMap() {
        return baseMapper.selectCsatRequestTotalNumMap();
    }

    @Override
    public List<Map<String ,String>> selectCsatPhoneTotalNumMap() {
        return baseMapper.selectCsatPhoneTotalNumMap();
    }

    @Override
    public List<Map<String ,String>> selectCsatIncidentTotalNumMap() {
        return baseMapper.selectCsatIncidentTotalNumMap();
    }

    @Override
    public List<String> selectCsatDateList() {
        return  baseMapper.selectCsatDateList();
    }
}
