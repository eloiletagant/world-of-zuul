package test;

import static org.junit.Assert.*;
import org.junit.*;

import room.Room;
import room.Door;



public class DoorTest {

	private Door door;
	private Character character;
	

	/**
	 * test if the next room is not empty
	 */
	@Before
	public void testNotEmptyNextRoom() {
		assertNotNull(door.getNextRoom());
	}
	
	/**
	 * test if the current and the next rooms are different
	 */
	@Test
	public void testDifferentRooms() {
		assertNotSame(character.getCurrentRoom(), door.getNextRoom());
	}
	
	
}
