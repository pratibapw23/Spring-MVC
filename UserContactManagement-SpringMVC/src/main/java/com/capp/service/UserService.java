package com.capp.service;

import java.util.List;

import com.capp.domain.User;
import com.capp.exception.BlockedUserException;

public interface UserService {
	
	public static final Integer loginStatusActive=1;
	public static final Integer LoginStatusBlocked=2;
	
	public static final Integer Admin_Role=1;
	public static final Integer User_Role=2;
	
	public void register(User u);
	public User login(String loginName, String password) throws BlockedUserException;
	public List<User> getUserList();
	public void changeLoginStatus(Integer userid, Integer loginStatus);
}
