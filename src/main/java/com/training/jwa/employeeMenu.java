package com.training.jwa;

import java.sql.Connection;
import java.util.Scanner;

import com.training.jwa.dao.EmployeeDAO;
import com.training.jwa.dao.EmployeeDAOImpl;
import com.training.jwa.model.Customer;
import com.training.jwa.model.Employee;
import com.training.jwa.utility.DBConnection;

public class employeeMenu {
	Scanner scanner = new Scanner(System.in);
	int choice = 0;
	EmployeeDAO empDAO = new EmployeeDAOImpl();
	//Employee emp = new Employee(true, 0, null, null, 0, 0);
	//Customer cust = new Customer(false, 0, null, null, 0, 0, 0);

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
	
				System.out.println("Please enter account username to approve account?");
				String username = scanner.next();
				//Customer customer = null;
				//empDAO.accountApproval(username);
				boolean status = empDAO.accountApproval(username);
				if(status) {
					System.out.println("Update Successful");
				} else {
					System.out.println("Update Unsuccessful");
				}
				break;

			case 2:
				System.out.println("Please enter the account you would like to view?");
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
