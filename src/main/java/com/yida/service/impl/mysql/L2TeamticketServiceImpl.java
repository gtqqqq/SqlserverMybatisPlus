package com.yida.service.impl.mysql;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yida.entity.L2Teamticket;
import com.yida.mapper.L2TeamticketMapper;
import com.yida.service.IL2IncindentService;
import com.yida.service.IL2TeamticketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
public class L2TeamticketServiceImpl extends ServiceImpl<L2TeamticketMapper, L2Teamticket> implements IL2TeamticketService {

    @Autowired
    IL2IncindentService il2IncindentService;


    public void taskL2Teamticket() {

        Integer totalTickets= il2IncindentService.selectL2Totalticket();
        Integer workingTickets = il2IncindentService.selectL2WorkingTickets();
        Integer waitingTickets = il2IncindentService.selectL2WaitingTickets();
        Integer pendingTickets = il2IncindentService.selectL2PendingTickets();
        Integer closedTickets = il2IncindentService.selectL2ClosedTickets();

        L2Teamticket l2Teamticket = new L2Teamticket();
        l2Teamticket.setTotalTickets(totalTickets);
        l2Teamticket.setWorkingTickets(workingTickets);
        l2Teamticket.setWaitingTickets(waitingTickets);
        l2Teamticket.setPendingTickets(pendingTickets);
        l2Teamticket.setClosedTickets(closedTickets);
        l2Teamticket.setOptDate(new Date());
        savemysql(l2Teamticket);
    }

    private void savemysql(L2Teamticket l2Teamticket) {
        QueryWrapper<L2Teamticket> queryWrapper = new QueryWrapper<L2Teamticket>();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyy-MM-dd");
        queryWrapper.eq("opt_date", dateFormat.format(new Date()));
        try {
            List<L2Teamticket> list = this.list(queryWrapper);
            if (list.size() > 0) {
                log.info("mysql:删除当天" + dateFormat.format(new Date()) + "的L2TeamTickets统计数");
                this.remove(queryWrapper);
                log.info("mysql:更新当天" + dateFormat.format(new Date()) + "的L2TeamTickets统计数");
                this.save(l2Teamticket);
            }else{
                log.info("mysql:首次添加当天" + dateFormat.format(new Date()) + "的L2TeamTickets统计数");
                this.save(l2Teamticket);
            }
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }

}
