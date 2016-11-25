package test;
 
import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import room.Room;
import room.Door;


/**
 * The test class LockTest
 * Unit tests of the Lock class 
 * @author Groupe4
 * @version 22/11/2016
 */

public class RoomTest {
	
	private Room myRoom;
	
	public RoomTest(){
	}

	@Before
	public void setUp() {
		myRoom = new Room("Salle 1", 1);
	}
	
	@After
	public void tearDown(){}
	
	@Test
	public void testRoom(){
		assertEquals("Salle 1",myRoom.getDescription());
		assertEquals(1,myRoom.getLevel());
	}
	
	@Test
	public void testEmptyDescription()
	{
		Room myRoom2 = new Room("", 1);
		assertEquals("UndescribedRoom",myRoom2.getDescription());
	}
	
	@Test
	public void testNegativeLevel(){
		Room myRoom2 = new Room("Salle 2", -2);
		assertEquals(0,myRoom2.getLevel());
	}
	
	@Test
	public void testAddExit() 
	{
		Room room2 = new Room("Salle 2", 1);
		Room room3 = new Room("Salle 3", 1);
		Door d1 = new Door(room2);
		Door d2 = new Door(room2);
		Door d3 = new Door(room3);
		Door d4 = new Door(myRoom);
		
		//Simple door adding and test
		myRoom.addExit(d1, "front");
		HashMap<String, Door> map = new HashMap<String, Door>();
		map.put("front", d1);
		assertEquals(myRoom.getDoors(),map);
		
		//Adding a door already present in the hashmap
		myRoom.addExit(d1, "front");
		assertEquals(myRoom.getDoors(),map);
		
		//Adding a door with a next room already present in the hashmap
		myRoom.addExit(d2, "right");
		assertEquals(myRoom.getDoors(),map);
		
		//Adding a door with a direction already present in the hashmap
		myRoom.addExit(d3, "front");
		assertEquals(myRoom.getDoors(),map);

		//Adding a door with specific direction and next room
		myRoom.addExit(d3, "right");
		map.put("right", d3);
		assertEquals(myRoom.getDoors(),map);

		//Adding its own room for next room
		myRoom.addExit(d4, "left");
		assertEquals(myRoom.getDoors(),map);
	}
		
	@Test
	public void removeExit() 
	{
		Room room2 = new Room("Salle 2", 1);
		Door d1 = new Door(room2);
		
		//Remove test with a direction present in the hashmap
		myRoom.addExit(d1, "front");
		HashMap<String, Door> map = new HashMap<String, Door>();
		myRoom.removeExit("front");
		assertEquals(myRoom.getDoors(),map);
		
		//Remove test with a direction not present in the hashmap
		map.put("right", d1);
		myRoom.addExit(d1, "right");
		myRoom.removeExit("front");
		assertEquals(myRoom.getDoors(),map);
	}
	
}
