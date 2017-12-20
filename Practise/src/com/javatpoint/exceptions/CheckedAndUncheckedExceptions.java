package com.javatpoint.exceptions;

public class CheckedAndUncheckedExceptions {
	
	public static void main(String[] args) {
		try {
		int a = 50/0;
	}catch(ArithmeticException e){
		System.out.println("Exception caught "+e.getMessage());
	}finally{
		System.out.println("Finally executed");
	}
	}
}
