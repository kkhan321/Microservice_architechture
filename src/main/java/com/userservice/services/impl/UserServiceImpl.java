package com.userservice.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.userservice.entities.User;
import com.userservice.exception.ResourcesNotFoundException;
import com.userservice.repositories.UserRepository;
import com.userservice.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	public  UserServiceImpl(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getALLusers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUserById(String Id) {
		// TODO Auto-generated method stub
		return userRepository.findById(Id).orElseThrow(()-> new ResourcesNotFoundException("user with given not found on server "+ Id));
	}

	@Override
	public boolean isdeleted(String Id) {
		// TODO Auto-generated method stub
		return false;
	}

}
