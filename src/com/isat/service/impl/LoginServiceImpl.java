package com.isat.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.isat.common.StaticVariable;
import com.isat.dao.LoginDao;
import com.isat.exception.IncidentTrackerBusinessException;
import com.isat.objects.Offer;
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
			if (user != null && user.getUserName() != null && user.getPassword() != null) {
				loginUser = loginDao.validateUser(user);

			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			if (e instanceof EmptyResultDataAccessException) {
				throw new IncidentTrackerBusinessException(StaticVariable.LOGIN_FAILURE, e.getMessage());
			} else {
				throw new IncidentTrackerBusinessException(StaticVariable.INTERNAL_FAILURE, e.getMessage());
			}
		}
		return loginUser;
	}

	public boolean insertUser(User user) throws IncidentTrackerBusinessException {
		boolean insertSucces = false;
		int registerUsercounter = 0;

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
		} else if (registerUsercounter == 2) {
			throw new IncidentTrackerBusinessException(StaticVariable.DUP_USER, null);
		}
		return insertSucces;
	}

	@Override
	public Set<String> checkOffering(String user) throws IncidentTrackerBusinessException {

		List<Offer> offerResultSet = null;
		Set<String> listOfOffers = new HashSet<String>();
		try {
			offerResultSet = loginDao.getOfferingByUser(user);
			for (Offer offer : offerResultSet) {
				System.out.println(offer.getOFFER_NAME());
				listOfOffers.add(offer.getOFFER_NAME());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listOfOffers;
	}

}
