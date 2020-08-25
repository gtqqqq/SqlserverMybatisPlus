package com.xkcoding.multi.datasource.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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
public interface SlaveUserMapper extends BaseMapper<User> {
	
//	@Select("select id, name from table where id=#{id}")
//	User selectById(@Param("id") Integer id);
	

	  @Delete("delete from usertest ")
	  public  void deleteSlaveUser();
	  
	  @Insert({
          "<script>",
          "insert into usertest( name, age) values ",
          "<foreach collection='userList' item='item' index='index' separator=','>",
          "( #{item.name}, #{item.age})",
          "</foreach>",
          "</script>"
	  })
	  int insertCollectList(@Param(value = "userList") List<User> userList);

}

