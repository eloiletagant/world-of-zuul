package test;

import static org.junit.Assert.*;
import org.junit.*;

import room.Lock;
import room.LockedDoor;

public class LockedDoorTest {

	private LockedDoor lockedDoor1, lockedDoor2;
	
	/**
	 * 
	 */
	@Test
	public void testLockingDoor() {
		lockedDoor1 = new LockedDoor();
		lockedDoor2 = new LockedDoor();
		lockedDoor2.lockingDoor();
		assertNotSame(lockedDoor1.getLock(), lockedDoor2.getLock());
	}

}
