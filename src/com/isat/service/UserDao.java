package com.isat.service;

import com.isat.pojo.*;

public interface UserDao {
	
		void register(User user);
		User validateUser(Login login);

}
