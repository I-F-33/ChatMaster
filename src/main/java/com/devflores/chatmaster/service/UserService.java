package com.devflores.chatmaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devflores.chatmaster.domain.User;
import com.devflores.chatmaster.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public User saveUser(User user) {
		return userRepo.save(user);
	}
	
	public User createNewUser(String userName) {
		User user = new User();
		user.setName(userName);
		return userRepo.save(user);
	}
	
	public User findById(Long userID) {
		return userRepo.findById(userID).get();
	}
}
