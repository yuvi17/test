package com.library.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.library.models.BookSearchResponse;
import com.library.models.Transaction;
import com.library.models.TransactionResponse;
import com.library.models.UserResponse;


@Repository
public class BorrowedDAO {
	
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	BooksDAO booksDAO;

	private static List<Transaction> transactions = new ArrayList<>();
	
	// use this from property file
	private static int MAX_COUNT = 2;
	
	public TransactionResponse lendBook(Transaction transaction) {
		
		TransactionResponse response = new TransactionResponse();
		
		UserResponse user = userDAO.getUserById(transaction.getUserId());
		
		
		if(user.getUser().getBorrowedCount() == MAX_COUNT ) {
			response.setMessage("Sorry, you've excedded book borrow limit");
			response.setStatus(200);
			
			return response;
		} 
		
		BookSearchResponse book = booksDAO.getBookbyId(transaction.getBookId());
		
		
		if(book.getBook().getStatus().equals("Issued") ){
			response.setMessage("This book has been already issued");
			response.setStatus(200);
			
			return response;
		} else {
			
			userDAO.IncrementIssueCount(transaction.getUserId());
			booksDAO.updateBookStatus(transaction.getBookId(), "Issued");
			transaction.setStatus(0);
			transaction.setTimeStamp(new Date().toString());
			transaction.setTransactionId(generateId());
			
			response.setMessage("Issued to you");
			response.setStatus(201);
			
			BorrowedDAO.transactions.add(transaction);
			
			return response;
		}
		
		
	}
	
	/**
	 * @return the transactions
	 */
	public static List<Transaction> getTransactions() {
		return transactions;
	}

	/**
	 * @param transactions the transactions to set
	 */
	public static void setTransactions(List<Transaction> transactions) {
		BorrowedDAO.transactions = transactions;
	}

	public TransactionResponse returnBook(Transaction transaction) {
		
		TransactionResponse response = new TransactionResponse();
		
		userDAO.DecrementIssueCount(transaction.getUserId());
		booksDAO.updateBookStatus(transaction.getBookId(), "Free");
		transaction.setStatus(1);
		transaction.setTimeStamp(new Date().toString());
		transaction.setTransactionId(generateId());
		
		BorrowedDAO.transactions.add(transaction);
		
		response.setMessage("Returned Successfully");
		response.setStatus(200);
		
		return response;
	}
	
	
	private String generateId( ){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	

}
