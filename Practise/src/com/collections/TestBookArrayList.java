package com.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class TestBookArrayList {
	
	public static void main(String[] args) {
		ArrayList<Book> list = new ArrayList<Book>();
		
		Book b1 = new Book(1000, "ABC", "Sai");
		Book b2 = new Book(2000, "XYZ", "Abhi");
		
		list.add(b1);
		list.add(b2);
		
		for(Book b:list) {
			System.out.println(b.price+" "+b.author+" "+b.name);
		}
	}
}
