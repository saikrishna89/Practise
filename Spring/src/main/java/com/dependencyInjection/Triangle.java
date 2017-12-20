package com.dependencyInjection;

public class Triangle implements Shape{

	private String Type;
	
	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public void draw() {
		System.out.println("draw triangle");
	}

}
