package fmVehicle;

public class SaloonCar extends Vehicle {

	//Chooses type
	public SaloonCar() {
		name = "saloon";
	}
	
	//Overrides vehicle
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
