package com.library.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.library.models.Book;
import com.library.models.BookSearchResponse;


/*
 * This Class can be later used to persist things to the database by modifying the methods
 */

@Repository
public class BooksDAO {
	
	private static List<Book> books = new ArrayList<>();
	
	/*
	 * TODO
	 * Modify these methods to appropriate database methods with exceptions and errors
	 * Ignored due to shortage of time
	 * Add a check for ISBN and other things
	 */
	
	public List<Book> getBooks() {
		return BooksDAO.books;
	}
	
	
	public Boolean addBook(Book book) {
		
		try {
		books.add(book);
		return true;
		} catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
		
	}
	
	
	public void updateBookStatus(String bookId,String status) {
		for(Book book : BooksDAO.books) {
				if(book.getId().equals(bookId)) {
					book.setStatus(status);
				}
			
		}
		
	}
	
	// All three function below to be ideally replaced by a single search function with parameter and value
	
	/*
	 * TODO
	 * Modify these methods to appropriate database methods with exceptions and errors
	 * Ignored due to shortage of time
	 * Implement better algorithms for searching/matching substrings
	 */
	
	public BookSearchResponse getBookbyTitle(String title) {
		BookSearchResponse response = new BookSearchResponse();
		response.setStatus("Success");
		response.setMessage("Book Found");
		int flag = 0;
		for(Book book : BooksDAO.books) {
			if(book.getTitle().contains(title)) {
				response.setBook(book);
				flag = 1;
				break;
			}
		}
		if(flag == 0) {
			response.setMessage("book with given id is not present");
			response.setStatus("Error");
		}
		return response;
	}
	
	/*
	 * TODO
	 * Modify the method to return all books by a particular author.
	 * Ignored due to shortage of time
	 * Implement better algorithms for searching/matching substrings
	 */
	public BookSearchResponse getBookbyAuthor(String author) {
		BookSearchResponse response = new BookSearchResponse();
		response.setStatus("Success");
		response.setMessage("Book Found");
		int flag = 0;
		for(Book book : BooksDAO.books) {
			if(book.getAuthor().contains(author)) {
				response.setBook(book);
				flag = 1;
				break;
			}
		}
		if(flag == 0) {
			response.setMessage("book with given id is not present");
			response.setStatus("Error");
		}
		return response;
	}
	
	/*
	 * TODO
	 * Modify these methods to appropriate database methods with exceptions and errors
	 * Ignored due to shortage of time
	 */
	
	public BookSearchResponse getBookbyId(String Id) {
		BookSearchResponse response = new BookSearchResponse();
		response.setStatus("Success");
		response.setMessage("Book Found");
		int flag = 0;
		for(Book book : BooksDAO.books) {
			if(book.getId().equals(Id)) {
				response.setBook(book);
				flag = 1;
				break;
			}
		}
		if(flag == 0) {
			response.setMessage("book with given id is not present");
			response.setStatus("Error");
		}
		return response;
	}
	
	

}
