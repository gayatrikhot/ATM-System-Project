package com.priyanka.atm.dao;

import com.priyanka.atm.entity.Card;

public interface CardDao 
{
	public Card findCardNo(String cardNo) ;

	public String updateCardStatus(Card card);
	
	public String updateCardPin(Card card, String npin);
}
