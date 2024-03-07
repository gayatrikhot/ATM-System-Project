package com.priyanka.atm.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Account 
{
	@Id
	private String accountNo;
	private String accountType;
	private Double accountBalance;
	private String accountStatus;
	private LocalDate accountOpeningDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId")
	private Customer customer;
	
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private List<Card> card;
	
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private List<Transaction> transaction;

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public LocalDate getAccountOpeningDate() {
		return accountOpeningDate;
	}

	public void setAccountOpeningDate(LocalDate accountOpeningDate) {
		this.accountOpeningDate = accountOpeningDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Card> getCard() {
		return card;
	}

	public void setCard(List<Card> card) {
		this.card = card;
	}

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}
}
