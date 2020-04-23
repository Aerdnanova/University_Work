/* Class implements HousingCost for Inclass outlines
 * Andrea Bonato
 * 104760390
 * */
package goodcode;

public class InClassHousingCost implements HousingCost {
	//This will check the courseSize and return a string dependent on it
	public String calculateHousingCost(String courseSize) {
		if(courseSize.equals("Full")) {
			return "Estimated Housing Cost: CAD$500\n";
		}else {
			return "Estimated Housing Cost: CAD$250\n";
		}
	}
}
