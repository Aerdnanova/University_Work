/**
 * This is used to run the progra, assign values, test methods and get the proper response.
 * 104760390
 * @author Andrea Bonato
 *
 */
public class ObserverMain {
	
	public static void main(String[] args) {
		
		//Create followers and channel
		Follower o = new Follower(), k = new Follower(), x = new Follower();
		Channel channel = new Channel();
		
		//Assign values
		channel.setChannelName("MY CHANNEL");
		o.setFollowerName("FIRST FOLLOWER");
		channel.registerObserver(o);
		k.setFollowerName("SECOND FOLLOWER");
		channel.registerObserver(k);
		channel.setStatus("NEW SONG1");
		channel.unregisterObserver(k);
		x.setFollowerName("THIRD FOLLOWER");
		channel.registerObserver(x);
		channel.setStatus("NEW SONG2");

		//terminate program
		return;
	}
}
