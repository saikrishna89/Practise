package com.javatpoint;

public class AccessModifiersExample {
	
	private int a = 1;
	
	static void a() {
		System.out.println("a is printing");
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
}
