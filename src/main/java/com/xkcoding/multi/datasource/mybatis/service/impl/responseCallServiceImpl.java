package com.xkcoding.multi.datasource.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xkcoding.multi.datasource.mybatis.mapper.UserMapper;
import com.xkcoding.multi.datasource.mybatis.mapper.responseCallMapper;
import com.xkcoding.multi.datasource.mybatis.model.User;
import com.xkcoding.multi.datasource.mybatis.model.responseCall;
import com.xkcoding.multi.datasource.mybatis.service.responseCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: smf
 * @description: L1累计电话接入 服务
 */
@Service
@DS("master")
public class responseCallServiceImpl extends ServiceImpl<responseCallMapper, responseCall> implements responseCallService {

    @Autowired
    private responseCallMapper responseCallMapper;


    /**
     * 录入 L1累计响应
     *
     * @param responseCallsList
     * @return
     */
    @Override
    public Boolean insertResponseCall(List<responseCall> responseCallsList) {
        return responseCallMapper.insertResponseCall(responseCallsList);
    }

    /**
     * 清call表
     */
    @Override
    public void deleteResponseCall() {
        responseCallMapper.deleteResponseCall();
    }

    /**
     * L1累计电话接入
     *
     * @return
     */
    @DS("slave")
    @Override
    public Integer selectResponseCall() {
        return responseCallMapper.selectResponseCall();
    }

    /**
     * L1累计电话接入-累计响应
     *
     * @return
     */
    @DS("slave")
    @Override
    public Integer selectByResponseCall() {
        return responseCallMapper.selectByResponseCall();
    }

    /**
     * L1累计电话接入-累计解决
     *
     * @return
     */
    @DS("slave")
    @Override
    public Integer selectBySoleResponseCall() {
        return responseCallMapper.selectBySoleResponseCall();
    }


}
