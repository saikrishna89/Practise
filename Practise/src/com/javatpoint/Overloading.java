package com.javatpoint;

public class Overloading {
	
	static int add(int a, int b) {
		return a+b;
	}
	static double add(double a, double b) {
		return a+b;
	}
	
	public static void main(String[] args) {
		System.out.println(Overloading.add(3, 4));
		System.out.println(Overloading.add(12, 34));
	}
}
