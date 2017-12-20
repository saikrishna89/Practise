package com.javatpoint;

public class TestInterfaceExample {
	
	public static void main(String[] args) {
		InterfaceExample IE = new InterfaceExample3();
		IE.eating();
		IE.running();
		IE.sleeping();
		System.out.println("-----------------------");
		InterfaceExample2 IE2 = new InterfaceExample3();
		IE2.drinking();
		IE2.eating();
		IE2.running();
		IE2.sleeping();		
	}
}
