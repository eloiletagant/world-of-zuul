package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import character.NPC;

public class NPCTest {
	
	private NPC myNPC;
	/**
	 * sets up
	 * <p> Initialize one NPC for each test, whose name is "chevalier au lion" </p>
	 */
	@Before
	public void setUp()
	{
		myNPC = new NPC ("Chevalier au lion");
	}
	
	/**
	 * Method testNameChevalier
	 * <p> checks if the name given as parameter in the constructor is correctly set to the attribute </p>
	 */
	@Test
	public void testNameChevalier()
	{
		assertEquals("Chevalier au lion",myNPC.getName());
		assertEquals(true,myNPC.getEnemy());
	}
	
	/**
	 * Method testNameNPC
	 * <p> checks that the default name is Zuul, if the given name is empty</p>
	 */
	@Test
	public void testNameNPC() {
		character.NPC friend = new NPC ("");
		assertEquals("Zuul",friend.getName());
		assertEquals(true,myNPC.getEnemy());
	}
	
	/**
	 * Method testSwapFriendShip
	 * <p> checks if the swapping works well </p>
	 */
	@Test
	public void testSwapFriendShip()
	{
		myNPC.swapFriendShip();
		assertEquals(false,myNPC.getEnemy());
		myNPC.swapFriendShip();
		assertEquals(true,myNPC.getEnemy());
	}

}
