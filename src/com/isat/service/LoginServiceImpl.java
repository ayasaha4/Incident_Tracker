package com.isat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isat.dao.impl.UserDao;
import com.isat.pojo.Login;
import com.isat.pojo.User;

@Service(value = "LoginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserDao userDao;

	@Override
	public User checkUser(Login login) {

		User user = userDao.validateUser(login);
		if (user.getAssignee_id() != login.getUserid()) {
			return user;
		} else
			return null;

	}

}
