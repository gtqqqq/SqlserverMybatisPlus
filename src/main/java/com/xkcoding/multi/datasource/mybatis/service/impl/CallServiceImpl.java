package com.xkcoding.multi.datasource.mybatis.service.impl;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xkcoding.multi.datasource.mybatis.mapper.CallMapper;
import com.xkcoding.multi.datasource.mybatis.model.Call;
import com.xkcoding.multi.datasource.mybatis.service.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
/**
 *
 * @author: smf
 * @description:
 * call服务
 *
 */
@Service
@DS("slave")
public class CallServiceImpl extends ServiceImpl<CallMapper, Call> implements CallService {

    @Autowired
    private CallMapper callMapper;

    /**
     * 查询 L1累计电话接入累计响应
     */
    @DS("slave")
    @Override
    public List<HashMap> selectCallByCode(String code) {
        List<HashMap> hashMaps = baseMapper.selectCallByCode(code);
        return hashMaps;
    }

    /***
     * 查询L1累计电话接入
     */
    @DS("slave")
    @Override
    public List<Object> selectPhoneAll() {
        return baseMapper.selectPhoneAll();
    }

    /***
     * 查询L1累计解决
     */
    @DS("slave")
    @Override
    public List<Object> selectCallSolveByCode(String code) {
        return baseMapper.selectCallSolveByCode(code);
    }

    /***
     *查询 L1累计工单派出
     */
    @DS("slave")
    @Override
    public List<Object> selectWorkOrder() {
        return baseMapper.selectWorkOrder();
    }

    /**
     * 查询 L1累计工单响应
     *
     * @return
     */
    @DS("slave")
    @Override
    public List<Object> selectWorkOrderResp() {
        return baseMapper.selectWorkOrderResp();
    }

    /**
     * 查询 L1累计工单累计解决
     *
     * @return
     */
    @DS("slave")
    @Override
    public List<Object> selectWorkOrderSolveSum() {
        return baseMapper.selectWorkOrderSolveSum();
    }


}
