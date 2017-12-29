package com.isat.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isat.dao.LoginDao;
import com.isat.service.IncidentService;

@Service(value = "IncidentService")
public class IncidentServiceImpl implements IncidentService {

	private static final Logger logger = Logger.getLogger(IncidentServiceImpl.class);

	@Autowired
	LoginDao loginDao;

	@Override
	public void viewIncidents() {
		try {
			/*int registerUsercounter = loginDao.register(user);
			if (registerUsercounter != 0) {
				logger.info(registerUsercounter + "rows updated Successfully");
				System.out.println(registerUsercounter + "rows updated Successfully");
				return registerUsercounter;
			}*/
		} catch (Exception e) {

		}
		//return 0;
	}

}
