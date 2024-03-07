package com.priyanka.atm.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Transaction 
{
	@Id
	private String transationId;
	private String transctionType;
	private Double transactionAmount;
	private String transactionDateTime;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "accountNo")
	private Account account;

	public String getTransationId() {
		return transationId;
	}

	public void setTransationId(String transationId) {
		this.transationId = transationId;
	}

	public String getTransctionType() {
		return transctionType;
	}

	public void setTransctionType(String transctionType) {
		this.transctionType = transctionType;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionDateTime() {
		return transactionDateTime;
	}

	public void setTransactionDateTime(String transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
}
