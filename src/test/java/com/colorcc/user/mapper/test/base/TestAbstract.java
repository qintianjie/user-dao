package com.colorcc.user.mapper.test.base;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/WEB-INF/config/applicationContext.xml")
public abstract class TestAbstract {
	
	protected ApplicationContext context;

	public ApplicationContext getContext() {
		return context;
	}

	@Autowired
	public void setContext(ApplicationContext context) {
		this.context = context;
	}
}
