package com.xkcoding.multi.datasource.mybatis.service.impl;

import com.xkcoding.multi.datasource.mybatis.model.DailyComplianceStatistics;


import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class testField {
    public static void main(String[] args) {
        DailyComplianceStatistics model = new DailyComplianceStatistics();
        setModelField(model, new BigDecimal(1.00d), 1, "hour","Ok");
        setModelField(model, new BigDecimal(2.00d), 2, "hour","Ok");
        setModelField(model, new BigDecimal(3.00d), 3, "hour","Ok");
        setModelField(model, new BigDecimal(4.00d), 4, "hour","Ok");
        setModelField(model, new BigDecimal(5.00d), 5, "hour","Ok");

        setModelField(model, new BigDecimal(1.00d), 1, "hour","All");
        setModelField(model, new BigDecimal(2.00d), 2, "hour","All");
        setModelField(model, new BigDecimal(3.00d), 3, "hour","All");
        setModelField(model, new BigDecimal(4.00d), 4, "hour","All");
        setModelField(model, new BigDecimal(6.00d), 5, "hour","All");


        //System.out.println(model.getHour7Ok().doubleValue());
        System.out.println(  fieldSum(model, "hour", "All"));

    }
    private static Double fieldSum(Object model, String keyPrefix, String keysuffix) {
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

    private static void setModelField(Object model, Object result, Integer key, String keyPrefix, String keysuffix) {
        Map<String, Field> sfield = getBeanPropertyFields(model.getClass());
        Field field = sfield.get(keyPrefix + key + keysuffix);
        try {
            if (field != null)
                field.set(model, result);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

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
