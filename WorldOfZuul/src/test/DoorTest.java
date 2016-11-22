//en cours : anatole

package test;

import static org.junit.Assert.*;
import org.junit.*;

import room.Room;


public class DoorTest {

	private Room room;
	
	/**
	 * test if the character success to move to another room
	 */
	@After
	public void testNotEmptyRoom() {
		assertNotNull(room);
	}

}
