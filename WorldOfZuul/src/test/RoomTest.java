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
	public void testGoodAddExit() 
	{
		Room room2 = new Room("Salle 2", 1);
		Room room3 = new Room("Salle 3", 1);
		Door d1 = new Door(room2);
		Door d2 = new Door(room2);
		Door d3 = new Door(room3);
		Door d4 = new Door(myRoom);
		
		myRoom.addExit(d1, "front");
		HashMap<String, Door> map = new HashMap<String, Door>();
		map.put("front", d1);
		assertEquals(myRoom.getExitDoors(),map);
		myRoom.addExit(d1, "front");
		assertEquals(myRoom.getExitDoors(),map);
		myRoom.addExit(d2, "right");
		assertEquals(myRoom.getExitDoors(),map);
		myRoom.addExit(d3, "front");
		assertEquals(myRoom.getExitDoors(),map);
		myRoom.addExit(d3, "right");
		map.put("right", d3);
		assertEquals(myRoom.getExitDoors(),map);
		myRoom.addExit(d4, "left");
		assertEquals(myRoom.getExitDoors(),map);
	}
		
	
/* Test addExit avec salle pas déjà présente, direction pas déjà prise
 * Test addexit avec salle déjà présente et direction déjà prise 
 * Test remove door avec salle présente
 * Avec salle pas présente
 * ......
 * */
	
}
