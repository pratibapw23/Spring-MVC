package com.capp.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capp.config.SpringRootConfig;
import com.capp.dao.ContactDAO;
import com.capp.domain.Contact;

public class TestContactDAOUpdate {
	
	@Test
	public void TestUserDAOUpdateOperation()
	{
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactDAO contactdao=ctx.getBean(ContactDAO.class);
		
		Contact u=new Contact();
		u.setContactid(1);
		u.setName("Neha Wabale");
		u.setPhone("3646336337");
		u.setEmail("neha.wabale@gmail.com");
		u.setAddress("Pune");
		u.setRemark("Not LoggedIn");
		contactdao.update(u);
		
		System.out.println("-------Data Updated----");
		
		
	}

}
