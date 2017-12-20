package com.library.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.DAO.UserDAO;
import com.library.models.AddResponseModel;
import com.library.models.User;
import com.library.models.UserResponse;

@RestController
public class UserController {

	
	@Autowired
	UserDAO userDAO;
	
	
	/*
	 * TODO
	 * Add a service layer between the controller and DAO
	 * Ignored due to shortage of time
	 */
	
	
	/*
	 * TODO
	 * Hash password
	 * Implement Login
	 */
	@CrossOrigin
	@RequestMapping("/addUser")
	public AddResponseModel addUser(@RequestBody User user) {
		AddResponseModel response = new AddResponseModel();
		
		
		
		user.setUserId(generateuserId());
		UserResponse isAdded = userDAO.addUser(user);
		
		if(isAdded.getStatus() == 201) {
			response.setMessage("user has been added successfully");
			response.setStatus(201);
		} else {
			response.setMessage("user could not be added, try again");
			response.setStatus(500);
		}
		
		return response;
		
		
	}
	
	
	
	
	@CrossOrigin
	@RequestMapping("/searchUser/{param}/{value}")
	public UserResponse searchBook(@PathVariable String param,@PathVariable String value){
		if(param.equals("name")) {
			return userDAO.getUserByName(value);
		} else if(param.equals("name")) {
			return userDAO.getUserByEmail(value);
		} else if(param.equals("id")) {
			return userDAO.getUserById(value);
		} else {
			UserResponse response = new UserResponse();
			response.setStatus(400);
			response.setMessage("Invalid Param");
			return response;
		}
	}
	
	
	
	
	
	/*
	 * TODO
	 * Utility methods, move them to services
	 * 
	 * 
	 */
	
	private String generateuserId( ){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	
	
}
