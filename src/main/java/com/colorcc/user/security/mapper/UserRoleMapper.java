package com.colorcc.user.security.mapper;

import com.colorcc.base.mybatis.mapper.BaseMapper;
import com.colorcc.user.security.model.UserRole;

public interface UserRoleMapper extends BaseMapper<UserRole> {
	
	public int deleteRolesByUserID(int userId);
	/**
	
	public List<User> getPageUsersWithRole(int roleId, int startRows, int fetchSize);
	*/
}
