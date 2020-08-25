package com.xkcoding.multi.datasource.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xkcoding.multi.datasource.mybatis.model.weChatResponseRate;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author: smf
 * @time: 8/10/2020
 * @description:微信响应率 以及snow在线响应率 持久层
 */
public interface weChatResponseRateMapper extends BaseMapper<weChatResponseRate> {

    /**
     * 录入微信响应率以及snow在线响应率
     *
     * @return
     */
    @Insert({
            "<script>",
            "insert into wechat_response_rate(time, Wechat_Resp_Rate_Molecule_Hour,Wechat_Resp_Rate_Molecule_Number,Wechat_Resp_Rate_Denominator_Hour,Wechat_Resp_Rate_Denominator_Number,Snow_Resp_Rate_Molecule_Hour,Snow_Resp_Rate_Molecule_Number,Snow_Resp_Rate_Denominator_Hour,Snow_Resp_Rate_Denominator_Number,EndTime) values ",
            "<foreach collection='weChatResponseRateList' item='item' index='index' separator=','>",
            "( #{item.time}, #{item.WechatRespRateMoleculeHour},#{item.WechatRespRateMoleculeNumber},#{item.WechatRespRateDenominatorHour},#{item.WechatRespRateDenominatorNumber},#{item.SnowRespRateMoleculeHour},#{item.SnowRespRateMoleculeNumber},#{item.SnowRespRateDenominatorHour},#{item.SnowRespRateDenominatorNumber},#{item.EndTime})",
            "</foreach>",
            "</script>"
    })
    public Boolean insertWeChatResponseRate(@Param("weChatResponseRateList") List<weChatResponseRate> weChatResponseRateList);


    /**
     * 清表
     */
    @Delete({
            "<script>",
            "delete from sla_phone_incident",
            "</script>"
    })
    public void deleteWeChatResponseRate();

    /**
     * 查询微信响应率
     *
     * @return
     */
    @Select({
            ""
    })
    public List<Map<String, Object>> selectWeChatResponseRate();

    /**
     * 查询 SNOW在线响应率
     *
     * @return
     */
    @Select({
            ""
    })
    public List<Map<String, Object>> selectSnowRate();

}
