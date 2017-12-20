package com.spring;

public class Person {
	
	private int id;
	private String name;
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void speak() {
		System.out.println("I can speak!!");
	}
	
}
