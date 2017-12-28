package com.isat.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.isat.common.StaticVariable;
import com.isat.dao.LoginDao;
import com.isat.exception.IncidentTrackerBusinessException;
import com.isat.objects.User;
import com.isat.service.LoginService;

@Service(value = "LoginService")
public class LoginServiceImpl implements LoginService {
	
	private static final Logger logger = Logger.getLogger(LoginServiceImpl.class);

	@Autowired
	LoginDao loginDao;

	@Override
	public User checkUser(User user) throws IncidentTrackerBusinessException {
		
		User loginUser = null;
		try {
			loginUser = loginDao.validateUser(user);
		} catch (Exception e) {
			if(e instanceof EmptyResultDataAccessException){
				throw new IncidentTrackerBusinessException(StaticVariable.LOGIN_FAILURE,null);
			}else {
				throw new IncidentTrackerBusinessException(StaticVariable.INTERNAL_FAILURE, null);
			}
		}
		return loginUser;
	}
}
