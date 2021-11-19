package com.capp.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capp.config.SpringRootConfig;
import com.capp.dao.ContactDAO;

public class TestContactDAODelete {
	
	@Test
	public void TestUserDAODeleteOperation()
	{
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactDAO contactdao=ctx.getBean(ContactDAO.class);
		
		contactdao.delete(1);
		
		System.out.println("-------Data Deleted----");
		
		
	}

}
