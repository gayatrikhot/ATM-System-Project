package com.priyanka.atm.service;

import com.priyanka.atm.dao.CardDao;
import com.priyanka.atm.dao.CardDaoImpl;
import com.priyanka.atm.entity.Card;

public class CardServiceImpl implements CardService {
	CardDao cardDao = new CardDaoImpl();

	@Override
	public Card findCardNo(String cardNo) {
		Card c = cardDao.findCardNo(cardNo);

		if (c == null) {
			System.out.println("\tCard not found");
			return null;
		}
		return c;
	}

	@Override
	public String updateCardStatus(Card card) {
		return cardDao.updateCardStatus(card);
	}

	@Override
	public String updateCardPin(Card card, String npin) {
		return cardDao.updateCardPin(card, npin);
	}
}
