package com.training.jwa.dao;

import java.util.List;

import com.training.jwa.model.Customer;
import com.training.jwa.model.Employee;

public interface EmployeeDAO {
	public boolean accountApproval(String username);
	public void viewAccount(Employee employee);
	public List<Employee> viewTransactions(Employee employee);

}
