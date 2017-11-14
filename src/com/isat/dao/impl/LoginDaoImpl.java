package com.isat.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.isat.dao.LoginDao;
import com.isat.pojo.User;

@Repository(value = "UserDao")
public class LoginDaoImpl implements LoginDao {

	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void register(User user) {
		/*
		 * String sql = "insert into users values(?,?,?,?)";
		 * jdbcTemplate.update(sql, new Object[] { user.get, user.getPassword(),
		 * user.getFirstname(), user.getLastname(), user.getEmail(),
		 * user.getAddress(), user.getPhone() });
		 */}

	public User validateUser(User user) throws Exception{
		String sql = "select * from EAI.TEMP_INCIDENT_USER where user_id=" + user.getUserId() + "";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		return users.get(0);
	}

}

class UserMapper implements RowMapper<User> {
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();
		user.setUserId(rs.getString("user_id"));
		user.setEmail(rs.getString("email"));
		user.setPhone(rs.getString("phone"));
		return user;
	}

}
