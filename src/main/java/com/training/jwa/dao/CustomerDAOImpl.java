package com.training.jwa.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.training.jwa.model.Customer;
import com.training.jwa.model.Employee;
import com.training.jwa.utility.DBConnection;

public class CustomerDAOImpl implements CustomerDAO{
	//Connection connection = DBConnection.getConnection();
	Scanner scanner = new Scanner(System.in);
	
	@Override
	public Customer viewBalance(Customer customer) {
		
		Connection connection = DBConnection.getConnection();
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement("select balance from customer where username = ?");
			statement.setString(1, customer.getCustomerName());
			
			ResultSet res = statement.executeQuery();
			res.next();
			customer.setAccountBalance(res.getDouble(1));
			
			//System.out.println("Printing customer's curerent balance: " +res);
			//statement.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public int withdraw(Customer customer) {
		int withdrawBalance = 0;
		
		Connection connection = DBConnection.getConnection();
		CallableStatement stat;
		try {
			stat = connection.prepareCall("call withdrawal(?,?,?)");
			stat.setInt(1, customer.getCustomerId());
			stat.setBigDecimal(2, customer.getAmount());
			
			stat.registerOutParameter(3, Types.INTEGER);
			stat.setInt(3, withdrawBalance);
			
			stat.execute();
			
			withdrawBalance = stat.getInt(3);
		} catch (SQLException e){
			e.printStackTrace();
		}
		return withdrawBalance;
	}

	@Override
	public int deposit(Customer customer) {
		int depositBalance = 0;
		
		Connection connection = DBConnection.getConnection();
		CallableStatement stat;
		try {
			stat = connection.prepareCall("call depositing(?,?,?)");
			stat.setInt(1, customer.getCustomerId());
			stat.setBigDecimal(2, customer.getAmount());
			
			stat.registerOutParameter(3, Types.INTEGER);
			stat.setInt(3, depositBalance);
			
			stat.execute();
			
			depositBalance = stat.getInt(3);
		} catch (SQLException e){
			e.printStackTrace();
		}
		return depositBalance;
	}

	@Override
	public void transfer(Customer customer) {
		
		int debitorBalance=0, creditorBalance=0;
		
		/*System.out.println("Enter the account number to debit the amount :");
		int sender = scanner.nextInt();
		
		System.out.println("Enter the account number to credit the amount :");
		int receiver = scanner.nextInt();
		
		System.out.println("Enter the amount to be transferred :");
		int amount = scanner.nextInt();*/
		
		Connection connection = DBConnection.getConnection();
		CallableStatement stat;
		try {
			stat = connection.prepareCall("call transfer(?,?,?,?,?)");
			stat.setInt(1, customer.getCustomerId());
			stat.setInt(2, customer.getCustomerId());
			stat.setBigDecimal(3, customer.getAmount());
			
			stat.registerOutParameter(4, Types.INTEGER);
			stat.setInt(4, debitorBalance);
			
			stat.registerOutParameter(5, Types.INTEGER);
			stat.setInt(5, creditorBalance);
			
			stat.execute();
			
			debitorBalance = stat.getInt(4);
			creditorBalance = stat.getInt(5);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Transfer done/completed");
		System.out.println("Debitor balance :"+debitorBalance);
		System.out.println("Creditor balance :"+creditorBalance);
		
		//return debitorBalance,creditorBalance;
	}
	
	

}
