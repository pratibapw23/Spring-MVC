package com.capp.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capp.config.SpringRootConfig;
import com.capp.dao.UserDAO;
import com.capp.domain.User;

public class TestUserDAOFindByUserId {
	
	@Test
	public void TestUserDAOFetchSingleUserDataByIdOperation()
	{
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userdao=ctx.getBean(UserDAO.class);
		
		User u=userdao.findById(1);
		
		System.out.println("-------Data Fetched----");
		System.out.println(u.getUserid());
		System.out.println(u.getName());
		System.out.println(u.getAddress());
		System.out.println(u.getEmail());
		System.out.println(u.getPhone());
		System.out.println(u.getLoginName());
		System.out.println(u.getLoginStatus());
		System.out.println(u.getRole());
		
	}

}
