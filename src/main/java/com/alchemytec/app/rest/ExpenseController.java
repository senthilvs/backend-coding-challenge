package com.alchemytec.app.rest;

/**
 * Date: 21-Nov-2015
 * Author: senthil
 **/
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alchemytec.app.domain.Expense;
import com.alchemytec.app.service.ExpenseService;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;

    @RequestMapping("/health")
    public String index() {
        return "Expense application served from Spring Boot!!!";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Expense> getExpenses() {
        return expenseService.findAll();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public Object saveExpense(@RequestBody Expense expense) {
    	return expenseService.save(expense);    	
    }
    

}
