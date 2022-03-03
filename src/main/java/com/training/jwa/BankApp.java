package com.training.jwa;

import java.util.Scanner;
import com.training.jwa.dao.LoginDAO;
import com.training.jwa.dao.LoginDAOImpl;
import com.training.jwa.dao.CustomerDAOImpl;
import com.training.jwa.dao.EmployeeDAO;
import com.training.jwa.dao.EmployeeDAOImpl;
import com.training.jwa.model.Bank;
import com.training.jwa.model.Customer;
import com.training.jwa.model.Employee;
import com.training.jwa.model.Login;

public class BankApp {

	Scanner scanner = new Scanner(System.in);
	int choice = 0;
	LoginDAO loginDAO = new LoginDAOImpl();
	Login login = new Login();
	customerMenu cMenu = new customerMenu();
	employeeMenu eMenu = new employeeMenu();
	boolean result;
	//EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	//CustomerDAO customerDAO = new CustomerDAOImpl();

	public void startBankApp() {
		//int accountNum = 0;
		//double accountBalance = 0;
		//double amount = 0;
		String username;
		String password;
		boolean employee;
		//boolean customer;
		
		while (true) {
			System.out.println("BANK  -  HOME PAGE");
			System.out.println("===================================================================================");
			System.out.println("1. Add User ");
			System.out.println("2. Login ");
			
			System.out.println("Please enter your choice : ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Please enter a Username");
				username = scanner.next();
				System.out.println("Please enter a Password");
				password = scanner.next();
				//System.out.println("are you an employee? True/False");
				//employee = scanner.nextBoolean();
				Login login = new Login(username, password);
				result = loginDAO.register(login);
				if(result) {
					System.out.println("You have registered " + username + " successfully");
				} else {
					System.out.println("Your registration was unsuccessful");
				}
				break;

			case 2:
				System.out.println("Please enter a Username");
				username = scanner.next();
				System.out.println("Please enter a Password");
				password = scanner.next();
				if(loginDAO.validate(username, password)) {
					System.out.println("Login successful");
				} else {
					System.out.println("username or password doesn't exist");
				}
				if(loginDAO.checkEmployee(username)) {
					//employee account exists;
					eMenu.EmployeeMenu();
				}else if (loginDAO.checkCustomer(username)) {
					//customer account exists;
					cMenu.CustomerMenu();
				}else {}
				break;

			default:
				System.out.println("Invalid Choice ");
				break;
			}			
		}
	}
}
		
