package com.isat.dao.impl;

import com.isat.pojo.Login;
import com.isat.pojo.User;
import com.isat.service.UserDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
		String sql = "select * from Incident_assignee where assgn_id='" + login.getUserid() + "' and password='"
				+ login.getPassword() + "'";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		return users.size() > 0 ? users.get(0) : null;
	}
}

class UserMapper implements RowMapper<User> {
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();
		user.setAssignee_id(rs.getString("assgn_id"));
		user.setEmail(rs.getString("email"));
		user.setPhone(Integer.parseInt(rs.getString("phone")));
		return user;
	}

}
