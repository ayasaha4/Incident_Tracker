package com.isat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isat.dao.LoginDao;
import com.isat.pojo.User;
import com.isat.service.LoginService;

@Service(value = "LoginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao loginDao;

	@Override
	public User checkUser(User user) {
		
		try {
			User loginUser = loginDao.validateUser(user);
			if (loginUser != null) {
				System.out.println("User is not null");
				return loginUser;
			}
		} catch (Exception e) {
			
		}
		return null;

	}

}
