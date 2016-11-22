package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import character.Character;
import room.Room; 

public class CharacterTest {

	private Character character;
	private Room firstRoom, secondRoom;
	
	/**
	 * test if the character success to move to another room
	 */
	@After
	public void testMoveRoom() {
		firstRoom = new Room("test1",0);
		character.moveRoom(firstRoom);
		assertEquals(firstRoom,character.getLocation());
		secondRoom = new Room("test2",1);
		character.moveRoom(secondRoom);
		secondRoom = character.getLocation(); 
		assertEquals(secondRoom, character.getLocation());
	}
	
	@Test
	public void testCharacter()
	{
		Character C1 = new Character("");
		if(C1.getName() != "Zuul")
		{
			fail("Name definition fail");
		}
	}
	 
	@Test
	public void testAddHealth() {
		fail("Not yet implemented");
	}

}
