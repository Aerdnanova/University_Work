package fmVehicle;

public abstract class Vehicle {
	
	//used to name the type
	protected String name;
	
	//get name, print out everything else
	public abstract String getName();
	public abstract String makeBody();
	public abstract String makeChassis();
	public abstract String makeGlassware();
}
