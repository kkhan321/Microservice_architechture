package com.userservice.services;

import java.util.List;

import com.userservice.entities.User;

public interface UserService {

	User saveUser(User user);
	List<User> getALLusers();
	User getUserById(String Id);
	boolean isdeleted(String Id);
	
}
