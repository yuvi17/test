package com.library.DAO;

import java.util.ArrayList;
import java.util.List;

import com.library.models.Transaction;

public class BorrowedDAO {
	

	List<Transaction> transactions = new ArrayList<>();
	
	
	
	public void lendBook(Transaction transaction) {
		
		transactions.add(transaction);
		
		
	}
	
	public void returnBook(Transaction transaction) {
		
		transactions.add(transaction);
	}
	
	

}
