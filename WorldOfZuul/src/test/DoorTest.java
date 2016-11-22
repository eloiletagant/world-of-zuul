package test;

import static org.junit.Assert.*;
import org.junit.*;

import room.*;
import character.*;
import character.Character;


public class DoorTest {

	private Door door;
	private Character character;
	private Room firstRoom, secondRoom;
	
	/**
	 * test if the character success to move to another room
	 */
	@After
	public boolean testMoveRoom() {
		firstRoom = character.getLocation();
		character.moveRoom();
		secondRoom = character.getLocation(); 
		return assertNotSame(firstRoom, secondRoom);
	}

}
