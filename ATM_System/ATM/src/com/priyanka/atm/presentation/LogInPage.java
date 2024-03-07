package com.priyanka.atm.presentation;

import java.util.Scanner;

import com.priyanka.atm.entity.Account;
import com.priyanka.atm.entity.Card;

public class LogInPage {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		App app = new AppImpl();
		String choice;

		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t\t\t\t--------------------------------------");
		System.out.println("\t\t\t\t\t\t\t\t Welcome to ATM System");
		System.out.println("\t\t\t\t\t\t\t--------------------------------------\n");
		Account account = null;
		Card card = app.findCard();
		if (card != null) {
			account = card.getAccount();
		}
		if (card != null) {
			System.out.println("\n\t\t\t\t\t\t\t\tWelcome " + card.getAccount().getCustomer().getCustomerName());
			System.out.println("\n\t\t\t\t\t\t\t\tBank : " + card.getAccount().getCustomer().getBank().getBankName());
			System.out.println("\n\t\t\t\t\t\t\t\tAccount number : "
					+ (card.getAccount().getAccountNo()).substring(0, 4) + "xxxxxxxxxxxxx");
			do {
				System.out.println("\n\n\t\t\t\t\t\t**********************************************************");
				System.out.println("\t\t\t\t\t\t*                         MENU                           *");
				System.out.println("\t\t\t\t\t\t**********************************************************\n");
				System.out.println(
						"\t\t\t\t\t\t1. Deposit cash \t\t\t4.Check balance \n\n\t\t\t\t\t\t2. Withdraw cash \t\t\t5.Mini statement \n\n\t\t\t\t\t\t3. Change Pin \t\t\t\t6. Exit");
				System.out.print("\n\n\tEnter your choice\n\t");

				choice = sc.next();
				switch (choice) {
				case "1":
					app.depositCash(account);
					System.out.println();
					break;
				case "2":
					app.withdrawCash(account);
					System.out.println();
					break;
				case "3":
					app.updateCardPin(card);
					System.out.println();
					break;
				case "4":
					app.checkBalance(account);
					System.out.println();
					break;
				case "5":
					app.getMiniStatement(card);
					System.out.println();
					break;
				case "6":
					System.out.println("\tThank you for visting.....");
					System.out.println();
					System.exit(0);
				default:
					System.out.println("\tInvalid choice");
				}
			} while (choice != "6");
		}
		sc.close();
	}
}
