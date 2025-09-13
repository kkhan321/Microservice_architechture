package com.userservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.entities.User;
import com.userservice.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService=userService;
	}
    
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User user2=userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user2);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable(name = "userId") String userId){
		User user=userService.getUserById(userId);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/getAllUser")
	public ResponseEntity<List<User>> getAllUser(){
		List<User>  user=userService.getALLusers();
		return ResponseEntity.ok(user);
	}
}
