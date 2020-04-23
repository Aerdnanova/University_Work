package fmVehicle;

public abstract class VehicleFactory {

	//call it all
	public void orderVehicle(String vehicleType) {
		System.out.print(makeVehicle(vehicleType));
	}
	
	//print out everything
	public abstract String makeVehicle(String vehicleType);

}
