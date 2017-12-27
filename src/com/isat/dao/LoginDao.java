package com.isat.dao;

import com.isat.objects.User;

public interface LoginDao {

	int register(User user) throws Exception ;

	User validateUser(User user) throws Exception;

}
