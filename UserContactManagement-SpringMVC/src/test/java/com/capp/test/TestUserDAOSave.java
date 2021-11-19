package com.capp.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capp.config.SpringRootConfig;
import com.capp.dao.UserDAO;
import com.capp.domain.User;

public class TestUserDAOSave {
	
	@Test
	public void TestUserDAOSaveOperation()
	{
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		UserDAO userdao=ctx.getBean(UserDAO.class);
		
		User u=new User();
		u.setName("Neha");
		u.setPhone("3646336337");
		u.setEmail("neha@gmail.com");
		u.setAddress("Indapur");
		u.setLoginName("testdata2");
		u.setPassword("Neha1234");
		u.setRole(1);
		u.setLoginStatus(1);
		userdao.save(u);
		
		System.out.println("-------Data Saved----");
		
		
	}

}
