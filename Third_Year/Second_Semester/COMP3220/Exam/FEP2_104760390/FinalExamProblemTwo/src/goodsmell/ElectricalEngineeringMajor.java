package goodsmell;
/**
 * This will extend the MajorType class and compute the tuition fees and return the name of the 
 * electrical engineering major.
 * 104760390
 * @author Andrea Bonato
 *
 */
public class ElectricalEngineeringMajor extends MajorType {

	//Return the tuition fee for electrical engineering
	@Override
	public double computeTuitionFees() {
		return 3850.00;
	}
	
	//Return the name of the degree
	@Override
	public String degreeToBeGranted() {
		return "B. A. Sc. (Honours)";
	}

}
