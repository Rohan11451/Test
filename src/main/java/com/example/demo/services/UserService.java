package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.User;

public interface UserService {

	
	public User createUser(User user);
	
	public List<User> getAllUser();
}
