package com.javatpoint.exceptions;

public class UncheckedExceptions {
	
	public static void main(String[] args) {
		int a[] = new int[5];
		try {
			int b = 50/0;
		}catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		try {
			a[6] = 100; 
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("Finally block is executed");
		}
	}
}
