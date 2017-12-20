package com.interfaces;

import java.time.LocalDateTime;

public class ModernHospital implements TestInterface, Hospital, TimeClient{

	@Override
	public void firstAid() {
		System.out.println("MH has firstAid");
	}

	@Override
	public void diagnoise() {
		System.out.println("MH can diagnoise");
	}

	@Override
	public void treatment() {
		System.out.println("MH can do treatment");
	}

	@Override
	public void setTime(int hour, int min, int sec) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDate(int day, int month, int year) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDateAndTime(int hour, int min, int sec, int day, int month, int year) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LocalDateTime getLocalDateTime() {
		// TODO Auto-generated method stub
		return null;
	}

}
