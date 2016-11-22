package test;

import static org.junit.Assert.*;
import org.junit.*;

import room.LockedDoor;

public class LockedDoorTest {

	private LockedDoor lockedDoor;
	private boolean isLocked;
	
	
	/**
	 * check if all informations of the constructor are available
	 */
	@Test
	public void testLockedDoor(){
		assertNotNull(lockedDoor.getCurrentRoom());
		assertNotNull(lockedDoor.getNextRoom());
	}
	
	/**
	 * test if the door can be locked
	 */
	@Test
	public void testLockingDoor() {
		lockedDoor = new LockedDoor(null, null, null, null, 0, true);
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
