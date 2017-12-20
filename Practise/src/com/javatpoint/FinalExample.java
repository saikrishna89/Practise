package com.javatpoint;

public class FinalExample {
	
	static final int SPEED_LIMIT;
	
	static {SPEED_LIMIT = 190;}
	
	public static void main(String[] args) {
		System.out.println(FinalExample.SPEED_LIMIT);
	}
}
