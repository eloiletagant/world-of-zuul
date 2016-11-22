package room;
import java.util.ArrayList;
import java.util.HashMap;

import event.Event;

/**
 * 
 * This class describes the structure of a room. 
 * 
 * @author Groupe4
 * @version 10/11/2016
 *
 */
public class Room
{

	private String nameRoom;
	private HashMap<String, ExitRoom> exit;
	private ArrayList<Event> events;
	private int level;

	/**
	 * This method displays exits from the room where the player is.
	 */
	public HashMap<String, ExitRoom> getExitRoom()
	{
		return exit;
	}
	
	/**
	 * This methods displays the different events.
	 */
	public ArrayList<Event> getEvents()
	{
		return events;
	}
	
	/**
	 * This method displays the name of the room.
	 */
	public String getRoomName()
	{
		return nameRoom;
	}
	
	/**
	 * This method displays the level of the room.
	 */
	public int getLevel()
	{
		return level;
	}

}