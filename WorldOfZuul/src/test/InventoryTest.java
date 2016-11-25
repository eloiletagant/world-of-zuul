package test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import item.Consumable;
import item.Inventory;
import item.Item;
import item.Weapon;
import item.Key;

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
	private Weapon myWeapon;
	private Key myKey, Key1, Key2, Key3, Key4, Key5, Key6, Key7, Key8, Key9, Key10, Key11;

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
		myKey=new Key("Key1","This key can open something",0,false);
		myWeapon=new Weapon("Sword","This sword is very helpfull during a fight", 150, true, 5, true);
		myInventory2= new ArrayList<Item>();
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
	 * Method testAddItemsInventory
	 * <p>Checks if items is correctly added in an inventory</p>
	 */
	@Test
	public void testAddItemsInventory()
	{
		myInventory2.add(myConsumable);
		myInventory.addItem(myConsumable);
		assertEquals(myInventory2,myInventory.getItems());
		myInventory2.add(myWeapon);
		myInventory.addItem(myWeapon);
		assertEquals(myInventory2,myInventory.getItems());
		myInventory2.add(myKey);
		myInventory.addItem(myKey);
		assertEquals(myInventory2,myInventory.getItems());
		myInventory2.add(myKey);
		myInventory.addItem(myKey);
		assertNotEquals(myInventory2,myInventory.getItems());
	}
	
	/**
	 * Method testDeleteItemsInventory
	 * <p>Checks if items is correctly deleted in an inventory</p>
	 */
	@Test
	public void testDeleteItemsInventory()
	{		
		myInventory2.add(myConsumable);
		myInventory.addItem(myConsumable);
		assertEquals(myInventory2,myInventory.getItems());
		myInventory2.add(myWeapon);
		myInventory.addItem(myWeapon);
		assertEquals(myInventory2,myInventory.getItems());
		myInventory2.add(myKey);
		myInventory.addItem(myKey);
		assertEquals(myInventory2,myInventory.getItems());
		myInventory2.remove(myConsumable);
		myInventory.deleteItem(myConsumable);
		assertEquals(myInventory2,myInventory.getItems());
		myInventory2.remove(myWeapon);
		myInventory.deleteItem(myWeapon);
		assertEquals(myInventory2,myInventory.getItems());
		myInventory2.remove(myKey);
		myInventory.deleteItem(myKey);
		assertEquals(myInventory2,myInventory.getItems());
	}
	
	/**
	 * Method testResetItem
	 * <p>Checks if the inventory is correctly clear</p>
	 */
	@Test
	public void testResetItem()
	{
		myInventory.addItem(myConsumable);
		myInventory.addItem(myWeapon);
		myInventory.addItem(myKey);
		myInventory.resetInventory();
		assertEquals(myInventory2,myInventory.getItems());
	}
	
	/**
	 * Method testLimitInventory
	 * <p>Checks if items is correctly added in an inventory</p>
	 */
	@Test
	public void testLimitInventory()
	{
		Key1=new Key("Key1","This key can open something",0,false);
		Key2=new Key("Key2","This key can open something",0,false);
		Key3=new Key("Key3","This key can open something",0,false);
		Key4=new Key("Key4","This key can open something",0,false);
		Key5=new Key("Key5","This key can open something",0,false);
		Key6=new Key("Key6","This key can open something",0,false);
		Key7=new Key("Key7","This key can open something",0,false);
		Key8=new Key("Key8","This key can open something",0,false);
		Key9=new Key("Key9","This key can open something",0,false);
		Key10=new Key("Key10","This key can open something",0,false);
		Key11=new Key("Key11","This key can open something",0,false);
		myInventory.addItem(Key1);
		myInventory.addItem(Key2);
		myInventory.addItem(Key3);
		myInventory.addItem(Key4);
		myInventory.addItem(Key5);
		myInventory.addItem(Key6);
		myInventory.addItem(Key7);
		myInventory.addItem(Key8);
		myInventory.addItem(Key9);
		myInventory.addItem(Key10);
		myInventory.addItem(Key11);
		myInventory2.add(Key1);
		myInventory2.add(Key2);
		myInventory2.add(Key3);
		myInventory2.add(Key4);
		myInventory2.add(Key5);
		myInventory2.add(Key6);
		myInventory2.add(Key7);
		myInventory2.add(Key8);
		myInventory2.add(Key9);
		myInventory2.add(Key10);
		assertEquals(myInventory2,myInventory.getItems());
	}
	
	@Test
	/**
	 * 
	 */
	public void testManageGolds()
	{
		myInventory.manageGold(100);
		assertEquals(1100, myInventory.getGold());
		myInventory.manageGold(-1200);
		assertEquals(1100, myInventory.getGold());
		myInventory.manageGold(-200);
		assertEquals(900, myInventory.getGold());
	}
}
