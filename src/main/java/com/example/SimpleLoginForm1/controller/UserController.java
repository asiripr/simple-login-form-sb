package com.example.SimpleLoginForm1.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.SimpleLoginForm1.domain.User;
import com.example.SimpleLoginForm1.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new User());
		return mav;
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("user") User user) {
	    User oauthUser = userService.login(user.getUsername(), user.getPassword());
	    System.out.println("Login attempt with username: " + user.getUsername());
	    System.out.println("Authenticated user: " + oauthUser);

	    if (Objects.nonNull(oauthUser)) {
	        System.out.println("Login successful. Redirecting to welcome page.");
	        return "redirect:/";  // Ensure you have a "/welcome" mapping in your controller
	    } else {
	        System.out.println("Login failed. Redirecting to login page.");
	        return "redirect:/login";
	    }
	}
}
