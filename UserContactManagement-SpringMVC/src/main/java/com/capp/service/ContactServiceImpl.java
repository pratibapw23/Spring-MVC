package com.capp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capp.dao.BaseDAO;
import com.capp.dao.ContactDAO;
import com.capp.domain.Contact;
import com.capp.rowmapper.ContactRowMapper;
import com.capp.util.StringUtility;

@Service
public class ContactServiceImpl extends BaseDAO implements ContactService{

	@Autowired
	private ContactDAO contactdao;
	
	@Override
	public void save(Contact c) {
	
		contactdao.save(c);
		
	}

	@Override
	public void update(Contact c) {
		contactdao.update(c);
		
	}

	@Override
	public void delete(Integer contactid) {
		contactdao.delete(contactid);
	}

	@Override//delete multiple values
	public void delete(Integer[] contactids) {
		String ids=StringUtility.arrayToCommaSeperatedString(contactids);
		String sql="delete from contact where contactid in("+ids+")";
		getJdbcTemplate().update(sql);
	}

	@Override
	public List<Contact> findUserContact(Integer userid) {
		return contactdao.findByProperty("userid",userid);
	}

	@Override
	public List<Contact> findUserContact(Integer userid, String text) {
		
		String sql="select contactid,userid,name,phone,email,address,remark from contact where userid=? and (name like '%"+text+"%' or address like '%"+text+"%' or phone like '%"+text+"%' or email like '%"+text+"%' or address like '%"+text+"%' or remark like '%"+text+"%')";
		return getJdbcTemplate().query(sql, new ContactRowMapper(),userid);
	}

}
