package com.training.jwa.dao;

import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.training.jwa.employeeMenu;
import com.training.jwa.model.Customer;
import com.training.jwa.model.Employee;
import com.training.jwa.utility.DBConnection;

public class EmployeeDAOImpl implements EmployeeDAO {
	Scanner scan = new Scanner(System.in);
	int employeeId = 0;
	String employeeName = "";
	String employeePassword = "";
	double accountBalance = 0;
	String customerName = "";
	String customerPassword = "";

	@Override
	public boolean accountApproval(String username) {
		boolean status = false;
		Connection con = DBConnection.getConnection();
		PreparedStatement statement;
		CallableStatement update;
		try {
			statement = con.prepareStatement("select * from customer where username = ?");
			statement.setString(1, username);
			ResultSet res = statement.executeQuery();
			status = res.next();
			
			System.out.println("Would you like to approve account: T/F");
			String ans = scan.next();
			
			if(ans.toUpperCase().equals("T")) {
			update = con.prepareCall("call approveAccount(?,?)");
			update.setString(1, username);
			update.registerOutParameter(2, Types.BOOLEAN);
			update.execute();
			status = true;
			}
			res.close();
			statement.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
	}
	
	

	@Override
	public Employee viewAccount(Employee employee) {
		Connection con = DBConnection.getConnection();
        PreparedStatement stat;
        
        try {
            stat= con.prepareStatement("select id, username, password, balance from customer where username= ?");
            stat.setString(1, employee.getEmployeeName());
            ResultSet res = stat.executeQuery();
            
            res.next();
            employee.setEmployeeId(res.getInt(1));
            employee.setEmployeeName(res.getString(2));
            employee.setEmployeePassword(res.getString(3));
            employee.setAccountBalance(res.getInt(4));
            
            return employee;
            
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
		
        }
		return null;
	}
	
	public Customer searchByEmployeeId(int customerId) {
		Connection con = DBConnection.getConnection();
		Customer customer = new Customer(customerId, customerName, customerPassword, accountBalance, 0);
		PreparedStatement stat;
		try {
			stat = con.prepareStatement("select id from customer where Id = ?");
			stat.setInt(1, customerId);

			ResultSet res = stat.executeQuery();
			res.next();
			customer.setCustomerId(res.getInt(1));
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public List<Customer> viewTransactions(Customer customer) {
		List<Customer> transactions = new ArrayList<Customer>();
		Connection con = DBConnection.getConnection();
		Statement stat;
		try {
			stat = con.createStatement();
			ResultSet res = stat.executeQuery("select id, amount from transaction join customer where customerid_send = id");

			while (res.next()) {
				customer.setCustomerId(res.getInt(1));
				customer.setAccountBalance(res.getDouble(2));
				transactions.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transactions;

	}
		
}
