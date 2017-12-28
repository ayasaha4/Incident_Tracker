package com.isat.service;

import com.isat.exception.IncidentTrackerBusinessException;
import com.isat.objects.User;

public interface LoginService {

	public User checkUser(User user) throws IncidentTrackerBusinessException;

}
