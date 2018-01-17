package com.isat.service;

import java.util.Set;

import com.isat.exception.IncidentTrackerBusinessException;
import com.isat.objects.User;

public interface LoginService {

	public User checkUser(User user) throws IncidentTrackerBusinessException;
	
	public boolean insertUser(User user) throws IncidentTrackerBusinessException;
	
	public Set<String> checkOffering(String user) throws IncidentTrackerBusinessException;

}
