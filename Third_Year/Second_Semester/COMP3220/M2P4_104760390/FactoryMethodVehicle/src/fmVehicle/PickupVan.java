package fmVehicle;

public class PickupVan extends Vehicle {
	
	//chooses type
	public PickupVan() {
		name = "pickup";
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
