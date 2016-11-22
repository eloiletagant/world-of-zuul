package test;

import static org.junit.Assert.*;

import org.junit.Test;
import character.Character;
import npc.NPC;

public class NPCTest {
	
	private NPC npc;

	@Test
	public void testNPC() {
		character.NPC friend = new NPC ("");
		assertEquals("Zuul",friend.getName());
	}

}
