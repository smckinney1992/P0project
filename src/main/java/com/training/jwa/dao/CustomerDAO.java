package com.training.jwa.dao;

import com.training.jwa.model.Customer;
import com.training.jwa.model.Employee;

public interface CustomerDAO {
	public Customer viewBalance(Customer customer);
	public int withdraw(Customer customer);
	public int deposit(Customer customer);
	public void transfer(Customer customer);
}
