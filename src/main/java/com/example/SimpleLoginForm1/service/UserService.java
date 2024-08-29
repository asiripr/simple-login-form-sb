package com.example.SimpleLoginForm1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SimpleLoginForm1.domain.User;
import com.example.SimpleLoginForm1.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	
	public User login(String username, String password) {
		User user = repo.findByUsernameAndPassword(username, password);
		return null;
	}
}
