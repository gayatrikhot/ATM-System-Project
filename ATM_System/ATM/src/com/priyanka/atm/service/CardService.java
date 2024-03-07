package com.priyanka.atm.service;

import com.priyanka.atm.entity.Card;

public interface CardService 
{
	public Card findCardNo(String cardNo);
	
	public String updateCardStatus(Card card);
	
	public String updateCardPin(Card card, String npin); 
}
