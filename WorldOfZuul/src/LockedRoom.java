/**
 * This method manages the room which are locked by a locker.
 * 
 * @author Group 4
 * @version 10/11/2016
 *
 */
public class LockedRoom extends ExitRoom{

	private Lock blockingLock;

	/**
	 * This method returns the next room of the current room.
	 */
	public Room getNextRoom()
	{
		return super.nextRoom;
	}
	
	/**
	 * This method return the state lock or unlock of a lockedRoom.
	 * @return
	 */
	public Lock getLock()
	{
		return blockingLock;
	}
	
	/**
	 * This method unlocks a lockedRoom.
	 */
	public void unlockRoom()
	{
		
	}

}
