package com.xkcoding.multi.datasource.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xkcoding.multi.datasource.mybatis.mapper.UserMapper;
import com.xkcoding.multi.datasource.mybatis.mapper.callcalcMapper;
import com.xkcoding.multi.datasource.mybatis.model.CallCalcTable;
import com.xkcoding.multi.datasource.mybatis.model.User;
import com.xkcoding.multi.datasource.mybatis.service.CallCalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@DS("callcalctable")
public class CallCalcServiceImpl extends ServiceImpl<callcalcMapper, CallCalcTable> implements CallCalcService {

    @Autowired
    private callcalcMapper callcalcMapper;

    @Override
    public Boolean insertCallCalc(List<CallCalcTable> calcTableList) {
        List<CallCalcTable> CallCalcTabledata = new ArrayList<CallCalcTable>();
        CallCalcTable calcTable = new CallCalcTable();
        for (int i = 0; i < 10; i++) {
            calcTable.setCallSum(1.1);
            calcTable.setHanDerSum(0.0);
            calcTable.setMissSum(1.1);
        }
        CallCalcTabledata.add(calcTable);
        CallCalcTabledata.add(calcTable);
        CallCalcTabledata.add(calcTable);
        CallCalcTabledata.add(calcTable);
        CallCalcTabledata.add(calcTable);
        CallCalcTabledata.add(calcTable);
        CallCalcTabledata.add(calcTable);
        CallCalcTabledata.add(calcTable);
        CallCalcTabledata.add(calcTable);
        CallCalcTabledata.add(calcTable);
        return callcalcMapper.insertCallCalc(CallCalcTabledata);
    }
}
