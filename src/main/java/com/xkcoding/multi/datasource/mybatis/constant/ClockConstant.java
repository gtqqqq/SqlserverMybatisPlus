package com.xkcoding.multi.datasource.mybatis.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 小时段的常量
 * @author fnchenxi
 */
public class ClockConstant {
    public final  static Map<Integer,Object> HOUR_MAP=new HashMap<>();

    static {
        HOUR_MAP.put(9,"nine");
        HOUR_MAP.put(10,"ten");
        HOUR_MAP.put(11,"eleven");
        HOUR_MAP.put(12,"twelve");
        HOUR_MAP.put(13,"thirteen");
        HOUR_MAP.put(14,"fourteen");
        HOUR_MAP.put(15,"fifteen");
        HOUR_MAP.put(16,"sixteen");
        HOUR_MAP.put(17,"seventeen");
        HOUR_MAP.put(18,"eighteen");

    }
}
