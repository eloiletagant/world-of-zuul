package test;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import room.Room;


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
	public void testName(){
		assertEquals("Salle 1",myRoom.getRoomName());
	}
	
	@Test
	public void testEmptyName()
	{
		Room myRoom2 = new Room("", 1);
		assertEquals("UnnamedRoom",myRoom2.getRoomName());
	}
	
	@Test
	public void testLevel(){
		assertEquals(1,myRoom.getLevel());
	}
	
	@Test
	public void testNegativeLevel(){
		Room myRoom2 = new Room("Salle 2", -2);
		assertEquals(0,myRoom2.getLevel());
	}
		
	
	
}
