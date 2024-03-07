package com.priyanka.atm.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer 
{
	@Id
	private String customerId;
	private String customerName;
	private String customerPhoneNo;
	private String customerEmail;
	private String customerGender;
	private String customerAdhaarNo;
	private String customerPancardNo;
	private LocalDate customerDob;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "houseNo")
	private Address address;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ifscCode")
	private Bank bank;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Account> account;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhoneNo() {
		return customerPhoneNo;
	}

	public void setCustomerPhoneNo(String customerPhoneNo) {
		this.customerPhoneNo = customerPhoneNo;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	public String getCustomerAdhaarNo() {
		return customerAdhaarNo;
	}

	public void setCustomerAdhaarNo(String customerAdhaarNo) {
		this.customerAdhaarNo = customerAdhaarNo;
	}

	public String getCustomerPancardNo() {
		return customerPancardNo;
	}

	public void setCustomerPancardNo(String customerPancardNo) {
		this.customerPancardNo = customerPancardNo;
	}

	public LocalDate getCustomerDob() {
		return customerDob;
	}

	public void setCustomerDob(LocalDate customerDob) {
		this.customerDob = customerDob;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}
}
