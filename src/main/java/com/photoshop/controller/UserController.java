package com.photoshop.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.photoshop.model.User;
import com.photoshop.service.UserService;
import com.photoshop.util.SessionController;

public class UserController {

	private UserService us;
	private SessionController sc;
	
	private static Logger logger = Logger.getLogger(UserController.class);
	
	public UserController() {
		this(new UserService(), new SessionController());
	}
	
	public UserController(UserService us, SessionController sc) {
		this.us = us;
		this.sc = sc;
	}
	
	public String verifyUser(HttpServletRequest req) {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		if ( us.verifyUser(email, password) ) {
			User user = us.findByEmail(email);
			logger.info("Current User: " + user);
			
			if (user.getUserRole().getRole().equals("Employee")) {
				sc.setSessionUser(req, user);
				logger.info("User is an employee");
				return "html/employee.html";
			} 
			else {
				sc.setSessionUser(req, user);
				logger.info("User is a Finance Manager");
				return "html/finance manager.html";
			}
		}
		
		return "html/login.html";
	}
	
	public void getEmployeeList(HttpServletResponse res) {
		List<User> users = null;
		try {
			users = us.findAll().stream().filter(u -> u.getUserRole().getRole().equals("Employee")).collect(Collectors.toList());
			
			res.getWriter().println(new ObjectMapper().writeValueAsString(users));
			logger.info("All Employees successfully loaded");
		} catch (IOException e) {
			logger.warn("Could not load all Employees: ", e);
		}
	}
}
