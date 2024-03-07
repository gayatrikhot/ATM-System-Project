package com.priyanka.atm.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Card 
{
	@Id
	private String cardId;
	private String cardType;
	private Integer cardCvv;
	private String cardStatus;
	private String cardPin;
	private String cardIssueDate;
	private String cardExpiryDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "accountNo")
	private Account account;

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Integer getCardCvv() {
		return cardCvv;
	}

	public void setCardCvv(Integer cardCvv) {
		this.cardCvv = cardCvv;
	}

	public String getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}

	public String getCardPin() {
		return cardPin;
	}

	public void setCardPin(String cardPin) {
		this.cardPin = cardPin;
	}

	public String getCardIssueDate() {
		return cardIssueDate;
	}

	public void setCardIssueDate(String cardIssueDate) {
		this.cardIssueDate = cardIssueDate;
	}

	public String getCardExpiryDate() {
		return cardExpiryDate;
	}

	public void setCardExpiryDate(String cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
