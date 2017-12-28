package com.isat.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.isat.common.SQLConstants;
import com.isat.dao.LoginDao;
import com.isat.objects.User;

@Repository(value = "UserDao")
public class LoginDaoImpl implements LoginDao {

	private static final Logger logger = Logger.getLogger(LoginDaoImpl.class);

	@Autowired
	DataSource datasource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int register(User user) throws Exception {

		int execusionStatus = 0;
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("INC_TRACKER")
				.withProcedureName("CREATE_USER");

		Map<String, Object> inParamMap = new HashMap<String, Object>();
		inParamMap.put("USER_NAME", user.getUserName());
		inParamMap.put("PASSWD", user.getPassword());
		inParamMap.put("EMAIL", user.getEmail());
		inParamMap.put("PHONE", user.getPhone());
		inParamMap.put("LOC", user.getLocation());
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);

		Map<String, Object> mapResult = simpleJdbcCall.execute(in);
		System.out.println("------------------------------------------------>>>>>>>>>>>" + mapResult.keySet().toString()
				+ "---- " + mapResult.get("STATUS"));

		return execusionStatus;

	}

	@Override
	public User validateUser(User user) throws Exception {
		User loginUser = jdbcTemplate.queryForObject(SQLConstants.IS_VALID_USER,
				new Object[] { user.getUserName(), user.getPassword() }, new UserMapper());
		return loginUser;
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
