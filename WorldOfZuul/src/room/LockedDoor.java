package room;

import item.Lock;

/**
 * This method manages the door which are locked by a locker (which inherits from Door).
 * 
 * @author Group 4
 * @version 10/11/2016
 *
 */
public class LockedDoor extends Door{

	//this is the lock which allow to keep the door close.
	private Lock lock;

	/**
	 * Constructor which need the informations about the rooms (current and next one)
	 * and all informations about the key
	 */
	public LockedDoor(Room nextRoom, Lock aLock){
		super(nextRoom);
		lock = aLock;
	}
	
	
	/**
	 * This method return the lock of a lockedDoor.
	 * @return the lock
	 */
	public Lock getLock(){
		return lock;
	}

}