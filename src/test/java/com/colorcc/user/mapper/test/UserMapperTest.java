package com.colorcc.user.mapper.test;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.colorcc.user.mapper.UserMapper;
import com.colorcc.user.mapper.test.base.TestAbstract;
import com.colorcc.user.model.User;

public class UserMapperTest extends TestAbstract {

	private static final Logger logger = LoggerFactory.getLogger(UserMapperTest.class);

	private String emailName;

	private UserMapper userMapper;

	@BeforeClass
	public static void classInit() {
		if (logger.isDebugEnabled()) {
			logger.debug("Start UserMapperTest test .........................");
		}
	}

	@Before
	public void methodInit() {
		if (logger.isDebugEnabled()) {
			logger.debug("Do some initialization.........................");
		}

		emailName = "jackqin@colorcc.com";
		userMapper = (UserMapper) context.getBean("userMapper");
	}

	@Test
	public void testCase() {
		if (logger.isInfoEnabled()) {
			logger.info("Test start ...");
		}

		// find User by email
		User regUser = userMapper.findUserByEmail(emailName);
		if (regUser != null) {
			emailName = "new" + emailName;
		}

		Assert.assertEquals(0, userMapper.countUser());

		// insert a new user
		User user = new User();
		user.setEmail(emailName);
		user.setPasswd("111");
		user.setSalt("111");
		user.setRegisterTime(new Date());
		user.setStatus((byte) 2);
		userMapper.insertOne(user);

		List<User> users = userMapper.getUsers(0, 5);
		Assert.assertNotNull(users);
		if (logger.isDebugEnabled()) {
			logger.debug("user list size: " + users.size());
		}
		Assert.assertTrue(users.size() > 0);

		// select a user by email
		User newUser = userMapper.findUserByEmail(emailName);
		Assert.assertNotNull(newUser);
		Assert.assertEquals(1, userMapper.countUser());

		// update the selected user's email and status
		int userId = newUser.getId();
		newUser.setEmail(userId + emailName);
		newUser.setStatus((byte) 1);
		userMapper.updateOne(newUser);

		String newEmail = userMapper.selectOne(userId).getEmail();
		// select the user by id
		Assert.assertEquals(newEmail, newUser.getEmail());

		// delete the user by id
		userMapper.deleteOne(userId);
		Assert.assertNull(userMapper.selectOne(userId));

		if (logger.isInfoEnabled()) {
			logger.info("Test end!");
		}
	}

	@Test
	@Ignore("Function will implement in feature.")
	public void testIngore() {
		Assert.assertTrue(1 == 2);
	}

}
