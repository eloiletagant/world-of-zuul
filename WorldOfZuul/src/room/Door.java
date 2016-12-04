package room;

import item.Lock;

/**
 * This class manages the door of the room in order to allow a character to move.
 * It can be blocked by a lock and so need a key to open it : subclass LockedDoor
 * Have to check the player move in another place.
 *
 * @author Group 4
 * @version 10/11/2016
 */
public class Door {

    //the next room of the current one, it can exist just one next room
    protected Room nextRoom;

    /**
     * Constructor of the door class, there is just one room given in parameters
     * @param nextRoom Room room on the other side of the door
     */
    public Door(Room nextRoom) {
        this.nextRoom = nextRoom;
    }

    /**
     * This method returns the next room of the current room.
     *
     * @return Room
     */
    public Room getNextRoom() {
        return nextRoom;
    }
    
	/**
	 * This method return if the door is locked or not.
	 * @return true if the door is locked
	 */
	public boolean isLocked(){
			return false;
	}
	
	/**
	 * This method return the lock of a Door
	 * @return null
	 */
	public Lock getLock(){
		return null;
	}
}
