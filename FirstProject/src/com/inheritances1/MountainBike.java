package com.inheritances1;

public class MountainBike extends Bicycle implements TestInterface, TestInterface1{
    
  // the MountainBike subclass adds one field
  public int seatHeight;

  // the MountainBike subclass has one constructor
  public MountainBike(int startHeight,
                      int startCadence,
                      int startSpeed,
                      int startGear) {
      super(startCadence, startSpeed, startGear);
      seatHeight = startHeight;
  }   
      
  // the MountainBike subclass adds one method
  public void setHeight(int newValue) {
      seatHeight = newValue;
  }   
  
  public void setCadence(int oldValue) {
      cadence = oldValue;
  }
  
  public void setGear(int newValue) {
      gear = newValue;
  }

@Override
public void test() {
	// TODO Auto-generated method stub
	
}

@Override
public void test1() {
	// TODO Auto-generated method stub
	
}

}
