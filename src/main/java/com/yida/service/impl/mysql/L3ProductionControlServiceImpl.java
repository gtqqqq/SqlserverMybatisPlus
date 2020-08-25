package com.yida.service.impl.mysql;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xkcoding.multi.datasource.mybatis.util.DateUtils;
import com.yida.entity.L3ProductionControl;
import com.yida.mapper.L3ProductionControlMapper;
import com.yida.service.IL3IncindentService;
import com.yida.service.IL3ProductionControlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
@DS("master")
@Service
public class L3ProductionControlServiceImpl extends ServiceImpl<L3ProductionControlMapper, L3ProductionControl> implements IL3ProductionControlService {

    @Autowired
    IL3IncindentService il3IncindentService;

    public void  taskL3Production() {
        List<L3ProductionControl> l3List=new ArrayList<>();
        List<Map<String, Object>> list = il3IncindentService.selectTeamProductList();
        for (Map<String, Object> map: list) {
            Integer totalNum = (Integer) map.get("total_num");
            Integer Responded = (Integer) map.get("respond_num");;
            Integer closeNum = (Integer) map.get("close_num");;
            String assignmentGroup = (String) map.get("Assignment group");
            L3ProductionControl l3ProductionControl = new L3ProductionControl();
            l3ProductionControl.setMark((Integer)map.get("mark"));
            Date createTime = new Date();
            l3ProductionControl.setCreateTime(createTime);
            l3ProductionControl.setTotalNum(totalNum);
            l3ProductionControl.setResponded(Responded);
            l3ProductionControl.setCloseNum(closeNum);
            l3ProductionControl.setAssignmentGroup(assignmentGroup);
            l3ProductionControl.setSourceType(1);
            l3ProductionControl.setEndTime(DateUtils.getAddHourTime(map.get("opened")==null?null:(String)map.get("opened")));
            l3List.add(l3ProductionControl);
        }
        QueryWrapper<L3ProductionControl> queryWrapper = new QueryWrapper<L3ProductionControl>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyy-MM-dd");
        //queryWrapper.eq("assignment_group", assignmentGroup);
        savemysql(l3List,queryWrapper,dateFormat);
    }


    //sqlserver L3ProductionControl统计数定时写入mysql

    private void savemysql(List<L3ProductionControl> l3ProductionControl, QueryWrapper<L3ProductionControl> queryWrapper,SimpleDateFormat dateFormat ) {
        try {
            List<L3ProductionControl> list = this.list(queryWrapper);
            if (list.size() > 0) {
                log.info("mysql:删除当天" + dateFormat.format(new Date()) + "的L3ProductionControl统计数");
                this.remove(queryWrapper);
                log.info("mysql:更新当天" + dateFormat.format(new Date()) + "的L3ProductionControl统计数");
                for(L3ProductionControl l3Data:l3ProductionControl){
                    this.save(l3Data);
                }
            }else{
                log.info("mysql:首次添加当天" + dateFormat.format(new Date()) + "的L3ProductionControl统计数");
                for(L3ProductionControl l3Data:l3ProductionControl){
                    this.save(l3Data);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }
    @Transactional
    @Override
    @DS("master")
    public Boolean remove(QueryWrapper<L3ProductionControl> queryWrapper) {
        return super.remove(queryWrapper);
    }

    @Transactional
    @Override
    @DS("master")
    public boolean save(L3ProductionControl l3ProductionControl) {
        return super.save(l3ProductionControl);
    }

}
