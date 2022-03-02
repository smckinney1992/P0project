package com.training.jwa.dao;

import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.training.jwa.model.Customer;
import com.training.jwa.model.Employee;
import com.training.jwa.utility.DBConnection;

public class EmployeeDAOImpl implements EmployeeDAO {
	Scanner scan = new Scanner(System.in);

	@Override
	public boolean accountApproval(Customer customer) {
		boolean status = false;
		Connection con = DBConnection.getConnection();
		PreparedStatement statement;
		CallableStatement update;
		try {
			statement = con.prepareStatement("select * from customer where id = ?");
			statement.setInt(1, customer.getCustomerId());
			ResultSet res = statement.executeQuery();
			status = res.next();
			
			System.out.println("Would you like to approve account: T/F");
			String ans = scan.next();
			
			if(ans.toUpperCase().equals("T")) {
			update = con.prepareCall("call updateAccount(?)");
			update.setInt(1, customer.getCustomerId());
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
	public void viewAccount(Employee employee) {
		Connection con = DBConnection.getConnection();
        PreparedStatement stat;
        
        try {
            stat= con.prepareStatement("select * from customer where userId= ?");
            stat.setInt(1, employee.getEmployeeId());
            ResultSet res = stat.executeQuery();
            
            while(res.next()) {
            	
            }
            
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
		
        }
	}

	@Override
	public void viewTransactions(Employee employee) {
		System.out.println("Printing user transactions ");
		/*List<Transaction> transactions = new ArrayList<Transaction>();
		
		Statement stat;
		try {
			stat = con.createStatement();
			ResultSet res = stat.executeQuery("select * from transaction");

			while (res.next()) {
				Employee employee = new Employee();
				employee.setProductId(res.getInt(1));
				employee.setProductName(res.getString(2));
				employee.setQuanityOnHand(res.getInt(3));
				employee.setPrice(res.getInt(4));
				employee.add(transactions);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transactions;*/

	}
		
}
