package com.isat.dao;

import java.util.List;
import com.isat.objects.Offer;
import com.isat.objects.Role;
import com.isat.objects.User;

public interface LoginDao {

	int register(User user) throws Exception ;

	User validateUser(User user) throws Exception;
	
	List<Offer> getOfferingByUser(String user) throws Exception;
	
	Role getRoleByUser(User user) throws Exception;
	


}
