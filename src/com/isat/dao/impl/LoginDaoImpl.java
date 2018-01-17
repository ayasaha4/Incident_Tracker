package com.isat.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
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
import com.isat.objects.Offer;
import com.isat.objects.Role;
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
		inParamMap.put("InUsername", user.getUserName().trim());
		inParamMap.put("InPassword", user.getPassword().trim());
		inParamMap.put("InEmail", user.getEmail().trim());
		inParamMap.put("InPhone", user.getPhone().trim());
		inParamMap.put("InLocation", user.getLocation().trim());
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);

		Map<String, Object> mapResult = simpleJdbcCall.execute(in);
		if (mapResult.get("InStatus") != null) {
			execusionStatus = Integer.parseInt(mapResult.get("InStatus").toString());
		}
		return execusionStatus;

	}

	@Override
	public User validateUser(User user) throws Exception {
		User loginUser = jdbcTemplate.queryForObject(SQLConstants.IS_VALID_USER,
				new Object[] { user.getUserName().trim(), user.getPassword().trim() }, new UserMapper());
		System.out.println(loginUser.getEmail());
		return loginUser;
	}

	@Override
	public List<Offer> getOfferingByUser(String user) throws Exception {
		return jdbcTemplate.query(SQLConstants.VALID_URLOFFER_ROLE, new Object[] { user.trim() },
				new OfferByRoleMapper());
	}

	@Override
	public Role getRoleByUser(User user) throws Exception {/*
		Role UseRole = jdbcTemplate.query(SQLConstants.IS_VALID_USER_ROLE,new Object[] { user.getUserId().trim() }, new RoleMapper());
		System.out.println(UseRole);
		return UseRole;
	*/
		return null;}

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

class OfferByRoleMapper implements RowMapper<Offer> {
	public Offer mapRow(ResultSet rs, int arg1) throws SQLException {
		Offer OfferByRole = new Offer();
		OfferByRole.setOFFER_NAME(rs.getString("OFFER_NAME"));
		return OfferByRole;
	}
}

class RoleMapper implements RowMapper<Role> {
	public Role mapRow(ResultSet rs, int arg1) throws SQLException {
		Role userRole = new Role();
		userRole.setId(rs.getInt("Role_id"));
		userRole.setName(rs.getString("Role_name"));
		userRole.setDesc(rs.getString("Role_desc"));
		return userRole;
	}

}
