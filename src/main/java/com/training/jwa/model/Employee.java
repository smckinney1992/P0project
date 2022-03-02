package com.training.jwa.model;

public class Employee {
	private String accountType;
	private int employeeId;
	private String employeeName;
	private String employeePassword;
	private int eAccountNum;
	private double accountBalance;

	public Employee(String accountType, int employeeId, String employeeName, String employeePassword, 
					int eAccountNum, double accountBalance) {
		super();
		this.accountType = accountType;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeePassword = employeePassword;
		this.eAccountNum = eAccountNum;
		this.accountBalance = accountBalance;
	}
	
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	
	public int getAccountNum() {
		return eAccountNum;
	}

	public void setAccountNum(int accountNum) {
		this.eAccountNum = accountNum;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	@Override
	public String toString() {
		return "Bank [accountType=" + accountType + ", employeeId=" + employeeId + ", employeeName=" + employeeName
				+ ", employeePassword=" + employeePassword + ", eAccountNum=" + eAccountNum
				+ ", accountBalance=" + accountBalance + "]";
	}
}
