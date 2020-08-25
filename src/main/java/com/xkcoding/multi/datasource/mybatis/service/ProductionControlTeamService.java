package com.xkcoding.multi.datasource.mybatis.service;

import com.xkcoding.multi.datasource.mybatis.model.ProductionControlTeam;
import com.xkcoding.multi.datasource.mybatis.model.ProductionControlTeamGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: smf
 * @time: 7/12/2020 8:46 AM
 * @description: 作业生产量管控-SD-L1 Team 服务层
 */
public interface ProductionControlTeamService {
    /**
     * 作业生产量管控-SD-L1 Team
     *
     * @param productionControlTeamList
     * @return
     */
    public Boolean insertProductionControlTeamList(List<ProductionControlTeam> productionControlTeamList);

    /**
     * 清表
     */
    public void deleteProductionControlTeam();

    //TODO 作业生产量管控(每日)  SD-L1 Team

    /**
     * 作业生产量管控-SD-L1 Team-Incoming
     *
     * @return
     */
    public Integer selectProductionControlIncoming();


    /**
     * 作业生产量管控-SD-L1 Team-Responded
     *
     * @return
     */
    public Integer selectProductionControlResponded();

    /**
     * 作业生产量管控-SD-L1 Team-Closed
     *
     * @return
     */
    public Integer selectProductionControlClosed();

    //测试时间接口
    public Integer selectByDuration(String starDuration, String endDuration, String year, String month);


    /**
     * 作业生产量管控-SD-L1 Team-Incoming-2
     *
     * @return
     */
    public List<ProductionControlTeam> selectProductionControlIncoming2();


    /**
     * 查询昨天23点至零点数据
     *
     * @return
     */
    public List<ProductionControlTeam> selectProductionControlIncomingByTime();

    /**
     * 删除当天23点至零点数据
     */
    public void deleteIncomingByTime();


    /**
     * 录入production_control_team_group
     *
     * @param productionControlTeamList
     * @return
     */
    public Boolean insertProductionControlTeamGroup(List<ProductionControlTeamGroup> productionControlTeamList);

    /**
     * 清表
     */
    public void deleteProductionControlTeamGroup();


    /**
     * 分组统计RESPONDED以及close
     *
     * @return
     */
    public List<ProductionControlTeamGroup> selectProductionControlRespondedByGroup();

    /**
     * 分组统计Close
     *
     * @return
     */
    public List<ProductionControlTeamGroup> selectProductionControlCloseByGroup();

    /**
     * 查询 incoming 全部历史数据
     *
     * @return
     */
    List<ProductionControlTeamGroup> selectIncomingByDate();

}
