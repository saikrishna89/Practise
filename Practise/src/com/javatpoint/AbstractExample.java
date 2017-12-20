package com.javatpoint;

abstract class AbstractExample {
	
	int a;
	void example() {
		System.out.println("Example1");
	}
	
	abstract void example2();
	
	AbstractExample(int a){
		this.a = a;
	}
}
