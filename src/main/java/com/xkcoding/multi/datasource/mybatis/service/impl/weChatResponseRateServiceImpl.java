package com.xkcoding.multi.datasource.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xkcoding.multi.datasource.mybatis.mapper.weChatResponseRateMapper;
import com.xkcoding.multi.datasource.mybatis.model.weChatResponseRate;
import com.xkcoding.multi.datasource.mybatis.service.weChatResponseRateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author: smf
 * @description:微信响应率 以及snow在线响应率 服务层
 */
@Service
@Slf4j
@DS("master")
public class weChatResponseRateServiceImpl extends ServiceImpl<weChatResponseRateMapper, weChatResponseRate> implements weChatResponseRateService {

    @Autowired
    private weChatResponseRateMapper weChatResponseRateMapper;

    /**
     * 录入微信响应率以及snow在线响应率
     *
     * @return
     */
    @Override
    public Boolean insertWeChatResponseRate(List<weChatResponseRate> weChatResponseRateList) {
        return weChatResponseRateMapper.insertWeChatResponseRate(weChatResponseRateList);
    }

    /**
     * 清表
     */
    @Override
    public void deleteWeChatResponseRate() {
        weChatResponseRateMapper.deleteWeChatResponseRate();
    }

    /**
     * 查询 微信响应率
     *
     * @return
     */
//    @DS("slave")
    @Override
    public List<weChatResponseRate> selectWeChatResponseRate() {
        try {
            List<Map<String, Object>> weChatResponseRate = weChatResponseRateMapper.selectWeChatResponseRate();
            /*if (null !=weChatResponseRate && weChatResponseRate.size()>0){
                for (Map<String, Object> da:weChatResponseRate) {
                    weChatResponseRate we =   new weChatResponseRate();
                    we.setWechatRespRateMoleculeHour(da.get("Wechat_Resp_Rate_Molecule_Hour")==null?null:(String) da.get("Wechat_Resp_Rate_Molecule_Hour"));
                }
            }
*/

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 查询 SNOW在线响应率
     *
     * @return
     */
    @DS("slave")
    @Override
    public List<weChatResponseRate> selectSnowRate() {
        List<Map<String, Object>> snowRate = weChatResponseRateMapper.selectSnowRate();
        return null;
    }
}
