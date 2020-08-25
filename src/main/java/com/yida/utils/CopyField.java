package com.yida.utils;

import com.sun.media.jfxmedia.logging.Logger;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
@Slf4j
public class CopyField {

    /**
     * 求和
     * @param model
     * @param keyPrefix
     * @param keysuffix
     * @return
     */
    public static Double fieldSum(Object model, String keyPrefix, String keysuffix) {
        Double sum = 0.00d;
        Field[] rFields = model.getClass().getDeclaredFields();
        for (Field field : rFields) {
            field.setAccessible(true);
            if (field.getName().startsWith(keyPrefix) && field.getName().endsWith(keysuffix)) {
                try {
                    sum += field.get(model) != null ? ((BigDecimal) field.get(model)).doubleValue() : 0.00d;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                }
            }
        }
        return sum;
    }

    /**
     * 字段的赋值
     * @param model
     * @param result
     * @param key
     * @param keyPrefix
     * @param keysuffix
     */
    public static void setModelField(Object model, Object result, Integer key, String keyPrefix, String keysuffix) {
        Field field=null;
        try {
            field = model.getClass().getDeclaredField(keyPrefix + key + keysuffix);
            field.setAccessible(true);
            field.set(model, result);
            log.info("实体bean:"+model.getClass().getName()+"的属性"+field.getName()+"赋值："+result);
        } catch (IllegalAccessException e) {
            log.error("实体bean:"+model.getClass().getName()+"的属性"+field.getName(),e);
        } catch (NoSuchFieldException e) {
            log.error("实体bean:"+model.getClass().getName(),e);
        }
    }

    /**
     * 上面字段赋值函数的调用方法
     * @param cl
     * @return
     */
    public static Map<String, Field> getBeanPropertyFields(Class cl) {
        Map<String, Field> properties = new HashMap<String, Field>();
        for (; cl != null; cl = cl.getSuperclass()) {
            Field[] fields = cl.getDeclaredFields();
            for (Field field : fields) {
                if (Modifier.isTransient(field.getModifiers())
                        || Modifier.isStatic(field.getModifiers())) {
                    continue;
                }
                properties.put(field.getName(), field);
            }
        }
        return properties;
    }
}
