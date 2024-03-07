package com.priyanka.atm.validation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.priyanka.atm.dao.CardDao;
import com.priyanka.atm.dao.CardDaoImpl;

public class MyValidation {
	CardDao cardDao = new CardDaoImpl();
	Scanner sc = new Scanner(System.in);

	public Boolean checkInputTypeInt(String value) {
		for (int i = 0; i < value.length(); i++) {
			if ((value.charAt(i) >= 65 && value.charAt(i) <= 90) || (value.charAt(i) >= 97 && value.charAt(i) <= 122)) {
				System.out.print("\n\tYou cannot enter characters\n");
				return false;
			} else if (!(value.charAt(i) >= 48 && value.charAt(i) <= 57) && value.charAt(0) != '-') {
				System.out.print("\n\tYou cannot enter symbols.\n");
				return false;
			}
		}
		return true;
	}

	public Boolean checkCardNo(String cardNo) {

		if (cardNo.matches("\\d{16}")) {
			return true;
		} else {
			if (cardNo.charAt(0) == '-') {
				System.out.println("\tCard number cannot be negative!\n");
				return false;
			}
			if (!checkInputTypeInt(cardNo)) {
				return false;
			}
			if (cardNo.length() < 16) {
				System.out.println("\tCard number should not be less than 16 digits!\n");
			} else if (cardNo.length() > 16) {
				System.out.println("\tCard number should not be greater than 16 digits!\n");
			}

			return false;
		}
	}

	public Boolean checkExpiry() {
		return true;
	}

	public Boolean checkCardPin(String cpin) {
		if (cpin.matches("\\d{4}")) {
			return true;
		} else {
			if (cpin.charAt(0) == '-') {
				System.out.println("\tCard pin cannot be negative!\n");
				return false;
			}
			if (!checkInputTypeInt(cpin)) {
				return false;
			}
			if (cpin.length() < 4) {
				System.out.println("\tCard pin should not be less than 4 digits!\n");
			} else if (cpin.length() > 4) {
				System.out.print("\tCard pin should not be greater than 4 digits!\n");
			}
			return false;
		}
	}

	public Boolean checkInputAmount(String amount) {
		String regex = "[+-]?[0-9]+";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(amount);

		if (!checkInputTypeInt(amount)) {
			return false;
		} else if (m.find() && m.group().equals(amount)) {
			Double Amount = Double.parseDouble(amount);
			if (Amount < 0) {
				System.out.print("\n\tAmount cannot be negative! \n");
				return false;
			} else if (Amount == 0) {
				System.out.println("\n\tAmount cannot be 0! \n");
				return false;
			} else if (Amount % 100 != 0) {
				System.out.print("\n\tPlease enter amount in multiples of 100\n");
				return false;
			}

			if (Amount > 10000) {
				System.out.print("\tYou cannot withdraw/deposit amount greater than Rs. 10,000 at a time.\n");
				return false;
			}
		}
		return true;
	}
}
