package com.collections;

import java.util.*;

public class HashSetStudentExample {
	
	public static void main(String[] args) {
		HashSet<Student> set = new HashSet<Student>();
		Student st1 = new Student(1234, "Sai", "A2");
		Student st2 = new Student(9087, "Abhi", "Detroit");
		
		set.add(st1);
		set.add(st2);
		
		for(Student s:set) {
			System.out.println(s.name+" "+s.phoneNumber+" "+s.city);
		}
	}
}
