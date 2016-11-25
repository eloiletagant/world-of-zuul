package test;
import item.Key;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Test;


public class KeyTest
{
	
	private Key myKey;
	
	/**
	 * Sets up the test fixture
	 * Called before every test method
	 * Initialize one key with specific parameters
	 */
	@Before
	public void setUp()
	{
		myKey = new Key("Key1","This key can open something",0,false);
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
	 * Method testKey1
	 * Checks if the given parameter in the constructor is correctly set to the attribute.
	 * 
	 */
	@Test
	public void testKey1()
	{
		assertEquals("Key1",myKey.getName());
		assertEquals("This key can open something",myKey.getDescription());
		assertEquals(0,myKey.getPrice());
		assertEquals(false,myKey.getSellAble());
	}
	
	/**
	 * Method testDefault
	 * Checks the default parameters
	 * 
	 */
	@Test
	public void testDefault()
	{
		Key bad = new Key("", "", -10, true);
		assertEquals("Unidentified object",bad.getName());
		assertEquals("This object seems strange and come from nowhere",bad.getDescription());
		assertEquals(0,bad.getPrice());
		assertEquals(false,bad.getSellAble());
	}
}
