package test;

import static org.junit.Assert.*;

import org.junit.Test;
import character.Character;

public class CharacterTest {

	
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
