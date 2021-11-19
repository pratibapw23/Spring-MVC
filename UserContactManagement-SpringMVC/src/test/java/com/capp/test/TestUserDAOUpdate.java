package com.capp.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capp.config.SpringRootConfig;
import com.capp.dao.UserDAO;
import com.capp.domain.User;

public class TestUserDAOUpdate {
	
	@Test
	public void TestUserDAOUpdateOperation()
	{
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userdao=ctx.getBean(UserDAO.class);
		
		User u=new User();
		u.setUserid(4);
		u.setName("Neha Wabale");
		u.setPhone("3646336337");
		u.setEmail("neha.wabale@gmail.com");
		u.setAddress("Pune");
		u.setRole(1);
		u.setLoginStatus(1);
		userdao.update(u);
		
		System.out.println("-------Data Updated----");
		
		
	}

}
