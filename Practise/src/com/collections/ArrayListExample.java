package com.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListExample {
	
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("Sai");
		al.add("Krishna");
		al.add("Madhireddy");
		
		Iterator ite = al.iterator();
		while(ite.hasNext()) {
			System.out.println(ite.next());
		}
	}
}
