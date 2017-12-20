package com.javatpoint;

public class InterfaceExample3 implements InterfaceExample2{

	@Override
	public void running() {
		System.out.println("running");
	}

	@Override
	public void eating() {
		System.out.println("eating");
	}

	@Override
	public void sleeping() {
		System.out.println("sleeping");
	}

	@Override
	public void drinking() {
		System.out.println("drinking");
	}

}
