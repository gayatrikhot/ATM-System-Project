package com.priyanka.atm.dao;

import com.priyanka.atm.entity.Account;
import com.priyanka.atm.entity.Transaction;

public interface AccountDao 
{
	public String updateBalance(Account account, Double newBalance);
	
	public Transaction createTransaction(Account account, String type, Double Tamount);
}
