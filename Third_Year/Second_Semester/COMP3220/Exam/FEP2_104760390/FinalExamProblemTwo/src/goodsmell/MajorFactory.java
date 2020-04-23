package goodsmell;
/**
 * This will be used to create the MajorType that will be used to keep track of the major of the student, and return
 * the proper major object type
 * 104760390
 * @author Andrea Bonato
 *
 */

public class MajorFactory {
	public static MajorType createMajorObject(String major) {
		
		if(major.equals("Computer Science Major")) {
			return new ComputerScienceMajor();
		} else if (major.equals("French Major")) {
			return new FrenchMajor();
		}else if (major.equals("Electrical Engineering Major")) {
			return new ElectricalEngineeringMajor();
		} else {
			
			System.out.println("ERROR");
			System.exit(0);
		}
		
		return null;
		
	}
}
