package test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import character.*;
import room.Room;

public class CharacterTest
{

	private Player c1;
	private Room firstRoom, secondRoom;
	
	/**
	 * Initialize the character with the name "pseudo"
	 */
	@Before
	public void setUp()
	{
		c1 = new Player("Pseudo", 20);
	}
	
	/**
	 * Tears down the test fixture.
	 * Called after every test case method. Nothing to do in this case.
	 */
	@After
	public void tearDown()
	{
	}
	
	/**
	 * Method testCharacterEmptyName
	 * <p>test the constructor with the default value "Kaamelott"</p>
	 */
	@Test
	public void testCharacterEmptyName()
	{
		Player c2 = new Player("Player", 20);
		assertEquals(c2.getName(), "Kaamelott");	
	}
	
	/**
	 * Method testCharacter
	 * <p>test the constructor with the setUp value</p>
	 */
	@Test
	public void testCharacter()
	{
		assertEquals(c1.getName(), "Pseudo");
	}
	
	/**
	 * Method  testMoveRoom
	 * <p>Test if the character success to move to another room</p>
	 */
	@Test
	public void testMoveRoom() 
	{
		firstRoom = new Room("test1",0);
		c1.moveRoom(firstRoom);
		assertEquals(firstRoom,c1.getLocation());
		secondRoom = new Room("test2",1);
		c1.moveRoom(secondRoom);
		secondRoom = c1.getLocation(); 
		assertEquals(secondRoom, c1.getLocation());
	}
	 
	/**
	 * Method testSetHealth
	 * <p>This method test that a player's hp will never go out of [0/MaxHp]</p>
	 * <p>It also test if the health is correctly modified</p>
	 */
	@Test
	public void testManageHealth() 
	{
		c1.manageHealth(c1.getMaxHealth() + 1);
		assertEquals(c1.getHealth(),c1.getMaxHealth());
		c1.manageHealth(-(c1.getMaxHealth() + 1));
		assertEquals(c1.getHealth(),0);
		c1.manageHealth(c1.getMaxHealth()/2);
		assertEquals(c1.getHealth(),c1.getMaxHealth()/2);
		c1.manageHealth(-(c1.getMaxHealth()/4));
		assertEquals(c1.getHealth(),c1.getMaxHealth()/4);
	}
	
	/**
	 * Method testManageBonusDamages
	 * <p>This method test if the bonus damages are well applied and if it don't go out of [-5,5]</p>
	 */
	public void testManageBonusDamages()
	{
		c1.manageBonusDamages(6);
		assertEquals(5,c1.getBonusDamages());
		c1.manageBonusDamages(-11);
		assertEquals(-5,c1.getBonusDamages());
		c1.manageBonusDamages(5);
		assertEquals(0,c1.getBonusDamages());
		c1.manageBonusDamages(-1);
		assertEquals(-1,c1.getBonusDamages());
	}
}
