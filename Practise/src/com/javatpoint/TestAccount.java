package com.javatpoint;

public class TestAccount {
	
	public static void main(String[] args) {
		Account acc = new Account();
		acc.insert(1234, "Sai's account", 47862.2f);
		System.out.println("AccountNumber :"+acc.accountNumber+ "AccountName :"+acc.accountName+ "Amount :"+acc.amount);
		acc.deposit(6777.2f);
		System.out.println("AccountNumber :"+acc.accountNumber+ "AccountName :"+acc.accountName+ "Amount :"+acc.amount);
	}
}
