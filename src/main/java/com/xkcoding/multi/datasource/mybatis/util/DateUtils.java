package com.xkcoding.multi.datasource.mybatis.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

    /**
     * 获取当前时间小时取整
     * @return
     */
    public static Date getCurrHourTime() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:00:00 ");
        String time = formatter.format(date);
        Date parse=null;
        try{
            parse = formatter.parse(time);
        }catch (Exception e){
            e.printStackTrace();
        }
        return parse;
    }

    /**
     * 获取昨天时间 格式改为23点59分59秒
     * @return
     */
    public static Date getYestToDayCurrHourTime() {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(calendar.DATE,-1);
        Date date = new Date(calendar.getTime().getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 23:59:59 ");
        String time = formatter.format(date);
        try{
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = format.parse(time);
            return date;
        }catch (Exception e){
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取指定时间往后加一小时取整
     * @return
     */
    public static Date getAddHourTime(String date){
        Date addHour=null;
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH");
        try {
            Date formatDate = format.parse(date);
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(formatDate);
            calendar.add(calendar.HOUR,1);
            addHour = new Date(calendar.getTime().getTime());
        }catch (Exception e){
            e.printStackTrace();
        }
        return addHour;
    }

    public static void main(String[] args) {
        Date addHourTime = getAddHourTime("2019-12-30 0");
        System.out.println("格式化的时间:"+addHourTime);
    }

}
