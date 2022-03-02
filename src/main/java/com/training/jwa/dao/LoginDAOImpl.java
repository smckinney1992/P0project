package com.training.jwa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.training.jwa.model.Login;
import com.training.jwa.utility.DBConnection;

public class LoginDAOImpl implements LoginDAO {
	
	Connection connection = DBConnection.getConnection();
	//Creates a new account
	@Override
	public boolean register(Login login) {
		System.out.println("##Adding user :" + login);
		PreparedStatement statement = null;
		int rows = 0;
		try {
				statement = connection.prepareStatement("insert into login values(default,?,?)");
				statement.setString(1, login.getUsername());
				statement.setString(2, login.getPassword());
				//statement.setBoolean(3, login.getEmployee());
				
				rows = statement.executeUpdate();
				System.out.println(rows + " user registered successfully");
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(rows == 0)
			return false;
		else
			return true;
	}
	
	//confirms that the account exists
	@Override
	public boolean validate(String username, String password) {
		boolean userValid = false;
		PreparedStatement stat;
		try {
				stat = connection.prepareStatement("select * from login where username = ? and password = ? ");
				stat.setString(1, username);
				stat.setString(2, password);
				
				ResultSet res = stat.executeQuery();
				userValid = res.next();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userValid;
	}
	//Checks employee table if account exists
	public boolean checkEmployee(String username) {
		boolean employee = false;
		PreparedStatement statement;
		try {
			//statement = connection.prepareStatement("select * from employee where username = ?");
			statement = connection.prepareStatement("select * from employees where username = ?");
			statement.setString(1, username);
			ResultSet res = statement.executeQuery();
			//res.next();
			employee = res.next();
			//res.close();
			//statement.close();
			//connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}
	//Checks customer table if account exists
	public boolean checkCustomer(String username){
		boolean customer = false;
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement("select * from customer where username = ?");
			statement.setString(1, username);
			ResultSet res = statement.executeQuery();
			//res.next();
			customer = res.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer; 
		}
}
