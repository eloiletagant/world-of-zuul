package test;
import item.Key;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Test;


public class KeyTest {
	
	private Key myKey;
	
	/**
	 * Sets up the test fixture
	 * Called before every test method
	 * Initialize one key with specific parameters
	 */
	@Before
	public void setUp()
	{
		myKey = new Key("Key1", "Open the door", 0, false);
	}
	
	/**
	 * Tear down the test fixture
	 * Called after every test case method. Nothing to do in this case.
	 */
	@After
	public void tearDown (){}
	
	 /**
	  * Checks if the name given as parameter in the constructor is correctly set to the attribute
	  */
	 @Test
	 public void testNameKey()
	 {
		 // The parameter "Key1" must be set as the name attribute
		 assertEquals("Key1", myKey.getName());
	 }
	 
	 /**
	  * Checks if the description given as parameter in the constructor is correctly set to the attribute
	  */
	 @Test
	 public void testDescriptionKey()
	 {
		 // The parameter "Open the door" must be set as the name attribute
		 assertEquals("Open the door", myKey.getDescription());
	 }
	 
	 /**
	  * Checks if the price given as parameter in the constructor is correctly set to the attribute
	  */
	 @Test
	 public void testPriceKey()
	 {
		 // The parameter "0" must be set as the name attribute
		 assertEquals(0, myKey.getPrice());
	 }
	 
	 /**
	  * Method testBad
	  * Test the default parameters
	  */
	 public void testBadKey()
	 {
		    Key bad = new Key("", "", -10, true);
			assertEquals("Unidentified object",bad.getName());
			assertEquals("This object seems strange and come from nowhere.",bad.getDescription());
			assertEquals(100,bad.getPrice());
	 }
}
