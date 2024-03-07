package com.priyanka.atm.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.priyanka.atm.entity.Account;
import com.priyanka.atm.entity.Transaction;

public class AccountDaoImpl implements AccountDao {
	EntityManager entityManager = MyConnection.getEntityManger();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	@Override
	public String updateBalance(Account account, Double newBalance) {
		account.setAccountBalance(newBalance);
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(account);
		entityTransaction.commit();

		return "Balance updated";
	}

	@Override
	public Transaction createTransaction(Account account, String type, Double Tamount) {
		String tId = "ATM" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd"))
				+ (int) (Math.random() * 1000) + LocalDateTime.now().format(DateTimeFormatter.ofPattern("ss"))
				+ (int) (Math.random() * 100);
		String tType = type;
		Double aAmount = Tamount;

		String DateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));

		Transaction t = new Transaction();

		t.setTransationId(tId);
		t.setTransctionType(tType);
		t.setTransactionAmount(aAmount);
		t.setTransactionDateTime(DateTime);
		t.setAccount(account);

		List<Transaction> transactions = List.of(t);
		EntityTransaction entityTransaction = entityManager.getTransaction();

		account.setTransaction(transactions);

		entityTransaction.begin();
		entityManager.persist(account);
		entityTransaction.commit();

		return t;
	}
}
