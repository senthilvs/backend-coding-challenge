package com.alchemytec.app;


import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alchemytec.app.ExpenseApplication;
import com.alchemytec.app.dao.ExpenseRepository;
import com.alchemytec.app.domain.Expense;


/**
 * Date: 21-Nov-2015
 * Author: senthil 
 **/

@RunWith(SpringJUnit4ClassRunner.class)   
@SpringApplicationConfiguration(classes = ExpenseApplication.class) 
public class ExpenseRepositoryTests {
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Before
    public void setUp() {		
		Expense expense = new Expense();
		expense.setDate(new Date());
		expense.setAmount(new BigInteger("11"));
		expense.setReason("test");		
		expenseRepository.deleteAll();		
		expenseRepository.save(expense);		
	}
	
	@Test
	public void findAll(){		
		List<Expense> expenses = expenseRepository.findAll();
		System.out.println("test3 =" +expenses.size());
		Assert.assertTrue(expenses.size() == 1);		
	}
	
	@Test
	public void save(){
		Expense expense = new Expense();
		expense.setDate(new Date());
		expense.setAmount(new BigInteger("100"));
		expense.setReason("test");
		
		Expense savedExpense = expenseRepository.save(expense);
		System.out.println("test4 =" +savedExpense);
		Assert.assertTrue(expenseRepository.exists(savedExpense.getId()));		
	}
}
