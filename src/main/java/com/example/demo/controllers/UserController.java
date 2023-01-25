package com.example.demo.controllers;

import java.util.List;

import org.apache.tomcat.util.net.AbstractEndpoint.Handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.helper.Message;
import com.example.demo.services.UserService;

import jakarta.servlet.http.HttpSession;


@Controller
public class UserController {


	@Autowired
	private UserService userService;
	
	@RequestMapping("/base")
	public String base(Model model) {
		
		model.addAttribute("title","Home Page");
		
		return "base";
	}
	@RequestMapping("/new_user")
	public String newUser(Model model) {
		
		model.addAttribute("title","new user");
		
		return "new_user";
	}
	
//	this is for new user..
//	Handler
	@RequestMapping(value = "/do_register",method = RequestMethod.POST)
//	@PostMapping(path = "/do_register")
	public String newUser(@ModelAttribute("user") User user,Model model,HttpSession session) {
		
		System.out.println("User" + user);
		
		User createUser = this.userService.createUser(user);
		
		model.addAttribute(createUser);
		return "new_user";
	}
	
	@GetMapping(path = "/show_users")
	public String getAllUsers(Model model){
		
		List<User> allUser = this.userService.getAllUser();
		
		model.addAttribute("AllUser",allUser);
		
		return "show_users";
	}
	
	
	
	
}
