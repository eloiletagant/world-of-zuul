/**
 * This class manages the door of the room in order to changes the location of a character.
 * @author Group 4
 * @version 10/11/2016
 *
 */
public class ExitRoom {
	private Room nextRoom;

	/**
	 * This method returns the next room of the current room.
	 * @return
	 */
	public Room getNextRoom()
	{
		return nextRoom;
	}
}
