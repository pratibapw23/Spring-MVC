package com.capp.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.capp.config.SpringRootConfig;

//Independent testing
public class TestDataSource {

	@Test
	public void SqlConnectionCheck() {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
		DataSource ds = ctx.getBean(DataSource.class);
		JdbcTemplate jt = new JdbcTemplate(ds);
		String sql = "INSERT INTO user(name, phone, email, address, loginName, password)"+ "VALUES(?,?,?,?,?,?)";
		Object[] param = new Object[] { "pratibha", "5463738463", "prati@gmail.com", "pune", "prati", "password" };
		jt.update(sql,param);
		System.out.println("SQL Executed");
	}
}
