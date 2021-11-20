package com.capp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capp.dao.BaseDAO;
import com.capp.dao.UserDAO;
import com.capp.domain.User;
import com.capp.exception.BlockedUserException;

@Service
public class UserServiceImpl extends BaseDAO implements UserService{

	@Autowired
	private UserDAO userdao;
	
	@Override
	public void register(User u) {
		userdao.save(u);
	}

	@Override
	public User login(String loginName, String password) throws BlockedUserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeLoginStatus(Integer userid, Integer loginStatus) {
		// TODO Auto-generated method stub
		
	}

}
