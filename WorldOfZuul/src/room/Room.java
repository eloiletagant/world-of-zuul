package room;

import java.util.ArrayList;
import java.util.HashMap;

import event.Event;
import item.Lock;

/**
 * This class describes the structure of a room. A room is defined by a name and a map level (0 or 1).
 * One room could have several doors associated to directions and it can contain some events like fight or trade.
 * A room can't have two exits on the same room or with the same way. The ways can be front, behind, right, left, upstair, downstair and hole.
 *
 * @author Groupe4
 * @version 10/11/2016
 */

public class Room {


    private String description; // initiate to "UndescribedRoom" is empty
    private HashMap<String, Door> doors; //String = front, behind, right, left, stair and hole. Doors are uniques on this hashmap
    private ArrayList<Event> events; // an event can appear once on a room
    private int level; // initiate to 0 if the level declaration is < 0

    /**
     * Constructor used to instantiate a room
     *
     * @param String description: Room name
     * @param int    lvl: Room level
     */
    public Room(String description, int lvl) {
        if (description == "")
            this.description = "UndescribedRoom";
        else
            this.description = description;
        if (lvl < 0)
            level = 0;
        else
            level = lvl;
        doors = new HashMap<String, Door>();
        events = new ArrayList<Event>();
    }

    /**
     * Simple accessor
     *
     * @return HashMap<String, Door>: doors associated to the room
     */
    public HashMap<String, Door> getDoors() {
        return doors;
    }

    /**
     * Simple accessor
     *
     * @return ArrayList<Event>: Events associated to the room
     */
    public ArrayList<Event> getEvents() {
        return events;
    }

    /**
     * Simple accessor
     *
     * @return String: Room name
     */
    public String getDescription() {
        return description;
    }

    /**
     * Simple accessor
     *
     * @return int: Room level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Add an exit to the room. An exit can't be add if it exist or if the direction is already taken.
     *
     * @param newDoor Door we want to add
     * @param way     String of the direction
     */
    public void addExit(Door newDoor, String way) {
        boolean isOk = true;
        //test if the room linked to the newDoor (param) is not already linked to the current room
        for (HashMap.Entry<String, Door> entry : doors.entrySet()) {
            //Entry is a couple of the HashMap
            //entrySet() return a set view of the mapping contained in the map
            if (entry.getValue().getNextRoom().equals(newDoor.getNextRoom())) {
                isOk = false;
                break;
                //if the door is linked to a room already linked to the current room, isOk is set on false
            }
        }
        //test if iOK is true, if the direction is not already in the HM, and if the door is not already in the HM
        if (isOk && doors.containsKey(way) == false && !newDoor.getNextRoom().equals(this))
            doors.put(way, newDoor);
    }

    /**
     * Add an event to the room. The same event can't be add twice on the same room
     *
     * @param anEvent Event we want to add in the room
     */
    public void addEvent(Event anEvent) {
        boolean isOk = true;
        for (Event ev : events) {
            if (ev.equals(anEvent)) {
                isOk = false;
                break;
            }
        }
        if (isOk)
            events.add(anEvent);
    }

    /**
     * Remove an exit to the room.
     */
    public void removeExit(String way) {
        doors.remove(way);
    }

    /**
     * Remove an event to the room.
     */
    public void removeEvent(Event anEvent) {
        events.remove(anEvent);
    }
    
	/**
	 * This method return if the door is locked or not.
	 * @return true if the door is locked
	 */
	public boolean isLocked(){
			return false;
	}
}
