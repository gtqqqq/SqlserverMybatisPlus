package com.yida.service;

import com.yida.entity.L3Incindent;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gtq
 * @since 2020-07-11
 */
public interface IL3IncindentService extends IService<L3Incindent> {

    public List<Map<String,Object>> selectTeamProductList();

    public Map<String, Integer> selectTeamProductTotalList();

}
