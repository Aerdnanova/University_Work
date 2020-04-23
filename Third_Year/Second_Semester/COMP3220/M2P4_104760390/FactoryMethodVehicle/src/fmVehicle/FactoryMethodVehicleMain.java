package fmVehicle;

public class FactoryMethodVehicleMain {
	
	public static void main(String[] args) {
		
		//call all the vehicles
		VehicleFactory van, car;
		van = new VanFactory();
		car = new CarFactory();
		car.orderVehicle("saloon");
		car.orderVehicle("coupe");
		car.orderVehicle("sport");
		van.orderVehicle("boxvan");
		van.orderVehicle("pickup");
		
	}
} 