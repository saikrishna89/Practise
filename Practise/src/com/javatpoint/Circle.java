package com.javatpoint;

public class Circle {
	
	Operation Op;
	double pi = 3.14;
	
	double area(int n) {
		Op = new Operation();
		return Op.square(n) * pi;
	}
}
