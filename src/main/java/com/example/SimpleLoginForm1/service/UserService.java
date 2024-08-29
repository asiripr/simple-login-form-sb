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
        // Fetch the user by user name
        User user = repo.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;  // Successfully authenticated
        }
        return null;  // Authentication failed
    }
}
