package com.xkcoding.multi.datasource.mybatis.service.impl;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xkcoding.multi.datasource.mybatis.SpringBootDemoMultiDatasourceMybatisApplicationTests;
import com.xkcoding.multi.datasource.mybatis.model.User;
import com.xkcoding.multi.datasource.mybatis.service.UserService;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

/**
 * <p>
 * 测试主从数据源
 * </p>
 *
 * @package: com.xkcoding.multi.datasource.mybatis.service.impl
 * @description: 测试主从数据源
 * @author: yangkai.shen
 * @date: Created in 2019-01-21 14:45
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Slf4j
public class UserServiceImplTest extends SpringBootDemoMultiDatasourceMybatisApplicationTests {
    @Autowired
    private UserService userService;



    /**
     * 主从库添加
     */
    @Test
    public void addUser() {
		
		
		  User userMaster = new User("主库添加",20); userService.addUser(userMaster);
//		  
		  User userSlave = new User("主库从q",20); userService.save(userSlave);
		 
		 
    }


	/**
     	* 从库查询
     */
    @Test
    public void testListUser() {
       List<User> list = userService.list(new QueryWrapper<>());
//        log.info("【list】= {}", JSONUtil.toJsonStr(list));
    }
    
   // @Scheduled(cron="0 0/1 * * * ?")
    @Scheduled(cron="${corn.time}")
    public void testScheduled() {
       // log.info("【list】= {}aaaaaaaaaaaaaaaa");
    	System.out.println("定时任务开始");
    }
}