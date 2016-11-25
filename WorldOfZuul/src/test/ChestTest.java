package test;
import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import item.Lock;
import item.Chest;
import item.Key;

public class ChestTest
{
	private Chest myChest;
	private Lock aLock;
	private Key myKey, aBadKey;


	/**
	 * Sets up the test fixture
	 * Called before every test method
	 * Initialize one key with specific parameters
	 */
	@Before
	public void setUp()
	{
		aLock=new Lock();
		myChest=new Chest("Treasure Box", "This treasure box can contain some items", 5, 0, aLock);
		myKey = new Key("goodKey", "Test good key", 10, true);
		aBadKey = new Key("badKey", "Test bad key", 10, true);
		aLock.addKey(myKey);
	}
	
	/**
	 * Tears down the test fixture
	 * <p> Called after every test case method. NOthing to do in this case </p>
	 */
	@After
	public void tearDown()
	{ 	 
	}
	 
	/**
	 * Method testTreasureBox
	 * Checks if the given parameter in the constructor is correctly set to the attribute.
	 * 
	 */
	@Test
	public void testTreasureBox()
	{
		assertEquals("Treasure Box",myChest.getName());
		assertEquals("This treasure box can contain some items",myChest.getDescription());
		assertEquals(5,myChest.getMaxItems());
		assertEquals(0,myChest.getGold());
		assertEquals(aLock,myChest.getLock());
	}
	
	/**
	 * Method testDefault
	 * Checks the default parameters
	 * 
	 */
	@Test
	public void testDefault()
	{
		Chest bad = new Chest("", "", -2, -10, aLock);
		assertEquals("Unidentified object",bad.getName());
		assertEquals("This object seems strange and come from nowhere",bad.getDescription());
		assertEquals(10,bad.getMaxItems());
		assertEquals(0,bad.getGold());
		assertEquals(aLock,bad.getLock());
	}
	
	/**
	 * Method testOpenChest
	 * Checks the default parameters
	 */
	@Test
	public void testOpenChest()
	{
		assertEquals(true,myChest.getLock().getLock());
		myChest.openChest(aBadKey);
		assertEquals(true,myChest.getLock().getLock());
		myChest.openChest(myKey);
		assertEquals(false,myChest.getLock().getLock());
	}
	 
}