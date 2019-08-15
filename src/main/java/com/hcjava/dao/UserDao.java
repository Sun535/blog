package com.hcjava.dao;

import com.hcjava.pojo.User;

public interface UserDao {
	
	User findByName(String username);
}
