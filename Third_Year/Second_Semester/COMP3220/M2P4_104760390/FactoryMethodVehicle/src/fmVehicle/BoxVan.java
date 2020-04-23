package fmVehicle;

public class BoxVan extends Vehicle {

	//choose type
	public BoxVan() {
		name = "boxvan";
	}
	
	//override vehicle
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
