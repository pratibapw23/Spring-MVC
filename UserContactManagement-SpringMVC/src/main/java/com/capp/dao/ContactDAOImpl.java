package com.capp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.capp.domain.Contact;
import com.capp.domain.User;
import com.capp.rowmapper.ContactRowMapper;

@Repository
public class ContactDAOImpl extends BaseDAO implements ContactDAO{

	@Override
	public void save(Contact c) {
		String sql="insert into contact(userid,name,phone,email,address,remark) values(:userid,:name,:phone,:email,:address,:remark)";
		Map m=new HashMap();
		m.put("userid", c.getUserid());
		m.put("name", c.getName());
		m.put("phone", c.getPhone());
		m.put("email", c.getEmail());
		m.put("address", c.getAddress());
		m.put("remark", c.getRemark());
		
		SqlParameterSource ps=new MapSqlParameterSource(m);
		KeyHolder kh=new GeneratedKeyHolder();
		getNamedParameterJdbcTemplate().update(sql, ps,kh);
		c.setContactid(kh.getKey().intValue());
	}

	@Override
	public void update(Contact c) {
		String sql="update contact set name=:name, phone=:phone, email=:email, address=:address, remark=:remark where contactid=:contactid";
		Map m=new HashMap();
		m.put("contactid", c.getContactid());
		m.put("name", c.getName());
		m.put("phone", c.getPhone());
		m.put("email", c.getEmail());
		m.put("address", c.getAddress());
		m.put("remark", c.getRemark());
		getNamedParameterJdbcTemplate().update(sql, m);
	}

	@Override
	public void delete(Contact c) {
		this.delete(c.getContactid());
		
	}

	@Override
	public void delete(Integer contactid) {
		String sql="delete from contact where contactid=?";
		getJdbcTemplate().update(sql,contactid);
	}

	@Override
	public Contact findById(Integer contactid) {
		String sql="select contactid,userid,name,phone,email,address,remark from contact where contactid=?";
		return getJdbcTemplate().queryForObject(sql, new ContactRowMapper(),contactid);
		
	}

	@Override
	public List<Contact> findAll() {
		String sql="select contactid,userid,name,phone,email,address,remark from contact";
		return getJdbcTemplate().query(sql, new ContactRowMapper());
	}

	@Override
	public List<Contact> findByProperty(String propName, Object propValue) {
		String sql="select contactid,userid,name,phone,email,address,remark from contact where "+propName+"=?";
		return getJdbcTemplate().query(sql, new ContactRowMapper(),propValue);
	}

}
