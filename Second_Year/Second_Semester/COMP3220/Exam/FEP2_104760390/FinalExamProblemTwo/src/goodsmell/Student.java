package goodsmell;
/**
 * This will be used to create a student and assign it a name, a major type and a student number.
 * 104760390
 * @author Andrea Bonato
 *
 */
public class Student {
	
	//Attributes
	private String studentNumber;
	private String studentName;
	private MajorType major;
	
	//This is the contructor for student. It will be used to create a student and assign its values
	public Student(String studentNumber, String studentName, String major) {
		
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.major = MajorFactory.createMajorObject(major);
	}
	
	//This will return the cost of tuition
	public double computeTuitionFees() {
		return major.computeTuitionFees();
	}
	
	//This will return the degree name
	public String degreeToBeGranted() {
		
		return major.degreeToBeGranted();
	}
	
	//This will change the major to the new major inputted
	public void changeMajor(String newMajor) {
		
		this.major = MajorFactory.createMajorObject(newMajor);

	}
	//Prints out student
	public String toString() {
		return studentName + " is pursuing " + major.degreeToBeGranted() + "; pays " + this.computeTuitionFees();
	}
}
