package com.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.DAO.BorrowedDAO;
import com.library.models.Transaction;
import com.library.models.TransactionResponse;

@RestController
public class TransactionController {
	
	
	@Autowired
	BorrowedDAO borrowedDAO;
	
	@CrossOrigin
	@RequestMapping("/borrow")
	public TransactionResponse lend(@RequestBody Transaction transaction) {
		return borrowedDAO.lendBook(transaction);
		
	}
	
	@CrossOrigin
	@RequestMapping("/back")
	public TransactionResponse back(@RequestBody Transaction transaction) {
		
		return borrowedDAO.returnBook(transaction);
		
	}
	
	/*
	 * for debugging purpose
	 */
	
	@CrossOrigin
	@RequestMapping("/getAllTransactions")
	public List<Transaction> getAllTransaction() {
		return BorrowedDAO.getTransactions();
	}
	
	 
}
