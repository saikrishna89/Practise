package com.interfaces;

import java.time.LocalDateTime;

public interface TimeClient {
	
	void setTime(int hour, int min, int sec);
	void setDate(int day, int month, int year);
	void setDateAndTime(int hour, int min, int sec, int day, int month, int year);
	LocalDateTime getLocalDateTime();
}
