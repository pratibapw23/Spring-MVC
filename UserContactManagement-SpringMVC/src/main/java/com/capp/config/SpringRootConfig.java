package com.capp.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= {"com.capp.dao","com.capp.service"})
public class SpringRootConfig {
	
	@Bean
	public BasicDataSource getDataSource()
	{
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/contactapp_db");
		ds.setUsername("root");
		ds.setPassword("root");
		ds.setMaxTotal(2);//Connections that can be active at same time
		ds.setInitialSize(1);
		ds.setTestOnBorrow(true);
		ds.setValidationQuery("SELECT 1");//Test the connection
		ds.setDefaultAutoCommit(true);
		return ds;
	}

}
