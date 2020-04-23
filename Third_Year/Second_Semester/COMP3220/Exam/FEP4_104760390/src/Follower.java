/**
 * This class will implement both Observer and PlayChannel so that it can utilize the update(String status) 
 * and  play() methods. This will be used to store the Follower's name, and the status, which is assumed
 * to be the song that they are listening too. It will also have the sets and gets methods for each.
 * 104760390
 * @author Andrea Bonato
 *
 */
public class Follower implements Observer, PlayChannel {

	String followerName;
	String status;
	
	//Constructor so that when instantiating something of type follower, it doesn't crash
	public Follower () {status = ""; followerName="";}
	
	//override the play and update methods from the interfaces
	@Override
	public void play() { System.out.println("Now Playing: " + status + "... for " + followerName); }
	@Override
	public void update(String status) {this.status = status;}

	//get and set follower names
	public String getFollowerName() {return followerName;}
	public void setFollowerName(String followerName) {this.followerName = followerName;}
	
}
