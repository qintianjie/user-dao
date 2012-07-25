package com.colorcc.user.security.mapper;

import java.util.List;

import com.colorcc.base.mybatis.mapper.BaseMapper;
import com.colorcc.user.security.model.Role;

public interface RoleMapper extends BaseMapper<Role> {

	public List<Role> getRolesForUser(int userId);
	
	public Role getRoleByName(String roleName);

}
