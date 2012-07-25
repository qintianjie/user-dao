package com.colorcc.user.security.mapper.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.colorcc.user.mapper.test.base.TestAbstract;
import com.colorcc.user.security.mapper.RoleMapper;
import com.colorcc.user.security.model.Role;

public class RoleMapperTest extends TestAbstract {

	private static final Logger logger = LoggerFactory.getLogger(RoleMapperTest.class);

	private RoleMapper roleMapper;

	@BeforeClass
	public static void classInit() {
		if (logger.isDebugEnabled()) {
			logger.debug("Start roleMapper test .........................");
		}
	}

	@Before
	public void methodInit() {
		if (logger.isDebugEnabled()) {
			logger.debug("Do some initialization.........................");
		}

		roleMapper = (RoleMapper) context.getBean("roleMapper");
	}

	@Test
	public void testCase() {
		if (logger.isInfoEnabled()) {
			logger.info("Test start ...");
		}
		
//		Role user0Role = roleMapper.selectOne(0);
//		Assert.assertNull(user0Role);
//		
//		Role newRole = new Role();
//		newRole.setRole("USER");
//		newRole.setDescription("Role level : USER");
//		roleMapper.insertOne(newRole);
		
		Role user0Role = roleMapper.selectOne(1);
		Assert.assertNotNull(user0Role);
		
		Assert.assertNotNull(roleMapper.getRoleByName("ADMIN"));
		
		Assert.assertNull(roleMapper.getRoleByName("NONE_ROLE_NAME"));
	}

	@Test
	@Ignore("Function will implement in feature.")
	public void testIngore() {
		Assert.assertTrue(1 == 2);
	}

}
