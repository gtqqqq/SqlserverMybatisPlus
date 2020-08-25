package com.xkcoding.multi.datasource.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xkcoding.multi.datasource.mybatis.mapper.ProductionControlTeamMapper;
import com.xkcoding.multi.datasource.mybatis.mapper.lineChartMapper;
import com.xkcoding.multi.datasource.mybatis.model.ProductionControlTeam;
import com.xkcoding.multi.datasource.mybatis.model.ProductionControlTeamGroup;
import com.xkcoding.multi.datasource.mybatis.model.lineChart;
import com.xkcoding.multi.datasource.mybatis.service.ProductionControlTeamService;
import com.xkcoding.multi.datasource.mybatis.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description: 作业生产量管控-SD-L1 Team 服务层
 * @author: smf
 * @time: 7/12/2020 8:47 AM
 */
@Service
@DS("master")
public class ProductionControlTeamServiceImpl extends ServiceImpl<ProductionControlTeamMapper, ProductionControlTeam> implements ProductionControlTeamService {
    @Autowired
    private ProductionControlTeamMapper productionControlTeamMapper;

    /**
     * 作业生产量管控-SD-L1 Team
     *
     * @param productionControlTeamList
     * @return
     */
    @Override
    public Boolean insertProductionControlTeamList(List<ProductionControlTeam> productionControlTeamList) {
        return productionControlTeamMapper.insertProductionControlTeamList(productionControlTeamList);
    }

    /**
     * 清表
     */
    @Override
    public void deleteProductionControlTeam() {
        productionControlTeamMapper.deleteProductionControlTeam();
    }

    /**
     * 作业生产量管控-SD-L1 Team-Incoming
     *
     * @return
     */
    @DS("slave")
    @Override
    public Integer selectProductionControlIncoming() {
        return baseMapper.selectProductionControlIncoming();
    }

    /**
     * 作业生产量管控-SD-L1 Team-Responded
     *
     * @return
     */
    @DS("slave")
    @Override
    public Integer selectProductionControlResponded() {
        return baseMapper.selectProductionControlResponded();
    }

    /**
     * 作业生产量管控-SD-L1 Team-Closed
     *
     * @return
     */
    @DS("slave")
    @Override
    public Integer selectProductionControlClosed() {
        return baseMapper.selectProductionControlClosed();
    }

    //测试时间接口
    @DS("slave")
    @Override
    public Integer selectByDuration(String starDuration, String endDuration, String year, String month) {
        return baseMapper.selectByDuration(starDuration, endDuration, year, month);
    }

    /**
     * 作业生产量管控-SD-L1 Team-Incoming-2  //TODO Call 表没有页面三个组
     *
     * @return
     */
    @DS("slave")
    @Override
    @Transactional
    public List<ProductionControlTeam> selectProductionControlIncoming2() {
        List<ProductionControlTeam> data = new ArrayList<ProductionControlTeam>();
        try {
            List<Map<String, Object>> IncomingAllList = productionControlTeamMapper.selectProductionControlIncoming2();
            if (null != IncomingAllList && IncomingAllList.size() > 0) {
                for (Map<String, Object> da : IncomingAllList) {
                    ProductionControlTeam productionControlTeam = new ProductionControlTeam();
//                    int num = Double.valueOf((Double) da.get("num")).intValue();
                    Integer num = (Integer) da.get("num");
                    productionControlTeam.setIncoming(num);
                    productionControlTeam.setTime(new Date());
                    data.add(productionControlTeam);
                }
            }
          /*  productionControlTeamMapper.deleteProductionControlTeam();
            productionControlTeamMapper.insertProductionControlTeamList(data);*/

            if (null != IncomingAllList && IncomingAllList.size() > 0) {
                for (Map<String, Object> da : IncomingAllList) {
                    Integer startTime = (Integer) da.get("startTime");
                    if (startTime >= 23 && startTime <= 24) {
                        //调用昨天23:00至零点
                        selectProductionControlIncomingByTime();
                    }

                }

            }


        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return data;
    }

    /**
     * 查询昨天23点至零点数据
     *
     * @return
     */
    @DS("slave")
    @Override
    public List<ProductionControlTeam> selectProductionControlIncomingByTime() {
        List<ProductionControlTeam> data = new ArrayList<ProductionControlTeam>();
        try {
            List<Map<String, Object>> byTime = productionControlTeamMapper.selectProductionControlIncomingByTime();
            if (null != byTime && byTime.size() > 0) {
                for (Map<String, Object> da : byTime) {
                    ProductionControlTeam productionControlTeam = new ProductionControlTeam();
//                    int num = Double.valueOf((Double) da.get("num")).intValue();
                    Integer num = (Integer) da.get("num");
                    productionControlTeam.setIncoming(num);
                    productionControlTeam.setTime(new Date());
                    data.add(productionControlTeam);
                }
            }
           /* productionControlTeamMapper.deleteIncomingByTime();
            productionControlTeamMapper.insertProductionControlTeamList(data);
*/
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return data;
    }

    /**
     * 删除当天23点至零点数据
     */
    @Override
    public void deleteIncomingByTime() {

    }

    /**
     * 分组统计RESPONDED
     *
     * @return
     */
    @DS("slave")
    @Override
    public List<ProductionControlTeamGroup> selectProductionControlRespondedByGroup() {
        List<ProductionControlTeamGroup> data = new ArrayList<ProductionControlTeamGroup>();
        try {

            List<Map<String, Object>> byGroup = productionControlTeamMapper.selectProductionControlRespondedByGroup();
            if (null != byGroup && byGroup.size() > 0) {
                for (Map<String, Object> da : byGroup) {
                    ProductionControlTeamGroup productionControlTeamGroup = new ProductionControlTeamGroup();
                    Integer responded = (Integer) da.get("resNum");
                    String groupName = (String) da.get("resGroupName");
                    String resopendateTime = (String) da.get("resopendateTime");
                    String mark = (String) da.get("resMark");
                    Integer closeNum = (Integer) da.get("closeNum");
                    productionControlTeamGroup.setResponded(responded);
                    productionControlTeamGroup.setAssignmentGroup(groupName);
                    productionControlTeamGroup.setMaRk(mark);
                    productionControlTeamGroup.setClosed(closeNum);
                    productionControlTeamGroup.setTime(new Date());
                    productionControlTeamGroup.setSourceType((String) da.get("resMark"));
                    productionControlTeamGroup.setEndTime(DateUtils.getAddHourTime(resopendateTime));
                    data.add(productionControlTeamGroup);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return data;
    }

    /**
     * 分组统计Close
     *
     * @return
     */
    @DS("slave")
    @Override
    public List<ProductionControlTeamGroup> selectProductionControlCloseByGroup() {
        List<ProductionControlTeamGroup> data = new ArrayList<ProductionControlTeamGroup>();
        try {
            List<Map<String, Object>> ByClose = productionControlTeamMapper.selectProductionControlCloseByGroup();
            if (null != ByClose && ByClose.size() > 0) {
                for (Map<String, Object> da : ByClose) {
                    ProductionControlTeamGroup controlTeamGroup = new ProductionControlTeamGroup();
                    Integer closed = (Integer) da.get("closed");
                    String groupName = (String) da.get("groupName");
                    String mark = (String) da.get("mark");
                    controlTeamGroup.setClosed(closed);
                    controlTeamGroup.setAssignmentGroup(groupName);
                    controlTeamGroup.setMaRk(mark);
                    controlTeamGroup.setSourceType("0");
                    controlTeamGroup.setTime(new Date());
                    data.add(controlTeamGroup);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return data;
    }

    /**
     * 查询 incoming 全部历史数据
     *
     * @return
     */
    @DS("slave")
    @Override
    public List<ProductionControlTeamGroup> selectIncomingByDate() {
        List<ProductionControlTeamGroup> data = new ArrayList<>();
        try {
            List<Map<String, Object>> maps = productionControlTeamMapper.selectIncomingByDate();
            if (null != maps && maps.size() > 0) {
                for (Map<String, Object> da : maps) {
                    ProductionControlTeamGroup teamGroup = new ProductionControlTeamGroup();
                    teamGroup.setInComing((Integer) da.get("num"));
                    teamGroup.setMaRk((String) da.get("Mark"));
                    String startTime = (String) da.get("startTime");
                    teamGroup.setSourceType((String) da.get("Mark"));
                    teamGroup.setEndTime(DateUtils.getAddHourTime(startTime));
                    data.add(teamGroup);
                }

            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }


        return data;
    }

    /**
     * 录入 production_control_team_group
     *
     * @param productionControlTeamGroupList
     * @return
     */
    @Override
    public Boolean insertProductionControlTeamGroup(List<ProductionControlTeamGroup> productionControlTeamGroupList) {
        return productionControlTeamMapper.insertProductionControlTeamGroup(productionControlTeamGroupList);
    }

    /**
     *
     */
    @Override
    public void deleteProductionControlTeamGroup() {
        productionControlTeamMapper.deleteProductionControlTeamGroup();
    }
}
