package com.isat.dao.impl;

import com.isat.pojo.Login;
import com.isat.pojo.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository(value="UserDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	DataSource datasource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void register(User user) {
		/*
		 * String sql = "insert into users values(?,?,?,?)"; jdbcTemplate.update(sql,
		 * new Object[] { user.get, user.getPassword(), user.getFirstname(),
		 * user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone() });
		 */}

	public User validateUser(Login login) {
		String sql = "select * from EAI.TEMP_INCIDENT_USER where user_id=" + login.getUserid()+"";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		return users.get(0);
	}
}

class UserMapper implements RowMapper<User> {
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();
		user.setAssignee_id(rs.getString("user_id"));
		user.setEmail(rs.getString("email"));
		user.setPhone(Integer.parseInt(rs.getString("phone")));
		return user;
	}

}
