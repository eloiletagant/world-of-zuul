package test;

import static org.junit.Assert.*;
import org.junit.*;

import item.Key;
import item.Lock;
import room.LockedDoor;
import room.Room;

public class LockedDoorTest {

	private LockedDoor lockedDoor;
	private Lock lock;
	private Room nextRoom;
	private Key myKey;
	
	/**
	 * Default constructor for test class LockTest
	 */
	public LockedDoorTest(){
	}
	
	/**
	 * Sets up the test fixture
	 * Called before every test method
	 * Initialize one key and the lock associated
	 */
	@Before
	public void setUp() {
		nextRoom = new Room("Room 1", 0);
		myKey = new Key("Key1","This key can open something", 0, false);
		lock = new Lock();
		lock.addKey(myKey);
		lockedDoor = new LockedDoor(nextRoom, lock);
	}
	
	/**
	 * Check if all informations of the constructor are available
	 */
	@Test
	public void testLockedDoor(){
		assertSame(nextRoom, lockedDoor.getNextRoom());
		assertSame(lock, lockedDoor.getLock());
	}
}
