package com.colorcc.user.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.colorcc.base.mybatis.mapper.BaseMapper;
import com.colorcc.user.model.User;

public interface UserMapper extends BaseMapper<User> {

	public User findUserByEmail(String email);

	public int deleteUsers(Map<String, Long> map);

	public int countUser();

	/**
	 * Got page user's data
	 * 
	 * @param startRow  page start row
	 * @param fetchRows row counts per page
	 * @return
	 */
	public List<User> getUsers(@Param("startRow") int startRow, @Param("fetchRows") int fetchRows);

}
