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
		myNPC = new NPC ("Chevalier au lion",40,3);
	}
	
	/**
	 * Method testNameNPC
	 * <p> checks that the name and default name is Zuul, if the given name is empty. </p>
	 * <p> checks the number of hand and health limit </p>
	 */
	@Test
	public void testNPC() {
		assertEquals("Chevalier au lion",myNPC.getName());
		assertEquals(true,myNPC.getEnemy());
		assertEquals(3,myNPC.getNbHandsAvailable());
		assertEquals(40,myNPC.getHealth());	
		NPC friend = new NPC ("",150,5);
		assertEquals("Zuul",friend.getName());
		assertEquals(5,friend.getNbHandsAvailable());
		assertEquals(150,friend.getHealth());		
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
