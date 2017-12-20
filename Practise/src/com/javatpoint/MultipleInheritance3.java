package com.javatpoint;

public class MultipleInheritance3 implements MultipleInheritance, MultipleInheritance2{

	public void test() {
		System.out.println("testing");
	}
	
	public static void main(String[] args) {
		MultipleInheritance3 MI3 = new MultipleInheritance3();
		MI3.test();
	}
	
}
