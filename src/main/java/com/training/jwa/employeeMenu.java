package com.training.jwa;

import java.util.Scanner;

import com.training.jwa.dao.LoginDAO;
import com.training.jwa.dao.LoginDAOImpl;
import com.training.jwa.model.Login;

public class employeeMenu {
	Scanner scanner = new Scanner(System.in);
	int choice = 0;
	LoginDAO loginDAO = new LoginDAOImpl();
	Login login = new Login();

	public void EmployeeMenu() {
		
		while (true) {
			System.out.println("BANK  -  EMPLOYEE MENU");
			System.out.println("===================================================================================");
			System.out.println("1. Approve or Reject an account");
			System.out.println("2. View a Customer's accounts");
			System.out.println("3. View a log of past transactions");
			System.out.println("4. EXIT");

			System.out.println("Please enter your choice : ");
			choice = scanner.nextInt();
			
			//while(true){
			switch (choice) {
			case 1:
				//System.out.println("Would you like to approve or reject " + customerName + "account");
				break;

			case 2:
				//System.out.println("View " + customerName + " account");
				break;

			case 3:
				//System.out.println("print log of " + customerName + "past transactions");
				break;

			case 4:
				System.out.println("Thanks for banking with us");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid Choice, Please enter (1-3) or 4 to EXIT");
				break;
			}
		}
	}
}
