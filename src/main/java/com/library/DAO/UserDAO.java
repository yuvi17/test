package com.library.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.library.models.User;
import com.library.models.UserResponse;

@Repository
public class UserDAO {

	
	private List<User> users = new ArrayList<>();
	
	/*
	 * TODO
	 * Modify these methods to appropriate database methods with exceptions and errors
	 * Ignored due to shortage of time
	 */
	
	
	public UserResponse addUser(User user) {
		
		UserResponse existingUser = getUserByEmail(user.getEmail());
		
		UserResponse response = new UserResponse();
		
		// User does not exist, can be added
		if(existingUser.getStatus() == 404) {
			response.setMessage("User has been added");
			response.setStatus(201);
			response.setUser(user);
			
		} else {
			response.setMessage("User with this email id already exists");
			response.setStatus(409);
		}
		
		return response;
		
	}
	
	// All functions below to be ideally replaced by a single search function with parameter and value
	
	/*
	 * TODO
	 * Modify these methods to appropriate database methods with exceptions and errors
	 * Ignored due to shortage of time
	 */
	
	public UserResponse getUserById(String id) {
		UserResponse response = new UserResponse();
		
		int flag = 0;
		for(User user : this.users) {
			if(user.getUserId().equals(id)) {
				response.setStatus(200);
				response.setMessage("User Found");
				response.setUser(user);
				flag = 1;
			}
		}
		if(flag == 0) {
			response.setStatus(404);
			response.setMessage("User Not Found");
		}
		
		return response;
	}
	
	/*
	 * TODO
	 * Modify these methods to appropriate database methods with exceptions and errors
	 * Ignored due to shortage of time
	 */
	
	
	public UserResponse getUserByEmail(String email) {
		UserResponse response = new UserResponse();
		
		int flag = 0;
		for(User user : this.users) {
			if(user.getEmail().equals(email)) {
				response.setStatus(200);
				response.setMessage("User Found");
				response.setUser(user);
				flag = 1;
			}
		}
		if(flag == 0) {
			response.setStatus(404);
			response.setMessage("User Not Found");
		}
		
		return response;
	}
	
	/*
	 * TODO
	 * Modify these methods to appropriate database methods with exceptions and errors
	 * Ignored due to shortage of time
	 * Implement better algorithms for searching/matching substrings
	 */
	
	
	public UserResponse getUserByName(String name) {
		UserResponse response = new UserResponse();
		
		int flag = 0;
		for(User user : this.users) {
			if(user.getName().contains(name)) {
				response.setStatus(200);
				response.setMessage("User Found");
				response.setUser(user);
				flag = 1;
			}
		}
		if(flag == 0) {
			response.setStatus(404);
			response.setMessage("User Not Found");
		}
		
		return response;
	}
	
	
}
