package com.xkcoding.multi.datasource.mybatis.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

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
        Map<String, Field> sfield = getBeanPropertyFields(model.getClass());
        Field field = sfield.get(keyPrefix + key + keysuffix);
        try {
            if (field != null)
                field.set(model, result);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
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

                field.setAccessible(true);

                properties.put(field.getName(), field);
            }
        }

        return properties;
    }
}
