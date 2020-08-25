package com.yida.mapper;

import com.yida.entity.L2Incindent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author guantianqi
 * @since 2020-07-06
 */
public interface L2IncindentMapper extends BaseMapper<L2Incindent> {

    @Select("select  " +
            "(SELECT count(1) " +
            "FROM dbo.L2Incindent AS inc  " +
            "WHERE DateDiff(dd,inc.Opened,getdate())=0) " +
            "+ " +
            "(SELECT count(1) " +
            "FROM dbo.L2Request AS req " +
            "WHERE DateDiff(dd,req.Opened,getdate())=0)")
    public Integer  selectL2Totalticket();

    @Select("select  " +
            "(SELECT count(1) " +
            "FROM dbo.L2Incindent AS inc  " +
            "WHERE DateDiff(dd,inc.Opened,getdate())=0 and inc.[Incident state]='in progress') " +
            "+ " +
            "(SELECT count(1) " +
            "FROM dbo.L2Request AS req " +
            "WHERE DateDiff(dd,req.Opened,getdate())=0 and req.State='working in progress')")
    public Integer  selectL2WorkingTickets();

    @Select("select   " +
            "(SELECT count(1)  " +
            "FROM dbo.L2Incindent AS inc   " +
            "WHERE DateDiff(dd,inc.Opened,getdate())=0 and inc.[Incident state] in('assigned','transfer'))  " +
            "+  " +
            "(SELECT count(1)  " +
            "FROM dbo.L2Request AS req  " +
            "WHERE DateDiff(dd,req.Opened,getdate())=0 and req.State='Hold')")
    public Integer  selectL2WaitingTickets();

    @Select("select  " +
            "(SELECT count(1) " +
            "FROM dbo.L2Incindent AS inc  " +
            "WHERE DateDiff(dd,inc.Opened,getdate())=0 and inc.[Incident state] LIKE 'Pending%') " +
            "+ " +
            "(SELECT count(1) " +
            "FROM dbo.L2Request AS req " +
            "WHERE DateDiff(dd,req.Opened,getdate())=0 and req.State='Hold')")
    public Integer  selectL2PendingTickets();

    @Select("select   " +
            "(SELECT count(1)  " +
            "FROM dbo.L2Incindent AS inc   " +
            "WHERE DateDiff(dd,inc.Opened,getdate())=0 and inc.[Incident state] in('Resolved','closed'))  " +
            "+  " +
            "(SELECT count(1)  " +
            "FROM dbo.L2Request AS req  " +
            "WHERE DateDiff(dd,req.Opened,getdate())=0 and req.State='complete')")
    public Integer  selectL2ClosedTickets();

}
