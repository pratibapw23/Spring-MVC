package com.capp.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capp.config.SpringRootConfig;
import com.capp.domain.Contact;
import com.capp.service.ContactService;

public class TestContactServiceSave {
	
	@Test
	public void TestContactServiceSaveOperation()
	{
		ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringRootConfig.class);
		ContactService contactservice=ctx.getBean(ContactService.class);
		
		Contact u=new Contact();
		u.setUserid(11);
		u.setName("Vidya1");
		u.setPhone("36336337");
		u.setEmail("vidya1@gmail.com");
		u.setAddress("Mumbai");
		u.setRemark("LoggedIn");
		contactservice.save(u);
		
		System.out.println("-------Contact Saved----");
		
		
	}

}
