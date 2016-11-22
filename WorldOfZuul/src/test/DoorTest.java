package test;

import static org.junit.Assert.*;
import org.junit.*;

import room.Door;
import room.Room;
import character.Character;


public class DoorTest {

	private Door door;
	private Character character;
	private Room room;
	
	public DoorTest() {
	}
	
	@Before
	public void setUp() {
		door = new Door(new Room("Garden", 0));
		character = new Character("Jason");
	}

	/**
	 * test if the next room is not empty
	 */
	@Test
	public void testNotEmptyNextRoom() {
		assertNotNull(door.getNextRoom());
	}
	
	/**
	 * test if the current and the next rooms are different
	 */
	@Test
	public void testDifferentRooms() {
		assertNotSame(character.getLocation(), door.getNextRoom());
	}
	
	
}
