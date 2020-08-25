package com.xkcoding.multi.datasource.mybatis.mapper;


import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
import java.util.Map;


public interface QualityCheckQueryMapper {
    /**
     * 获取SqlServer L1质量检测数据
     * PS:只需要查询L1的
     * @return
     */
    @Select(" select a.*,\n" +
            "'1' as source_type,-- CN 工单和邮件\n" +
            "'CN' as group_name,\n" +
            "[Month] as end_time\n" +
            "from (\n" +
            "select \n" +
            "[Month],\n" +
            "sum([Call Audit Volume]+[Case Audit Volume]+[Chat Audit Volume])as total,\n" +
            "sum([case audit volume])as check_number,\n" +
            "(sum([case audit volume])-sum([Case Audit qualified]))as fail_number\n" +
            "from [Quality Part] where team='CN' group by [Month]\n" +
            ")a\n" +
            "union \n" +
            "select b.*,\n" +
            "'2' as source_type,-- CN 电话\n" +
            "'CN' as group_name,\n" +
            "[Month] as end_time\n" +
            "from (\n" +
            "select \n" +
            "[Month],\n" +
            "sum([Call Audit Volume]+[Case Audit Volume]+[Chat Audit Volume])as total,\n" +
            "sum([call audit volume])as check_number,\n" +
            "(sum([call audit volume])-sum([call audit qualified]))as fail_number\n" +
            "from [Quality Part] where team='CN' group by [Month]\n" +
            ")b\n" +
            "union \n" +
            "select c.*,\n" +
            "'3' as source_type,-- CN 微信\n" +
            "'CN' as group_name,\n" +
            "[Month] as end_time\n" +
            "from (\n" +
            "select \n" +
            "[Month],\n" +
            "sum([Call Audit Volume]+[Case Audit Volume]+[Chat Audit Volume])as total,\n" +
            "sum([chat audit volume])as check_number,\n" +
            "(sum([chat audit volume])-sum([chat audit qualified]))as fail_number\n" +
            "from [Quality Part] where team='CN' group by [Month]\n" +
            ")c\n" +
            "union \n" +
            "select a.*,\n" +
            "'1' as source_type,-- ESM 工单和邮件\n" +
            "'ESM' as group_name,\n" +
            "[Month] as end_time\n" +
            "from (\n" +
            "select \n" +
            "[Month],\n" +
            "sum([Call Audit Volume]+[Case Audit Volume]+[Chat Audit Volume])as total,\n" +
            "sum([case audit volume])as check_number,\n" +
            "(sum([case audit volume])-sum([case audit qualified]))as fail_number\n" +
            "from [Quality Part] where team='ESM' group by [Month]\n" +
            ")a\n" +
            "union \n" +
            "select b.*,\n" +
            "'2' as source_type,-- ESM 电话\n" +
            "'ESM' as group_name,\n" +
            "[Month] as end_time\n" +
            "from (\n" +
            "select \n" +
            "[Month],\n" +
            "sum([Call Audit Volume]+[Case Audit Volume]+[Chat Audit Volume])as total,\n" +
            "sum([call audit volume])as check_number,\n" +
            "(sum([call audit volume])-sum([call audit qualified]))as fail_number\n" +
            "from [Quality Part] where team='ESM' group by [Month]\n" +
            ")b\n" +
            "union \n" +
            "select c.*,\n" +
            "'3' as source_type,-- ESM 微信\n" +
            "'ESM' as group_name,\n" +
            "[Month] as end_time\n" +
            "from (\n" +
            "select \n" +
            "[Month],\n" +
            "sum([Call Audit Volume]+[Case Audit Volume]+[Chat Audit Volume])as total,\n" +
            "sum([chat audit volume])as check_number,\n" +
            "(sum([chat audit volume])-sum([chat audit qualified]))as fail_number\n" +
            "from [Quality Part] where team='ESM' group by [Month]\n" +
            ")c\n" +
            "union\n" +
            "select a.*,\n" +
            "'1' as source_type,-- AA 工单和邮件\n" +
            "'AA' as group_name,\n" +
            "[Month] as end_time\n" +
            "from (\n" +
            "select \n" +
            "[Month],\n" +
            "sum([Call Audit Volume]+[Case Audit Volume]+[Chat Audit Volume])as total,\n" +
            "sum([case audit volume])as check_number,\n" +
            "(sum([case audit volume])-sum([case audit qualified]))as fail_number\n" +
            "from [Quality Part] where team='AA' group by [Month]\n" +
            ")a\n" +
            "union \n" +
            "select b.*,\n" +
            "'2' as source_type,-- AA 电话\n" +
            "'AA' as group_name,\n" +
            "[Month] as end_time\n" +
            "from (\n" +
            "select \n" +
            "[Month],\n" +
            "sum([Call Audit Volume]+[Case Audit Volume]+[Chat Audit Volume])as total,\n" +
            "sum([call audit volume])as check_number,\n" +
            "(sum([call audit volume])-sum([call audit qualified]))as fail_number\n" +
            "from [Quality Part] where team='AA'  group by [Month]\n" +
            ")b\n" +
            "union \n" +
            "select c.*,\n" +
            "'3' as source_type,-- AA 微信\n" +
            "'AA' as group_name,\n" +
            "[Month] as end_time\n" +
            "from (\n" +
            "select \n" +
            "[Month],\n" +
            "sum([Call Audit Volume]+[Case Audit Volume]+[Chat Audit Volume])as total,\n" +
            "sum([chat audit volume])as check_number,\n" +
            "(sum([chat audit volume])-sum([chat audit qualified]))as fail_number\n" +
            "from [Quality Part] where team='AA' group by [Month]\n" +
            ")c ")
    List<Map<String,Object>> getQualityData();

    /**
     * 获取状态23点59分之前的数据
     * @return
     */
    @Select(" -- 质量检测\n" +
            "select a.*,\n" +
            "'1' as source_type,-- CN 工单和邮件\n" +
            "'AZ China Shanghai Service Desk' as group_name \n" +
            "from (\n" +
            "select \n" +
            "sum([total audit volume])as total,\n" +
            "sum([case audit volume])as check_number,\n" +
            "(sum([total audit volume])-sum([Automatic Defect Volume]))as ok_number\n" +
            "from [Quality Part] where team='CN'\n" +
            "and datediff(day, Month,getdate())=1   \n" +
            ")a\n" +
            "union \n" +
            "select b.*,\n" +
            "'2' as source_type,-- CN 电话\n" +
            "'AZ China Shanghai Service Desk' as group_name \n" +
            "from (\n" +
            "select \n" +
            "sum([total audit volume])as total,\n" +
            "sum([call audit volume])as check_number,\n" +
            "(sum([total audit volume])-sum([Automatic Defect Volume]))as ok_number\n" +
            "from [Quality Part] where team='CN'\n" +
            "and datediff(day, Month,getdate())=1  \n" +
            ")b\n" +
            "union \n" +
            "select c.*,\n" +
            "'3' as source_type,-- CN 微信\n" +
            "'AZ China Shanghai Service Desk' as group_name \n" +
            "from (\n" +
            "select \n" +
            "sum([total audit volume])as total,\n" +
            "sum([chat audit volume])as check_number,\n" +
            "(sum([total audit volume])-sum([Automatic Defect Volume]))as ok_number\n" +
            "from [Quality Part] where team='CN'\n" +
            "and datediff(day, Month,getdate())=1  \n" +
            ")c\n" +
            "\n" +
            "union \n" +
            "\n" +
            "select a.*,\n" +
            "'1' as source_type,-- ESM 工单和邮件\n" +
            "'AZ ESM Level 1 Support' as group_name \n" +
            "from (\n" +
            "select \n" +
            "sum([total audit volume])as total,\n" +
            "sum([case audit volume])as check_number,\n" +
            "(sum([total audit volume])-sum([Automatic Defect Volume]))as ok_number\n" +
            "from [Quality Part] where team='ESM'\n" +
            "and datediff(day, Month,getdate())=1    \n" +
            ")a\n" +
            "union \n" +
            "select b.*,\n" +
            "'2' as source_type,-- ESM 电话\n" +
            "'AZ ESM Level 1 Support' as group_name \n" +
            "from (\n" +
            "select \n" +
            "sum([total audit volume])as total,\n" +
            "sum([call audit volume])as check_number,\n" +
            "(sum([total audit volume])-sum([Automatic Defect Volume]))as ok_number\n" +
            "from [Quality Part] where team='ESM'\n" +
            "and datediff(day, Month,getdate())=1   \n" +
            ")b\n" +
            "union \n" +
            "select c.*,\n" +
            "'3' as source_type,-- ESM 微信\n" +
            "'AZ ESM Level 1 Support' as group_name \n" +
            "from (\n" +
            "select \n" +
            "sum([total audit volume])as total,\n" +
            "sum([chat audit volume])as check_number,\n" +
            "(sum([total audit volume])-sum([Automatic Defect Volume]))as ok_number\n" +
            "from [Quality Part] where team='ESM'\n" +
            "and datediff(day, Month,getdate())=1   \n" +
            ")c\n" +
            "\n" +
            "union\n" +
            "\n" +
            "select a.*,\n" +
            "'1' as source_type,-- AA 工单和邮件\n" +
            "'AZ AsiaPac IT Service Desk' as group_name \n" +
            "from (\n" +
            "select \n" +
            "sum([total audit volume])as total,\n" +
            "sum([case audit volume])as check_number,\n" +
            "(sum([total audit volume])-sum([Automatic Defect Volume]))as ok_number\n" +
            "from [Quality Part] where team='AA'\n" +
            "and datediff(day, Month,getdate())=1   \n" +
            ")a\n" +
            "union \n" +
            "select b.*,\n" +
            "'2' as source_type,-- AA 电话\n" +
            "'AZ AsiaPac IT Service Desk' as group_name \n" +
            "from (\n" +
            "select \n" +
            "sum([total audit volume])as total,\n" +
            "sum([call audit volume])as check_number,\n" +
            "(sum([total audit volume])-sum([Automatic Defect Volume]))as ok_number\n" +
            "from [Quality Part] where team='AA'\n" +
            "and datediff(day, Month,getdate())=1   \n" +
            ")b\n" +
            "union \n" +
            "select c.*,\n" +
            "'3' as source_type,-- AA 微信\n" +
            "'AZ AsiaPac IT Service Desk' as group_name \n" +
            "from (\n" +
            "select \n" +
            "sum([total audit volume])as total,\n" +
            "sum([chat audit volume])as check_number,\n" +
            "(sum([total audit volume])-sum([Automatic Defect Volume]))as ok_number\n" +
            "from [Quality Part] where team='AA'\n" +
            "and datediff(day, Month,getdate())=1   \n" +
            ")c ")
    List<Map<String,Object>> getYestToDayData();

    @Select(" select getdate()  ")
    Date getSysDate();
}