package com.library.services;

import org.springframework.stereotype.Service;

import com.library.DAO.BooksDAO;
import com.library.DAO.UserDAO;

@Service
public class utilService {
	
	
	private UserDAO userDAO;
	
	private BooksDAO booksDAO;

	/**
	 * @return the userDAO
	 */
	public UserDAO getUserDAO() {
		return userDAO;
	}

	/**
	 * @param userDAO the userDAO to set
	 */
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/**
	 * @return the booksDAO
	 */
	public BooksDAO getBooksDAO() {
		return booksDAO;
	}

	/**
	 * @param booksDAO the booksDAO to set
	 */
	public void setBooksDAO(BooksDAO booksDAO) {
		this.booksDAO = booksDAO;
	}
	
	

}
