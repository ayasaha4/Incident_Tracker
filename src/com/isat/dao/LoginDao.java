package com.isat.dao;

import com.isat.objects.User;

public interface LoginDao {

	int register(User user);

	User validateUser(User user) throws Exception;

}
