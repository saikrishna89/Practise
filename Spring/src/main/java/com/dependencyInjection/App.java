package com.dependencyInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/com/beans/Spring.xml");
		Triangle triangle = (Triangle) context.getBean("triangle");
		triangle.draw();
		System.out.println(triangle.getType().toUpperCase());
}

}