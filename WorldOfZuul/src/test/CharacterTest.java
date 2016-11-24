package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import character.Character;
import room.Room;

public class CharacterTest {

	private Character c1;
	private Room firstRoom, secondRoom;
	
	/**
	 * Initialize the character with the name "pseudo"
	 */
	@Before
	public void setUp()
	{
		c1 = new Character("Pseudo");
	}
	
	/**
	 * Method testCharacterEmptyName
	 * <p>test the constructor with the default value "Zuul"</p>
	 */
	@Test
	public void testCharacterEmptyName()
	{
		Character c2 = new Character("");
		assertEquals(c2.getName(), "Zuul");	
	}
	
	/**
	 * Method testCharacter
	 * <p>test the constructor with the setUp value</p>
	 */
	@Test
	public void testCharacter()
	{
		c1 = new Character("");
		assertEquals(c1.getName(), "Zuul");
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
	public void testAddHealth() 
	{
		c1.addHealth(c1.getMaxHealth() + 1);
		assertEquals(c1.getHealth(),c1.getMaxHealth());
		c1.addHealth(-(c1.getMaxHealth() + 1));
		assertEquals(c1.getHealth(),0);
		c1.addHealth(c1.getMaxHealth()/2);
		assertEquals(c1.getHealth(),c1.getMaxHealth()/2);
		c1.addHealth(-(c1.getMaxHealth()/4));
		assertEquals(c1.getHealth(),c1.getMaxHealth()/4);
	}

	/**
	 * Method testSwapWeapon
	 * <p>This method test if the number of hands will never go out of [0,MaxHands].</p>
	 * <p>Overwise, the number of available hands will be modified and the method will return true </p>
	 */
	@Test
	public void testSwapWeapon() 
	{
		c1.swapWeapon(c1.getMaxHands() + 1);
		assertEquals(c1.getNbHandsAvailable(),c1.getMaxHands());
		c1.swapWeapon(-(c1.getMaxHands()+1));
		assertEquals(c1.getNbHandsAvailable(),c1.getMaxHands());
		c1.swapWeapon(-c1.getMaxHands());
		assertEquals(c1.getNbHandsAvailable(),0);
		c1.swapWeapon(c1.getMaxHands()/2);
		assertEquals(c1.getNbHandsAvailable(),c1.getMaxHands()/2);
		c1.swapWeapon(1);
		assertEquals(c1.getNbHandsAvailable(),(c1.getMaxHands()/2) + 1);
		c1.swapWeapon(-1);
		assertEquals(c1.getNbHandsAvailable(),c1.getMaxHands()/2);
	}
	
	/**
	 * Method testAddBonusDamages
	 * <p>This method test if the bonus damages are well applied and if it don't go out of [-5,5]</p>
	 */
	public void testAddBonusDamages()
	{
		c1.addBonusDamages(6);
		assertEquals(c1.getBonusDamages(),5);
		c1.addBonusDamages(-11);
		assertEquals(c1.getBonusDamages(),-5);
		c1.addBonusDamages(5);
		assertEquals(c1.getBonusDamages(),0);
		c1.addBonusDamages(-1);
		assertEquals(c1.getBonusDamages(),-1);
	}
}
