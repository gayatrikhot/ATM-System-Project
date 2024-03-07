package com.priyanka.atm.presentation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.priyanka.atm.dao.MyConnection;
import com.priyanka.atm.entity.Account;
import com.priyanka.atm.entity.Address;
import com.priyanka.atm.entity.Bank;
import com.priyanka.atm.entity.Card;
import com.priyanka.atm.entity.Customer;
import com.priyanka.atm.entity.Transaction;

public class DummyData {
	public static void insert(String[] args) {
		EntityManager entityManager = MyConnection.getEntityManger();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Bank bank1 = new Bank();
		bank1.setBankName("Bank of Maharashtra");
		bank1.setBranchCode("1072");
		bank1.setIfscCode("MAHB0001072");

		Bank bank2 = new Bank();
		bank2.setBankName("State Bank of India");
		bank2.setBranchCode("7157");
		bank2.setIfscCode("SBIN0000317");

		Bank bank3 = new Bank();
		bank3.setBankName("Bank of Baroda");
		bank3.setBranchCode("BARAMA");
		bank3.setIfscCode("BARBOBARAMA");

		Bank bank4 = new Bank();
		bank4.setBankName("Indian Bank");
		bank4.setBranchCode("3002");
		bank4.setIfscCode("IDID000R115");

		Customer customer1 = new Customer();
		customer1.setCustomerId("10185462113");
		customer1.setCustomerName("Gayatri Khot");
		customer1.setCustomerPhoneNo("9322800430");
		customer1.setCustomerEmail("gayatrikhot912@gmail.com");
		customer1.setCustomerGender("female");
		customer1.setCustomerAdhaarNo("6086 0506 4486");
		customer1.setCustomerPancardNo("KRJPK2158B");
		customer1.setCustomerDob(LocalDate.of(2002, 11, 9));
		customer1.setBank(bank1);

		Customer customer2 = new Customer();
		customer2.setCustomerId("88750027025");
		customer2.setCustomerName("Sana Patel");
		customer2.setCustomerPhoneNo("7620801222");
		customer2.setCustomerEmail("sanapatel152003@gmail.com");
		customer2.setCustomerGender("female");
		customer2.setCustomerAdhaarNo("6798 6486 5366");
		customer2.setCustomerPancardNo("OTEPS0133P");
		customer2.setCustomerDob(LocalDate.of(2003, 06, 15));
		customer2.setBank(bank2);

		Customer customer3 = new Customer();
		customer3.setCustomerId("MV3063207");
		customer3.setCustomerName("Bhavika Holkar");
		customer3.setCustomerPhoneNo("9307021346");
		customer3.setCustomerEmail("bhavikaholkar15@gmail.com");
		customer3.setCustomerGender("female");
		customer3.setCustomerAdhaarNo("5824 6943 9388");
		customer3.setCustomerPancardNo("BLMPH4436D");
		customer3.setCustomerDob(LocalDate.of(2002, 01, 12));
		customer3.setBank(bank3);

		Customer customer4 = new Customer();
		customer4.setCustomerId("30490019188");
		customer4.setCustomerName("Gayatri Hampe");
		customer4.setCustomerPhoneNo("8605963855");
		customer4.setCustomerEmail("gayatrihampe2703@gmail.com");
		customer4.setCustomerGender("female");
		customer4.setCustomerAdhaarNo("3550 8047 5445");
		customer4.setCustomerPancardNo("AMBPH9922P");
		customer4.setCustomerDob(LocalDate.of(2003, 03, 27));
		customer4.setBank(bank4);

		Customer customer5 = new Customer();
		customer5.setCustomerId("88751266906");
		customer5.setCustomerName("Priyanka Khuspe");
		customer5.setCustomerPhoneNo("9561769654");
		customer5.setCustomerEmail("priyankakhuspe09@gmail.com");
		customer5.setCustomerGender("female");
		customer5.setCustomerAdhaarNo("6245 1271 9860");
		customer5.setCustomerPancardNo("KHAPK9278L");
		customer5.setCustomerDob(LocalDate.of(2002, 9, 9));
		customer5.setBank(bank2);

		List<Customer> cust1 = List.of(customer1);
		List<Customer> cust2 = List.of(customer2);
		List<Customer> cust3 = List.of(customer3);
		List<Customer> cust4 = List.of(customer4);
		List<Customer> cust5 = List.of(customer5);

		bank1.setCustomer(cust1);
		bank2.setCustomer(cust2);
		bank3.setCustomer(cust3);
		bank4.setCustomer(cust4);
		bank2.setCustomer(cust5);

		Account account1 = new Account();
		account1.setAccountNo("68023321739");
		account1.setAccountType("Savings");
		account1.setAccountOpeningDate(LocalDate.of(2017, 9, 21));
		account1.setAccountStatus("Active");
		account1.setAccountBalance(90000.60);
		account1.setCustomer(customer1);

		List<Transaction> t1 = null;

		account1.setTransaction(t1);

		Account account2 = new Account();
		account2.setAccountNo("35305486358");
		account2.setAccountType("Savings");
		account2.setAccountOpeningDate(LocalDate.of(2015, 05, 01));
		account2.setAccountStatus("Active");
		account2.setAccountBalance(50000.50);
		account2.setCustomer(customer2);

		List<Transaction> t2 = null;
		account2.setTransaction(t2);

		Account account3 = new Account();
		account3.setAccountNo("98720100016");
		account3.setAccountType("Savings");
		account3.setAccountOpeningDate(LocalDate.of(2021, 9, 03));
		account3.setAccountStatus("Active");
		account3.setAccountBalance(20000.40);
		account3.setCustomer(customer3);

		List<Transaction> t3 = null;
		account3.setTransaction(t3);

		Account account4 = new Account();
		account4.setAccountNo("72794519779");
		account4.setAccountType("Savings");
		account4.setAccountOpeningDate(LocalDate.of(2022, 8, 29));
		account4.setAccountStatus("Active");
		account4.setAccountBalance(123000.40);
		account4.setCustomer(customer4);

		List<Transaction> t4 = null;
		account4.setTransaction(t4);

		Account account5 = new Account();
		account5.setAccountNo("35309412248");
		account5.setAccountType("Savings");
		account5.setAccountOpeningDate(LocalDate.of(2015, 11, 06));
		account5.setAccountStatus("Active");
		account5.setAccountBalance(40000.20);
		account5.setCustomer(customer5);

		List<Transaction> t5 = null;
		account5.setTransaction(t5);

		Account account6 = new Account();
		account6.setAccountNo("23230943481");
		account6.setAccountType("Current");
		account6.setAccountOpeningDate(LocalDate.of(2020, 10, 07));
		account6.setAccountStatus("Active");
		account6.setAccountBalance(50000.20);
		account6.setCustomer(customer1);

		List<Transaction> t6 = null;
		account6.setTransaction(t6);

		Account account7 = new Account();
		account7.setAccountNo("45061000273");
		account7.setAccountType("Current");
		account7.setAccountOpeningDate(LocalDate.of(2019, 03, 25));
		account7.setAccountStatus("Active");
		account7.setAccountBalance(35000.50);
		account7.setCustomer(customer2);

		List<Transaction> t7 = null;
		account7.setTransaction(t7);

		List<Account> acc1 = List.of(account1, account6);
		customer1.setAccount(acc1);

		List<Account> acc2 = List.of(account3);
		customer2.setAccount(acc2);

		List<Account> acc3 = List.of(account4);
		customer3.setAccount(acc3);

		List<Account> acc4 = List.of(account5);
		customer4.setAccount(acc4);

		List<Account> acc5 = List.of(account2, account7);
		customer5.setAccount(acc5);

		Card card1 = new Card();
		card1.setCardId("6521550008648330");
		card1.setCardStatus("Active");
		card1.setCardType("ATM");
		DateTimeFormatter issueDate = DateTimeFormatter.ofPattern("MM/yy");
		String iDate = LocalDateTime.of(2020, 10, 01, 01, 01).format(issueDate);
		card1.setCardIssueDate(iDate);
		DateTimeFormatter currentTime = DateTimeFormatter.ofPattern("MM/yy");
		String formatDateTime = LocalDateTime.of(2026, 05, 01, 01, 01).format(currentTime);
		card1.setCardExpiryDate(formatDateTime);
		card1.setCardCvv(172);
		card1.setCardPin("4510");
		card1.setAccount(account1);

		Card card2 = new Card();
		card2.setCardId("6522950722201046");
		card2.setCardStatus("Active");
		card2.setCardType("ATM");
		issueDate = DateTimeFormatter.ofPattern("MM/yy");
		iDate = LocalDateTime.of(2023, 9, 01, 01, 01).format(issueDate);
		card2.setCardIssueDate(iDate);
		currentTime = DateTimeFormatter.ofPattern("MM/yy");
		formatDateTime = LocalDateTime.of(2028, 07, 01, 01, 01).format(currentTime);
		card2.setCardExpiryDate(formatDateTime);
		card2.setCardCvv(856);
		card2.setCardPin("3020");
		card2.setAccount(account2);

		List<Card> cardd2 = List.of(card2);
		account2.setCard(cardd2);

		Card card3 = new Card();
		card3.setCardId("5110646527978688");
		card3.setCardStatus("Active");
		card3.setCardType("Debit");
		issueDate = DateTimeFormatter.ofPattern("MM/yy");
		iDate = LocalDateTime.of(2021, 8, 01, 01, 01).format(issueDate);
		card3.setCardIssueDate(iDate);
		currentTime = DateTimeFormatter.ofPattern("MM/yy");
		formatDateTime = LocalDateTime.of(2026, 8, 01, 01, 01).format(currentTime);
		card3.setCardExpiryDate(formatDateTime);
		card3.setCardCvv(858);
		card3.setCardPin("1202");
		card3.setAccount(account3);

		List<Card> cardd3 = List.of(card3);
		account3.setCard(cardd3);

		Card card4 = new Card();
		card4.setCardId("2468951345798865");
		card4.setCardStatus("Active");
		card4.setCardType("Debit");
		issueDate = DateTimeFormatter.ofPattern("MM/yy");
		iDate = LocalDateTime.of(2023, 7, 01, 01, 01).format(issueDate);
		card4.setCardIssueDate(iDate);
		currentTime = DateTimeFormatter.ofPattern("MM/yy");
		formatDateTime = LocalDateTime.of(2029, 05, 01, 01, 01).format(currentTime);
		card4.setCardExpiryDate(formatDateTime);
		card4.setCardCvv(458);
		card4.setCardPin("3232");
		card4.setAccount(account4);

		List<Card> cardd4 = List.of(card4);
		account4.setCard(cardd4);

		Card card5 = new Card();
		card5.setCardId("4838341005121157");
		card5.setCardStatus("Active");
		card5.setCardType("Debit");
		issueDate = DateTimeFormatter.ofPattern("MM/yy");
		iDate = LocalDateTime.of(2022, 1, 01, 01, 01).format(issueDate);
		card5.setCardIssueDate(iDate);
		currentTime = DateTimeFormatter.ofPattern("MM/yy");
		formatDateTime = LocalDateTime.of(2028, 12, 01, 01, 01).format(currentTime);
		card5.setCardExpiryDate(formatDateTime);
		card5.setCardCvv(648);
		card5.setCardPin("6402");
		card5.setAccount(account5);

		List<Card> cardd5 = List.of(card5);
		account5.setCard(cardd5);

		Card card6 = new Card();
		card6.setCardId("3456210234088688");
		card6.setCardStatus("Active");
		card6.setCardType("Debit");
		issueDate = DateTimeFormatter.ofPattern("MM/yy");
		iDate = LocalDateTime.of(2020, 8, 01, 01, 01).format(issueDate);
		card6.setCardIssueDate(iDate);
		currentTime = DateTimeFormatter.ofPattern("MM/yy");
		formatDateTime = LocalDateTime.of(2025, 8, 01, 01, 01).format(currentTime);
		card6.setCardExpiryDate(formatDateTime);
		card6.setCardCvv(678);
		card6.setCardPin("3082");
		card6.setAccount(account1);

		List<Card> list4 = List.of(card1, card6);
		account1.setCard(list4);

		Card card7 = new Card();
		card7.setCardId("6875678397978688");
		card7.setCardStatus("Active");
		card7.setCardType("Debit");
		issueDate = DateTimeFormatter.ofPattern("MM/yy");
		iDate = LocalDateTime.of(2020, 3, 01, 01, 01).format(issueDate);
		card7.setCardIssueDate(iDate);
		currentTime = DateTimeFormatter.ofPattern("MM/yy");
		formatDateTime = LocalDateTime.of(2025, 07, 01, 01, 01).format(currentTime);
		card7.setCardExpiryDate(formatDateTime);
		card7.setCardCvv(124);
		card7.setCardPin("6463");
		card7.setAccount(account6);

		List<Card> list5 = List.of(card3, card7);
		account3.setCard(list5);

		Address address1 = new Address();
		address1.setHouseNo(120);
		address1.setHouseName("Akashdeep Housing Society");
		address1.setPincode("411018");
		customer1.setAddress(address1);

		Address address2 = new Address();
		address2.setHouseNo(131);
		address2.setHouseName("NDurwankur");
		address2.setPincode("413602");
		customer2.setAddress(address2);

		Address address3 = new Address();
		address3.setHouseNo(202);
		address3.setHouseName("VaradVinayak Society");
		address3.setPincode("413102");
		customer3.setAddress(address3);

		Address address4 = new Address();
		address4.setHouseNo(127);
		address4.setHouseName("Binawat Township");
		address4.setPincode("411033");
		customer4.setAddress(address4);

		Address address5 = new Address();
		address5.setHouseNo(503);
		address5.setHouseName("Nisarga Classic");
		address5.setPincode("411028");
		customer5.setAddress(address5);

		entityTransaction.begin();
		entityManager.persist(bank1);
		entityManager.persist(bank2);
		entityManager.persist(bank3);
		entityManager.persist(bank4);
		entityTransaction.commit();

		System.out.println("Details entered");
	}
}
