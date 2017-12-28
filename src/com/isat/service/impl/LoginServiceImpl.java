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
			if(user!=null && user.getEmail() != null && user.getPassword()!=null){
				loginUser = loginDao.validateUser(user);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			if(e instanceof EmptyResultDataAccessException){
				throw new IncidentTrackerBusinessException(StaticVariable.LOGIN_FAILURE,e.getMessage());
			}else {
				throw new IncidentTrackerBusinessException(StaticVariable.INTERNAL_FAILURE, e.getMessage());
			}
		}
		return loginUser;
	}
	
	public boolean insertUser(User user) throws IncidentTrackerBusinessException {
		boolean insertSucces = false;
		int registerUsercounter = 0 ;
		
		try {
			 registerUsercounter = loginDao.register(user);
			 System.out.println(registerUsercounter + "-----------registerUsercounter");
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new IncidentTrackerBusinessException(StaticVariable.INTERNAL_FAILURE, e.getMessage());
		}
		if (registerUsercounter == 1) {
			logger.info(registerUsercounter + "rows updated Successfully");
			System.out.println(registerUsercounter + "rows updated Successfully");
			insertSucces = true;
		}else if(registerUsercounter == 2){
			throw new IncidentTrackerBusinessException(StaticVariable.DUP_USER,null);
		}
		return insertSucces;
	}

	
}
