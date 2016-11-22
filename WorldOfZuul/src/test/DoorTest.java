//en cours : anatole

package test;

import static org.junit.Assert.*;
import org.junit.*;

import room.Room;
import room.Door;


public class DoorTest {

	private Door door;
	
	/**
	 * test if the current room is not empty
	 */
	@Before
	public void testNotEmptyCurRoom() {
		assertNotNull(door.getCurrentRoom());
	}

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
		assertNotSame(door.getCurrentRoom(), door.getNextRoom());
	}
	
	
}
