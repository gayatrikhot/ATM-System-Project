package com.priyanka.atm.service;

import com.priyanka.atm.dao.AccountDao;
import com.priyanka.atm.dao.AccountDaoImpl;
import com.priyanka.atm.entity.Account;
import com.priyanka.atm.entity.Transaction;

public class AccountServiceImpl implements AccountService {

	AccountDao accountDao = new AccountDaoImpl();

	@Override
	public String updateBalance(Account account, Double newBalance) {
		return accountDao.updateBalance(account, newBalance);
	}

	@Override
	public Transaction createTransaction(Account account, String type, Double Tamount) {
		return accountDao.createTransaction(account, type, Tamount);
	}

	@Override
	public String withdrawAmount(Double amount, Account account) {
		if (amount < account.getAccountBalance() && amount % 100 == 0) {
			Double newBalance = (account.getAccountBalance()) - (amount);
			account.setAccountBalance(newBalance);
			accountDao.updateBalance(account, newBalance);
			return "Successful";
		}
		return null;
	}

	@Override
	public String depositAmount(Double amount, Account account) {
		Double newBalance = (account.getAccountBalance()) + (amount);
		account.setAccountBalance(newBalance);
		accountDao.updateBalance(account, newBalance);
		return "Successful";
	}

}
