package com.priyanka.atm.presentation;

import com.priyanka.atm.entity.Account;
import com.priyanka.atm.entity.Card;
import com.priyanka.atm.entity.Transaction;

public interface App 
{
	public Card findCard();
	public void updateCardPin(Card card); 
	public void generateReceipt(Card card, Transaction t);
	public void withdrawCash(Account account);
	public void depositCash(Account account);
	public void checkBalance(Account account);
	public void getMiniStatement(Card card);
}
