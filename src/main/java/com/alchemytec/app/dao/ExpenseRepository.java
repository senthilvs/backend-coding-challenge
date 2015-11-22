package com.alchemytec.app.dao;

import java.util.List;



import org.springframework.data.repository.CrudRepository;

import com.alchemytec.app.domain.Expense;

/**
 * Date: 21-Nov-2015
 * Author: senthil
 **/
public interface ExpenseRepository extends CrudRepository<Expense, Long>{
	
	List<Expense> findAll();
	
	@SuppressWarnings("unchecked")
	Expense save(Expense expense);
	
	void deleteAll();
	
	boolean exists(Long id);

}
