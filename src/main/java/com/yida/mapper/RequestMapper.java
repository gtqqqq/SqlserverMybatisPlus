package com.yida.mapper;

import com.yida.entity.Request;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author guantianqi
 * @since 2020-07-02
 */
public interface RequestMapper extends BaseMapper<Request> {
    /**
     * L1创建req数
     * @return
     */
    @Select("SELECT count(1) FROM dbo.Request AS req "+
            "WHERE  req.[Business Service] IS NOT NULL AND req.[Assignment Group] IN (SELECT L1_AssignmentGroup FROM  L1_AssignmentGroup)")
    public  Integer selectL1Request();

    /**
     * l2解决req数
     * @param state
     * @return
     */
    @Select("SELECT count(1) FROM dbo.L2Request AS req "+
            "WHERE req.State =#{state} " +
            "AND DateDiff(dd,req.Closed,getdate())=0")
    public  Integer selectL2Request(@Param("state")String state);

    /**
     * L3解决req数
     * @param state
     * @return
     */
    @Select("SELECT count(1) FROM dbo.L3Request  AS req "+
            "WHERE req.State =#{state}  " +
            "DateDiff(dd,req.Closed,getdate())=0  ")
    public Integer selectL3Request(@Param("state")String state);
}
