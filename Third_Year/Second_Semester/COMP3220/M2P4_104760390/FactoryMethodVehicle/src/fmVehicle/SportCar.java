package fmVehicle;

public class SportCar extends Vehicle{

	//chooses type
	public SportCar() {
		name = "sport";
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
