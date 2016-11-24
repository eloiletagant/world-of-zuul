package room;

import java.util.ArrayList;
import java.util.HashMap;

import event.Event;

/**
 * This class describes the structure of a room. A room is defined by a name and a map level (0 or 1).
 * One room could have several doors associated to directions and it can contain some events like fight or trade.
 * A room can't have two exits on the same room or with the same way. The ways can be front, behind, right, left, stair and hole.
 *
 * @author Groupe4
 * @version 10/11/2016
 */

public class Room {

    private String nameRoom; // initiate to "UnnamedRoom" is empty
    private HashMap<String, Door> exitDoors; //String = front, behind, right, left, stair and hole. Doors are uniques on this hashmap
    private ArrayList<Event> events; // an event can appear once on a room
    private int level; // initiate to 0 if the level declaration is < 0

    /**
     * Constructor used to instantiate a room
     *
     * @param String newName: Room name
     * @param int    lvl: Room level
     */
    public Room(String newName, int lvl) {
        if (newName == "")
            nameRoom = "UnnamedRoom";
        else
            nameRoom = newName;
        if (level < 0)
            level = 0;
        else
            level = lvl;
        exitDoors = new HashMap<String, Door>();
        events = new ArrayList<Event>();
    }

    /**
     * Simple accessor
     *
     * @return HashMap<String, Door>: doors associated to the room
     */
    public HashMap<String, Door> getExitDoors() {
        return exitDoors;
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
    public String getRoomName() {
        return nameRoom;
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
     */
    public void addExit(Door newDoor, String way) {
        if (exitDoors.containsValue(newDoor) == false && exitDoors.containsKey(way) == false)
            exitDoors.put(way, newDoor);
    }

    /**
     * Add an event to the room. The same event can't be add twice on the same room
     */
    public void addEvent(Event anEvent) {
        if (events.contains(anEvent) == false)
            events.add(anEvent);
    }

    /**
     * Remove an exit to the room.
     */
    public void removeExit(String way) {
        exitDoors.remove(way);
    }

    /**
     * Remove an event to the room.
     */
    public void removeEvent(Event anEvent) {
        events.remove(anEvent);
    }
}
