package com.xkcoding.multi.datasource.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xkcoding.multi.datasource.mybatis.mapper.SlaveUserMapper;
import com.xkcoding.multi.datasource.mybatis.mapper.UserMapper;
import com.xkcoding.multi.datasource.mybatis.model.User;
import com.xkcoding.multi.datasource.mybatis.service.UserService;

import cn.hutool.json.JSONUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据服务层 实现
 * </p>
 *
 * @package: com.xkcoding.multi.datasource.mybatis.service.impl
 * @description: 数据服务层 实现
 * @author: yangkai.shen
 * @date: Created in 2019-01-21 14:37
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Service
@DS("slave")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

	   @Autowired
	    private UserService userService;
	   
	   @Autowired
	   private SlaveUserMapper slaveUserMapper;
	   
    /**
     * 类上 {@code @DS("slave")} 代表默认从库，在方法上写 {@code @DS("master")} 代表默认主库
     *
     * @param user 用户
     */
    @DS("master")
    @Override
    public void addUser(User user) {
        baseMapper.insert(user);
    }
    
    @DS("master")
    @Override
    public List<User> selectUserList(int age) {
    	List<User> list = baseMapper.selectUserList(age);
		return list;
    }
    
    @DS("master")
    @Override
    public List<HashMap> selectUserList1(int age) {
    	List<HashMap> list = baseMapper.selectUserList1(age);
		return list;
    }
    
    @DS("master")
    @Override
    public  void deleteUser(int id) {
    	baseMapper.deleteUser(4);
	}
    
    @Override
    public  void deleteSlaveUser() {
    	slaveUserMapper.deleteSlaveUser();
	}
    
    @Override
    public  void saveSlaveUser(List<User> userList) {
    	//userService.saveBatch(userList);
    	slaveUserMapper.insertCollectList(userList);
	}
    
    
    @Scheduled(cron="${corn.time}")
    public void testScheduled() {
//     User userMaster = new User("主库添加",20); 
//     userService.addUser(userMaster);
    	//List<User> list = selectList(9);
    	//deleteUser(4);
    	//userService.deleteSlaveUser();
    	//List<HashMap> hashMap=selectUserList1(20);
    	List<User> list = selectUserList(20);
    	
    	//userService.saveSlaveUser(list);
    	System.out.println(new Date()+"-定时任务开始"+list.size());
    	//System.out.println(new Date()+"-定时任务开始"+hashMap.size());
    }
}
