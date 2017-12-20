package com.javatpoint;

public class Account {
	
	int accountNumber;
	String accountName;
	float amount;
	
	void insert(int accountNumber, String accountName, float amount) {
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.amount = amount;
	}
	
	void deposit(float amount) {
		this.amount = amount;
	}
	
	void withdraw(float amount) {
		this.amount = amount;
	}
}
