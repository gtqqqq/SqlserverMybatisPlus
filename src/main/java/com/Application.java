package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

/**
 * <p>
 * 启动器
 * </p>
 *
 * @package: com.xkcoding.multi.datasource.mybatis
 * @description: 启动器
 * @author: yangkai.shen
 * @date: Created in 2019-01-21 14:19
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: yangkai.shen
 */
//开启定时任务
@EnableScheduling
//开启异步调用
//@EnableAsync
//开启事务支持
@EnableTransactionManagement
@SpringBootApplication
@MapperScan({"com.xkcoding.multi.datasource.mybatis.mapper","com.yida.mapper"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

