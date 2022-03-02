package com.training.jwa.model;

public class Customer {
	private String accountType;
	private int customerId;
	private String customerName;
	private String customerPassword;
	private int cAccountNum;
	private double accountBalance;
	private int amount;
	
	public Customer(String accountType, int customerId, String customerName, String customerPassword, int cAccountNum,
			double accountBalance, int amount) {
		super();
		this.accountType = accountType;
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.cAccountNum = cAccountNum;
		this.accountBalance = accountBalance;
		this.amount = amount;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Customer [accountType=" + accountType + ", customerId=" + customerId + ", customerName=" + customerName
				+ ", customerPassword=" + customerPassword + ", cAccountNum=" + cAccountNum + ", accountBalance="
				+ accountBalance + ", amount=" + amount + "]";
	}
	
	
	
	
}
