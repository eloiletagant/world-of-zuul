package test;
import item.Item;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import item.Inventory;


/**
 * The test class ConsumableTest
 * Unit tests of the Consumable class
 * @author Group4
 * @version 22/11/2016
 *
 */
public class InventoryTest
{
	private Inventory myInventory;
	private Item itemToAdd;

	/**
	 * Sets up the test fixture.
	 * Called before every test case method.
	 * Initialize one consumable for each test, whose name is "Bread".
	 */
	@Before
	public void setUp()
	{
		myInventory = new Inventory();
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
	 * Method testUse
	 * <p>Checks if an item is correctly add in an inventory</p>
	 */
	@Test
	public void testAddItem()
	{
		//ça marche pas j'arrive pas à créer d'item vu que c'est en abstract
		itemToAdd = new Item("Unidentified object", "This object seems strange and come from nowhere.", 100, true);
		myInventory.addItem(itemToAdd);
		
	}
	
	/**
	 * Method testUseDestroyItem
	 * <p>Checks if an item is correctly delete from an inventory</p>
	 */
	@Test
	public void testDeleteItem()
	{
		
	}
	
	/**
	 * Method testResetItem
	 * <p>Checks if the inventory is correctly clear</p>
	 */
	@Test
	public void testResetItem()
	{
		
	}
}
