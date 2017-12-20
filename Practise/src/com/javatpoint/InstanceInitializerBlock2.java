package com.javatpoint;

public class InstanceInitializerBlock2 extends InstanceInitializerBlock{
	
	InstanceInitializerBlock2(){
		super();
		System.out.println("Child class invoked");
	}
	
	{System.out.println("instance initializer block");}

	public static void main(String[] args) {
		InstanceInitializerBlock2 IIB2 = new InstanceInitializerBlock2();
	}
}
