package com.isat.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.isat.controller.LoginController;
import com.isat.dao.LoginDao;
import com.isat.objects.User;

@Repository(value = "UserDao")
public class LoginDaoImpl implements LoginDao {
	
	private static final Logger logger = Logger.getLogger(LoginDaoImpl.class);

	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int register(User user) {
		
		  String sql = "insert into EAI.TEMP_INCIDENT_USER values(?,?,?,?,?,?)";
		  int i=jdbcTemplate.update(sql, new Object[] {"'TEMP_INCIDENT_USER_ID.nextVal'", user.getUserName(),user.getPassword(), user.getEmail(), user.getPhone(),user.getLocation()});
		  logger.info(user);
		  return i;
		 }

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
