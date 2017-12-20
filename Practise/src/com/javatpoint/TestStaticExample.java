package com.javatpoint;

public class TestStaticExample {
	
	public static void main(String[] args) {
		StaticExample SE = new StaticExample();
		SE.rollno = 12;
		SE.name = "Sai";
		StaticExample.changeCollegeName("CSU");
		System.out.println(SE.rollno+" "+SE.name+" "+StaticExample.collegeName);
	}
}
