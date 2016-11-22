package room;

/**
 * This class manages the door of the room in order to allow a character to move.
 * It can be blocked by a lock and so need a key to open it : subclass LockedDoor
 * @author Group 4
 * @version 10/11/2016
 *
 */
public class Door {
	
	//the next room of the current one.
	protected Room nextRoom;

	public Door(){
		
	}
	
	/**
	 * This method returns the next room of the current room.
	 * @return Room
	 */
	public Room getNextRoom()
	{
		return nextRoom;
	}
}
