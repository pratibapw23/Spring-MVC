package com.capp.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capp.config.SpringRootConfig;
import com.capp.dao.ContactDAO;
import com.capp.domain.Contact;

public class TestContactDAOSave {
	
	@Test
	public void TestContactDAOSaveOperation()
	{
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactDAO contactdao=ctx.getBean(ContactDAO.class);
		
		Contact u=new Contact();
		u.setUserid(4);
		u.setName("Neha");
		u.setPhone("3646336337");
		u.setEmail("neha@gmail.com");
		u.setAddress("Indapur");
		u.setRemark("LoggedIn");
		contactdao.save(u);
		
		System.out.println("-------Data Saved----");
		
		
	}

}
