package com.javatpoint;

public class TestPolymorphismExample {
	
	public static void main(String[] args) {
		PolymorphismExample PE = new PolymorphismExample2();
		System.out.println(PE.speed);
		PE.increaseSpeed();
	}
}
