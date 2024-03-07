package com.priyanka.atm.service;

import com.priyanka.atm.entity.Account;
import com.priyanka.atm.entity.Transaction;

public interface AccountService {
	public String updateBalance(Account account, Double newBalance);

	public Transaction createTransaction(Account account, String type, Double Tamount);

	public String withdrawAmount(Double amount, Account account);

	public String depositAmount(Double amount, Account account);
}
