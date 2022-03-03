package com.training.jwa.model;

public class Customer {
	private Boolean accountType;
	private int customerId;
	private String customerName;
	private String customerPassword;
	private int cAccountNum;
	private double accountBalance;
	private double amount;
	
	public Customer(int customerId, String customerName, String customerPassword, double accountBalance, double amount2) {
		super();
		//this.accountType = accountType;
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		//this.cAccountNum = cAccountNum;
		this.accountBalance = accountBalance;
		this.amount = amount2;
	}

	public Boolean getAccountType() {
		return accountType;
	}

	public void setAccountType(Boolean accountType) {
		this.accountType = accountType;
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
		return cAccountNum;
	}

	public void setAccountNum(int accountNum) {
		this.cAccountNum = accountNum;
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
		return "Customer [ accountBalance=" + accountBalance + "]";
	}
	
	
	
	
}
