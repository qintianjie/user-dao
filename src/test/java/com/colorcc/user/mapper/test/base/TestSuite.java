package com.colorcc.user.mapper.test.base;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.colorcc.user.mapper.test.UserMapperTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({UserMapperTest.class})
public class TestSuite {

	private static final Logger logger = LoggerFactory.getLogger(TestSuite.class);

	private static DbTestInitialization dti;

	@BeforeClass
	public static void init() {
		if (logger.isInfoEnabled()) {
			logger.info("Suit init.");
		}
		dti = new MySQLDbTestInitialization();
		if (dti.canInit()) {
			dti.dropOrCreateDatabae(DbTestInitialization.DbAction.DROP.getActionValue());
			dti.dropOrCreateDatabae(DbTestInitialization.DbAction.CREATE.getActionValue());
			dti.initDatabase();
		} else {
			if(logger.isErrorEnabled()) {
				logger.error("Error db configuration for test cases.");
			}
		}
	}

	@AfterClass
	public static void tearDown() {
		if (logger.isInfoEnabled()) {
			logger.info("Suit destory.");
		}
//		dti.dropOrCreateDatabae(DbTestInitialization.DbAction.DROP.getActionValue());
	}

}
