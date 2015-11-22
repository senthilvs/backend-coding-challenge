package com.alchemytec.app.service;

import java.util.List;


import com.alchemytec.app.domain.Expense;

/**
 * Date: 21-Nov-2015
 * Author: senthil 
 **/
public interface ExpenseService {
	
	List<Expense> findAll();
	
	Expense save(Expense expense);

}
