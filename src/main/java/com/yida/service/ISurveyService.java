package com.yida.service;

import com.yida.entity.Survey;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author guantianqi
 * @since 2020-07-07
 */
public interface ISurveyService extends IService<Survey> {

    public Integer selectCsatRequest(int hour);

    public Integer selectCsatIncident(int hour);

    public Integer selectCsatPhone(int hour);

    public List<Map<String ,String>> selectCsatRequestNumMap();

    public List<Map<String ,String>> selectCsatPhoneNumMap();

    public List<Map<String ,String>> selectCsatIncidentNumMap();

    public List<Map<String ,String>> selectCsatRequestTotalNumMap();

    public List<Map<String ,String>> selectCsatPhoneTotalNumMap();

    public List<Map<String ,String>> selectCsatIncidentTotalNumMap();

    public List<String > selectCsatDateList();
}
