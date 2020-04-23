package fmVehicle;

public class VanFactory extends VehicleFactory {

	//overrides vehicle factory, prints out everything here
	@Override
	public String makeVehicle(String vehicleType) {
		
		Vehicle van;
		
		if(vehicleType.equals("pickup")) {
			van = new PickupVan();
		}else {
			van = new BoxVan();
		}
		
		String outputString = "---------Making a " + vehicleType + "---------\n";
		outputString += van.makeBody() + van.makeChassis() + van.makeGlassware();
				
		return outputString;
	}


}
