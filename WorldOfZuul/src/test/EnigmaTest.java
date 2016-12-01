package test;

import static org.junit.Assert.*;

import character.*;
import org.junit.*;

import character.NPC;
import event.Enigma;
import item.Consumable;

public class EnigmaTest {
	
	private Enigma enigma;
	private Consumable potion;
	private Player peter;
	private NPC john;


	/**
	 * sets up
	 * <p> Initialize one Enigma for each test </p>
	 */
	@Before
	public void setUp()
	{
		//potion is the loot get by find the answer.
	    potion = new Consumable("potion", "description", 10, true, "become invisible", 10, 0, false);
		john = new NPC("jean le paysant",35,4,true);
		peter = new Player("Peter",40, 2);
		enigma = new Enigma ("Stupid enigma", potion, peter, john,"1 + 1 = ?","2");
	}
	
    /**
     * Method testTestAnswer
     * <p>This method checks if the method of comparison of answer works well.</p>
     */
	@Test
	public void testCheckAnswer()
	{
	     assertTrue(enigma.checkAnswer("2"));
	     assertFalse(enigma.checkAnswer("11"));

	}
	
    /**
     * Method testSetAnswer
     * <p>This method checks if the input in setAnswer works well</p>
     */
	public void testSetAnswer()
	{
		assertEquals("2", enigma.getAnswer());
	}
	
    /**
     * Method testSetQuestion
     * <p>This method checks if the input in setQuestion works well</p>
     */
	public void testSetQuestion()
	{
		assertEquals("1 + 1 = ?", enigma.getQuestion());
	}
}
