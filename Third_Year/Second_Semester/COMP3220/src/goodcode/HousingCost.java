/* Class used to be implmented in the housing cost for online vs offline
 * Andrea Bonato
 * 104760390
 * */
package goodcode;

public interface HousingCost {
	//This will be overriden by any class that implements HousingCost
	public String calculateHousingCost(String courseSize);
}
