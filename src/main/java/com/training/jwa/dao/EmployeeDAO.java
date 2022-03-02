package com.training.jwa.dao;

import com.training.jwa.model.Customer;
import com.training.jwa.model.Employee;

public interface EmployeeDAO {
	public boolean accountApproval(Customer customer);
	public void viewAccount(Employee employee);
	public void viewTransactions(Employee employee);

}
