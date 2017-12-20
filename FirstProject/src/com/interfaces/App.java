package com.interfaces;

import com.accessspecifiers.Plant;

public class App {
	
	public static void main(String args[]) {
		
		Hospital UH = new UrbanHospital();
		UH.diagnoise();
		
		UrbanHospital UH1 = new UrbanHospital();
		UH1.firstAid();
		
		Plant plant = new Plant();
		plant.setPlantName("Test");
	}
	
}
