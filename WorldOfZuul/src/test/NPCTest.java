package test;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import character.NPC;

public class NPCTest
{
	
	private NPC myNPC;
	/**
	 * sets up
	 * <p> Initialize one NPC for each test, whose name is "Lion Knight" </p>
	 */
	@Before
	public void setUp()
	{
		myNPC = new NPC ("Lion Knight",40,3,false);
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
	 * Method testNameNPC
	 * <p> checks that the name and default name is Attila, if the given name is empty. </p>
	 * <p> checks the number of hand and health limit </p>
	 */
	@Test
	public void testNPC()
	{
		assertEquals("Lion Knight",myNPC.getName());
		assertEquals(false,myNPC.getEnemy());
		assertEquals(3,myNPC.getNbHandsAvailable());
		assertEquals(40,myNPC.getHealth());
		NPC anEnemy = new NPC ("",150,5,true);
		assertEquals("Attila",anEnemy.getName());
		assertEquals(4,anEnemy.getNbHandsAvailable());
		assertEquals(150,anEnemy.getHealth());
		assertEquals(true,anEnemy.getEnemy());
	}
	
	/**
	 * Method testSwapFriendShip
	 * <p> checks if the swapping works well </p>
	 */
	@Test
	public void testSwapFriendShip()
	{
		assertEquals(false,myNPC.getEnemy());
		myNPC.swapFriendShip();
		assertEquals(true,myNPC.getEnemy());
		myNPC.swapFriendShip();
		assertEquals(false,myNPC.getEnemy());
	}
	
	/**
	 * Method testAddHealth
	 * The super method have to be test before this one.
	 */
	@Test
	public void testAddHealth()
	{
		myNPC.manageHealth(-2);
		assertEquals(myNPC.getHealth(),myNPC.getMaxHealth()-2);
		myNPC.manageHealth(1);
		assertEquals(myNPC.getHealth(),myNPC.getMaxHealth()-2);
		myNPC.manageHealth(-myNPC.getMaxHealth());
		assertEquals(myNPC.getHealth(),0);
	}

}
