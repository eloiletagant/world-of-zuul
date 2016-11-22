package test;

import static org.junit.Assert.*;
import org.junit.*;

import room.Room;
import character.Character;


public class DoorTest {

	private Door door;
	private Character character;
	private Room firstRoom, secondRoom;
	
	/**
	 * test if the character success to move to another room
	 */
	@After
	public void testMoveRoom() {
		firstRoom = character.getLocation();
		character.moveRoom();
		secondRoom = character.getLocation(); 
		assertNotSame(firstRoom, secondRoom);
	}

}
