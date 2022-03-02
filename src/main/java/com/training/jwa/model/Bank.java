package com.training.jwa.model;

public class Bank {
	private char accountType;
	private int employeeId;
	private String employeeName;
	private String employeePassword;
	private int customerId;
	private String customerName;
	private String customerPassword;
	private int accountNum;
	private double accountBalance;
	private double amount;

	public Bank() {
		super();
		this.accountType = accountType;
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeePassword = employeePassword;
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.accountNum = accountNum;
		this.accountBalance = accountBalance;
		this.amount = amount;
	}

	public char getAccountType() {
		return accountType;
	}

	public void setAccountType(char accountType) {
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

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public int getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Bank [accountType=" + accountType + ", employeeId=" + employeeId + ", employeeName=" + employeeName
				+ ", employeePassword=" + employeePassword + ", customerId=" + customerId + ", customerName="
				+ customerName + ", customerPassword=" + customerPassword + ", accountNum=" + accountNum
				+ ", accountBalance=" + accountBalance + ", amount=" + amount + "]";
	}

}
