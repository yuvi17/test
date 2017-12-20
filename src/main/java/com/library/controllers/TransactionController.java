package com.library.controllers;

import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.models.Transaction;

@RestController
public class TransactionController {
	
	
	@CrossOrigin
	@RequestMapping("/borrow")
	public void lend(@RequestBody Transaction transaction) {
		
		transaction.setTransactionId(generateId());
		transaction.setStatus(0);
		
	}
	
	@CrossOrigin
	@RequestMapping("/back")
	public void back(@RequestBody Transaction transaction) {
		
		transaction.setTransactionId(generateId());
		transaction.setStatus(1);
		
	}
	
	private String generateId( ){
		return UUID.randomUUID().toString().replace("-", "");
	}
	 
}
