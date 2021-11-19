package com.capp.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capp.config.SpringRootConfig;
import com.capp.dao.UserDAO;
import com.capp.domain.User;

public class TestUserDAOFindByPropertyValue {
	
	@Test
	public void TestUserDAOFetchAllUsersDataByProperyValueOperation()
	{
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userdao=ctx.getBean(UserDAO.class);
		System.out.println("-------Data Fetched----");
		List<User> users=userdao.findByProperty("address","pune");
		for(User u:users)
		{
			System.out.println(u.getUserid());
			System.out.println(u.getName());
			System.out.println(u.getAddress());
		}
		
	
		
		
	}

}
