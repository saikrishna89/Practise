package com.collections1;

//import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class collections1 {
	
	public static void main(String[] args) {
		Collection<Integer> values = new ArrayList();
		values.add(1);
		values.add(4);
		values.add(3);
		
	 Iterator ite = values.iterator();
	 
	 while(ite.hasNext()) {
		 System.out.println(ite.next()); 
	 }
	 
	 List values1 = new ArrayList();
	 values1.add(1);
	 values1.add(99);
	 values1.add(1, "Sai");
	 
	 Iterator ite1 = values1.iterator();
	 
	 while(ite1.hasNext()) {
		 System.out.println(ite1.next()); 
	 }
	 
	 List values2 = new LinkedList();
	 values2.add("101");
	 values2.add("201");
	 values2.add(1, "151");
	 
	 Iterator ite2 = values2.iterator();
	 
	 while(ite2.hasNext()) {
		 System.out.println(ite2.next()); 
	 }
	 
	 
	}
}
