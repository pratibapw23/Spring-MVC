package com.capp.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capp.config.SpringRootConfig;
import com.capp.dao.ContactDAO;
import com.capp.domain.Contact;

public class TestContactDAOFindByContactId {
	
	@Test
	public void TestUserDAOFetchSingleUserDataByIdOperation()
	{
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactDAO contactdao=ctx.getBean(ContactDAO.class);
		
		Contact u=contactdao.findById(2);
		
		System.out.println("-------Data Fetched----");
		System.out.println(u.getUserid());
		System.out.println(u.getName());
		System.out.println(u.getAddress());
		System.out.println(u.getEmail());
		System.out.println(u.getPhone());
		
	}

}
