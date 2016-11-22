package test;

import static org.junit.Assert.*;

import org.junit.Test;

import room.Lock;
import room.LockedDoor;

public class LockedDoorTest {

	private LockedDoor lockedDoor;
	
	/**
	 * 
	 */
	@Test
	public void testLockingDoor() {
		return assertNotSame(lockedDoor.getLock(), lockedDoor.lockingDoor());
	}

}
