package com.capp.service;

import java.util.List;

import com.capp.domain.Contact;

public interface ContactService {
	
	public void save(Contact c);
	public void update(Contact c);
	public void delete(Integer contactid);
	public void delete(Integer[] contactids);
	public List<Contact> findUserContact(Integer userid);
	public List<Contact> findUserContact(Integer userid, String text);

}
