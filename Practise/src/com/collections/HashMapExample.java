package com.collections;

import java.util.*;

public class HashMapExample {
	
	public static void main(String[] args) {
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "Sai");
		hm.put(2,  "Abhi");
		
		for(Map.Entry m: hm.entrySet()) {
			System.out.println(m.getKey()+" "+m.getValue());
		}
	}
}
