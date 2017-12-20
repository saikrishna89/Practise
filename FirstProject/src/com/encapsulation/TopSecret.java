package com.encapsulation;

public class TopSecret {
	
	private String baseUrl;
//	private String environment;
	
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	};
	
	public void getBaseUrl() {
		System.out.println(baseUrl);
	};
}
