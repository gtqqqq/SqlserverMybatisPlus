package com.xkcoding.multi.datasource.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xkcoding.multi.datasource.mybatis.model.User;

/**
 * <p>
 * 数据访问层
 * </p>
 *
 * @package: com.xkcoding.multi.datasource.mybatis.mapper
 * @description: 数据访问层
 * @copyright: Copyright (c) 2019
 * @version: V1.0
 */
public interface UserMapper extends BaseMapper<User> {
	
//	@Select("select id, name from table where id=#{id}")
//	User selectById(@Param("id") Integer id);
	

	  @Delete("delete  from usertest where id =#{id} ")
	  public  void deleteUser(@Param("id") int id);
	  
	  @Select("select name,age from usertest where age =#{age} ")
	  public List<User> selectUserList(@Param("age") int age);
	  
	  @Select("select name,age from usertest where age =#{age} ")
	  public List<HashMap> selectUserList1(@Param("age") int age);
	  
	/*
	 * @Delete("delete from usertest ") public void deleteSlaveUser();
	 */
	 
	  
}

