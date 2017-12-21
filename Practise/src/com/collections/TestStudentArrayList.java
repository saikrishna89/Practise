package com.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class TestStudentArrayList {
	
	public static void main(String[] args) {
		
		ArrayList<Student> student = new ArrayList<Student>();
		Student st1 = new Student(12, "Sai", "AnnArbor");
		Student st2 = new Student(21, "Abhi", "Detroit");
		
		student.add(st1);
		student.add(st2);
		
		Iterator ite = student.iterator();
		while(ite.hasNext()) {
			 Student st=(Student)ite.next();  
			 System.out.println(st.phoneNumber+" "+st.name+" "+st.city);  
		}
	}
}
