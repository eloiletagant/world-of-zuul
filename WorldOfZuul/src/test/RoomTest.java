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
		myRoom = new Room("Salle 1", 0);
	}
	
	@After
	public void tearDown(){}
	
	@Test
	public void testName(){
		assertEquals("Salle 1",myRoom.getRoomName());
	}
	
	@Test
	public void testLevel(){
		assertEquals(0,myRoom.getLevel());
	}
	
}
