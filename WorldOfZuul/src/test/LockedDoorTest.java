package test;

import static org.junit.Assert.*;
import org.junit.*;

import room.LockedDoor;

public class LockedDoorTest {

	private LockedDoor lockedDoor;
	private boolean isLocked;
	
	/**
	 * test if the door can be locked
	 */
	@Test
	public void testLockingDoor() {
		lockedDoor = new LockedDoor(null, null);
		isLocked = lockedDoor.isLocked();
		lockedDoor.lockingDoor();
		assertNotSame(isLocked, lockedDoor.isLocked());
	}
	
	/**
	 * check if the lock exist
	 */
	@Test
	public void testNotEmptyLock() {
		assertNotNull(lockedDoor.getLock());
	}
	
	

}
