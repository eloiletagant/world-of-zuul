package room;

/**
 * This method manages the door which are locked by a locker.
 * 
 * @author Group 4
 * @version 10/11/2016
 *
 */
public class LockedDoor extends Door{

	//this is the lock which allow to keep the door close.
	private Lock blockingLock;

	/**
	 * Constructor
	 */
	public LockedDoor(){
		super();
	}
	
	/**
	 * This method returns the next room of the current room.
	 */
	public Room getNextRoom(){
		return super.nextRoom;
	}
	
	/**
	 * This method return the state lock or unlock of a lockedDoor.
	 * @return
	 */
	public Lock getLock(){
		return blockingLock;
	}
	
	/**
	 * This method unlocks a lockedDoor.
	 */
	public void unlockRoom(){
		
	}

}
