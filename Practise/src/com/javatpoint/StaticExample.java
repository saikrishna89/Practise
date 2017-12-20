package com.javatpoint;

public class StaticExample {
	
	int rollno;
	String name;
	static String collegeName = "KITS";
	
	static void changeCollegeName(String collegeName) {
		StaticExample.collegeName = collegeName;
	}
}
