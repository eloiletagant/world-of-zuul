package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import character.Character;
import npc.NPC;

public class NPCTest {
	
	private NPC myNPC;
	
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
	}
	
	/**
	 * Method testNameNPC
	 * <p> checks that the default name is Zuul, if the given name is empty</p>
	 */
	@Test
	public void testNameNPC() {
		character.NPC friend = new NPC ("");
		assertEquals("Zuul",friend.getName());
	}

}
