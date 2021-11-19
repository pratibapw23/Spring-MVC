package com.capp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.capp.domain.User;

@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO {

	@Override
	public void save(User u) {

		String sql = "INSERT INTO user(name, phone, email, address, loginName, password, role, loginStatus)"
				+ "VALUES(:name, :phone, :email, :address, :loginName, :password, :role, :loginStatus)";

		Map m = new HashMap();
		m.put("name", u.getName());
		m.put("phone", u.getPhone());
		m.put("email", u.getEmail());
		m.put("address", u.getAddress());
		m.put("loginName", u.getLoginName());
		m.put("password", u.getPassword());
		m.put("role", u.getRole());
		m.put("loginStatus", u.getLoginStatus());

		KeyHolder kh = new GeneratedKeyHolder();
		SqlParameterSource ps = new MapSqlParameterSource(m);
		super.getNamedParameterJdbcTemplate().update(sql, ps, kh);
		Integer userid=kh.getKey().intValue();
		u.setUserid(userid);
	}

	@Override
	public void update(User u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer userid) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findById(Integer userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByProperty(String propName, Object propValue) {
		// TODO Auto-generated method stub
		return null;
	}

}
