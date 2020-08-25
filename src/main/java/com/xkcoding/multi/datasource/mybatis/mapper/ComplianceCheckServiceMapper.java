package com.xkcoding.multi.datasource.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xkcoding.multi.datasource.mybatis.model.ComplianceCheck;
import com.xkcoding.multi.datasource.mybatis.model.businessVolume;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * @author: smf
 * @time: 7/12/2020 8:05 AM
 * @description: 服务水平管理参数展示-持久层
 */
public interface ComplianceCheckServiceMapper extends BaseMapper<ComplianceCheck> {

    /***
     * 录入 service_level_compliance_check
     */
    @Insert({
            "<script>",
            "insert into service_level_compliance_check(time, CompleteRecord,Phone,WorkOrder,WeChat,Email,CompleteUnqualified,DefectRate,SamplingRate,ChGroup,EsmGroup,AAGroup) values ",
            "<foreach collection='complianceCheckList' item='item' index='index' separator=','>",
            "( #{item.time}, #{item.CompleteRecord},#{item.Phone},#{item.WorkOrder},#{item.WeChat},#{item.Email},#{item.CompleteUnqualified},#{item.DefectRate},#{item.SamplingRate},#{item.ChGroup},#{item.EsmGroup},#{item.AAGroup})",
            "</foreach>",
            "</script>"
    })
    public Boolean insertComplianceCheckList(@Param("complianceCheckList") List<ComplianceCheck> complianceCheckList);


    /***
     * service_level_compliance_check
     */
    @Delete({
            "<script>",
            "delete from service_level_compliance_check",
            "</script>"
    })
    public void deleteComplianceCheck();
    //TODO  以下需求没确定 下周一 确认

    /**
     * 查询合规抽检-电话
     *
     * @return
     */
    @Select({
            "\n" +
                    "select  \n" +
                    "\n" +
                    "COUNT(*) as num \n" +
                    "\n" +
                    "from Call_Test"
    })
    public Integer selectComplianceCheckByPhone();


    /**
     * 查询合规抽检-工单
     *
     * @return
     */
    @Select({
            "select count(*) as num from Incident_Test"
    })
    public Integer selectComplianceCheckWorkOrder();

    /**
     * 查询合规抽检-微信
     *
     * @return
     */
    @Select({
            "select count(*) as num from Incident_Test"
    })
    public Integer selectComplianceCheckWeChat();


    /**
     * 查询合规抽检-邮件
     *
     * @return
     */
    @Select({
            "select count(*) as num from Incident_Test"
    })
    public Integer selectComplianceEmail();


    /**
     * 查询合规抽检-抽检不合格
     *
     * @return
     */
    @Select({
            "select count(*) as num from Incident_Test"
    })
    public Integer selectComplianceUnqualified();


    /**
     * 查询合规抽检-Defect rate
     *
     * @return
     */
    @Select({
            "select count(*) as num from Incident_Test"
    })
    public String selectComplianceDefectRate();

    /**
     * 查询合规抽检-抽检率
     *
     * @return
     */
    @Select({
            "select count(*) as num from Incident_Test"
    })
    public String selectComplianceSamplingRate();


}
