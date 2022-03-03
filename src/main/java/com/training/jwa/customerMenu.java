package com.training.jwa;

import java.util.Scanner;

import com.training.jwa.dao.CustomerDAO;
import com.training.jwa.dao.CustomerDAOImpl;
import com.training.jwa.dao.LoginDAO;
import com.training.jwa.dao.LoginDAOImpl;
import com.training.jwa.model.Customer;
import com.training.jwa.model.Login;

public class customerMenu {

	Scanner scanner = new Scanner(System.in);
	int choice = 0;
	LoginDAO loginDAO = new LoginDAOImpl();
	CustomerDAO customDAO = new CustomerDAOImpl();
	Login login = new Login();
	double accountBalance = 0;
	int customerId = 0;
	String customerName = "";
	String customerPassword = "";

	public void CustomerMenu() {
	while (true) {
	System.out.println("BANK  -  CUSTOMER MENU");
	System.out.println("===================================================================================");
	System.out.println("1. View current balance of Customer Accounts");
	System.out.println("2. Make a withdrawal from Customer's Account");
	System.out.println("3. Make a deposit to Customer's Account");
	System.out.println("4. Transfer money to an Account");
	System.out.println("5. Transfer money from an Account");
	System.out.println("6. EXIT");
	
	System.out.println("Please enter your choice : ");
	choice = scanner.nextInt();
	
	
	switch (choice) {
	case 1:
		System.out.println("Enter the customer name to view current balance :");
		customerName = scanner.next();
		Customer cust = new Customer(customerId, customerName, customerName, accountBalance);
		cust = customDAO.viewBalance(cust);
		System.out.println(cust);
		break;

	case 2:
		System.out.println("Enter the account number to withdraw from :");
		int withdraw = scanner.nextInt();
		
		System.out.println("Enter the amount to be withdrawn :");
		//amount = scanner.nextInt();
		break;

	case 3:
		System.out.println("Enter the account number to deposit into :");
		int deposit = scanner.nextInt();
		
		System.out.println("Enter the amount to be deposited :");
		//amount = scanner.nextInt();
		break;

	case 4:
		System.out.println("Enter the account number to debit the amount :");
		int sender = scanner.nextInt();
		
		System.out.println("Enter the account number to credit the amount :");
		int receiver = scanner.nextInt();
		
		System.out.println("Enter the amount to be transferred :");
		//amount = scanner.nextInt();
		break;

	case 5:
		System.out.println("Enter the account number to debit the amount :");
		sender = scanner.nextInt();
		
		System.out.println("Enter the account number to credit the amount :");
		receiver = scanner.nextInt();
		
		System.out.println("Enter the amount to be transferred :");
		//amount = scanner.nextInt();
		break;

	case 6:
		System.out.println("Thanks for banking with us");
		System.exit(0);
		break;

	default:
		System.out.println("Invalid Choice, Please enter (1-5) or 6 to EXIT");
		break;

			}
		}
	}
}
