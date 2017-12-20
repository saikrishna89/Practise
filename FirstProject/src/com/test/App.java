package com.test;

class Person{
	
	public String name;	
	public static String description;
	public final static int NUMBER = 10;
	public static int count = 0;
	
	public Person() {
		count++;	
	}
	
	public void showName() {
		System.out.println(description);
	}
	
	public static void showInfo() {
		System.out.println(description);
	}
}

public class App {
	
	public static void main(String args[]) {
		
		System.out.println(Person.count);
		
		Person person1 = new Person();
		person1.name = "Sai";
		person1.description = "is a good boy";
		person1.showName();
		
		Person person2 = new Person();
		person2.name = "Krishna";
		person2.description = "is a bad boy";
		
		Person person3 = new Person();
		
		System.out.println(person1.name+" "+person1.description);
		System.out.println(person2.name+" "+person2.description);
		
		System.out.println(Person.NUMBER);
		System.out.println(Person.count);
	}
}
