package com.alchemytec.app;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.alchemytec.app.dao.ExpenseRepository;
import com.alchemytec.app.domain.Expense;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Date: 21-Nov-2015
 * Author: senthil 
 **/
@RunWith(SpringJUnit4ClassRunner.class)   
@SpringApplicationConfiguration(classes = ExpenseApplication.class)
@WebIntegrationTest
public class ExpenseApplicationTests {	
	
	public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	private RestTemplate restTemplate = new TestRestTemplate();
	
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
		RestTemplate template = new RestTemplate();
	    List list = template.getForObject("http://localhost:8080/expenses",
	        ArrayList.class);
	    System.out.println("test1 =" +list.size());
	    Assert.assertTrue(list.size() == 1);
	}
	
	
	@Test
	public void save() throws JsonProcessingException{		
		Map<String, Object> requestBody = new HashMap<String, Object>();
		requestBody.put("date", "21/11/2014");
		requestBody.put("amount", "180");
		requestBody.put("reason", "Books");
		
		HttpHeaders requestHeaders = new HttpHeaders();		
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> httpEntity =				
				      new HttpEntity<String>(OBJECT_MAPPER.writeValueAsString(requestBody), requestHeaders);
				
		Map<String, Object> apiResponse =				
				      restTemplate.postForObject("http://localhost:8080/expenses", httpEntity, Map.class, Collections.EMPTY_MAP);				
		boolean exists = expenseRepository.exists(new Long((Integer)apiResponse.get("id")));		
		Assert.assertTrue(exists);		
	}
}
