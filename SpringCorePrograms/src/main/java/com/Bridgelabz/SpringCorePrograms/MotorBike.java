package com.Bridgelabz.SpringCorePrograms;

public class MotorBike {
private String BikeName;
private String BikeCc;
public String getBikeName() {
	return BikeName;
}
public void setBikeName(String bikeName) {
	BikeName = bikeName;
}
public String getBikeCc() {
	return BikeCc;
}
public void setBikeCc(String bikeCc) {
	BikeCc = bikeCc;
}
 
public void display() {
	System.out.println("Bike Name:" + BikeName +"\n"+"Bike CC: " + BikeCc);
}

}
