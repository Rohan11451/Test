package com.example.demo.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepositories;
import com.example.demo.services.UserService;


@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserRepositories userRepositories;
	
	
	@Override
	public User createUser(User user) {
		
		User save = this.userRepositories.save(user);
		return save;
	}

	@Override
	public List<User> getAllUser() {
		
		
		List<User> findAll = this.userRepositories.findAll();
		return findAll;
	}

}
