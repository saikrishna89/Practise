package com.collections;

import java.util.*;

public class PersonMashMap {
	
	public static void main(String[] args) {
		HashMap<Integer, Person> hm = new HashMap<Integer, Person>();
		
		Address add = new Address("A2", "US", 48108);
		Person per = new Person(1234, "Sai", 210, add);
		
		hm.put(1, per);
		
		for(Map.Entry m : hm.entrySet()) {
			System.out.println(m.getKey()+" "+per.name+" "+per.phoneNumber);
		}
	}
}
