package test;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import character.Character;
import item.Item;
import room.Room;
import room.Door;


/**
 * The test class LockTest
 * Unit tests of the Lock class
 *
 * @author Groupe4
 * @version 22/11/2016
 */

public class RoomTest {

    private Room myRoom;

    public RoomTest() {
    }

    /**
     * Sets up the test fixture
     * Called before every test method
     * Initialize one room
     */
    @Before
    public void setUp() {
        myRoom = new Room("Room 1", 1);
    }

    /**
     * Tear down the test fixture
     * Called after every test case method. Nothing to do in this case.
     */
    @After
    public void tearDown() {
    }


    /**
     * Checks if the description and the level given in the constructor are correctly set to the attributes
     */
    @Test
    public void testRoom() {
        assertEquals("Room 1", myRoom.getDescription());
        assertEquals(1, myRoom.getLevel());
    }

    /**
     * Checks if the description default value is correctly set to the attribute when the description is empty
     */
    @Test
    public void testEmptyDescription() {
        Room myRoom2 = new Room("", 1);
        assertEquals("UndescribedRoom", myRoom2.getDescription());
    }

    /**
     * Checks if the level default value is correctly set to the attribute when the level is negative
     */
    @Test
    public void testNegativeLevel() {
        Room myRoom2 = new Room("Room 2", -2);
        assertEquals(0, myRoom2.getLevel());
    }

    /**
     * Checks the method addExit to add doors to a room.
     * Checks all possibilities like adding a door already present in the room, adding a door with a direction already present...
     */
    @Test
    public void testAddExit() {
        Room room2 = new Room("Room 2", 1);
        Room room3 = new Room("Room 3", 1);
        Door d1 = new Door(room2);
        Door d2 = new Door(room2);
        Door d3 = new Door(room3);
        Door d4 = new Door(myRoom);

        //Adding test with a door in an empty hashmap
        myRoom.addExit(d1, "front");
        HashMap<String, Door> map = new HashMap<String, Door>();
        map.put("front", d1);
        assertEquals(myRoom.getDoors(), map);

        //Adding test with a door already present in the hashmap
        myRoom.addExit(d1, "front");
        assertEquals(myRoom.getDoors(), map);

        //Adding test with a next room already present in the hashmap
        myRoom.addExit(d2, "right");
        assertEquals(myRoom.getDoors(), map);

        //Adding test with a direction already present in the hashmap
        myRoom.addExit(d3, "front");
        assertEquals(myRoom.getDoors(), map);

        //Adding test with specific direction and next room
        myRoom.addExit(d3, "right");
        map.put("right", d3);
        assertEquals(myRoom.getDoors(), map);

        //Adding test with a own room for next room
        myRoom.addExit(d4, "left");
        assertEquals(myRoom.getDoors(), map);
    }

    /**
     * Checks the method removeExit to remove a door to a room
     * Checks if a door present or not can be removed
     */
    @Test
    public void removeExit() {
        Room room2 = new Room("Room 2", 1);
        Door d1 = new Door(room2);

        //Removing test with a direction present in the hashmap
        myRoom.addExit(d1, "front");
        HashMap<String, Door> map = new HashMap<String, Door>();
        myRoom.removeExit("front");
        assertEquals(myRoom.getDoors(), map);

        //Removing test with a direction not present in the hashmap
        map.put("right", d1);
        myRoom.addExit(d1, "right");
        myRoom.removeExit("front");
        assertEquals(myRoom.getDoors(), map);
    }
}
