package com.yida.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yida.entity.Incident;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author guantianqi
 * @since 2020-07-02
 */
public interface IIncidentService extends IService<Incident> {

    public Integer selectL1IncidentList();


    public Integer selectL2IncResolvedList(@Param("state")String state);


    public Integer selectL3IncResolvedList(@Param("state")String state);

    public List<Incident> selectL2L3IncTop5List();


}
