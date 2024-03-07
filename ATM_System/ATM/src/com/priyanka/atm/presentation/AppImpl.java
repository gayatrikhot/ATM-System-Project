package com.priyanka.atm.presentation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.priyanka.atm.entity.Account;
import com.priyanka.atm.entity.Card;
import com.priyanka.atm.entity.Transaction;
import com.priyanka.atm.service.AccountService;
import com.priyanka.atm.service.AccountServiceImpl;
import com.priyanka.atm.service.CardService;
import com.priyanka.atm.service.CardServiceImpl;
import com.priyanka.atm.validation.MyValidation;

public class AppImpl implements App {
	Scanner sc = new Scanner(System.in);
	MyValidation check = new MyValidation();
	CardService cardService = new CardServiceImpl();
	static String cardNo;
	Double dailyL = 20000D;

	public static Card cardReceived;
	AccountService accountService = new AccountServiceImpl();

	@Override
	public Card findCard() {
		System.out.print("\tEnter the Card number:\n\t");
		cardNo = sc.next();
		while (!(check.checkCardNo(cardNo))) {
			System.out.print("\tEnter the Card number again :\n\t");
			cardNo = sc.next();
		}

		Card card = cardService.findCardNo(cardNo);

		while (card == null) {
			System.out.print("\n\tEnter the Card number again: \n\t");
			cardNo = sc.next();
			while (!(check.checkCardNo(cardNo))) {
				System.out.print("\tEnter the Card number again :\n\t");
				cardNo = sc.next();
			}
			card = cardService.findCardNo(cardNo);
		}
		cardReceived = card;

		if (card.getCardStatus().equals("Blocked")) {
			System.out.println("\tYour card is blocked. Please contact the bank for more details!\n");
			return null;
		}

		System.out.print("\tEnter card pin:\n\t");
		String cpin = sc.next();
		Integer i = 1;

		while (!(check.checkCardPin(cpin))) {
			if (i >= 3) {
				System.out.println("\tToo many invalid attempts, your card is blocked!");
				System.out.println("\tPlease contact the bank for more details!");
				card.setCardStatus("Blocked");
				cardService.updateCardStatus(card);
				return null;
			}
			System.out.print("\tEnter card pin again:\n\t");
			cpin = sc.next();
			i++;
		}

		while (!cpin.equals(card.getCardPin())) {
			if (i >= 3) {
				System.out.println("\tToo many invalid attempts, your card is blocked!");
				System.out.println("\tPlease contact the bank for more details!");
				card.setCardStatus("Blocked");
				cardService.updateCardStatus(card);
				return null;
			}
			System.out.print("\tIncorrect pin, enter again\n\t");
			cpin = sc.next();
			i++;
			while (!(check.checkCardPin(cpin))) {
				System.out.print("\tEnter card pin again:\n\t");
				cpin = sc.next();
				i++;
			}
		}
		return card;
	}

	@Override
	public void updateCardPin(Card card) {
		System.out.print("\tEnter previous pin: \n\t");
		String ppin = sc.next();

		while (!(ppin.equals(card.getCardPin()))) {
			System.out.print("\tWrong pin \n\t");
			ppin = sc.next();
		}

		System.out.print("\tEnter new pin: \n\t");
		String npin = sc.next();

		while (npin.equals(ppin)) {
			System.out.print("\tNew pin cannot be same as previous pin!\n\tPlease try again!\n\t");
			npin = sc.next();
		}

		while (!(check.checkCardPin(npin))) {
			if (npin.equals(ppin)) {
				System.out.print("\tNew pin cannot be same as previous pin!\n\tPlease try again!\n\t");
			} else {
				System.out.print("\tPlease enter a valid pin! \n\t");
			}
			npin = sc.next();
		}

		System.out.print("\tConfirm pin: \n\t");
		String confirmPin = sc.next();
		if (!(npin.contentEquals(confirmPin))) {
			System.out.println("\tWrong pin \n\tCould not update pin please try again later");
		} else {
			card.setCardPin(npin);
			cardService.updateCardPin(card, npin);
			System.out.println("\tCard pin updated");
		}
	}

	public void generateReceipt(Card card, Transaction t) {
		System.out.print("\tDo you want a receipt(y/n)\n\t");
		String receipt = sc.next();

		if (receipt.equalsIgnoreCase("y")) {
			System.out.println("\n\n\n\t\t\t\t\t\t\t| ---------------------------------------- |");
			System.out.println("\t\t\t\t\t\t\t| \tATM Transaction Receipt            |");
			System.out.println("\t\t\t\t\t\t\t| ---------------------------------------- |");
			System.out.println("\t\t\t\t\t\t\t \n \t\t\t\t\t\t\t Transaction id     : " + t.getTransationId());
			System.out.println("\t\t\t\t\t\t\t Date and Time      : " + t.getTransactionDateTime());
			System.out
					.println("\t\t\t\t\t\t\t Card Number        : " + card.getCardId().substring(0, 4) + "xxxxxxxxxxx");
			System.out.println(
					"\t\t\t\t\t\t\t Customer Name      : " + card.getAccount().getCustomer().getCustomerName());
			System.out.println("\t\t\t\t\t\t\t Transaction amount : " + t.getTransactionAmount());
			System.out.println("\t\t\t\t\t\t\t Transaction type   : " + t.getTransctionType());
			System.out.println("\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t Available Balance : Rs."
					+ Math.round(card.getAccount().getAccountBalance()));
			System.out.println(
					"\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t Thank you for visiting, visit again!    \n\t\t\t\t\t\t\t---------------------------------------------\n");
		} else {
			System.out.println("\tThank you for visiting, visit again!\n");
		}
	}

	@Override
	public void withdrawCash(Account account) {
		System.out.print("\tEnter the amount you wish to withdraw \n\t");
		String withdrawAmount = sc.next();

		while ((!(check.checkInputAmount(withdrawAmount)))) {
			System.out.print("\tEnter again: \n\t");
			withdrawAmount = sc.next();
		}

		Double wAmount = Double.parseDouble(withdrawAmount);
		while (accountService.withdrawAmount(wAmount, account) == null) {
			System.out.print("\tInsufficient balance!\n\tEnter again: \n\t");
			withdrawAmount = sc.next();

			while ((!(check.checkInputAmount(withdrawAmount)))) {
				System.out.print("\tEnter again: \n\t");
				withdrawAmount = sc.next();
			}
			wAmount = Double.parseDouble(withdrawAmount);
		}
		Transaction t = accountService.createTransaction(account, "DR", wAmount);
		generateReceipt(cardReceived, t);

		System.out.println("\tAmount withdrawn successfully!");
	}

	@Override
	public void depositCash(Account account) {
		System.out.print("\n\tEnter the amount you wish to deposit \n\t");
		String depositAmount = sc.next();

		while (!(check.checkInputAmount(depositAmount))) {
			System.out.print("\tEnter again: \n\t");
			depositAmount = sc.next();
		}
		Double dAmount = Double.parseDouble(depositAmount);

		accountService.depositAmount(dAmount, account);
		Transaction t = accountService.createTransaction(account, "CR", dAmount);
		generateReceipt(cardReceived, t);

		System.out.println("\tAmount deposited!");
	}

	@Override
	public void checkBalance(Account account) {
		Double balance = account.getAccountBalance();
		System.out.println("\t------------------------------------------");
		System.out.print("\t Your account balance is: Rs." + Math.round(balance));
		System.out.println("\n\t------------------------------------------");
	}

	@Override
	public void getMiniStatement(Card card) {
		Account account = card.getAccount();
		List<Transaction> transactions = account.getTransaction();
		Iterator<Transaction> itr = transactions.iterator();

		if (transactions.isEmpty()) {
			System.out.println("\tNo transaction history");
			return;
		}

		DateTimeFormatter currentTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		String formatDateTime = LocalDateTime.now().format(currentTime);
		System.out.println("\n\t\t\t\t\t\t\t\tDate : " + formatDateTime);

		String accNo = account.getAccountNo();
		String cardNo = card.getCardId();
		System.out.println("\n\t\t\t\t\t\t\t\tAccount number : " + accNo.substring(0, 4) + "********");
		System.out.println("\t\t\t\t\t\t\t\tCard no : " + cardNo.substring(0, 4) + "************\n");

		System.out.println("\n\t\t\t\t\t\t------------------------------------------------------------------------");
		System.out.println("\t\t\t\t\t\t\t\t\t  MINI  STATEMENT            ");
		System.out.println("\t\t\t\t\t\t------------------------------------------------------------------------\n");
		System.out.println("\t\t\t\t\t\tTransaction Id \t\t Date \t\t\tType \t\t Amount\n");

		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

		Integer i = 10;
		while (itr.hasNext() && i > 0) {
			Transaction t = itr.next();
			String transactionDate = t.getTransactionDateTime().formatted(format);
			System.out.println("\t\t\t\t\t\t" + t.getTransationId() + "\t\t" + transactionDate + "\t"
					+ t.getTransctionType() + "\t\t" + t.getTransactionAmount());
			i--;
		}
		System.out.println("\n\t\t\t\t\t\t-------------------------------------------------------------------------");
	}
}
