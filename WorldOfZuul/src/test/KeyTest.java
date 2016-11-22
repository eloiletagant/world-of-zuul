package test;
import item.Key;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Test;


public class KeyTest {
	
	private Key myKey;


	/**
	 * 
	 */
	@Before
	public void setUp()
	{
		myKey = new Key("Key1", "Open the door", 0, false);
	}
	
	@After
	public void tearDown ()
	{
	
	}
	
	 /**
	  * Checks if the name given as parameter in the constructor is correctly set to the attribute</p>
	  */
	 @Test
	 public void testNameKey()
	 {
		 // The parameter "Key1" must be set as the name attribute
		 assertEquals("Key1", myKey.getName());
	 }
	 
	 /**
	  * Checks if the description given as parameter in the constructor is correctly set to the attribute</p>
	  */
	 @Test
	 public void testDescriptionKey()
	 {
		 // The parameter "Key1" must be set as the name attribute
		 assertEquals("Open the door", myKey.getDescription());
	 }
	 
	 /**
	  * Checks if the price given as parameter in the constructor is correctly set to the attribute</p>
	  */
	 @Test
	 public void testPriceKey()
	 {
		 // The parameter "Key1" must be set as the name attribute
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
