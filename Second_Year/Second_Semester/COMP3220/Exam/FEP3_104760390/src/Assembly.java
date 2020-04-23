import java.util.ArrayList;
/**
 * This will extend items and create an object that will represent an item made up of multiple parts
 * 104760390
 * @author Andrea Bonato
 *
 */
public class Assembly extends Item {
	
	ArrayList<Item> items; //parts
		
	//This will be used to assign values to the super class.
	public Assembly(String description) {
		super(description, 0);
		items = new ArrayList<Item>();
	}
	
	//Add an item to the list
	public void addItem(Item item) {
		items.add(item);
	}
	
	//remove an item from the list
	public void removeItem(Item item) {
		items.remove(item);
	}
	
	//this will total all the costs of items 
	public double getCost() {
		double total = 0;
		int size = items.size();
		
		for(int i = 0 ; i < size; i++) {
			total += items.get(i).getCost();
		}
		
		return total;
	}
	
	//this will list out all the items that make up this item and return them as a string
	public String getItems() {
		String total = this.getDescription() + " has ";
		int size = items.size();
		
		for(int i = 0 ; i < size; i++) {
			if( i + 1 == size)
				total += items.get(i).getDescription();
			else
				total += items.get(i).getDescription() + ", ";
		}
		
		return total;
	}
	
}
