/**In the diagram, Subject was an interface; however, the diagram states that Channel extended Subject,
 * thus, I decided to list it as public abstract instead, so that it can have similar functionality,
 * and also be extended by Channel. This will be used to lay the basis for  the three methods
 * 104760390
 * @author Andrea Bonato
 *
 */
public abstract class Subject {

	public abstract void registerObserver(Observer o);
	public abstract void unregisterObserver(Observer o);
	public abstract void notifyObservers();
}
