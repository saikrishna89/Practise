package com.accessspecifiers;

public class App {
	
	public static void main(String args[]) {
		
		Plant plant = new Plant();
		plant.setPlantName("pinacola");
		System.out.println(plant.getPlantName());
		plant.name = "pineapple";
		System.out.println(plant.name);
		
	}
}
