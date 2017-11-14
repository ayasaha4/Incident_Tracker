package com.isat.dao;

import com.isat.pojo.User;

public interface LoginDao {

	void register(User user);

	User validateUser(User user) throws Exception;

}
