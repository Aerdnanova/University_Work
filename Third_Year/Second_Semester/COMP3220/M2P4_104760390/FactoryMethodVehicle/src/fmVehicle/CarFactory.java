package fmVehicle;

public class CarFactory extends VehicleFactory {

	//override vehile factory, prints out everything
	@Override
	public String makeVehicle(String vehicleType) {
		
		Vehicle car;
		
		if(vehicleType.equals("sport")) {
			car = new SportCar();
		}else if(vehicleType.equals("coupe")) {
			car = new CoupeCar();
		}else {
			car = new SaloonCar();
		}
		
		System.out.println("---------Making a " + vehicleType + "---------");
		String outputString = "";
		outputString = car.makeBody() + car.makeChassis() + car.makeGlassware();
				
		return outputString;
		
	}
	

}
