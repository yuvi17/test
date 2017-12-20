package com.library.models;

import org.springframework.stereotype.Repository;

@Repository
public class User {
	
	private String name;
	
	private String userId;
	
	private String email;
	
	private String password;
	
	private int borrowedCount;
	
	
	public User() {
		this.borrowedCount = 0;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the borrowedCount
	 */
	public void incrementBorrowedCount() {
		this.borrowedCount = this.borrowedCount + 1;
	}

	/**
	 * @param borrowedCount the borrowedCount to set
	 */
	public int getBorrowedCount(int borrowedCount) {
		return borrowedCount;
	}
	
	

}
