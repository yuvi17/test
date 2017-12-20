package com.library.controllers;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.DAO.BooksDAO;
import com.library.models.AddResponseModel;
import com.library.models.Book;
import com.library.models.BookSearchResponse;

@RestController
public class BookController {
	
	
	@Autowired
	BooksDAO booksDAO;
	
	/*
	 * TODO
	 * Add a service layer between the controller and DAO
	 * Ignored due to shortage of time
	 */
	
	@CrossOrigin
	@RequestMapping("/addBook")
	public AddResponseModel addBook(@RequestBody Book book) {
		AddResponseModel response = new AddResponseModel();
		
		book.setId(generateBookId());
		book.setAddedTimeStamp(new Date().toString());
		Boolean isAdded = booksDAO.addBook(book);
		
		if(isAdded) {
			response.setMessage("Book has been added successfully");
			response.setStatus(201);
		} else {
			response.setMessage("Book could not be added, try again");
			response.setStatus(500);
		}
		
		return response;
		
		
	}
	
	@CrossOrigin
	@RequestMapping("/searchBook/{param}/{value}")
	public BookSearchResponse searchBook(@PathVariable String param,@PathVariable String value){
		if(param.equals("title")) {
			return booksDAO.getBookbyTitle(value);
		} else if(param.equals("author")) {
			return booksDAO.getBookbyAuthor(value);
		} else if(param.equals("id")) {
			return booksDAO.getBookbyId(value);
		} else {
			BookSearchResponse response = new BookSearchResponse();
			response.setStatus("Bad Request");
			response.setMessage("Invalid Param");
			return response;
		}
	}
	
	@CrossOrigin
	@RequestMapping("/getAllBooks")
	public List<Book> getAllBooks() {
		return booksDAO.getBooks();
		
	}
	
	
	
	
	/*
	 * TODO
	 * Utility methods, move them to util service
	 * 
	 */
	
	private String generateBookId( ){
		return UUID.randomUUID().toString().replace("-", "");
	}
	

}
