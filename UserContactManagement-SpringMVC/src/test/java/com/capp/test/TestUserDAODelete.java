package com.capp.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capp.config.SpringRootConfig;
import com.capp.dao.UserDAO;
import com.capp.domain.User;

public class TestUserDAODelete {
	
	@Test
	public void TestUserDAODeleteOperation()
	{
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userdao=ctx.getBean(UserDAO.class);
		
		userdao.delete(3);
		
		System.out.println("-------Data Deleted----");
		
		
	}

}
