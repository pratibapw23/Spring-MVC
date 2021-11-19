package com.capp.dao;

import java.util.List;

import com.capp.domain.User;

public interface UserDAO {

	public void save(User u);
	public void update(User u);
	public void delete(User u);
	public void delete(Integer userid);
	public User findById(Integer userid);
	public List<User> findAll();
	public List<User> findByProperty(String propName, Object propValue);
	
}
