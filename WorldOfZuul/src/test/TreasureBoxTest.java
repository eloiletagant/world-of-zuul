package test;

import static org.junit.Assert.*;
import org.junit.*;

import item.Lock;
import item.TreasureBox;
import item.Weapon;

public class TreasureBoxTest {

	private TreasureBox treasureBox;
	private Lock lock;

	/**
	 * Default constructor for the test class treasurBox
	 * 		 
	 */
	public TreasureBoxTest() {
	}
	
	/**
	 * sets up the test fixture.
	 */
	@Before
	public void setUp() {
		 treasureBox = new TreasureBox ("Box", "Box link to a key, contains items", 10, true, lock);
	}
	
	/**
	 * Tears down the test fixture
	 * <p> Called after every test case method. NOthing to do in this case </p>
	 */
	@After
	public void tearDown() { 
		 
	}
	 
	/**
	 * Checks if the name given as parameter in the constructor is correctly set to the attribute</p>
	 */
	@Test
	public void testNameBox() {
		 // The parameter "Box1" must be set as the name attribute
		 assertEquals("Box", treasureBox.getName());
	}
	 
	/**
	 * Checks if the name given as parameter in the constructor is correctly set to the attribute</p>
	 */
	@Test
	public void testDescriptionBox() {
		// The parameter "keys open the door" must be set as the name attribute
		assertEquals("Box link to a key, contains items", treasureBox.getDescription());	
	}
	 
}