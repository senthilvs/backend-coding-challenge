package com.alchemytec.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alchemytec.app.dao.ExpenseRepository;
import com.alchemytec.app.domain.Expense;

/**
 * Date: 21-Nov-2015
 * Author: senthil
 **/

@Component("expenseService")
@Transactional
public class ExpenseServiceImpl implements ExpenseService {
	
	@Autowired
	private ExpenseRepository expenseRepository;
	

	public List<Expense> findAll() {		
		return this.expenseRepository.findAll();
	}

	public Expense save(Expense expense) {		
		return this.expenseRepository.save(expense);
	}

}
