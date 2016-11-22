package test;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import item.Consumable;


/**
 * The test class ConsumableTest
 * Unit tests of the Consumable class
 * @author Group4
 * @version 22/11/2016
 *
 */
public class ConsumableTest
{
	private Consumable myConsumable;

	/**
	 * Sets up the test fixture.
	 * Called before every test case method.
	 * Initialize one consumable for each test, whose name is "Bread".
	 */
	@Before
	public void setUp()
	{
		myConsumable=new Consumable("Bread", "This bread was cooked by the baker of the village", 20, true, "This bread get 2 health points to the person who eats it");
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
	 * Method testNameBread
	 * Checks if the name given as parameter in the constructor is correctly set to the attribute.
	 * 
	 */
	@Test
	public void testNameBread()
	{
		assertEquals("Bread",myConsumable.getName());
	}	
}
