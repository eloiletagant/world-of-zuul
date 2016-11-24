package test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import item.Consumable;
import item.Inventory;
import item.Item;
import item.Lock;
import item.Chest;
import item.Lock;
import item.Weapon;


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
	private ArrayList<Item> myInventory2;
	private Consumable myConsumable;
	private Chest myChest;
	private Lock aLock;
	private Weapon myWeapon;

	/**
	 * Sets up the test fixture.
	 * Called before every test case method.
	 * Initialize one consumable for each test, whose name is "Bread".
	 */
	@Before
	public void setUp()
	{
		myInventory = new Inventory(10);
		myConsumable=new Consumable("Bread", "This bread was cooked by the baker of the village", 20, true, "This bread get 2 health points to the person who eats it", 0, 3, true);
		aLock= new Lock();
		myChest=new Chest("Treasure Box", "This treasure box can contain some items", 5, 0, aLock);
		myWeapon=new Weapon("Sword",String desc, int pric, boolean sell,int dmg, boolean hand");

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
	 * Method testAddConsumableInInventory
	 * <p>Checks if the consumable is correctly added in an inventory</p>
	 */
	@Test
	public void testAddConsumableInInventory()
	{
		myInventory2= new ArrayList<Item>();
		myInventory2.add(myConsumable);
		myInventory.addItem(myConsumable);
		assertEquals(myInventory2,myInventory.getItems());
	}
	
	/**
	 * Method testDeleteConsumableInInventory
	 * <p>Checks if the consumable is correctly deleted in an inventory</p>
	 */
	@Test
	public void testDeleteConsumableInInventory()
	{
		myInventory2= new ArrayList<Item>();
		myInventory2.add(myConsumable);
		myInventory2.remove(myConsumable);
		myInventory.addItem(myConsumable);
		myInventory.deleteItem(myConsumable);
		assertEquals(myInventory2,myInventory.getItems());
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
