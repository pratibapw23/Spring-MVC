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
import com.capp.rowmapper.UserRowMapper;

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
		String sql="update user set name=:name, phone=:phone, email=:email, address=:address, role=:role, loginStatus=:loginStatus where userid=:userid";
		Map m=new HashMap();
		m.put("name", u.getName());
		m.put("phone", u.getPhone());
		m.put("email", u.getEmail());
		m.put("address", u.getAddress());
		m.put("role", u.getRole());
		m.put("loginStatus", u.getLoginStatus());
		m.put("userid", u.getUserid());
		getNamedParameterJdbcTemplate().update(sql, m);
		
	}


	@Override
	public void delete(User u) {
		this.delete(u.getUserid());
		
	}

	@Override
	public void delete(Integer userid) {
		String sql="delete from user where userid=?";
		getJdbcTemplate().update(sql,userid);

	}

	@Override
	public User findById(Integer userid) {
		String sql="select userid, name, phone, email, address, loginName, role, loginStatus from user where userid=?";
		User u=getJdbcTemplate().queryForObject(sql,new UserRowMapper(),userid);//for single record
		return u;
	}

	@Override
	public List<User> findAll() {
		String sql="select userid, name, phone, email, address, loginName, role, loginStatus from user";
		List<User> users=getJdbcTemplate().query(sql, new UserRowMapper());
		return users;
	}

	@Override
	public List<User> findByProperty(String propName, Object propValue) {
		String sql="select userid, name, phone, email, address, loginName, role, loginStatus from user where "+propName+"=?";
		return getJdbcTemplate().query(sql, new UserRowMapper(), propValue);
	}


}
