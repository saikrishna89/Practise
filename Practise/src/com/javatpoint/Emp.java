package com.javatpoint;

public class Emp extends Person{

	float amount;
	String name;
	
	Emp(int id, String name, float amount) {
		super(id, name);
		this.amount = amount;
	}
	
	public static void main(String[] args) {
		Emp emp = new Emp(1, "Sai", 4000.0f);
		Person per = new Person(1, "SAI");
		System.out.println(emp.id+" "+per.name+" "+emp.amount);
	}
}
