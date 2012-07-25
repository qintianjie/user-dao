package com.colorcc.user.security.mapper.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.colorcc.user.mapper.test.base.TestAbstract;
import com.colorcc.user.security.mapper.UserVOMapper;

public class UserDetailsMapperTest extends TestAbstract {

	private static final Logger logger = LoggerFactory.getLogger(UserDetailsMapperTest.class);

	private UserVOMapper userDetailsMapper;

	@BeforeClass
	public static void classInit() {
		if (logger.isDebugEnabled()) {
			logger.debug("Start UserDetailsMapper test .........................");
		}
	}

	@Before
	public void methodInit() {
		if (logger.isDebugEnabled()) {
			logger.debug("Do some initialization.........................");
		}

		userDetailsMapper = (UserVOMapper) context.getBean("userDetailsMapper");
	}

	@Test
	public void testCase() {
		if (logger.isInfoEnabled()) {
			logger.info("Test start ...");
		}

		 Assert.assertNull(userDetailsMapper.selectOne(0));
		// Assert.assertNotNull(userDetailsMapper.selectOne(6));
	}

}
