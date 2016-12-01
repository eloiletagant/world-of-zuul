package test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import character.*;
import room.Room;
import clickerGame.Clicker;
import event.*;
import item.Weapon;

public class ClickerTest
{
private Fight f1;
	
	/**
	 * Initialize the character with the name "pseudo"
	 */
	@Before
	public void setUp()
	{
		Player c1 = new Player("Gael");
		NPC lapin = new NPC("TruiteVelue",60,2,true);
		Weapon w1 = new Weapon("Epee de merde", "Elle roks du poney", 1, true, 2, true);
		w1.equip();
		c1.getInventory().addItem(w1);
		Weapon w2 = w1;
		c1.getInventory().addItem(w2);
		lapin.getInventory().addItem(w1);
		f1 = new Fight("C'est l'heure du duel !", w2, c1, lapin);
	}
	
	@Test
	/**
	 * 
	 */
	public void testClicks()
	{
		int nbclicks = Clicker.clickerLauncher(30);
		boolean result = f1.runFight(nbclicks, 30);
		assertEquals(true, result);
	}
	
}
