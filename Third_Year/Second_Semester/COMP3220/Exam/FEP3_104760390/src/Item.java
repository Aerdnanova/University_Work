/**
 * This will be used to extend two other classes. It will have the attributes of an item, and be used to
 * manage the parts and assemblies of accessories 
 * 104760390
 * @author Andrea Bonato
 *
 */
public abstract class Item {
	private String description;
	private double cost;
	
	//Constructor. Determines costs and description and instantiated them
	public Item(String description, double cost) {
		this.description = description;
		this.cost = cost;
	}
	
	//Return description/ name
	public String getDescription() {
		return description;
	}
	
	//Return costs
	public double getCost() {
		return cost;
	}
	
	//Print string out
	public String toString() {
		return description + " costs " + this.getCost() + " CAD";
	}
}
