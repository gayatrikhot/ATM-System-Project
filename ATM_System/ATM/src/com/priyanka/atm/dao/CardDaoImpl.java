package com.priyanka.atm.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.priyanka.atm.entity.Card;

public class CardDaoImpl implements CardDao {
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;

	public CardDaoImpl() {
		entityManager = MyConnection.getEntityManger();
		entityTransaction = entityManager.getTransaction();
	}

	@Override
	public Card findCardNo(String cardNo) {
		return entityManager.find(Card.class, cardNo);
	}

	@Override
	public String updateCardStatus(Card card) {
		card.setCardStatus("Blocked");

		entityTransaction.begin();
		entityManager.persist(card);
		entityTransaction.commit();
		return "Updated";
	}

	@Override
	public String updateCardPin(Card card, String npin) {
		card.setCardPin(npin);

		entityTransaction.begin();
		entityManager.persist(card);
		entityTransaction.commit();

		return "Card Pin updated";
	}
}
