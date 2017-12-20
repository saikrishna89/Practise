package com.javatpoint;

public class TestConstructors {
	
		public static void main(String[] args) {
			Constructors con = new Constructors(89, "Sai");
			System.out.println(con.rollno+" "+con.name);
			Constructors con1 = new Constructors(89, "Sai", 12);
			System.out.println(con1.rollno+" "+con1.name+" "+con1.standard);
		}
}
