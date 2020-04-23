package goodsmell;
/**
 * This will extend the MajorType class and compute the tuition fees and return the name of the 
 * French major.
 * 104760390
 * @author Andrea Bonato
 *
 */
public class FrenchMajor extends MajorType {

	@Override
	public double computeTuitionFees() {
		return 2570.00;
	}

	@Override
	public String degreeToBeGranted() {
		return "B. A. (Honours)";
	}

}
