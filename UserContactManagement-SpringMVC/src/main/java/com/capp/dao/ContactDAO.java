package com.capp.dao;

import java.util.List;

import com.capp.domain.Contact;
import com.capp.domain.User;

public interface ContactDAO {
	
	public void save(Contact c);
	public void update(Contact c);
	public void delete(Contact c);
	public void delete(Integer contactid);
	public User findById(Integer contactid);
	public List<Contact> findAll();
	public List<Contact> findByProperty(String propName, Object propValue);

}
