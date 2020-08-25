package com.xkcoding.multi.datasource.mybatis.service.impl;

import java.util.Date;

public class XianYu {
    private String name;
    //年龄
    private int age;
    //性别
    private String gender;
    //生日
    private Date birthdayDate;

    public XianYu(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    XianYu(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }
}
