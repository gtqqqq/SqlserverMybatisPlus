package com.xkcoding.multi.datasource.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xkcoding.multi.datasource.mybatis.model.CallCalcTable;
import com.xkcoding.multi.datasource.mybatis.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface callcalcMapper extends BaseMapper<CallCalcTable> {
    /**
     * 录入callcalctable
     * @param calcTableList
     * @return
     */
    @Insert({
            "<script>",
            "insert into callcalctable(time,CallSum,HanderSum,MissSum) values ",
            "<foreach collection='calcTableList' item='item' index='index' separator=','>",
            "(#{item.time}, #{item.CallSum}, #{item.HanDerSum},#{item.MissSum})",
            "</foreach>",
            "</script>"
    })
    public  Boolean insertCallCalc(@Param("calcTableList") List<CallCalcTable> calcTableList);
}
