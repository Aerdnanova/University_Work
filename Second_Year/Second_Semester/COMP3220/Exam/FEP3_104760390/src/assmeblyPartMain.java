import java.util.ArrayList;
/**
 * This will be used to test the objects that were made before, and assign values so that there is output
 * 104760390
 * @author Andrea Bonato
 *
 */
public class assmeblyPartMain {
	public static void main(String[] args) {
		//This will create all the parts
		ArrayList<Part> part = new ArrayList<Part>();
		part.add(new Part("Nut", 4.99));
		part.add(new Part("Bolt", 8.99));
		part.add(new Part("Panel", 34.99));
		//build the assemblies
		Assembly assem = new Assembly("Gizmo");
		Assembly assemW = new Assembly("Widget");
		
		//Assign and print out prices
		for(int i = 0; i < 3; i++) {
			System.out.println(part.get(i));
			assem.addItem(part.get(i));
		}
		
		//Print out assembly info
		System.out.println(assem);
		System.out.println(assem.getItems());
		assemW.addItem(assem);
		assemW.addItem(part.get(0));
		System.out.println(assemW);
		System.out.println(assemW.getItems());
	}
}	
