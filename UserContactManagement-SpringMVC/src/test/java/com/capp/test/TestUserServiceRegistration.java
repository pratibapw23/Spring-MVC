package com.capp.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capp.config.SpringRootConfig;
import com.capp.dao.UserDAO;
import com.capp.domain.User;
import com.capp.service.UserService;

public class TestUserServiceRegistration {
	
	@Test
	public void TestUserServiceRegisterOperation()
	{
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserService userservice=ctx.getBean(UserService.class);
		User u=new User();
		u.setName("Vidya");
		u.setPhone("36336337");
		u.setEmail("vidya@gmail.com");
		u.setAddress("Mumbai");
		u.setLoginName("Vidya");
		u.setPassword("Vidya1234");
		u.setRole(userservice.Admin_Role);
		u.setLoginStatus(userservice.loginStatusActive);
		userservice.register(u);
		
		System.out.println("-------User Registered Successfully----");
		
		
	}

}
