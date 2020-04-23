/* Class implements Course fee i the online course fee instance
 * Andrea Bonato
 * 104760390
 * */
package goodcode;

public class OnlineCourseFee implements CourseFee{
	//This will use courseFee to determine the string to return to be 
	//printed
	public String estimatedCourseFee(String courseFee) {
		if(courseFee.equals("Full")) {
			return "Estimated Course Fee: CAD$2500.00\n";
		}else {
			return "Estimated Course Fee: CAD$1750.00\n";
		}
	}
}
