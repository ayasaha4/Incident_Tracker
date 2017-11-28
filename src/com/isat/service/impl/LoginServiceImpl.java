package com.isat.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isat.dao.LoginDao;
import com.isat.pojo.User;
import com.isat.service.LoginService;

@Service(value = "LoginService")
public class LoginServiceImpl implements LoginService {
	
	private static final Logger logger = Logger.getLogger(LoginServiceImpl.class);

	@Autowired
	LoginDao loginDao;

	@Override
	public User checkUser(User user) {
		
		try {
			User loginUser = loginDao.validateUser(user);
			if (loginUser != null) {
				logger.info("User is not null");
				System.out.println("User is not null");
				return loginUser;
			}
		} catch (Exception e) {
			
		}
		return null;

	}

}