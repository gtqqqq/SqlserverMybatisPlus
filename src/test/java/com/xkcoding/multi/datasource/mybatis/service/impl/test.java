package com.xkcoding.multi.datasource.mybatis.service.impl;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {


       /* XianYu a1 = new XianYu("zs", 18, "男");

        XianYu a2 = new XianYu("ls", 16, "女");

        XianYu a3 = new XianYu("ww", 20, "男");

        XianYu a4 = new XianYu("zl", 22, "女");

        List<XianYu> list = Arrays.asList(a1, a2, a3, a4);

        //根据条件分组
        Map<Integer, List<XianYu>> list1 = list.stream().collect(Collectors.groupingBy(XianYu::getAge));

        //取某个值返回list
        List<String> list2 = list.stream().map(xy -> xy.getName()).collect(Collectors.toList());

        //过滤 性别为男的
        List<XianYu> list3 = list.stream().filter(s -> s.getGender().equals("男")).collect(Collectors.toList());

        //过滤条件 先过滤男的 再只取年龄 把上面2个综合起来
        List<Integer> list4 = list.stream().filter(s -> s.getGender().equals("男")).map(m -> m.getAge()).collect(Collectors.toList());

        //求和
        int sum = list.stream().mapToInt(XianYu::getAge).sum();

        //求平均值
        OptionalDouble average = list.stream().mapToInt(XianYu::getAge).average();

        //最大值
        Integer max = list.stream().map(XianYu::getAge).max(Integer::compareTo).get();

        //最小值
        Integer min = list.stream().map(XianYu::getAge).min(Integer::compareTo).get();

        //单字段排序
        list.sort(Comparator.comparing(XianYu::getName));
        //多字段排序
        list.sort(Comparator.comparing(XianYu::getName).thenComparing(XianYu::getAge));

        //遍历集合 修改名称
        list.forEach((s)->{
            if(s.getName()!=null){
                s.setName("统一名称");
            }
        });*/


    }



}
