/* Class implements Course Fee, prints out course fee dependant on the 
 * course size
 * Andrea Bonato
 * 104760390
 * */
package goodcode;

public class InClassCourseFee implements CourseFee {
	//Checks the courseSize then returns the strings to be printed
	public String estimatedCourseFee(String courseFee) {
		if(courseFee.equals("Full")) {
			return "Estimated Course Fee: CAD$3300.0\n";
		}else {
			return "Estimated Course Fee: CAD$2250.0\n";
		}
	}
}
