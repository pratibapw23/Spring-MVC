package com.capp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.capp.dao.BaseDAO;
import com.capp.dao.UserDAO;
import com.capp.domain.User;
import com.capp.exception.BlockedUserException;
import com.capp.rowmapper.UserRowMapper;

@Service
public class UserServiceImpl extends BaseDAO implements UserService {

	@Autowired
	private UserDAO userdao;

	@Override
	public void register(User u) {
		userdao.save(u);
	}

	@Override
	public User login(String loginName, String password) throws BlockedUserException {
		String sql = "select userid, name, phone, email, address, role, loginStatus, loginName from user where loginName=:ln and password=:pw";
		Map m = new HashMap();
		m.put("ln", loginName);
		m.put("pw", password);
		try {
			User u = getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserRowMapper());
			if (u.getLoginStatus().equals(UserService.LoginStatusBlocked)) {
				throw new BlockedUserException("Your Account has been blocked!! Contact to admin");
			} else {
				return u;
			}

		} catch (EmptyResultDataAccessException ex) {
			return null;
		}

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
