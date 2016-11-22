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
	private Lock lock;

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
	 * @return the lock
	 */
	public Lock getLock(){
		return lock;
	}
	
	/**
	 * This method locks or unlocks a lockedDoor, so allow the character to move away;
	 */
	public void lockingDoor(){
		
	}

}
