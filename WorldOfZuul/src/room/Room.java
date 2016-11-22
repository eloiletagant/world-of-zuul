package room;
import java.util.ArrayList;
import java.util.HashMap;

import event.Event;

/**
 * 
 * This class describes the structure of a room. A room is defined by a name and a map level (0 or 1).
 * One room could have several doors associated to directions and it can contain some events like fight or trade. 
 * @author Groupe4
 * @version 10/11/2016
 *
 */
public class Room {
	
	private String nameRoom;
	private HashMap<String, Door> exitDoors;
	private ArrayList<Event> events;
	private int level;

	/**
	 * Constructor used to instantiate a room
	 * @param String name: Room name
	 * @param int level: Room level
	*/
	public Room(String nameRoom, int level){
		this.nameRoom = nameRoom;
		this.level = level;
	}
	
	/**
	 * Simple accessor
	 * @return HashMap<String, Door>: doors associated to the room
	 */
	public HashMap<String, Door> getExitDoors()
	{
		return exitDoors;
	}
	
	/**
	 * Simple accessor
	 * @return ArrayList<Event>: Events associated to the room
	 */
	public ArrayList<Event> getEvents()
	{
		return events;
	}
	
	/**
	 * Simple accessor
	 * @return String: Room name
	 */
	public String getRoomName()
	{
		return nameRoom;
	}
	
	/**
	 * Simple accessor
	 * @return int: Room level
	 */
	public int getLevel()
	{
		return level;
	}

}
