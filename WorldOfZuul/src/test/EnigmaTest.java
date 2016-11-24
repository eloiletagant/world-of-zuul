package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import character.NPC;
import event.Enigma;
import item.Consumable;

public class EnigmaTest {
	
	private Enigma myEnigma;
	/** 
	 * sets up
	 * <p> Initialize one Enigma for each test </p>
	 */
	@Before
	public void setUp()
	{
		Consumable potion = new Consumable("potion", "aDescription", 10, true, "rien", 10, 0, false);
		NPC jean = new NPC("jean le paysant",35,4);
		myEnigma = new Enigma ("Enigme a la con",potion,jean,"1+1=?","2");
	}
	
    /**
     * Method testTestAnswer
     * <p>This method checks if the method of comparison of answer works well.</p>
     */
	@Test
	public void testTestAnswer()
	{
	     assertTrue(myEnigma.testAnswer("2"));
	     assertFalse(myEnigma.testAnswer("11"));
	}
	
    /**
     * Method testSetAnswer
     * <p>This method checks if the input in setAnswer works well</p>
     */
	public void testSetAnswer()
	{
		assertEquals("2",myEnigma.setAnswer("2"));
	}
	
    /**
     * Method testSetQuestion
     * <p>This method checks if the input in setQuestion works well</p>
     */
	public void testSetQuestion()
	{
		assertEquals("1+1=?",myEnigma.setQuestion("1+1=?"));
	}
}
