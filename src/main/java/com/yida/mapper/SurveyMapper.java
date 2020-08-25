package com.yida.mapper;

import com.yida.entity.Survey;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author guantianqi
 * @since 2020-07-07
 */
public interface SurveyMapper extends BaseMapper<Survey> {
    @Select("select(CASE WHEN  " +
            "(SELECT count( 1 ) FROM " +
            " dbo.sn_survey AS sn  " +
            "WHERE " +
            "  sn.[I found it easy to raise my request#] IN ('yes','no') AND " +
            " sn.[I got what I ordered#] IN ('yes','no') AND " +
            " sn.[It was delivered ON time#] IN ('yes','no') AND " +
            " sn.[I would recommend this service TO a colleague ] IN ( 'yes', 'no' )  AND " +
            " sn.RITM is not null and " +
            "  DateDiff(dd,sn.[Assessment completed on date],getdate())=0 AND " +
            "  DATEPART(hh,sn.[Assessment completed on date])=#{hour} " +
            " )=0 THEN 0 ELSE " +
            "( SELECT count( 1 )  FROM dbo.sn_survey AS sn  " +
            "WHERE " +
            " sn.[I found it easy TO raise my request#] ='yes' AND " +
            " sn.[I got what I ordered#] ='yes' AND " +
            " sn.[It was delivered ON time#] ='yes' AND " +
            " sn.[I would recommend this service TO a colleague ] ='yes' and " +
            " sn.RITM is not null and " +
            " DateDiff(dd,sn.[Assessment completed on date],getdate())=0 and " +
            "  DATEPART(hh,sn.[Assessment completed on date])=#{hour} " +
            " )/  " +
            "(SELECT count( 1 ) as c1 FROM dbo.sn_survey AS sn  " +
            "WHERE " +
            "  sn.[I found it easy to raise my request#] IN ('yes','no') AND " +
            " sn.[I got what I ordered#] IN ('yes','no') AND " +
            " sn.[It was delivered ON time#] IN ('yes','no') AND " +
            " sn.[I would recommend this service TO a colleague ] IN ( 'yes', 'no' ) and " +
            " sn.RITM is not null and " +
            "   DateDiff(dd,sn.[Assessment completed on date],getdate())=0 and " +
            "   DATEPART(hh,sn.[Assessment completed on date])= #{hour} " +
            " )END )")
    public Integer selectCsatRequest(int hour);

    @Select("SELECT CONVERT(VARCHAR(13),sn.[Assessment completed on date],120) as dates,count( 1 ) as num FROM dbo.sn_survey AS sn  \n" +
            "WHERE " +
            " sn.[I found it easy TO raise my request#] ='yes' AND " +
            " sn.[I got what I ordered#] ='yes' AND " +
            " sn.[It was delivered ON time#] ='yes' AND " +
            " sn.[I would recommend this service TO a colleague ] ='yes' and"+
            " sn.RITM is not null  " +
       "group by  CONVERT(VARCHAR(13),sn.[Assessment completed on date],120)\n")
    public List<Map<String ,String>> selectCsatRequestNumMap();
    @Select("SELECT CONVERT(VARCHAR(13),sn.[Assessment completed on date],120) as dates,count( 1 ) as num FROM dbo.sn_survey AS sn  \n" +
            "WHERE \n" +
            "  sn.[I found it easy to raise my request#] IN ('yes','no') AND " +
            " sn.[I got what I ordered#] IN ('yes','no') AND " +
            " sn.[It was delivered ON time#] IN ('yes','no') AND " +
            " sn.[I would recommend this service TO a colleague ] IN ( 'yes', 'no' ) and " +
            " sn.RITM is not null  " +
            "group by  CONVERT(VARCHAR(13),sn.[Assessment completed on date],120)\n")
    public List<Map<String ,String>> selectCsatRequestTotalNumMap();
    @Select("SELECT(CASE WHEN " +
            "  ( SELECT count( 1 ) FROM dbo.Survey AS su WHERE su.agent_score != 0 AND DateDiff(dd,su.callin_time,getdate())=0 and DATEPART(hh,su.callin_time)=#{hour} ) = 0 THEN 0 ELSE  " +
            " ( SELECT count( 1 ) FROM dbo.Survey AS su WHERE su.agent_score IN ( 1, 2 ) AND DateDiff(dd,su.callin_time,getdate())=0 and DATEPART(hh,su.callin_time)=#{hour} ) / " +
            " ( SELECT count( 1 ) FROM dbo.Survey AS su WHERE su.agent_score != 0 AND DateDiff(dd,su.callin_time,getdate())=0 and DATEPART(hh,su.callin_time)=#{hour} ) END )")
    public Integer selectCsatPhone(int hour);

    @Select("SELECT CONVERT(VARCHAR(13),su.callin_time,120) as dates,count( 1 ) as num FROM dbo.Survey AS su  \n" +
            "WHERE " +
            "su.agent_score IN ( 1, 2 ) "+
            " group by  CONVERT(VARCHAR(13),su.callin_time,120)")
    public List<Map<String ,String>> selectCsatPhoneNumMap();
    @Select("SELECT CONVERT(VARCHAR(13),su.callin_time,120) as dates,count( 1 ) as num FROM dbo.Survey AS su  \n" +
            "WHERE " +
            "su.agent_score != 0" +
            " group by  CONVERT(VARCHAR(13),su.callin_time,120)")
    public List<Map<String ,String>> selectCsatPhoneTotalNumMap();
    
    @Select("select(CASE WHEN ( " +
            "SELECT count( 1 ) as c1 FROM dbo.sn_survey AS sn  WHERE " +
            "  sn.[I did not need to chase to get it fixed]IN ('yes','no') and " +
            "  sn.[I am happy with the quality of the fix]IN  ('yes','no')  and " +
            "  sn.[The person was friendly and knew how to fix my problem] IN ('yes','no') AND " +
            " sn.[I would recommend this service TO a colleague ] IN ( 'yes', 'no' ) AND " +
            " sn.Incident is not NULL and " +
            " DateDiff(dd,sn.[Assessment completed on date],getdate())=0 " +
            "  and DATEPART(hh,sn.[Assessment completed on date])=#{hour} " +
            " )=0 THEN 0 ELSE " +
            "(SELECT count( 1 )  FROM dbo.sn_survey AS sn  " +
            "  WHERE " +
            " sn.[I did not need to chase to get it fixed]='yes' and " +
            "  sn.[I am happy with the quality of the fix]='yes'  and " +
            "  sn.[The person was friendly and knew how to fix my problem]='yes' AND " +
            " sn.[I would recommend this service TO a colleague ] ='yes' AND " +
            "  sn.Incident is not NULL and " +
            "   DateDiff(dd,sn.[Assessment completed on date],getdate())=0 and " +
            "    DATEPART(hh,sn.[Assessment completed on date])= #{hour}" +
            " ) / ( " +
            "SELECT count( 1 ) as c1 FROM dbo.sn_survey AS sn  " +
            "WHERE " +
            " sn.[I did not need to chase to get it fixed]IN ('yes','no') and " +
            "  sn.[I am happy with the quality of the fix]IN ('yes','no')  and " +
            "  sn.[The person was friendly and knew how to fix my problem] IN ('yes','no') AND " +
            " sn.[I would recommend this service TO a colleague ] IN ( 'yes', 'no' )  AND " +
            " sn.Incident is not NULL and " +
            "  DateDiff(dd,sn.[Assessment completed on date],getdate())=0 " +
            "  and DATEPART(hh,sn.[Assessment completed on date])= #{hour} " +
            " )END )")
    public Integer selectCsatIncident(int hour);

    @Select("SELECT CONVERT(VARCHAR(13),sn.[Assessment completed on date],120) as dates,count( 1 ) as num FROM dbo.sn_survey AS sn  \n" +
            "  WHERE " +
            " sn.[I did not need to chase to get it fixed]='yes' and " +
            "  sn.[I am happy with the quality of the fix]='yes'  and " +
            "  sn.[The person was friendly and knew how to fix my problem]='yes' AND " +
            " sn.[I would recommend this service TO a colleague ] ='yes' AND " +
            "  sn.Incident is not NULL " +
            "group by  CONVERT(VARCHAR(13),sn.[Assessment completed on date],120)\n")
    public List<Map<String ,String>> selectCsatIncidentNumMap();
    @Select("SELECT CONVERT(VARCHAR(13),sn.[Assessment completed on date],120) as dates,count( 1 ) as num FROM dbo.sn_survey AS sn  \n" +
        "WHERE " +
        " sn.[I did not need to chase to get it fixed]IN ('yes','no') and " +
        "  sn.[I am happy with the quality of the fix]IN ('yes','no')  and " +
        "  sn.[The person was friendly and knew how to fix my problem] IN ('yes','no') AND " +
        " sn.[I would recommend this service TO a colleague ] IN ( 'yes', 'no' )  AND " +
        " sn.Incident is not NULL " +
        "group by  CONVERT(VARCHAR(13),sn.[Assessment completed on date],120)\n")
    public List<Map<String ,String>> selectCsatIncidentTotalNumMap();

    @Select("SELECT DISTINCT CONVERT(VARCHAR(10),sn.[Assessment completed on date],120) " +
            "FROM dbo.sn_survey AS sn ")
    public List<String > selectCsatDateList();
}
