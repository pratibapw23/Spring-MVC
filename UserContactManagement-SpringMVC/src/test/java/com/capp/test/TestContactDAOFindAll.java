package com.capp.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capp.config.SpringRootConfig;
import com.capp.dao.ContactDAO;
import com.capp.domain.Contact;
import com.capp.domain.User;

public class TestContactDAOFindAll {
	
	@Test
	public void TestContactDAOFetchAllUsersDataOperation()
	{
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactDAO contactdao=ctx.getBean(ContactDAO.class);
		System.out.println("-------Data Fetched----");
		List<Contact> contacts=contactdao.findAll();
		for(Contact u:contacts)
		{
			System.out.println(u.getUserid());
			System.out.println(u.getName());
			System.out.println(u.getAddress());
		}
		
	
		
		
	}

}
