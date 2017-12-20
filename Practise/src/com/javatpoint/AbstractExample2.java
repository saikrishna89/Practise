package com.javatpoint;

public class AbstractExample2 extends AbstractExample{

	AbstractExample2(int a) {
		super(a);
	}

	@Override
	void example2() {
		System.out.println("Example 2");
	}
	
	public static void main(String[] args) {
		AbstractExample2 AE2 = new AbstractExample2(2);
		System.out.println(AE2.a);
	}
}
