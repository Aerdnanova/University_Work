import java.util.ArrayList;

/**
 * This will extend the Subject class and create a class of type Channel. It will take an ArrayList<Observer>
 * and essentially manage the updated statuses of the observers. This is done by keeping track of all the
 * followers in the list of observers, the status of the channel (which is assumed to be the name of the song),
 * and manages the registration of followers.
 * 104760390
 * @author Andrea Bonato
 *
 */

public class Channel extends Subject{
	
	//Feilds to fill
	private ArrayList<Observer> observers;
	private String channelName;
	private String status;
	
	//constructor so that it doesn't crash when instantiating it
	public Channel() {channelName = ""; status = ""; observers = new ArrayList<Observer>();}
	
	//sets and gets for the channel name and status
	public String getChannelName() {return channelName;}
	public void setChannelName(String channelName) {this.channelName = channelName;}
	public void setStatus(String status) {
		
		this.status = status;
		statusChanged(); //When the status is changed, it will update everyone
	}
	
	//this will change the status of all the observers and let them know that there is a new song to listen too
	public void statusChanged() { 
	
		for(int i = 0; i < observers.size(); i++)
			((Follower)observers.get(i)).update(status);
	
		notifyObservers(); //tell the observers and notify them that there was a change
		
	}
	
	//This will override the subject methods. Register observer will add an observer to the list and print out a message
	@Override
	public void registerObserver(Observer o) { 
		
		observers.add((Follower)o); 
		System.out.println ("You (" + ((Follower)o).getFollowerName() + ") are successfully subscribed to " + channelName);

	}
	
	//The unregister observer method will remove the observer from the list and print a message
	@Override
	public void unregisterObserver(Observer o) {
		
		if(observers.isEmpty())
			return;
		
		int size = observers.size();
		
		int index = getIndexOfFollowerInList(o, observers);
		
		if(index == -1)
			return;
		
		observers.remove(index);
			
		System.out.println ("You (" + ((Follower)o).getFollowerName() + ") are successfully unsubscribed from " + channelName);
	}
	//This will notify all the observers and let them know that a new song is going to play
	@Override
	public void notifyObservers() {
		
		int size = observers.size();
		
		for(int i = 0; i < size; i++) {
			((Follower)observers.get(i)).play();
		}
	}
	
	//This is an extra method I made to keep things a bit pretty. It will take in an observer, and a list of them
	//and find the index in which they match. It will return -1 if it is not there
	public int getIndexOfFollowerInList(Observer f1, ArrayList<Observer> flist) {
		
		int index = -1;
		
		for(int i = 0; i < flist.size(); i++) {
			
			if(((Follower)flist.get(i)).getFollowerName().equals(((Follower)f1).getFollowerName())) {
				index = i;
			}
		}
		
		return index;
	}
}
