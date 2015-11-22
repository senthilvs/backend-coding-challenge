package com.alchemytec.app.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Date: 21-Nov-2015
 * Author: senthil
 **/

@Entity
@Table(name = "expense")
public class Expense implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date date ;
	
	@Column(nullable = false)
	private BigInteger amount = BigInteger.ZERO;
	
	@Column(nullable = false)
	private String reason = "";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigInteger getAmount() {
		return amount;
	}

	public void setAmount(BigInteger amount) {
		this.amount = amount;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", date=" + date + ", amount=" + amount + ", reason=" + reason + "]";
	}	
	
	

}
