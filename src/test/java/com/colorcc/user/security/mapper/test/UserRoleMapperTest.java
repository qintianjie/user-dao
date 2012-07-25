package com.colorcc.user.security.mapper.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.colorcc.user.mapper.test.base.TestAbstract;
import com.colorcc.user.security.mapper.UserRoleMapper;

public class UserRoleMapperTest extends TestAbstract {

	private static final Logger logger = LoggerFactory.getLogger(UserRoleMapperTest.class);

	private UserRoleMapper userRoleMapper;

	@BeforeClass
	public static void classInit() {
		if (logger.isDebugEnabled()) {
			logger.debug("Start userRoleMapper test .........................");
		}
	}

	@Before
	public void methodInit() {
		if (logger.isDebugEnabled()) {
			logger.debug("Do some initialization.........................");
		}

		userRoleMapper = (UserRoleMapper) context.getBean("userRoleMapper");
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
		
		Assert.assertNull(userRoleMapper.selectOne(1));
	}

}
