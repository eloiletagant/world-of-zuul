package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import character.*;
import event.*;
import item.*;

public class FightTest {

	private Fight f1;
	
	/**
	 * Initialize the character with the name "pseudo"
	 */
	@Before
	public void setUp()
	{
		Player c1 = new Player("Gael", 20);
		NPC lapin = new NPC("TruiteVelue",60,2,true);
		Weapon w1 = new Weapon("Epee de merde", "Elle roks du poney", 1, true, 2);
		w1.equip();
		c1.getInventory().addItem(w1);
		Weapon w2 = w1;
		c1.getInventory().addItem(w2);
		lapin.getInventory().addItem(w1);
		f1 = new Fight("C'est l'heure du duel !", w2, c1, lapin);
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
	public void testFight()
	{
		Boolean result = f1.runFight(8, 10);
		assertEquals(result,false);
	}

}
