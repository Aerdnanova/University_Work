package fmVehicle;

public class CoupeCar extends Vehicle {

	//sets type of vehicle
	public CoupeCar() {
		name = "coupe";
	}
	
	//overrides vehicle
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String makeBody() {
		return "Making body...\n";
	}

	@Override
	public String makeChassis() {
		return "Making chassis...\n";
	}

	@Override
	public String makeGlassware() {
		return "Making glassware...\n";
	}


}
