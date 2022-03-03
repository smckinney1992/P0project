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

import com.training.jwa.model.Customer;
import com.training.jwa.model.Employee;
import com.training.jwa.utility.DBConnection;

public class EmployeeDAOImpl implements EmployeeDAO {
	Scanner scan = new Scanner(System.in);

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
	public void viewAccount(Employee employee) {
		Connection con = DBConnection.getConnection();
        PreparedStatement stat;
        
        try {
            stat= con.prepareStatement("select * from customer where Id= ?");
            stat.setInt(1, employee.getEmployeeId());
            ResultSet res = stat.executeQuery();
            
            while(res.next()) {
            	employee.setEmployeeId(res.getInt(1));
            	employee.setEmployeeName(res.getString(2));
            	employee.setEmployeePassword(res.getString(3));
            	employee.setAccountType(res.getBoolean(4));
            	
            }
            con.close();
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
		
        }
	}

	@Override
	public List<Employee> viewTransactions(Employee employee) {
		System.out.println("Printing user transactions ");
		List<Employee> transactions = new ArrayList<Employee>();
		Connection con = DBConnection.getConnection();
		Statement stat;
		try {
			stat = con.createStatement();
			ResultSet res = stat.executeQuery("select * from transaction");

			while (res.next()) {
				employee.setEmployeeId(res.getInt(1));
				employee.setAccountBalance(res.getDouble(2));
				transactions.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transactions;

	}
		
}
