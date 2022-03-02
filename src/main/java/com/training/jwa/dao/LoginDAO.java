package com.training.jwa.dao;

import com.training.jwa.model.Login;

public interface LoginDAO {
	
	public boolean register(Login login);
	public boolean validate(String username, String password);
	public boolean checkEmployee(String username);
	public boolean checkCustomer(String username);
}
