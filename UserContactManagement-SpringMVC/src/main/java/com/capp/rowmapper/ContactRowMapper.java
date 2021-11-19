package com.capp.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.capp.domain.Contact;
import com.capp.domain.User;

public class ContactRowMapper implements RowMapper<Contact>{

	@Override
	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contact c=new Contact();
		c.setContactid(rs.getInt("contactid"));
		c.setUserid(rs.getInt("userid"));
		c.setName(rs.getString("name"));
		c.setPhone(rs.getString("phone"));
		c.setEmail(rs.getString("email"));
		c.setAddress(rs.getString("address"));
		c.setRemark(rs.getString("remark"));
		return c;
	}

}
