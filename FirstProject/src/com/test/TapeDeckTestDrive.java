package com.test;

public class TapeDeckTestDrive {
	
	public static void main(String[] args) {
		
		DVDPlayer t = new DVDPlayer();
		TapeDeck t1 = new TapeDeck();
		t.canRecord = true;
		t1.playTape();
		
		if(t.canRecord == true) {
			t1.recordTape();
		}
	}
}
