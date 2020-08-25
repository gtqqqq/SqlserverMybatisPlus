package com.xkcoding.multi.datasource.mybatis.timer;

import com.xkcoding.multi.datasource.mybatis.model.*;
import com.xkcoding.multi.datasource.mybatis.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 每小时定时执行
 * 读取SQLSERVER数据源 写入到 MYSQL数据库中
 * @author fanchenxi
 */
@Service
@Slf4j
public class OperationDataServiceImpl {

    @Autowired
    NotCloseOrderService notCloseOrderService;//尚未关闭模块服务层

    @Autowired
    TodayOrderTotalService todayOrderTotalService;//今日服务统计服务层

    @Autowired
    L3TeamTicketService l3TeamTicketService;//L3 Team/Ticket服务层

    @Autowired
    DailyCompliService dailyCompliService;//L2 L3 SLA 每日达标服务层

    @Autowired
    ProductionControlService productionControlService;//作业生产量管控服务层

    @Autowired
    QualityCheckService qualityCheckService;//质量检测服务层

    @Autowired
    OrderUpService orderUpService;//升单量服务层

    @Autowired
    HumanResourcesService humanResourcesService;//人力资源服务层

    @Autowired
    ExceptionService exceptionService;//异常信息服务层

    @Autowired
    LearnServer learnServer;//培训信息服务层

    @Autowired
    ComplaintService complaintService;//客户投诉服务层

    @Autowired
    SecurityIncidentService securityIncidentService;//安全事件服务层

    @Autowired
    FteService fteService;//FTE服务层

    /**
     * 操作对象 读写方法分离
     * @return
     */
   // @Scheduled(cron="${corn.time}")
    public void operationData(){
        /**
         * 1.尚未关闭模块内容
         */
       /*NotCloseModel model =notCloseOrderService.getNotCloseModelData();
        System.out.println("当日尚未关闭模块的实体对象："+model);
        if(model!=null){
            int del = notCloseOrderService.deleteDataByToDay();
            System.out.println("删除当日尚未关闭模块结果："+del);
            int result= notCloseOrderService.insertSelective(model);
            System.out.println("当日尚未关闭模块的实体对象写入结果："+result);
        }*/

        /**
         * 2.今日实时服务模块内容
         */
        /*TodayTotalModel todayTotalModelData = todayOrderTotalService.getTodayTotalModelData();
        System.out.println("今日实时服务模块内容的实体对象："+todayTotalModelData);
        if(todayTotalModelData!=null){
            int del = todayOrderTotalService.deleteDataByToDay();
            System.out.println("删除当日尚未关闭模块结果："+del);
            int result = todayOrderTotalService.insertSelective(todayTotalModelData);
            System.out.println("今日实时服务模块内容对象写入结果："+result);
        }*/

        /**
         * 3.今日服务热点
         */
        //todayOrderTotalService.getServerHot();

        /**
         * 4.查询 L3_team/Ticket 统计数量(总数,工作中,关闭数，等待数和待售数)
         */
       /* L3TeamTicket3 modelData = l3TeamTicketService.getModelData();
        System.out.println("L3_team/Ticket模块内容的实体对象："+modelData);
        if(modelData!=null){
            int del = l3TeamTicketService.deleteDataByToDay();
            System.out.println("删除L3_team/Ticket模块内容结果："+del);
            int result = l3TeamTicketService.insertSelective(modelData);
            System.out.println("L3_team/Ticket模块内容对象写入结果："+result);
        }*/

        /**
         * 5. 查询 L2 SLA 每日达标内容(分组插入)
         */
        /*List<DailyComplianceStatistics> modelL2GroupData = dailyCompliService.getModelL2GroupData();
        System.out.println("L2 SLA 每日达标内容模块内容的实体对象(分组)："+modelL2GroupData);
        if (modelL2GroupData!=null&&!modelL2GroupData.isEmpty()){
            int del = dailyCompliService.deleteL2DataByToDay();
            System.out.println("删除L2 SLA 每日达标内容结果(分组)："+del);
            int result = dailyCompliService.batchInsertSelectiveL2(modelL2GroupData);
            System.out.println("L2 SLA 每日达标内容对象写入结果(分组)："+result);
        }*/

        /**
         * 6.查询 L3 SLA 每日达标内容(分组插入)
         */
        /*List<DailyComplianceStatisticsL3> modelL3GroupData = dailyCompliService.getModelL3GroupData();
        System.out.println("L3 SLA 每日达标内容模块内容的实体对象(分组)："+modelL3GroupData);
        if (modelL3GroupData!=null&&!modelL3GroupData.isEmpty()){
            int del = dailyCompliService.deleteL3DataByToDay();
            System.out.println("删除L3 SLA 每日达标内容结果(分组)："+del);
            int result =dailyCompliService.batchInsertSelectiveL3(modelL3GroupData);
            System.out.println("L3 SLA 每日达标内容对象写入结果(分组)："+result);
        }*/

        /**
         * 8.查询 作业生产量(每日)管控汇总内容(废弃)
         */
        /*List<ProductionControlTotal> proConTotalModelData = productionControlService.getModelTotalData();
        System.out.println("作业生产量管控汇总内容的实体对象："+proConTotalModelData);
        if(proConTotalModelData!=null&&!proConTotalModelData.isEmpty()&&proConTotalModelData.get(0).getTicketsVol()!=null){
            //int delproConTotal = productionControlService.deleteTotalDataByToDay();
            //System.out.println("删除作业生产量管控汇总内容结果："+delproConTotal);
            int proConTotalInsert=productionControlService.batchInsertTotalData(proConTotalModelData);
            System.out.println("作业生产量管控汇总内容写入结果："+proConTotalInsert);
        }*/

        /**
         * 5.查询 L2事件解决
         */
        List<DailyComplianceStatistics> modelL2Data = dailyCompliService.getModelL2Data();
        System.out.println("L2 SLA 每日达标内容模块内容的实体对象："+modelL2Data);
        if (modelL2Data!=null&&!modelL2Data.isEmpty()){
            int del = dailyCompliService.deleteL2DataByToDay();
            System.out.println("删除L2 SLA 每日达标内容结果："+del);
            int result = dailyCompliService.insertSelectiveL2(modelL2Data);
            System.out.println("L2 SLA 每日达标内容对象写入结果："+result);
        }


        /**
         * 5.1 查询 L2请求解决
         */
        List<DailyComplianceStatistics> modelL2DataReq = dailyCompliService.getModelL2DataByReq();
        System.out.println("L2 SLA(REQ) 每日达标内容模块内容的实体对象："+modelL2DataReq);
        if (modelL2DataReq!=null){
            int del = dailyCompliService.deleteL2RqeDataByToDay();
            System.out.println("删除L2 SLA(REQ) 每日达标内容结果："+del);
            int result = dailyCompliService.insertSelectiveL2(modelL2DataReq);
            System.out.println("L2 SLA(REQ) 每日达标内容对象写入结果："+result);
        }

        /**
         * 6.查询 L3事件解决
         */
        List<DailyComplianceStatisticsL3> modelL3Data = dailyCompliService.getModelL3Data();
        System.out.println("L3 SLA 每日达标内容模块内容的实体对象："+modelL3Data);
        if (modelL3Data!=null){
            int del = dailyCompliService.deleteL3DataByToDay();
            System.out.println("删除L3 SLA 每日达标内容结果："+del);
            int result =dailyCompliService.insertSelectiveL3(modelL3Data);
            System.out.println("L3 SLA 每日达标内容对象写入结果："+result);
        }

        /**
         * 6.1 查询 L3请求解决
         */
        List<DailyComplianceStatisticsL3> modelL3DataReq = dailyCompliService.getModelL3DataByReq();
        System.out.println("L3 SLA(REQ) 每日达标内容模块内容的实体对象："+modelL3DataReq);
        if (modelL3DataReq!=null){
            int del = dailyCompliService.deleteL3ReqDataByToDay();
            System.out.println("删除L3 SLA(REQ) 每日达标内容结果："+del);
            int result =dailyCompliService.insertSelectiveL3(modelL3DataReq);
            System.out.println("L3 SLA(REQ) 每日达标内容对象写入结果："+result);
        }

        /**
         * 7.查询 作业生产量管控内容
         */
        List<ProductionControl> proConmodelData = productionControlService.getModelData();
        System.out.println("作业生产量管控内容的实体对象："+proConmodelData);
        if(proConmodelData!=null&&!proConmodelData.isEmpty()){
            int delproCon = productionControlService.deleteDataByToDay();
            System.out.println("删除作业生产量管控内容结果："+delproCon);
            int proConInsert=productionControlService.batchInsert(proConmodelData);
            System.out.println("作业生产量管控内容写入结果："+proConInsert);
        }

        /**
         * 9.查询L2,L3 工单解决平均时长
         */
        List<OrderComplianceAvg> modelDataAvg = dailyCompliService.getModelData();
        System.out.println("工单解决平均时长的实体对象："+modelDataAvg);
        if(modelDataAvg!=null && !modelDataAvg.isEmpty()){
            int deleteOrderCompliAvg = dailyCompliService.deleteOrderCompliAvg();
            System.out.println("删除工单解决平均时长内容结果："+deleteOrderCompliAvg);
            int insertAvg=dailyCompliService.insertOrderCompliAvg(modelDataAvg);
            System.out.println("工单解决平均时长内容写入结果："+insertAvg);
        }

        /**
         * 10.查询L1-L3 质量检测
         */
        executeQulityCheck();

        /**
         * 11.查询L1-L3 升单量
         */
       executeOrderUp();

        /**
         * 12.查询L1-L3 人力资源
         */
        //executeHumanResources();

        /**
         * 13.查询L1-L3 异常信息
         */
        //executeException();

        /**
         * 14.查询L1-L3 培训数据
         */
        //executeLearn();

        /**
         * 15.查询L1-L3 投诉数据
         */
        //executeComplaint();

        /**
         * 16.查询L1-L3 安全事件
         */
        //executeSecurityIncident();

        /**
         * 17.查询L1-L3 Fte 数据
         */
        executeFteOrder();
    }

    /**
     * Sqlserver查询质量检测数据 mysql添加质量检测数据
     */
    public void executeQulityCheck(){
        List<QualityCheckL1> qualityCheckL1Data=qualityCheckService.getL1ModelData();
        System.out.println("L1质量检测的实体对象："+qualityCheckL1Data);
        if(qualityCheckL1Data!=null&&!qualityCheckL1Data.isEmpty()){
            int delqualityCheck = qualityCheckService.deleteDataByToDay();
            System.out.println("删除L1质量检测内容结果："+delqualityCheck);

            int l1Result=qualityCheckService.insertL1ModelData(qualityCheckL1Data);
            System.out.println("L1质量检测内容写入结果："+l1Result);
        }

        QualityCheckL2 qualityCheckL2Data=qualityCheckService.getL2ModelData();
        System.out.println("L2质量检测的实体对象："+qualityCheckL2Data);
        if(qualityCheckL2Data!=null){
            int l2Result=qualityCheckService.insertL2ModelData(qualityCheckL2Data);
            System.out.println("L2质量检测内容写入结果："+l2Result);
        }

        QualityCheckL3 qualityCheckL3Data=qualityCheckService.getL3ModelData();
        System.out.println("L3质量检测的实体对象："+qualityCheckL3Data);
        if(qualityCheckL3Data!=null){
            int l3Result=qualityCheckService.insertL3ModelData(qualityCheckL3Data);
            System.out.println("L3质量检测内容写入结果："+l3Result);
        }
    }

    /**
     * Sqlserver查询升单量数据 mysql添加升单量数据
     */
    private void executeOrderUp() {
        List<OrderUpL1> l1ModelData = orderUpService.getL1ModelData();
        System.out.println("L1升单量的实体对象："+l1ModelData);
        if(l1ModelData!=null && !l1ModelData.isEmpty()){
            //int delL1 = orderUpService.deleteL1DataByToDay();
            //清表
            int deleteByL1 = orderUpService.deleteL1ModelData();
            System.out.println("删除L1升单量内容结果："+deleteByL1);
            int l1Result=orderUpService.insertL1ModelData(l1ModelData);
            System.out.println("L1升单量内容写入结果："+l1Result);
        }

        List<OrderUpL2> OrderUpL2Data= orderUpService.getL2ModelData();
        System.out.println("L2升单量的实体对象："+OrderUpL2Data);
        if(OrderUpL2Data!=null && !OrderUpL2Data.isEmpty()){
            int delL2 = orderUpService.deleteL2DataByToDay();
            System.out.println("删除L2升单量内容结果："+delL2);
            int l2Result=orderUpService.insertL2ModelData(OrderUpL2Data);
            System.out.println("L2升单量内容写入结果："+l2Result);
        }

        List<OrderUpL3> OrderUpL3Data= orderUpService.getL3ModelData();
        System.out.println("L3升单量的实体对象："+OrderUpL3Data);
        if(OrderUpL3Data!=null && !OrderUpL3Data.isEmpty()){
            int delL3 = orderUpService.deleteL3DataByToDay();
            System.out.println("删除L3升单量内容结果："+delL3);
            int l3Result=orderUpService.insertL3ModelData(OrderUpL3Data);
            System.out.println("L3升单量内容写入结果："+l3Result);
        }
    }

    /**
     * Sqlserver查询人力资源数据 mysql添加人力资源数据
     */
    private void executeHumanResources() {
        HumanResourcesL1 humanResourcesL1=humanResourcesService.getL1ModelData();
        System.out.println("L1人力资源的实体对象："+humanResourcesL1);
        if(humanResourcesL1!=null){
            int l1Result=humanResourcesService.insertL1ModelData(humanResourcesL1);
            System.out.println("L1人力资源内容写入结果："+l1Result);
        }

        HumanResourcesL2 humanResourcesL2=humanResourcesService.getL2ModelData();
        System.out.println("L2人力资源的实体对象："+humanResourcesL2);
        if(humanResourcesL2!=null){
            int l2Result=humanResourcesService.insertL2ModelData(humanResourcesL2);
            System.out.println("L2人力资源内容写入结果："+l2Result);
        }

        HumanResourcesL3 humanResourcesL3=humanResourcesService.getL3ModelData();
        System.out.println("L3人力资源的实体对象："+humanResourcesL3);
        if(humanResourcesL3!=null){
            int l3Result=humanResourcesService.insertL3ModelData(humanResourcesL3);
            System.out.println("L3人力资源内容写入结果："+l3Result);
        }
    }

    /**
     * Sqlserver查询异常信息数据 mysql添加异常信息数据
     */
    private void executeException() {
        ExceptionL1 l1ModelData = exceptionService.getL1ModelData();
        System.out.println("L1异常信息的实体对象："+l1ModelData);
        if(l1ModelData!=null){
            int l1Result = exceptionService.insertL1ModelData(l1ModelData);
            System.out.println("L1异常信息内容写入结果："+l1Result);
        }

        ExceptionL2 l2ModelData = exceptionService.getL2ModelData();
        System.out.println("L2异常信息的实体对象："+l2ModelData);
        if(l2ModelData!=null){
            int l2Result = exceptionService.insertL2ModelData(l2ModelData);
            System.out.println("L2异常信息内容写入结果："+l2Result);
        }

        ExceptionL3 l3ModelData = exceptionService.getL3ModelData();
        System.out.println("L3异常信息的实体对象："+l3ModelData);
        if(l3ModelData!=null){
            int l3Result = exceptionService.insertL3ModelData(l3ModelData);
            System.out.println("L3异常信息内容写入结果："+l3Result);
        }
    }

    /**
     * Sqlserver查询培训数据 mysql添加培训数据
     * PS:培训部分没有分L1-L3线
     */
    private void executeLearn() {
        LearnCycle learnCycle=learnServer.getModelData();
        System.out.println("培训情况的实体对象："+learnCycle);
        if(learnCycle!=null){
            int delLearn=learnServer.deleteDataByToDay();
            System.out.println("删除培训情况内容结果："+delLearn);
            int insertData=learnServer.insertModelData(learnCycle);
            System.out.println("培训情况内容写入结果："+insertData);
        }

       List<LearnList>learnCycleList= learnServer.getModelDataList();
       System.out.println("培训列表的实体对象："+learnCycleList);
       if(learnCycleList!=null&&!learnCycleList.isEmpty()){
           int delLearnList=learnServer.deleteDataListByToDay();
           System.out.println("删除培训列表内容结果："+delLearnList);
           int insertDataList=learnServer.batchInsertData(learnCycleList);
           System.out.println("培训列表内容写入结果："+insertDataList);
       }
    }

    /**
     * Sqlserver查询投诉数据 mysql添加投诉数据
     */
    private void executeComplaint() {
        CrComplaint l1ModelData=complaintService.getL1ModelData();
        System.out.println("L1投诉的实体对象："+l1ModelData);
        if(l1ModelData!=null){
            int l1Result = complaintService.insertL1ModelData(l1ModelData);
            System.out.println("L1投诉的内容写入结果："+l1Result);
        }

        CrComplaint l2ModelData = complaintService.getL2ModelData();
        System.out.println("L2投诉的实体对象："+l2ModelData);
        if(l2ModelData!=null){
            int l2Result = complaintService.insertL2ModelData(l2ModelData);
            System.out.println("L2投诉的内容写入结果："+l2Result);
        }

        CrComplaint l3ModelData = complaintService.getL3ModelData();
        System.out.println("L3投诉的实体对象："+l3ModelData);
        if(l3ModelData!=null){
            int l3Result = complaintService.insertL3ModelData(l3ModelData);
            System.out.println("L3投诉的内容写入结果："+l3Result);
        }
    }

    /**
     * Sqlserver查询安全事件数据 mysql添加安全事件数据
     */
    private void executeSecurityIncident() {
        SecurityIncident l1ModelData=securityIncidentService.getL1ModelData();
        System.out.println("L1安全事件的实体对象："+l1ModelData);
        if(l1ModelData!=null){
            int l1Result = securityIncidentService.insertL1ModelData(l1ModelData);
            System.out.println("L1安全事件的内容写入结果："+l1Result);
        }

        SecurityIncident l2ModelData = securityIncidentService.getL2ModelData();
        System.out.println("L2安全事件的实体对象："+l2ModelData);
        if(l2ModelData!=null){
            int l2Result = securityIncidentService.insertL2ModelData(l2ModelData);
            System.out.println("L2安全事件的内容写入结果："+l2Result);
        }

        SecurityIncident l3ModelData = securityIncidentService.getL3ModelData();
        System.out.println("L3安全事件的实体对象："+l3ModelData);
        if(l3ModelData!=null){
            int l3Result = securityIncidentService.insertL3ModelData(l3ModelData);
            System.out.println("L3安全事件的内容写入结果："+l3Result);
        }
    }

    /**
     * Sqlserver查询FTE数据 mysql添加FTE数据
     */
    private void executeFteOrder() {
        List<FteOrderL2> l2FteOrderList = fteService.getL2FteOrderList();
        System.out.println("L2FTE的实体对象："+l2FteOrderList);
        if(l2FteOrderList!=null && !l2FteOrderList.isEmpty()){
            int delL2 = fteService.deleteL2DataByToDay();
            System.out.println("删除L2FTE内容结果："+delL2);
            int l2Result=fteService.insertL2ModelData(l2FteOrderList);
            System.out.println("L2FTE内容写入结果："+l2Result);
        }

        List<FteOrderL3> l3FteOrderList = fteService.getL3FteOrderList();
        System.out.println("L3FTE的实体对象："+l3FteOrderList);
        if(l3FteOrderList!=null && !l3FteOrderList.isEmpty()){
            int delL3 = fteService.deleteL3DataByToDay();
            System.out.println("删除L3FTE内容结果："+delL3);
            int l3Result=fteService.insertL3ModelData(l3FteOrderList);
            System.out.println("L3FTE内容写入结果："+l3Result);
        }

        /**
         * 查询一线FTE
         */
        try {
            List<FteOrderL1> l1FteOrderList = fteService.getL1FteOrderList();
            System.out.println("L1FTE的实体对象：" + l1FteOrderList);
            if (null != l1FteOrderList && l1FteOrderList.size() > 0) {
                //清表
                int deleteFteOrderL1 = fteService.deleteFteOrderL1();
                System.out.println("删除L1FTE内容结果：" + deleteFteOrderL1);
                fteService.insertL1ModelData(l1FteOrderList);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }



}
