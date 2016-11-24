package room;

import item.Key;
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
	//the key associate to the lock
	private Key key;
	//state of the lock
	private boolean isLocked;

	/**
	 * Constructor which need the informations about the rooms (current and next one)
	 * and all informations about the key
	 */
	public LockedDoor(Room nextRoom, String keyName, String keyDescription, int keyPrice, boolean keySellAble){
		super(nextRoom);
		lock = new Lock(keyName, keyDescription, keyPrice, keySellAble);
		isLocked = true; //the door is closed by default
	}
	
	
	/**
	 * This method return the lock of a lockedDoor.
	 * @return the lock
	 */
	public Lock getLock(){
		return lock;
	}
	
	/**
	 * This method return the state lock or unlock of a lockedDoor.
	 * @return the state of the lock
	 */
	public boolean isLocked(){
		return isLocked;
	}
	
	/**
	 * This method locks or unlocks a lockedDoor, so allow the character to move away;
	 */
	public void lockingDoor(){
		if (isLocked) {
			isLocked = false;
		} else {
			isLocked = true;
		}
	}

}
