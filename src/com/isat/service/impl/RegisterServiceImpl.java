package com.isat.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isat.dao.LoginDao;
import com.isat.objects.User;
import com.isat.service.RegisterService;

@Service(value = "RegisterService")
public class RegisterServiceImpl implements RegisterService {

	private static final Logger logger = Logger.getLogger(RegisterServiceImpl.class);

	@Autowired
	LoginDao loginDao;

	@Override
	public int insertUser(User user) {
		try {
			int registerUsercounter = loginDao.register(user);
			if (registerUsercounter != 0) {
				logger.info(registerUsercounter + "rows updated Successfully");
				System.out.println(registerUsercounter + "rows updated Successfully");
				return registerUsercounter;
			}
		} catch (Exception e) {

		}
		return 0;
	}

}
