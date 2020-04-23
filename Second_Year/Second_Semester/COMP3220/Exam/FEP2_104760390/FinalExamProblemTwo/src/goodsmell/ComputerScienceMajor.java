package goodsmell;
/**
 * This extends the MajorType and assigns the MajorType to be a computer science major type.
 * @author Andrea Bonato
 *
 */
public class ComputerScienceMajor extends MajorType {

	@Override
	public double computeTuitionFees() {
		return 3150.00;
	}

	@Override
	public String degreeToBeGranted() {
		return "B.C.S. (Honours)";
	}

}
